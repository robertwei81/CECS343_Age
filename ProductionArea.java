
public class ProductionArea {
	String race;
	PoolOfTiles tilePool;
	//why private for productionSquares?
	private ProductionSquare [] productionSquares = new ProductionSquare[16];
	int fertile;
	int desert;
	int swamp;
	int hills;
	int forest;
	int mountains;
	ResourceState resource;
	
	public ProductionArea( String r){
		race = r;
		this.setProductionArea();
	}

	public void setProductionArea(){
		int total = 0;
		if(race.equals("Greek")){
			fertile=3;
			desert= 1;
			swamp= 1;
			hills= 8;
			forest= 2;
			mountains=1;
		}
		else if(race.equals("Norse")){
			fertile=3;
			desert= 1;
			swamp= 1;
			hills= 3;
			forest= 4;
			mountains=4;
		}
		else if(race.equals("Egypt")){
			fertile=5;
			desert= 6;
			swamp= 2;
			hills= 2;
			forest= 1;
			mountains=0;
		}
		for(int i = 0; i<fertile; i++){//set fertile production squares
			ProductionSquare PS = new ProductionSquare("fertile");
			productionSquares[total] = PS;
			total++;
		}
		int loopTotal = total + desert;
		for(int i = total; i<loopTotal;i++){//set desert production squares
			ProductionSquare PS = new ProductionSquare("desert");
			productionSquares[total] = PS;
			total++;
		}
		loopTotal = total + swamp;
		for(int i = total; i<loopTotal;i++){
			ProductionSquare PS = new ProductionSquare("swamp");
			productionSquares[total] = PS;
			total++;
		}
		loopTotal = total +hills;
		for(int i = total; i<loopTotal;i++){
			ProductionSquare PS = new ProductionSquare("hills");
			productionSquares[total] = PS;
			total++;
		}
		loopTotal = total + forest;
		for(int i = total; i<loopTotal;i++){
			ProductionSquare PS = new ProductionSquare("forest");
			productionSquares[total] = PS;
			total++;
		}
		loopTotal = total + mountains;
		for(int i = total; i<loopTotal;i++){
			ProductionSquare PS = new ProductionSquare("mountains");
			productionSquares[total] = PS;
			total++;
		}
	}
	//PlaceTile will be called from the placeTiles method of UserInterface when Explore is called from Player
	public void placeTile( ResourceTile rt){
		//int choice=UI.placeTile(productionSquares,rt);//uncomment once this is working with UI
		//while (productionSquares[choice].isFull()==false)
			//choice=UI.placeTile(productionSquares,rt);//repick////uncomment once this is working with UI
		//productionSquares[choice].fill(rt); //failure not an option must pick one
	}
	public int checkAvailableProductionSquares(ResourceTile selectedTile){
		int availableTerrainTile = 0;
		for(ProductionSquare p: productionSquares){
			if(!p.isFull()){
				p.getTerrain();
				if (p.getTerrain().equals(selectedTile.getTerrainType())){
					availableTerrainTile++;
				}		
			}
		}
		return availableTerrainTile;
	}
	//storage area or some other class will have gather method that calls the gathers of each resource depending on gatherType
	//resource cubes will only be tracked by an int, they do not need a class of their own (I think)
	void GetTerrainResource(String type,ResourceState holdings){
		int count=0;
		for (int i=0;i<productionSquares.length;i++) //rotate thru all 16 squares
			if (productionSquares[i].isFull()==true)
				if (productionSquares[i].getTile().getTerrainType()==type){
					if (productionSquares[i].getTile().hasVillager())
						count+= productionSquares[i].getTile().getResourceQuantity()+1;
					else
						count+= productionSquares[i].getTile().getResourceQuantity();
					//update holdings
					addToHoldings(type,count,holdings);
					count=0;
				}
	}
	void GetResourceType(String type, ResourceState holdings){
		int count=0;										//summation counter
		for (int i=0;i<productionSquares.length;i++) //rotate thru all 16 squares
			if (productionSquares[i].isFull()==true)
				if (productionSquares[i].getTile().getTypeOfResource()==type){
					if (productionSquares[i].getTile().hasVillager())
						count+=productionSquares[i].getTile().getResourceQuantity()+1;
					else
						count+=productionSquares[i].getTile().getResourceQuantity();
					//update holdings
					addToHoldings(type,count,holdings);
					count=0;
				}
	}
	void GetAllResource(ResourceState holdings){
		int count=0;
		for (int i=0;i<productionSquares.length;i++) //rotate thru all 16 squares
			if (productionSquares[i].isFull()==true){
				if (productionSquares[i].getTile().hasVillager())
					count+=productionSquares[i].getTile().getResourceQuantity()+1;
				else
					count+=productionSquares[i].getTile().getResourceQuantity();
				//update holdings
				addToHoldings(productionSquares[i].getTile().getTypeOfResource(),count,holdings);
				count=0;
			}
	}
	void addToHoldings(String type, int count, ResourceState holdings){
		if (type=="Gold")
			holdings.addResource(0, 0, count, 0);
		else if (type=="Wood")
			holdings.addResource(count, 0,0,0);
		else if (type=="Favor")
			holdings.addResource(0, count, 0, 0);
		else if (type=="Food")
			holdings.addResource(0,0,0,count);
	}
	void PlaceVillagers(int NumOfVillagers){
		//boolean answer=true;
		//if(answer==UI.askIfPlaceVillagers()){//uncomment once this is working with UI
			//UI.placeVillagers(NumOfVillagers,productionSquares);	//uncomment once this is working with UI
		}
		//reset villagers all to false
		//clearAllVillagers();//uncomment once this is working with UI
		
	//}
	void clearAllVillagers(){
		for (int i=0;i<productionSquares.length;i++){
			if (productionSquares[i].isFull()){
				productionSquares[i].tile.removeVillager();
			}
		}
	}
	public ProductionSquare[] getProductionSquares(){
		return productionSquares;
	}
}
