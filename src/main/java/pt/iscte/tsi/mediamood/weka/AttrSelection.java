package pt.iscte.tsi.mediamood.weka;

import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;

import java.io.File;

/**
 * Created by Chen on 27-05-2015.
 */
public class AttrSelection {
    public static void main(String[] args) throws Exception {
        DataSource source = new DataSource("weka/clussterTest/Blood.arff");
        Instances dataSet = source.getDataSet();

        AttributeSelection filter = new AttributeSelection();
        CfsSubsetEval eval = new CfsSubsetEval();
        GreedyStepwise search = new GreedyStepwise();

        search.setSearchBackwards(true);
        filter.setEvaluator(eval);
        filter.setSearch(search);

        filter.setInputFormat(dataSet);

        Instances newData = Filter.useFilter(dataSet, filter);

        ArffSaver saver =new ArffSaver();
        saver.setInstances(newData);
        saver.setFile(new File("weka/clussterTest/NewAttrSelection.arff"));
        saver.writeBatch();
    }
}
