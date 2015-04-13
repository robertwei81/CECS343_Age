import java.util.ArrayList;
public class player {
	private String Race;
	private String Name; 
	private ArrayList<Card> CardsInHand = new ArrayList<Card>();
	private PoolOfBuildings buildingPool = new PoolOfBuildings();
	private PermanentDeck PermDeck = new PermanentDeck();
	//ArrayList<Units> Military = new ArrayList<Units>();
	//or a class with count of each unit(type)
	//or a array with an appropriate unit indexes
	private ResourceState resource;
	private ProductionArea pArea;
	private CityArea cArea;
	
	int ageState=0;//0 for archaic, 1 for classical, 2 for heroic, 3 for mythic
	int Race_index=0;
	int MaxResource=5;
	
	UserInterface UI;

	//Constructor starts here
	public player(int Selection, String name){
		Race_index=Selection;
		Name=name;
		if (Selection == 1 ){Race="Norse";}
		else if (Selection == 2 ){Race="Greek";}
		else if (Selection == 3 ){Race="Egypt";}
		resource=new ResourceState (4,4,4,4); //default
		//should be the original list and modified the original when changed
		pArea= new ProductionArea(Race);
	}
	/* Building purchase list
	 * BuildHouse(),BuildWall(),BuildMarket(),BuildStoreHouse(),BuildArmory() [1-5]
	 * BuildQuarry(),BuildMonument(),BuildGranery(),BuildwoodWorkShop() [6-9]
	 * BuildgoldMint(),BuildSiegeEngineWorkshop(),BuildWonder(),BuildTemple() [10-13]
	 */
	public String getPlayerName(){
		return Name;
	}
	public String getPlayerRace(){
		return Race;
	}
	public int getAgeState(){
		return ageState;
	}
	public ResourceState getResourceState(){
		return resource;
	}
	public CityArea GetCityArea(){
		return cArea;
	}
/*	public int [] GetEmptyCityArea(){
		int [] emptyList ={};
		int emptyIT=0;
		for (int i=0;i<16;i++){
			if (!GetCitySquares().clone()[i].hasBuilding){
				emptyList[emptyIT]=i;
				emptyIT++;
			}
		}
		return emptyList; 
	}
*/	boolean PlaceVictoryCube(VictoryCard [] victorys){
		int choice = UserInterface.dropVictoryCubes(victorys);
		if ( choice > 0 && choice < 3){
			victorys[choice].cubeCount++;
			return true;
		}
		else 
			return false;
	}
	void DrawCards(RandomDeck randomDeck){
		boolean answer=false;
		int index=0;
		//Prompt "do you wish to take a card from the permanent deck?

		while(maxHandSize()!=CardsInHand.size()){
			answer=UserInterface.selectDrawDeck();
			if(answer==true){
				index=UserInterface.getPermCardIndex(PermDeck);
				CardsInHand.add(PermDeck.Draw(index));
			}
			else CardsInHand.add(randomDeck.Draw());
			System.out.println(CardsInHand.size());
		}
		System.out.println(CardsInHand);
	}
	
	void Spoil(){
		if ( resource.wood > MaxResource){resource.favor=MaxResource;}
		if ( resource.favor> MaxResource){resource.favor=MaxResource;}
		if ( resource.gold > MaxResource){resource.favor=MaxResource;}
		if ( resource.food > MaxResource){resource.favor=MaxResource;}
	}
	
	void returnCard(Card played, RandomDeck rDeck){
		if (played.getIsPerm())PermDeck.cardBack(played);
		else rDeck.cardBack(played);			
	}
	
	public boolean Trade(TradeCard played, Bank bank){ 
		int cost=played.getTradeCost(); 
		Payment toBank;
		while ((cost > 0) && (resource.SumOfHoldings() > cost)){
			toBank = UserInterface.askForPayment(cost);
			cost-=toBank.GetPaid();
			bank.AddToBank(toBank);
		}
		boolean checkState=false;
		Payment tradePayment;
		while (!checkState){
			//What you trading in?
			String resourceType = UserInterface.tradeResourceTypeSelection(resource);
			//How many of them?
			int resourceAmount = UserInterface.tradeResourceAmountSelection(resource, resourceType);
			tradePayment= new Payment(resourceType,resourceAmount);
			checkState=resource.CheckState(tradePayment);
			if (checkState==true){
				resource.minusResource(tradePayment);
				bank.addResource(tradePayment);
				break;
			}
		}
		return false;		
	}
	boolean Recruit(Card played){
		//fill in if we eventually implement battle
		// or prompt this feature is a future implementation
		return false;
	}
	/*//no longer need this one since it is also in age
	String Gather(Card played){
		boolean skipOthers=false;
		int answer=0;
		String type="wood";
		//call player function to present options of where to place the villager and which resource to gather
		//1. current.playerPlaceVillagers(current.countHouses());
		//2. option modifier... TerrainType(0)/ResourceType(1) or AllResource(2) if modv1=1;
		//3. option checker for skipping other players (played.modv2)
		if (skipOthers==false)
				//all players collect resource
				if (answer==0){
					GatherResourceOnTerrain(type);
					return "terrain"+type;
				}
				else if (answer==1){
					GatherResourceType(type);
					return "resource"+type;
				}
		
		else{
			//only current player collects
			if (answer==0)
				GatherResourceOnTerrain(type);
			else if (answer==1)
				GatherResourceType(type);
			else if (played.modv1==1)
				GatherAll();
			return null;
		}
		returnCard(played);//card returned to random or permanent decks
		//no alternative boolean state for gather its not dependent on anything
		//unless passing or skipping is prompted for passing, not implemented
		return null;
	}
	*/
	boolean Attack(Card played){
		//leaving it for now, v3 or v4 		
		return false;
	}
	public PoolOfBuildings GetBuildingPool(){
		return buildingPool;
	}
	public boolean Building(String choice, int cSquare){
		if (cArea != null)
			return cArea.Building(choice, cSquare, resource);
		else
			return false;
	}
	
	boolean Build(BuildCard played){
		String choice = UserInterface.selectAvailableBuilding(buildingPool);
		int cSquare = UserInterface.selectAvailableCitySquare(cArea);
		int count = played.getBuildingNum();
		
		cArea.Building(choice, cSquare , resource);
		
		
		while(count > 0 && !choice.equals(null)){
			System.out.println("You have chosen to build a "+choice+" on square #"+(cSquare+1)+".");
			if (cArea.Building(choice, cSquare , resource))
				count--;
			else
				System.out.println("Unable to build "+choice+", please select another.");
			if ( UserInterface.askIfKeepBuilding() ){
				cSquare = UserInterface.selectAvailableCitySquare(cArea);
				count = played.getBuildingNum();
			}
			else
				return true; // return instead of break saves 1 step
		}
	return true; // no other state, even if passed its still true
	}
	boolean NextAge(NextAgeCard played){
		if (resource.CheckState(played.getNextAgeCost(ageState)) ) {
			resource.minusResource(played.getNextAgeCost(ageState));
			ageState++;
			//Graphic display update aka refresh
			//UserInterface.updateResourceState(resource); 
			//UserInterface.updateAge(ageState);
			return true;
		}
		return false;
	}
	void Spoilage(){
		if ( resource.wood > MaxResource){resource.favor=MaxResource;}
		if ( resource.favor> MaxResource){resource.favor=MaxResource;}
		if ( resource.gold > MaxResource){resource.favor=MaxResource;}
		if ( resource.food > MaxResource){resource.favor=MaxResource;}
	}

	void Discard(){
		while ( maxHandSize() < CardsInHand.size() ){
			//one at at time
			//prompt user that he she has a great hand size than allowed
			CardsInHand.remove(UserInterface.selectDiscardCard(CardsInHand));
		}
	}

	int maxHandSize(){
		if (ageState == 0){ return 4;}
		else if (ageState == 1){ return 5;}
		else if (ageState == 2){ return 6;}
		else if (ageState == 3){ return 7;}
		return 0; //0 for false default
	}	
	void GatherAll(){
		pArea.GetAllResource(resource);
	}
	void GatherResourceOnTerrain(String type){
		pArea.GetResourceType(type, resource);
	}
	void GatherResourceType(String type){
		pArea.GetResourceType(type, resource);
	}
	String GetRace(){
		return Race;
	}
	PermanentDeck GetPermDeck(){
		return PermDeck;
	}
	ArrayList<Card> GetHand(){
		return CardsInHand;
	}
	String GetPlayerName(){
		return Name;
	}
	ProductionArea GetProductionArea() {
		return pArea;
	}
	void VillagersPutToWork(){
		pArea.PlaceVillagers(cArea.houseCount);
	}
	public void ExploreResource(PoolOfTiles pickFromTiles) {
		boolean passFlag=false;
		ResourceTile luckyPick;
		if(passFlag){
			passFlag=UserInterface.askIfWantTile(pickFromTiles);
			luckyPick=UserInterface.pickOne(pickFromTiles);
		}
		else 
			luckyPick=pickFromTiles.getTile();
		pArea.placeTile(luckyPick);
	}
}