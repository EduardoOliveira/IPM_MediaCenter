package pt.iscte.tsi.mediamood.weka;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.supervised.attribute.Discretize;

/**
 * Created by Chen on 27-05-2015.
 */
public class DiscretizeAttribute {
    public static void main(String[] args) throws Exception {
        DataSource source = new DataSource("weka/clussterTest/Blood.arff");
        Instances dataSet = source.getDataSet();

        String[] options = new String[4];
        options[0] = "-B";
        options[1] = "2";
        options[2] = "-R";
        options[3] = "first-last";

        Discretize discretize = new Discretize();
        discretize.setOptions(options);
        discretize.setInputFormat(dataSet);
        Instances newData = Filter.useFilter(dataSet, discretize);
    }
}
