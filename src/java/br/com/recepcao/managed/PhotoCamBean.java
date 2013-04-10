/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recepcao.managed;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import org.primefaces.event.CaptureEvent;

/**
 *
 * @author gabriel
 */
public class PhotoCamBean {  
     
    private List<String> photos = new ArrayList<String>();  
      
    private String getRandomImageName() {  
        int i = (int) (Math.random() * 10000000);  
          
        return String.valueOf(i);  
    }  
  
    public List<String> getPhotos() {  
        return photos;  
    }      
      
    public void oncapture(CaptureEvent captureEvent) {  
        String photo = getRandomImageName();  
        this.getPhotos().add(0,photo);  
        byte[] data = captureEvent.getData();  
          
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
        String newFileName = servletContext.getRealPath("") + File.separator + "photocam" + File.separator + photo + ".jpg";  
          
        FileImageOutputStream imageOutput;  
        try {  
            imageOutput = new FileImageOutputStream(new File(newFileName));  
            imageOutput.write(data, 0, data.length);  
            imageOutput.close();  
        }  
        catch(Exception e) {  
            throw new FacesException("Error in writing captured image.");  
        }  
    }  

    /**
     * @param photos the photos to set
     */
    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
}  
