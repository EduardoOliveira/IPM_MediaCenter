package pt.iscte.tsi.mediamood;
import pt.iscte.tsi.mediamood.database.entity.Movie;
import pt.iscte.tsi.mediamood.database.entity.MovieDAO;
import weka.core.Instances;
import weka.core.converters.ArffLoader.ArffReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Chen on 12-05-2015.
 */
public class Main {

    public void connectToDB(){
        MovieDAO movieDao = new MovieDAO();
        List<Movie> movies = movieDao.find().asList();
        int i = 0;
        for(Movie m: movies){
            if(i<10){
           System.out.println(m.getClusters());
            i++;}
        }
    }


    public void readArffFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("weka/clusters/Blood.arff"));
        ArffReader arff = new ArffReader(reader);
        Instances data = arff.getData();
        int j = 0;
        for(int k = 0; k < data.numInstances(); k++){
            if(data.instance(k).stringValue(2).equals("yes")){
                System.out.println(data.instance(k).stringValue(0));
                j +=1;
            }

        }
        System.out.println(j);
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.connectToDB();
       // try {
            //m.readArffFile();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

    }



}
