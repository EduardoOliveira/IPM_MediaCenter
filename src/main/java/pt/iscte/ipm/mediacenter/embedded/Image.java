package pt.iscte.ipm.mediacenter.embedded;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by Admin on 17-02-2015.
 */

@Embedded
public class Image {

    @Id
    private String fileName;
    private double size;

    public Image(String fileName, double size){
        this.fileName = fileName;
        this.size = size;
    }

    //Getters
    public String getFileName(){
        return fileName;
    }
    public double size(){
        return size;
    }

    //Setters
    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public void setSize(int size){
        this.size = size;
    }
}
