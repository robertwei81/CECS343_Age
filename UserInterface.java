import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface extends age{
	public UserInterface(){
		super("","","");
	}
	//Explore methods
	public void placeTiles(ResourceTile selectedTile, ProductionArea pa) {//From ProductionArea
		/*//will be in player explore method
		ResourceTile selectedTile = tilePool.getTile();
		*/
		int availableTerrainTile = pa.checkAvailableProductionSquares(selectedTile);
		//This stuff will be with GUI
		System.out.println("The terrain of the tile is:"+selectedTile.getTerrainType());
		System.out.println("The type of resource is: "+selectedTile.getTypeOfResource());
		System.out.println("The resource Quantity is: "+selectedTile.getResourceQuantity());
		System.out.println("You have "+ availableTerrainTile + " unfilled Production Squares of this terrain.");
		System.out.println("Do you want to place this tile?(y/n)");
		Scanner in = new Scanner(System.in);
		String decision = in.nextLine();
		if(decision.equals("y")){
			//GUI needs to allow user to click on a tile they want to 
			pa.placeTile(selectedTile);
		}
		//WHYNOT IN.CLOSE()????;
	}
	
	
	//trade methods
	public static String tradeResourceTypeSelection(ResourceState resource){
        String resourceType = null;//this will be selected/changed by user. can be "Wood", "Gold", "Favor", or "Food"
        TradeResourceSelect selection = new TradeResourceSelect();
        selection.setVisible(true);
        // Need to figure out a way to delay getChoice() until user has made selection... Maybe this would work?
        while(selection.getChoice() == null){
            resourceType = selection.getChoice();
        }
        resourceType = selection.getChoice();
        //called from player Trade() method
        //Asks user what resource they want to trade
        //returns name of resource they want to trade
        return resourceType;
    }
    public static int tradeResourceAmountSelection(ResourceState rs, String resource){
        //called from player trade() method
        //asks user how many of the resource they want to trade
        //returns number of the resource they want to trade and displays the new bank and resourceState numbers
        int resourceAmount = -1;//this will be selected/changed by user
        TradeResourceAmount askAmount = new TradeResourceAmount();
        askAmount.setVisible(true);
        while(askAmount.getAmount() == -1){
            resourceAmount = askAmount.getAmount();
        }
        if(resource.equals("Wood"))age.bank.minusResource(resourceAmount, 0,0,0);
        else if(resource.equals("Favor"))age.bank.minusResource(0,resourceAmount,0,0);
        else if (resource.equals("Gold"))age.bank.minusResource(0,0,resourceAmount,0);
        else if (resource.equals("Food"))age.bank.minusResource(0,0,0,resourceAmount);
        return resourceAmount;
    }
   
    
    
    //card play
	public static int userPlayCard(ArrayList<Card> cardsInHand) {
		for(Card c: cardsInHand){
			System.out.println(c);
		}
		System.out.println("Which card do you want to choose?(0-"+cardsInHand.size()+")");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		//WHYNOT IN.CLOSE()????;
		//displays cars in player's hand and lets user click on which one to play
		//message is something to display to user if card can't be played, etc.
		return choice;
	}
	public static boolean askIfUseGodPower() {
		//return false if don't want to use god power
		//return true if want to use god power
		return false;
	}
	
	
	//Victory cards/cubes
	public static int dropVictoryCubes(VictoryCard [] victory) {
		//TODO Auto-generated method stub
		//displays victory cards and lets user click on which one to drop a cube.
		int choice=-1;
		while (choice < 4 || choice > 4){
			//if (choice < 4 && choice > 3){
				Scanner in = new Scanner(System.in);
				System.out.println("Which card do you want to put a cube on?");
				choice = in.nextInt();
				in.nextLine();
				//WHYNOT IN.CLOSE()????;
				//Display
				//Which card is clicked on? [0-3]
				return choice;
			//}
		}
		return -1; //if action not completed 
	}
	public static boolean selectDrawDeck() {
		//asks user if they want to draw from permanent deck or random deck
		//returns true if they want permanent deck, false if they want random deck
		Scanner in = new Scanner(System.in);
		System.out.println("Which deck do you want to draw from?(p for perm or  r for rand)");
		if(in.nextLine().equals("p")){
			//WHYNOT IN.CLOSE()????;
			return true;
		}
		else {
			//WHYNOT IN.CLOSE()????;
			return false;
		}
	}
	public static boolean askIfPass() {
		//print message to user asking if they want to pass their turn
		//if they click yes, return true
		//if they click no, return false
		return false;
	}
	public static int getPermCardIndex(PermanentDeck permDeck) {
		//TODO Auto-generated method stub
		System.out.println("Which permanent card do you want to select? (0-4)");
		System.out.println(permDeck);
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		in.nextLine();
		//WHYNOT IN.CLOSE()????;
		//print message to user asking which card from permDeck they want to select
		//return int of the index of the card
		//remove the card from the displayed permDeck
		return choice;
	}
	public static int selectDiscardCard(ArrayList<Card> cardsInHand) {
		//TODO Auto-generated method stub
		//prompt user for card they want to discard
		//return index of card selected
		return 0;
	}
	
	
	
	//Build methods
	public static String selectAvailableBuilding(PoolOfBuildings buildingPool) {

		ArrayList<Building> bPool = buildingPool.getList();
		int i = 0;
		for(Building b: bPool){
			i++;
			System.out.println(i+"."+b.getType());
		}
		System.out.println("Which building do you want to build? (0-"+bPool.size());
		Scanner in = new Scanner(System.in);
		int index = in.nextInt();
		//WHYNOT IN.CLOSE()????;
		Building choice = bPool.remove(index-1);
		return choice.getType();
		//ask user to select building they want to build, return type of building
	}

	public static int selectAvailableCitySquare(CityArea ca) {
		//TODO Auto-generated method stub
		System.out.println("Which square would you like to place it in?");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		//WHYNOT IN.CLOSE()????;
		//for(int i=0;i<16;i++){
			System.out.println("You have chosen square #"+choice+".");	
		//}
		return (choice-1);
	}
	
	
	//gather methods
	public static int selectGatherOptions(Card played) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static boolean askIfPlaceVillagers() {
		// TODO Auto-generated method stub
		return false;
	}
	public static void placeVillagers(int numOfVillagers,ProductionSquare[] productionSquares) {
		// TODO Auto-generated method stub
		
	}
	public static String selectTerrain() {
		// TODO Auto-generated method stub
		return null;
	}
	public static String selectResource() {
		// TODO Auto-generated method stub
		return null;
	}
	public static boolean askIfKeepBuilding() {
		// TODO Auto-generated method stub
		return true;
	}
	public static boolean askIfWantTile(PoolOfTiles pickFromTiles) {
		// TODO Auto-generated method stub
		return false;
	}
	public static ResourceTile pickOne(PoolOfTiles pickFromTiles) {
		// TODO Auto-generated method stub
		int choice=0;
		return pickFromTiles.tileList.get(choice);
	}
	public static int placeTile(ProductionSquare[] productionSquares, ResourceTile luckyPick) {
		// TODO Auto-generated method stub
		int choice=0;
		return choice;
	}
	public static Payment askForPayment(int cost) {		
		String type="Wood"; //ask for type
		int paid=0; //ask for quantity
		
		if (paid>cost)paid=cost;
		Payment slip=new Payment (type,paid);
		return slip;
	}
	/*
	public int tradeResourceAmountSelection(ResourceState rs, String resource){
		//asks user how many of the resource they want to trade
		//returns number of the resource they want to trade and displays the new bank and resourceState numbers
		int resourceAmount = 0;//this will be selected/changed by user
		if(resource.equals("Wood"))bank.minusResource(resourceAmount, 0,0,0);
		else if(resource.equals("Favor"))bank.minusResource(0,resourceAmount,0,0);
		else if (resource.equals("Gold"))bank.minusResource(0,0,resourceAmount,0);
		else if (resource.equals("Food"))bank.minusResource(0,0,0,resourceAmount);
		return resourceAmount;
	}
	public void updatePermDeck(PermanentDeck permDeck) {
		permanentDeck = permDeck;
		//update display of permanentDeck
		
	}
		public static void updateResourceState(ResourceState resource) {
		//updates numbers of the resources displayed in the holding area
		
	}

	public static void updateAge(int AGESTATE) {
		//update name of user's current age
		// 0 = Archaic, 1 = Classical, 2 = Heroic, 3 = Mythic
	}

	public boolean askUserIfTrade() {
		//ask user if they want to trade again
		//return true if they say yes
		return false;
	}

	public static void updateProductionArea(ProductionArea pArea) {
		//update display of production area - its been changed
		
	}
	public void updateCardsInHand(ArrayList<Card> cardsInHand) {
		//used when drawing cards
		//displays all of the cards that user has already obtained		
	}
		public int displayResourceTileSelection(ArrayList<ResourceTile> tileSelection){
		//displays all of the tiles available to select from
		//lets users click on which one to obtain
		//once user selects tile, return index of selected tile
		return 0;
	}
	public int displayProductionSquares(ProductionArea pArea, ResourceTile rt, String message){
		//displays user's production area and prompts user for the square they want to place tile in
		//when user selects square, place tile in square, and return the number of the square selected
		return 0;
	}

*/
}
