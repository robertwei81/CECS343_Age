import java.util.ArrayList;
public class PoolOfBuildings {
	ArrayList<Building> buildingList = new ArrayList<Building>();
	public PoolOfBuildings(){
		this.setBuildings();
	}
	private void setBuildings(){
		for (int i=0; i<10;i++){
			buildingList.add(new Building("House"));
		}
		buildingList.add(new Building("Wall"));
		buildingList.add(new Building("Market"));
		buildingList.add(new Building("StoreHouse"));
		buildingList.add(new Building("Armory"));
		buildingList.add(new Building("Quarry"));
		buildingList.add(new Building("Monument"));
		buildingList.add(new Building("Granary"));
		buildingList.add(new Building("WoodWorkshop"));
		buildingList.add(new Building("GoldMint"));
		buildingList.add(new Building("SiegeEngineWorkshop"));
		buildingList.add(new Building("Wonder"));
		buildingList.add(new Building("Temple"));			
	}
	public Building getTile(String type){
		int index = 0;
		for( Building b:buildingList){
			if(b.getType().equals(type)){
				index = buildingList.indexOf(b);
			}
		}
		return buildingList.remove(index);
	}
	public void addTile(Building tile){
		buildingList.add(tile);
	}
	public int getNumberOfTiles(){
		return buildingList.size();
	}
	public ArrayList<Building> getList() {
		return buildingList;
	}
	public void removeBuilding(int b){
		buildingList.remove(b);
	}
}