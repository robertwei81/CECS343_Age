import java.util.ArrayList;
public class ResourceState {
	int wood;
	int favor;
	int gold;
	int food;
	int VICTORYCUBES;
	//initialized state fill in later
	private ArrayList<ResourceTile> playerTiles = new ArrayList<ResourceTile>();	

	public ResourceState(){
		this(4);//initial state
	}
	public ResourceState(String bank,int numOfPlayers){
		//
	}
	public ResourceState(int All){
		wood=favor=gold=food=All;		
	}
	public ResourceState (int woodInput,int favorInput, int goldInput, int foodInput){
		wood=woodInput;
		favor=favorInput;
		gold=goldInput;
		food=foodInput;
	}
	void setResource (int woodInput,int favorInput, int goldInput, int foodInput){
		wood=woodInput;
		favor=favorInput;
		gold=goldInput;
		food=foodInput;
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
	public boolean CheckState(Payment slip){
		if(slip.GetType()=="wood") return (wood>slip.GetPaid());
		if(slip.GetType()=="favor") return (favor>slip.GetPaid());
		if(slip.GetType()=="gold") return (gold>slip.GetPaid());
		if(slip.GetType()=="food") return (food>slip.GetPaid());
		return false;
	}
	ResourceTile storeTile(PoolOfTiles pool){
		ResourceTile a = new ResourceTile(pool.getTile());
		playerTiles.add(a);
		//not sure if its size-1 or just size
		return playerTiles.get(playerTiles.size()-1);
	}
	public int SumOfHoldings(){
		return (wood+favor+gold+food);
	}
	public void minusResource(Payment slip) {
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


