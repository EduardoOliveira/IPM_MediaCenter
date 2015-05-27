package pt.iscte.tsi.mediamood.weka;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.io.File;

/**
 * Created by Chen on 27-05-2015.
 */
public class AttributeFilter {

    public static void main(String[] args) throws Exception {
        DataSource source = new DataSource("weka/clusstertest/Blood.arff");
        Instances dataSet = source.getDataSet();

        //Set up options to removie list attribute
        String[]opts = new String[]{"-R", "1"};
        Remove remove = new Remove();
        remove.setOptions(opts);
        remove.setInputFormat(dataSet);
        Instances newData = Filter.useFilter(dataSet, remove);

        ArffSaver saver = new ArffSaver();
        saver.setInstances(newData);
        saver.setFile(new File("weka/clussterTest/New.arff/"));
        saver.writeBatch();
    }
}
