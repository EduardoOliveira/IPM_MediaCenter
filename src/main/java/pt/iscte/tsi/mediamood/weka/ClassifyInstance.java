package pt.iscte.tsi.mediamood.weka;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * Created by Chen on 27-05-2015.
 */
public class ClassifyInstance {
    public static void main(String[] args) throws Exception {
        DataSource source = new DataSource("weka/clussterTest/BloodNew.arff");
        Instances trainDataSet = source.getDataSet();

        trainDataSet.setClassIndex(trainDataSet.numAttributes() -1);
        int numClasses = trainDataSet.numClasses();
        for(int i = 0; i < numClasses; i++){
            String classValue = trainDataSet.classAttribute().value(i);
            System.out.println("Class Value " + i + " is " + classValue);
        }
        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(trainDataSet);

        DataSource source1 = new DataSource("weka/clussterTest/BloodNew2.arff");
        Instances testDataSet = source1.getDataSet();
        testDataSet.setClassIndex(testDataSet.numAttributes() - 1);

        System.out.println("Actual Classe, NB Predicted");
        for(int i = 0; i<testDataSet.numInstances(); i++){
            double actualClass = testDataSet.instance(i).classValue();
            String actual = testDataSet.classAttribute().value((int) actualClass);
            Instance newInst = testDataSet.instance(i);
            double predNB = nb.classifyInstance(newInst);
            String predString = testDataSet.classAttribute().value((int)predNB);
            System.out.println(actual + ", " + predString);
        }
    }
}
