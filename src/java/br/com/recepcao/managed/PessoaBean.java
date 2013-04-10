/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recepcao.managed;

import br.com.recepcao.dao.PessoaDaoImpl;
import br.com.recepcao.model.Pessoa;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import org.primefaces.event.CaptureEvent;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author gabriel
 */
@ManagedBean(name = "pessoaMB")
@SessionScoped
public class PessoaBean implements Serializable {

    private Pessoa pessoa = new Pessoa();
    private PessoaDaoImpl pessoaDAO = new PessoaDaoImpl();
    private UploadArquivo arquivo = new UploadArquivo();
    private List<Pessoa> listarPessoas = new ArrayList<Pessoa>();
    private String foto = new String();

    public PessoaBean() {
    }

        //CAPTURAR FOTO DA WEBCAM
 public void oncapture(CaptureEvent captureEvent) {
 
        final byte[] datos = captureEvent.getData();
 
        final ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().getExternalContext()
                .getContext();
        this.foto = new Date().getTime() +".jpg";
        final String fileFoto = servletContext.getRealPath("") + File.separator +"/fotos/" + File.separator + foto;
 
        this.pessoa.setFoto(this.foto);
        FileImageOutputStream outputStream = null;
        try {
            outputStream = new FileImageOutputStream(new File(fileFoto));
            outputStream.write(datos, 0, datos.length);
        } catch (IOException e) {
            throw new FacesException("Erro ao salvar a foto", e);
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
            }
        }
    }
    
    public void uploadAction(FileUploadEvent event) {
        this.arquivo.fileUpload(event, ".jpg", "/fotos/");
        this.pessoa.setFoto(this.arquivo.getNome());
    }

    public void salvar() {
          pessoaDAO.salvar(pessoa);
          pessoa = new Pessoa();

    }

    
    public void novo() {
        pessoa = new Pessoa();
    }
    
     public boolean isVerFoto() {
        return foto != null;
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

    /**
     * @return the arquivo
     */
    public UploadArquivo getArquivo() {
        return arquivo;
    }

    /**
     * @param arquivo the arquivo to set
     */
    public void setArquivo(UploadArquivo arquivo) {
        this.arquivo = arquivo;
    }

    /**
     * @return the listarPessoas
     */
    public List<Pessoa> getListarPessoas() {
        return listarPessoas;
    }

    /**
     * @param listarPessoas the listarPessoas to set
     */
    public void setListarPessoas(List<Pessoa> listarPessoas) {
        this.listarPessoas = listarPessoas;
    }

    /**
     * @return the foto
     */
    /**
     * @param foto the foto to set
     */

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }
}
