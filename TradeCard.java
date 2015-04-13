


public class TradeCard extends Card {
	public int tradeCost;
	public boolean permanent;
	public boolean gp;
	public TradeCard(int tCost, String t, boolean perm, boolean god, int fc, String gn){
		super( t, perm, god, fc, gn);
		tradeCost = tCost;
		gp = god;
		permanent = perm;
	}
	public int getTradeCost(){
		return tradeCost;
	}
	public String toString(){
		return "Trade Card Perm: "+permanent+" god:"+gp+" tradeCost: "+tradeCost;
	}
}
