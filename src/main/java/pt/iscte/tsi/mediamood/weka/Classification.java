package pt.iscte.tsi.mediamood.weka;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMO;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * Created by Chen on 27-05-2015.
 */
public class Classification {

    public static void main(String[] args) throws Exception {
        DataSource source = new DataSource("weka/clussterTest/Blood.arff");
        Instances dataSet = source.getDataSet();

        dataSet.setClassIndex(dataSet.numAttributes() - 1);

        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(dataSet);


        System.out.println(nb.getCapabilities().toString());

        SMO smo = new SMO();
        smo.buildClassifier(dataSet);
        System.out.println(smo.getCapabilities().toString());
    }
}
