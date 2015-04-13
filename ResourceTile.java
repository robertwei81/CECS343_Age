//ResourceTiles are initialized in the PoolOfTiles, and are then selected by users to be placed in Production Squares
public class ResourceTile {
	private String terrainType;
	private String typeOfResource;
	private int resourceQuantity,placedOnBoard;
	private boolean villager;
	//Default Constructor
	public ResourceTile(){
		//all values should be empty
		terrainType = "Void";
		typeOfResource = "None";
		resourceQuantity = 0;
		placedOnBoard = 0;
		villager = false;
	}
	
	public ResourceTile(String tt, String rt, int rq){
		terrainType = tt;
		typeOfResource = rt;
		resourceQuantity = rq;
		placedOnBoard = 0;
		villager = false;
	}
	//added for cloning same object
	public ResourceTile(ResourceTile clone){
		terrainType=clone.terrainType;
		typeOfResource=clone.typeOfResource;
		resourceQuantity=clone.resourceQuantity;
		placedOnBoard=clone.placedOnBoard;
		villager=clone.villager;
		
	}
	public String getTerrainType(){
		return terrainType;
	}
	public String getTypeOfResource(){
		return typeOfResource;
	}
	public int getResourceQuantity(){
		return resourceQuantity;
	}
	
	//villager actions or maned or not is that determine by player or set at time of 
	//acquiring resource tile?
	public void setVillager(){
		villager = true;
	}
	public void removeVillager(){
		villager = false;
	}
	public boolean hasVillager(){
		return villager;
	}
	public boolean setPlacement(){
		placedOnBoard = 1;
		return true;
	}
}
