package fr.grph3.univlille;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.utils.CSVModel;
import fr.grph3.univlille.utils.KnnMethod;
import fr.grph3.univlille.utils.distances.ManhattanDistance;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestKnnMethod {

	
	private CSVModel<Iris> model;
	private KnnMethod<Iris> knn;
	
	List<Iris> points = new ArrayList<>();

    private ManhattanDistance<Iris> distance;

    @BeforeEach
    void setUp(){
        this.model = new CSVModel<>(Iris.class, "Iris");
        this.knn = new KnnMethod<>();
        model.loadFromFile("src/main/resources/irisTest.csv");
        this.distance = new ManhattanDistance<>(model.getColumns());
    }
    
    @Test
    void test_getNeighbours() {
    	points.add(model.getPoint(0));
    	points.add(model.getPoint(1));
    	points.add(model.getPoint(2));
    	
    	assertTrue(knn.getNeighbours(model.getPoint(5), 3, distance, model).containsAll(points));

    }
    
    @Test
    void test_classifier() {
    	points.add(model.getPoint(0)); //Setosa
    	points.add(model.getPoint(1)); //Setosa
    	points.add(model.getPoint(3)); //Versicolor
    	
    	assertEquals("Setosa", knn.classifier(points));

    }
}
