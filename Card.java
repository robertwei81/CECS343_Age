
public class Card {
	public boolean isPerm; // true if perm, false if not
	public String type;
	public boolean isGod; // true if god, false if not
	public int favorCost; //only not 0 if god card
	public String godName; //only not null if god card
	
	//image file include here for v2 gui display
	
	public Card(String Type, boolean ifPerm, boolean ifGod, int favCost, String gName){
		isPerm=ifPerm; 
		type = Type;
		isGod = ifGod;
		favorCost = favCost;
		godName = gName;
	}
	public Card(Card clone){
		isGod = clone.getIsGod();
		isPerm=clone.getIsPerm();
		type=clone.getType();
	}
	public String getType(){
		return type;
	}
	public boolean getIsGod(){
		return isGod;
	}
	public boolean getIsPerm(){
		return isPerm;
	}
	public int getFavorCost(){
		return favorCost;
	}
	public String getGodName(){
		return godName;
	}
}