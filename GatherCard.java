
public class GatherCard extends Card {
	int gatherType; //0 if only terrainType or resourceType, 1 if gather all, 2 if food
	boolean permanent;
	boolean gp;
	public GatherCard(int gType, String t, boolean perm, boolean god, int fc, String gn) {
		super(t, perm, god, fc, gn);
		gatherType = gType;
	}
	int getGatherType(){
		return gatherType;
	}
	public String toString(){
		return "Gather Card Perm: "+permanent+" god:"+gp+" gatherType: "+gatherType;
	}

}
