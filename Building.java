
public class Building {
	String buildingType;
	//image file include here for v2 gui display
	boolean villager = false;
	public Building(String type){
		buildingType = type;
	}
	public Building(Building clone){
		buildingType = clone.buildingType;
	}
	public String getType(){
		return buildingType;
	}
	public boolean hasVillager(){
		return villager;
	}
	public boolean placeVillager(){
		villager = true;
		return true;
	}
}
