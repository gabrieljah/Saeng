package br.com.recepcao.managed;


import br.com.recepcao.dao.PessoaDaoImpl;
import br.com.recepcao.model.Pessoa;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import org.primefaces.event.CaptureEvent;

 
@ManagedBean(name="photoMB")
@SessionScoped
public class PhotoCamBean implements Serializable {
 
    private String nombre;
    private int edad;
    private String foto;
    private Pessoa pessoa = new Pessoa();
    private PessoaDaoImpl pessoaDAO = new PessoaDaoImpl();
    
    public PhotoCamBean(){
        
    }
   
    public void oncapture(CaptureEvent captureEvent) {
 
        // obtenemos los datos de la foto como array de bytes
        final byte[] datos = captureEvent.getData();
 
        final ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().getExternalContext()
                .getContext();
        // le asignamos el nombre que sea a la imagen (en este caso siempre el mismo)
        this.foto = "foto.png";
        // ruta destino de la imagen /photocam/foto.png
        final String fileFoto = servletContext.getRealPath("") + File.separator  + File.separator + foto;
 
        FileImageOutputStream outputStream = null;
        try {
            outputStream = new FileImageOutputStream(new File(fileFoto));
            // guardamos la imagen
            outputStream.write(datos, 0, datos.length);
        } catch (IOException e) {
            throw new FacesException("Error guardando la foto.", e);
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
            }
        }
    }
 
    public void Salvar(){
        pessoa.setFoto(foto);
        pessoaDAO.salvar(pessoa);
    }
 
    public String getFoto() {
        return foto;
    }
 
    public boolean isVerFoto() {
        return foto != null;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public int getEdad() {
        return edad;
    }
 
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /**
     * @return the pessoaDAO
     */
    public PessoaDaoImpl getPessoaDAO() {
        return pessoaDAO;
    }

    /**
     * @param pessoaDAO the pessoaDAO to set
     */
    public void setPessoaDAO(PessoaDaoImpl pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }
 
}