package fr.grph3.univlille.utils;

import com.opencsv.bean.CsvToBeanBuilder;
import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.models.points.Titanic;
import fr.grph3.univlille.models.points.builders.TitanicBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataLoader<T extends IPoint> extends MVCModel<T> {

    private List<T> points;

    public DataLoader() {
        this.points = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public int getNbLines() {
        return points.size();
    }

    @Override
    public void setLines(List<T> lines) {
        this.points = lines;
    }

    @Override
    public void addLine(T element) {
        points.add(element);
    }

    @Override
    public void addAllLine(List<T> elements) {
        points.addAll(elements);
    }

    @Override
    public void loadFromFile(String path, Class<T> dataType) {
        try {
            this.points = new CsvToBeanBuilder<T>(Files.newBufferedReader(Paths.get(path))).withSeparator(',')
                    .withType(dataType)
                    .build()
                    .parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) throws IllegalStateException, IOException {
    	List<Iris> a = Iris.loadIris("src/main/resources/iris.csv");
    	System.out.println(a.get(0).variety);
    	
    	
    	List<Titanic> b = Titanic.loadTitanic("src/main/resources/titanic.csv");
    	System.out.println(b.get(0).getAge());
	}

    @Override
    public void loadFromString(String data) {

    }

    @Override
    public IColumn defaultXCol() {
        return null;
    }

    @Override
    public IColumn defaultYCol() {
        return null;
    }

    @Override
    public int nbColumns() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return points.iterator();
    }
}