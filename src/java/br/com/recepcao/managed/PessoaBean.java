/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recepcao.managed;

import br.com.recepcao.dao.PessoaDaoImpl;
import br.com.recepcao.model.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
    private PhotoCamBean webcam = new PhotoCamBean();
    public PessoaBean() {
        
    
    }
    
       public void uploadAction(FileUploadEvent event) {
        this.arquivo.fileUpload(event, ".jpg", "/image/");
        this.pessoa.setFoto(this.arquivo.getNome());
    }
         public void salvar() {
        // new ColaboradorDao().salvar(colaborador);
        
        pessoaDAO.salvar(pessoa);
        this.arquivo.gravar();
        pessoa = new Pessoa();
        arquivo = new UploadArquivo();
        
    }
          public void novo() {
        pessoa = new Pessoa();
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
     * @return the webcam
     */
    public PhotoCamBean getWebcam() {
        return webcam;
    }

    /**
     * @param webcam the webcam to set
     */
    public void setWebcam(PhotoCamBean webcam) {
        this.webcam = webcam;
    }
    
}
