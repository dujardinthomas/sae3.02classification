package fr.grph3.univlille.models.columns;

import fr.grph3.univlille.models.IDataSet;

import java.util.ArrayList;
import java.util.List;

public class StringColumn implements IColumn {

    private String name;

    private List<String> values;

    public StringColumn(String name) {
        this.values = new ArrayList<>();
    }

    @Override
    public boolean push(Object value) {
        if (!(value instanceof String)) return false;
        return values.add((String) value);
    }

    @Override
    public double getNormalizedValue(Object value) {
        throw new UnsupportedOperationException("Cannot normalize a string value");
    }

    @Override
    public Object getDenormalizedValue(double value) {
        throw new UnsupportedOperationException("Cannot denormalize a string value");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IDataSet<?> getDataset() {
        return null;
    }

    @Override
    public boolean isNormalizable() {
        return false;
    }
}