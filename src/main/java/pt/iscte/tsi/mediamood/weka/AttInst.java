package pt.iscte.tsi.mediamood.weka;

import weka.core.AttributeStats;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.experiment.Stats;

/**
 * Created by Chen on 27-05-2015.
 */
public class AttInst {
    public static void main(String[] args) throws Exception {
        DataSource source = new DataSource("weka/clussterTest/Blood.arff");
        Instances data = source.getDataSet();

        if(data.classIndex() == -1){
            data.setClassIndex(data.numAttributes() -1);
        }
        int numAttr = data.numAttributes()-1;
        for(int i = 0; i < numAttr; i++){
            if(data.attribute(i).isNominal()){
                int n = data.attribute(i).numValues();
                System.out.println("The " + i +"th Attribute Has: " + n+ " values" );

            }

            AttributeStats as = data.attributeStats(i);
            int dC = as.distinctCount;
            System.out.println(i + "Has " + dC + " distinct values");

            if(data.attribute(i).isNumeric()){
                Stats s = as.numericStats;
                System.out.println(i + "Attribute has min value " + s.min + "and max "+  s.max);
            }
        }
        int numInst = data.numInstances();
        for(int j = 0; j < numInst; j++){
            Instance instance = data.instance(j);
            if (instance.isMissing(0)){
                System.out.println("The " + 0 + "Att is missing");
            }
            if (instance.classIsMissing()){
                System.out.println("The class is missing in the " + j + "instance");

            }
            double cv = instance.classValue();
            System.out.println(instance.classAttribute().value((int)cv));
        }
    }
}
