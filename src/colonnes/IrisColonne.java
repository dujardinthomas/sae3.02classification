package colonnes;

import Interfaces.IColumn;
import Interfaces.IDataset;
import Interfaces.IPoint;
import Interfaces.IValueNormalizer;

public class IrisColonne implements IColumn{
	
	public String name;
	
	public double maxSepalLength;
	public double minSepalLength;
	
	public double maxSepalWidth;
	public double minSepalWidth;
	
	public double maxPetalLength;
	public double minPetalLength;
	
	public double maxPetalWidth;
	public double minPetalWidth;
	
	
	

	@Override
	public void setNormalizer(IValueNormalizer valueNormalizer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getNormalizedValue(IPoint point) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getDenormalizedValue(double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDataset getDataset() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNormalizable() {
		// TODO Auto-generated method stub
		return false;
	}

}