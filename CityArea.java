//CityArea is made up of CitySquares
public class CityArea {
	//ResourceState resource;
	int buildingCount;
	public int [] emptyList={0};
	private CitySquare[] CitySquares = new CitySquare[16];
	private PoolOfBuildings buildingTiles;
	int houseCount = 0;
	boolean Wall = false;
	boolean Tower = false;
	boolean StoreHouse = false;
	boolean Market = false;
	boolean Armory = false;
	boolean Quarry = false;
	boolean Monument = false;
	boolean Granary = false;
	boolean GoldMint = false;
	boolean WoodWorkshop = false;
	boolean SiegeEngineWorkshop = false;
	boolean GreatTemple = false;
	boolean TheWonder = false;
	public CityArea() {
		for(int i = 0; i<16; i++){
			CitySquare cs = new CitySquare();
			CitySquares[i] = cs;			
		}
	}
	public CityArea(CityArea ca){
		CitySquares=ca.CitySquares;
	}
	public CityArea(PoolOfBuildings pb){
		buildingTiles = pb;
		for(int i = 0; i<16; i++){
			CitySquare cs = new CitySquare();
			CitySquares[i] = cs;			
		}
	}
	/* Building purchase list()
	 * BuildHouse(),BuildWall(),BuildMarket(),BuildStoreHouse(),BuildArmory()
	 * BuildQuarry(),BuildMonument(),BuildGranery(),BuildWoodWorkShop()
	 * BuildGoldMint(),BuildSiegeEngineWorkshop(),BuildWonder(),BuildTemple()
	 */
	boolean Building(String choice,int cSquare, ResourceState resource){
		if (resource != null){
			if (choice.equals("House") && houseCount<10)return BuildHouse(cSquare, resource);
			else if (choice.equals("Wall") && !Wall)return BuildWall(cSquare, resource);
			else if (choice.equals("Market") && !Market)return BuildMarket(cSquare, resource);
			else if (choice.equals("StoreHouse") && !StoreHouse)return BuildStoreHouse(cSquare, resource);
			else if (choice.equals("Armory") && !Armory)return BuildArmory(cSquare, resource);
			else if (choice.equals("Quarry") && !Quarry)return BuildQuarry(cSquare, resource);
			else if (choice.equals("Monument") && !Monument)return BuildMonument(cSquare, resource);
			else if (choice.equals("Granary") && !Granary)return BuildGranary(cSquare, resource);
			else if (choice.equals("WoodWorkshop") && !WoodWorkshop)return BuildWoodWorkShop(cSquare, resource);
			else if (choice.equals("GoldMint") && !GoldMint)return BuildGoldMint(cSquare, resource);
			else if (choice.equals("SiegeEngineWorkshop") && !SiegeEngineWorkshop)return BuildSiegeEngineWorkshop(cSquare, resource);
			else if (choice.equals("Wonder") && !TheWonder)return BuildWonder(cSquare, resource);
			else if (choice.equals("Temple") && !GreatTemple)return BuildTemple(cSquare, resource);
		}
			//GUI tell user this building can't be built
		return false;
	}
	public CitySquare [] GetCitySquares(){
		//System.out.println("citySquares:"+CitySquares);
		return CitySquares.clone();
	}
	public void SetEmptyList(){
		int emptyIT=0;
		for (int i=0;i<16;i++){
			if (!CitySquares[i].hasBuilding){
				emptyList[emptyIT]=i;
				emptyIT++;
			}
		}
	}
	boolean House(){ // true if okay to build, false if not
		if (houseCount < 9) return true;
		else return false;
	}
	boolean BuildHouse(int cSquare, ResourceState resource){
		if (resource.CheckState(2, 0, 0, 2)){
			resource.minusResource(2, 0, 0, 2);
			CitySquares[cSquare].setBuilding(buildingTiles.getTile("House"));
			houseCount++;
			buildingCount++;
			return true;
		}
		return false;
	}
	boolean BuildWall(int cSquare, ResourceState resource){
		if (resource.CheckState(3, 0, 3, 0)){
			resource.minusResource(3, 0, 3, 0);
			CitySquares[cSquare].setBuilding(buildingTiles.getTile("Wall"));
			buildingCount++;
			Wall = true;
			return true;
		}
		return false;
	}
	boolean BuildMarket(int cSquare, ResourceState resource){
		if(resource.CheckState(0, 2, 3, 0)){
			resource.minusResource(0, 2, 3, 0);
			CitySquares[cSquare].setBuilding(buildingTiles.getTile("Market"));
			buildingCount++;
			Market = true;
			return true;
		}
		return false;
	}
	boolean BuildStoreHouse(int cSquare, ResourceState resource){
		if(resource.CheckState(2, 2, 2, 2)){
			resource.minusResource(2, 2, 2, 2);
			CitySquares[cSquare].setBuilding(buildingTiles.getTile("StoreHouse"));
			buildingCount++;
			StoreHouse = true;
			return true;
		}
		return false;
	}
	boolean BuildArmory(int cSquare, ResourceState resource){
		if(resource.CheckState(3, 0, 2, 0)){
			resource.minusResource(3, 0, 2, 0);
			CitySquares[cSquare].setBuilding(buildingTiles.getTile("Armory"));
			buildingCount++;
			Armory = true;
			return true;
		}
		return false;
	}
	boolean BuildQuarry(int cSquare, ResourceState resource){
		if(resource.CheckState(0, 0, 1, 4)){
			resource.minusResource(0, 0, 1, 4);
			CitySquares[cSquare].setBuilding(buildingTiles.getTile("Quarry"));
			buildingCount++;
			Quarry = true;
			return true;
		}
		return false;
	}
	boolean BuildMonument(int cSquare, ResourceState resource){
		if(resource.CheckState(0, 0, 2, 3)){
			resource.minusResource(0, 0, 2, 3);
			CitySquares[cSquare].setBuilding(buildingTiles.getTile("Monument"));
			buildingCount++;
			Monument = true;
			return true;
		}
		return false;
	}
	boolean BuildGranary(int cSquare, ResourceState resource){
		if(resource.CheckState(2, 0, 3, 0)){
			resource.minusResource(2, 0, 3, 0);
			CitySquares[cSquare].setBuilding(buildingTiles.getTile("Granary"));
			buildingCount++;
			Granary = true;
			return true;
		}
		return false;
	}
	boolean BuildWoodWorkShop(int cSquare, ResourceState resource){
		if(resource.CheckState(0, 0, 3, 2)){
			resource.minusResource(0, 0, 3, 2);
			CitySquares[cSquare].setBuilding(buildingTiles.getTile("WoodWorkshop"));
			buildingCount++;
			WoodWorkshop = true;
			return true;
		}
		return false;
	}
	boolean BuildGoldMint(int cSquare, ResourceState resource){
		if(resource.CheckState(2, 0, 0, 3)){
			resource.minusResource(2, 0, 0, 3);
			CitySquares[cSquare].setBuilding(buildingTiles.getTile("GoldMint"));
			buildingCount++;
			GoldMint = true;
			return true;
		}
		return false;
	}
	boolean BuildSiegeEngineWorkshop(int cSquare, ResourceState resource){
		if(resource.CheckState(3, 0, 2, 0)){
			resource.minusResource(3, 0, 2, 0);
			CitySquares[cSquare].setBuilding(buildingTiles.getTile("SiegeEngineWorkshop"));
			buildingCount++;
			SiegeEngineWorkshop = true;
			return true;
		}
		return false;
	}
	boolean BuildWonder(int cSquare, ResourceState resource){
		if(resource.CheckState(10, 10, 10, 10)){
			resource.minusResource(10, 10, 10, 10);
			CitySquares[cSquare].setBuilding(buildingTiles.getTile("Wonder"));
			buildingCount++;
			TheWonder = true;
			return true;
		}
		return false;
	}
	boolean BuildTemple(int cSquare, ResourceState resource){
		if (resource.CheckState(4,4,4,4)){
			resource.minusResource(4, 4, 4, 4);
			CitySquares[cSquare].setBuilding(buildingTiles.getTile("Temple"));
			buildingCount++;
			GreatTemple = true;
			return true;
		}
		return false;
	}
	public void demolishBuilding(int bd){
		Building b = CitySquares[bd].getBuilding();
		if (b.getType().equals("House")) houseCount--;
		else if(b.getType().equals("Wall")) Wall = false;
		else if(b.getType().equals("Market")) Market = false;
		else if(b.getType().equals("StoreHouse"))StoreHouse = false;
		else if(b.getType().equals("Armory")) Armory = false;
		else if(b.getType().equals("Quarry")) Quarry = false;
		else if(b.getType().equals("Monument"))Monument = false;
		else if(b.getType().equals("Granary")) Granary = false;
		else if(b.getType().equals("WoodWorkshop")) WoodWorkshop = false;
		else if(b.getType().equals("GoldMint"))GoldMint = false;
		else if(b.getType().equals("SiegeEngineWorkshop")) SiegeEngineWorkshop = false;
		else if(b.getType().equals("Temple")) GreatTemple = false;
		else if(b.getType().equals("Wonder"))TheWonder = false;
		CitySquares[bd].removeBuilding();	
		buildingCount--;
	}
	public boolean cityFull(){
		if(buildingCount == 16) return false;
		return true;
	}
	public boolean hasWall(){
		return Wall;
	}
	public boolean hasTower(){
		return Tower;
	}
	public boolean hasStoreHouse (){
		return StoreHouse;
	}
	public boolean hasMarket(){
		return Market;
	}
	public boolean hasArmory(){
		return Armory;
	}
	public boolean hasQuarry(){
		return Quarry;
	}
	public boolean hasMonument(){
		return Monument;
	}
	public boolean hasGranary(){
		return Granary;
	}
	public boolean hasGoldMint(){
		return GoldMint;
	}
	public boolean hasWoodWorkshop(){
		return WoodWorkshop;
	}
	public boolean hasSiegeEngineWorkshop(){
		return SiegeEngineWorkshop;
	}
	public boolean hasGreatTemple(){
		return GreatTemple;
	}
	public boolean hasTheWonder(){
		return TheWonder;
	}
}
