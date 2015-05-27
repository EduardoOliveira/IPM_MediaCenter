package pt.iscte.tsi.mediamood.weka;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;

import java.io.*;

/**
 * Created by Chen on 27-05-2015.
 */
public class LoadSaveData {

    public static void main(String[] args) throws Exception {
        DataSource source = new DataSource("weka/clussterTest/Blood.arff") ;
        Instances dataSet = source.getDataSet();
        System.out.println(dataSet.toSummaryString());
        ArffSaver saver = new ArffSaver();
        saver.setInstances(dataSet);
        saver.setFile(new File("weka/clussterTest/New.arff"));
        saver.writeBatch();

    }
}
