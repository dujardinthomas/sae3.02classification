package calcul;
import java.lang.reflect.Type;
import java.util.List;

import Interfaces.IColumn;
import Interfaces.IPoint;

public class Pokemon implements IPoint {
	private String name;
	private int attack;
	private int baseEggSteps;
	private double captureRate;
	private int defense;
	private int experienceGrowth;
	private int hp;
	private int spAttack;
	private int spDefense;
	private Type type1;
	private Type type2;
	private double speed;
	private boolean isLegendary;

	
	public Pokemon (String name,int attack, int baseEggSteps,double captureRate,int defense,int experienceGrowth,
			int hp,int spAttack, int spDefense, Type type1, Type type2, double speed, boolean isLegendary) {
		this.attack = attack;
		this.baseEggSteps = baseEggSteps;
		this.captureRate = captureRate;
		this.defense = defense;
		this.experienceGrowth = experienceGrowth;
		this.hp = hp;
		this.isLegendary = isLegendary;
		this.name = name;
		this.spAttack = spAttack;
		this.spDefense = spDefense;
		this.speed = speed;
		this.type1 = type1;
		this.type2 = type2;
	}
	
	public List<Pokemon> getClosest(List<Pokemon> elements, int number) {
        // TODO Auto-generated method stub
        return null;
    }
	
	
	@Override
	public String toString() {
		return "Pokemon [nom=" + name + ", attack=" + attack + ", baseEggSteps=" + baseEggSteps + ", captureRate="
				+ captureRate + ", defense=" + defense + ", experienceGrowth=" + experienceGrowth + ", hp=" + hp
				+ ", spAttack=" + spAttack + ", spDefense=" + spDefense + ", type=" + type1 + ", type2=" + type2
				+ ", speed=" + speed + ", isLegendary=" + isLegendary + "]";
	}

	@Override
	public Object getValue(IColumn col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getNormalizedValue(IColumn xcol) {
		// TODO Auto-generated method stub
		return 0;
	}
}