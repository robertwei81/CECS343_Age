
public class NextAgeCard extends Card {
	int classicalCost;
	int heroicCost;
	int mythicCost;
	boolean permanent;
	boolean gp;
	public NextAgeCard(int cCost, int hCost, int mCost, String t, boolean perm, boolean god, int fc, String gn) {
		super(t, perm, god, fc, gn);
		classicalCost = cCost;
		heroicCost = hCost;
		mythicCost = mCost;
		permanent = perm;
		gp = god;
	}
	public int getClassicalCost(){
		return classicalCost;
	}
	public int getHeroicCost(){
		return heroicCost;
	}
	public int getMythicCost(){
		return mythicCost;
	}
	int getNextAgeCost(int age){ // 
		if (age ==0) return classicalCost;
		else if (age ==1) return heroicCost;
		else if (age ==2) return mythicCost;
		return 1000;  
	}
	public String toString(){
		return "NextAge Card Perm: "+permanent+" god:"+gp+" classicalCost: "+classicalCost;
	}
}
