
public class BuildCard extends Card {
	int buildingNum; //number of buildings you can build
	boolean permanent;
	boolean gp;
	String gname;
	public BuildCard(int bn, String t, boolean perm, boolean god, int fc, String gn) {
		super(t, perm, god, fc, gn);
		buildingNum = bn;
		permanent = perm;
		gp = god;
		gname = gn;
	}
	public int getBuildingNum(){
		return buildingNum;
	}
	public String toString(){
		return "Build Card Perm: "+permanent+" god:"+gp+" buildingNumb: "+buildingNum+ " gName:"+gname;
	}
}
