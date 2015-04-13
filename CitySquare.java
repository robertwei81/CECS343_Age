
public class CitySquare {
	Building cityBuilding;
	boolean hasBuilding;
	public CitySquare(){
		cityBuilding = new Building ("");
		hasBuilding = false;
	}
	public void setBuilding(Building b){
		cityBuilding = new Building(b);
		hasBuilding = true;
	}
	public Building getBuilding(){
		return cityBuilding;
	}
	public Building removeBuilding(){
		
		cityBuilding = null;
		return this.getBuilding();
	}
	public String toString(){
		if(hasBuilding) return cityBuilding.getType();
		else return null;
	}
}
