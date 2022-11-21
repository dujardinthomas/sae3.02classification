package fr.grph3.univlille.utils;

import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.models.columns.IColumn;
import fr.grph3.univlille.models.columns.NullColumn;
import fr.grph3.univlille.models.points.IPoint;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVModel<T extends IPoint> implements IDataSet<T> {

    private Class<T> dataType;

    public String title;

    private List<IColumn> columns;

    private List<T> points;

    public CSVModel(Class<T> dataType, String title) {
        this.dataType = dataType;
        this.title = title;
        this.points = new ArrayList<>();
        this.init();
    }

    private void init() {
        ColumnFactory factory = new ColumnFactory();
        this.columns = factory.generate(dataType);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getTotalPoints() {
        return points.size();
    }

    @Override
    public void setPoints(List<T> points) {
        this.points = points;
    }

    @Override
    public void addPoint(T point) {
        this.points.add(point);
    }

    @Override
    public void addPoints(List<T> points) {
        this.points.addAll(points);
    }

    public void loadFromFile(String path) {
        CSVUtil.loadCSVAsFile(Path.of(path), dataType);
    }

    public void loadFromString(String data) {

    }

    public IColumn defaultXCol() {
        IColumn defX = columns.get(0);
        return defX == null ? new NullColumn() : defX;
    }

    public IColumn defaultYCol() {
        IColumn defY = columns.get(1);
        return defY == null ? new NullColumn() : defY;
    }

    public List<IColumn> getColumns() {
        return columns;
    }

    public int nbColumns() {
        return columns.size();
    }

    @Override
    public Iterator<T> iterator() {
        return points.iterator();
    }
}
