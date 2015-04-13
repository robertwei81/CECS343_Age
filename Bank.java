public class Bank {
	int wood;
	int favor;
	int gold;
	int food;
	int victoryCubes;

	public Bank(boolean check, int NumOfPlayers){
		if (NumOfPlayers==3){
			setResource(25,25,25,25);
			setvictoryCubes(30);			
		}
	}
	
	public Bank(int Wood,int Favor, int Gold, int Food, int VictoryCubes){
		wood=Wood;
		favor=Favor;
		gold=Gold;
		food=Food;
		victoryCubes = VictoryCubes;
	}
	void setResource (int Wood,int Favor, int Gold, int Food){
		wood=Wood;
		favor=Favor;
		gold=Gold;
		food=Food;
	}
	void setvictoryCubes(int cubes){
		victoryCubes=cubes;
	}
	void minusVictoryCubes(int cubes){
		victoryCubes-=victoryCubes;
	}
	void addResource (int wood,int favor, int gold, int food){
		wood+=wood;
		favor+=favor;
		gold+=gold;
		food+=food;
	}

	void addResource (int all){
		wood+=all;
		favor+=all;
		gold+=all;
		food+=all;
	}
	void minusResource (int wood,int favor, int gold, int food){
		wood-=wood;
		favor-=favor;
		gold-=gold;
		food-=food;
	}
	void minusResource (int all){
		wood-=all;
		favor-=all;
		gold-=all;
		food-=all;
	}
	boolean CheckState (int wood,int favor, int gold, int food){
		if ( wood < wood ){ return false;}
		if ( favor < favor){return false;}
		if ( gold < gold ){ return false;}
		if ( food < food ){ return false;}
		return true;
	}
	boolean CheckState (int all){
		if ( wood < all ){ return false;}
		if ( favor < all ){return false;}
		if ( gold < all ){ return false;}
		if ( food < all ){ return false;}
		return true;
	}
	boolean CheckvictoryCubes(){
		if ( victoryCubes > 1) 
			return true;
		return false;
	}
	void AddToBank(Payment note){
		if ( note.GetType() == "wood" ){ wood+=note.GetPaid();}
		if ( note.GetType() == "favor"){ favor+=note.GetPaid();}
		if ( note.GetType() == "gold" ){ gold+=note.GetPaid();}
		if ( note.GetType() == "food" ){ food+=note.GetPaid();}
	}	public void minusResource(Payment slip) {
		if(slip.GetType()=="wood") 
			wood-=slip.GetPaid();
		else if(slip.GetType()=="favor")
			favor-=slip.GetPaid();
		else if(slip.GetType()=="gold") 
			gold-=slip.GetPaid();
		else if(slip.GetType()=="food") 
			food-=slip.GetPaid();
	}
	public void addResource(Payment slip) {
		if(slip.GetType()=="wood") 
			wood+=slip.GetPaid();
		else if(slip.GetType()=="favor")
			favor+=slip.GetPaid();
		else if(slip.GetType()=="gold") 
			gold+=slip.GetPaid();
		else if(slip.GetType()=="food") 
			food+=slip.GetPaid();
	}
}

