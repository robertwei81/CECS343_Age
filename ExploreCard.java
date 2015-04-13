
public class ExploreCard extends Card {
	int tileNumber; //number of tiles to draw
	boolean permanent;
	boolean gp;
	public ExploreCard(int tileNum, String t, boolean perm, boolean god, int fc, String gn) {
		super(t, perm, god, fc, gn);
		tileNumber = tileNum;
		permanent = perm;
		gp = god;
				
	}
	public int getTileNum(){
		return tileNumber;
	}
	public String toString(){
		return "Explore Card Perm: "+permanent+" god:"+gp+" numberOfExplores: "+tileNumber;
	}
}
