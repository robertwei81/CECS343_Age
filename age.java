import java.util.ArrayList;
public class age {
	//Variable at this level of game state 
	private static int CardActionAllowed=3;
	//Public Resource Initialization Stage
	private PoolOfTiles pTileForAll; // only default constructor is needed
	
	// this is a 3 player construction , set the choice base on length of player array
	public static Bank bank = new Bank(25,25,25,25,30); 
	private RandomDeck randomNorseDeck;
	private RandomDeck randomGreekDeck;
	private RandomDeck randomEgyptDeck;
	private RandomDeck [] randomDecks;
	private VictoryCard [] VicCards = new VictoryCard[4];

	//Player Initialization Stage
	private ArrayList<player> playerList = new ArrayList<player>();
	//public age(){}
	public age(String a, String b, String c){
		//public resource creation
		randomEgyptDeck=new RandomDeck("Egypt");
		randomGreekDeck=new RandomDeck("Greek");
		randomNorseDeck=new RandomDeck("Norse");
		randomDecks  = new RandomDeck[]{randomGreekDeck,randomEgyptDeck,randomNorseDeck};
		VicCards[0] = new VictoryCard("Won Last Battle");
		VicCards[1] = new VictoryCard("Having the Most Buildings");
		VicCards[2] = new VictoryCard("The Largest Army");
		VicCards[3] = new VictoryCard("The Wonder");
		player A = new player(1, a);
		playerList.add(A);
		player B = new player(2, b);
		playerList.add(B);
		player C = new player(3, c);
		playerList.add(C);
	}
	//GameStates
	//much tweaking still needed
	public ArrayList<player> getPlayerList(){
		return playerList;
	}
	void TakeTurn(){//Complete
		int choice;
		PlaceVictoryCubes();
		DrawCards();
		for (int PlayCards=0;PlayCards<CardActionAllowed;PlayCards++){
			for (int i=0; i<playerList.size();i++)
				if (UserInterface.askIfPass())
					UserInterface.selectDiscardCard(playerList.get(i).GetHand());
				else{
					choice = UserInterface.userPlayCard(playerList.get(i).GetHand());
					PlayAction(playerList.get(i),choice);
				}
			//playerList.add(playerList.remove(0));//rotation ... this will fix 0 being the current
		}
		Spoilage();
		Discard();
		//playerList.add(playerList.remove(0));//rotation ... this will fix 0 being the current
	}
	private void DrawCards() {
		for (int i=0; i<playerList.size();i++){
			player p = playerList.get(i);
			RandomDeck rd = GetDeck(p.GetRace());
			p.DrawCards(rd);
			}
			//insert dialog box for playerList.get(i); for v2 or v3 implementation for more than 3 players
			//playerList.get(i).PlaceVictoryCube(VicCards);	//??? what's this for?
	}
	private void PlaceVictoryCubes() {
		for (int i=0; i<playerList.size();i++){
			playerList.get(i).PlaceVictoryCube(VicCards);
		System.out.println("made it");
		}
	}
	public RandomDeck GetDeck(String race){
		if (race == "Egypt")return randomDecks[0];
		else if (race == "Greek")return randomDecks[1];
		else if (race == "Norse")return randomDecks[2];
		else return null;
	}

	boolean PlayAction(player current, int indexOfCard){
		//direct card instruction to the right function
		//passing current for ease
		if (current.GetHand().get(indexOfCard).getType()=="Explore")
			return Explore(current,(ExploreCard) current.GetHand().get(indexOfCard));
		else if (current.GetHand().get(indexOfCard).getType()=="Trade")
			return Trade(current,(TradeCard) current.GetHand().get(indexOfCard));
		else if (current.GetHand().get(indexOfCard).getType()=="Gather")
			return Gather(current,(GatherCard) current.GetHand().get(indexOfCard));
		else if (current.GetHand().get(indexOfCard).getType()=="Build")
			return Build(current,(BuildCard) current.GetHand().get(indexOfCard));
		/*
		else if (current.GetHand().get(indexOfCard).getType()=="Recruit")
			return Recruit(current,current.GetHand().get(indexOfCard));
		else if (current.GetHand().get(indexOfCard).getType()=="Attack")
			return Attack(current,current.GetHand().get(indexOfCard));
		else if (current.GetHand().get(indexOfCard).getType()=="Special")
			return Special(current.GetHand().get(indexOfCard));
		*/
		return false;
	}
	boolean Gather(player current, GatherCard played){
		boolean skipOthers=false;
		String type="Wood";
		boolean godAnswer= false;
		int answer = 0;
		if(played.getIsGod())godAnswer = UserInterface.askIfUseGodPower();
		if (played.getGodName().equals("Freyja")&& godAnswer){
			if(current.getResourceState().CheckState(0, played.getFavorCost(), 0, 0)){
				current.getResourceState().addResource(0, played.getFavorCost(), 0, 0);
				current.getResourceState().addResource(0, 0, 5, 0);
				bank.minusResource(0, 0, 5, 0);
			}
		}
		if(played.getGodName().equals("Skadi") && godAnswer){
			if(current.getResourceState().CheckState(0, played.getFavorCost(), 0, 0)){
				current.getResourceState().minusResource(0, played.getFavorCost(), 0, 0);
				skipOthers = true;
			}
		}
		if(played.getGodName().equals("Thor") && godAnswer){
			if(current.getResourceState().CheckState(0, played.getFavorCost(), 0, 0)){
				current.getResourceState().minusResource(0, played.getFavorCost(), 0, 0);
				//eliminate any single mythic unit owned by another player
			}
		}
		if(played.getGodName().equals("Hades") && godAnswer){
			if(current.getResourceState().CheckState(0, played.getFavorCost(), 0, 0)){
				current.getResourceState().minusResource(0, played.getFavorCost(), 0, 0);
				//bank.AddToBank(note);
				//eliminate any one of your units and gain any 7 resources
			}
		}
		if(played.getGodName().equals("Poseidon") && godAnswer){
			if(current.getResourceState().CheckState(0, played.getFavorCost(), 0, 0)){
				current.getResourceState().minusResource(0, played.getFavorCost(), 0, 0);
				//current.getResourceState
			}
		}
		if(played.getGodName().equals("Dionysus") && godAnswer){
			if(current.getResourceState().CheckState(0, played.getFavorCost(), 0, 0)){
				current.getResourceState().minusResource(0, played.getFavorCost(), 0, 0);
				//gather +1 food per food tile other players gather nothing
				skipOthers = true;
			}
		}
		
		//still need to do norse gods, and all egypt and greek
		
		//call player function to present options of where to place the villager and which resource to gather
		//1. option modifier... TerrainType(0)/ResourceType(1) or AllResource(2) if modv1=1;
		answer=UserInterface.selectGatherOptions(played);
		if (answer==0)
			type=UserInterface.selectTerrain();
		else
			type=UserInterface.selectResource();
		current.VillagersPutToWork();
		//3. option checker for skipping other players (played.modv2)
		if (skipOthers==false)
			for (int i=0;i<playerList.size();i++){ 
				if (answer==0)
					//no need for prompting this should be automatic
					playerList.get(i).GatherResourceOnTerrain(type);
				else if (answer==1)
					playerList.get(i).GatherResourceType(type);
			}
		else
			//only current player collects
			if (answer==0)
				current.GatherResourceOnTerrain(type);
			else if (answer==1)
				current.GatherResourceType(type);
			else if (played.getGatherType() == 1)
				current.GatherAll();
		current.returnCard(played, GetDeck(current.GetRace()));//card returned to random or permanent decks
		//no alternative boolean state for gather its not dependent on anything
		//unless passing or skipping is prompted for passing, not implemented
		return true;
	}
	boolean Build(player current, BuildCard played){
		boolean godAnswer = false;
		if(played.getIsGod())godAnswer = UserInterface.askIfUseGodPower();
		if(played.getGodName().equals("Njord") && godAnswer){
			if(current.getResourceState().CheckState(0, played.getFavorCost(), 0, 0)){
				current.getResourceState().minusResource(0, played.getFavorCost(), 0, 0);
				//eliminate any single building owned by another player
			}
		}
		for (int i=0;i<played.getBuildingNum();i++){
			String choice=UserInterface.selectAvailableBuilding(current.GetBuildingPool());
			int cSquare=UserInterface.selectAvailableCitySquare(current.GetCityArea());
			current.Building(choice, cSquare);
		}
		return true;
	}
	boolean Attack(player current, Card played){
		//leaving it for now, v3 or v4 		
		return false;
	}
	/*
	boolean Special(Card played){
		return false; //God cards not yet implemented
	}
	*/
	boolean Explore(player current, ExploreCard played){
		//modv1 is the number of tiles to randomly draw from
		PoolOfTiles PickFromTiles = new PoolOfTiles(true);
		boolean skipOthers=false;
		boolean godAnswer = false;
		for (int i=0; i<played.getTileNum();i++){
			ResourceTile a= new ResourceTile(pTileForAll.getTile());
			PickFromTiles.addTile(a);
		}
		if(played.getIsGod())godAnswer = UserInterface.askIfUseGodPower();
		if (played.getGodName().equals("Baldr")&& godAnswer){
			if(current.getResourceState().CheckState(0, played.getFavorCost(), 0, 0)){
				current.getResourceState().minusResource(0, played.getFavorCost(), 0, 0);
				skipOthers = true;
			}
		}
		if (skipOthers==false)
			for (int i=0;i<playerList.size();i++){ 
				playerList.get(i).ExploreResource(PickFromTiles);
			}
		else
			current.ExploreResource(PickFromTiles);
		pTileForAll.CombinePools(PickFromTiles);		
		//no alternative boolean state for gather its not dependent on anything
		//unless passing or skipping is prompted for passing, not implemented
		return true;
	}
	
	boolean Trade(player current, TradeCard played){
		boolean godAnswer = false;
		if(played.getIsGod())godAnswer = UserInterface.askIfUseGodPower();
		if (played.getGodName().equals("Forseti")&& godAnswer){
			if(current.getResourceState().CheckState(0, played.getFavorCost(), 0, 0)){
				current.getResourceState().minusResource(0, played.getFavorCost(), 0, 0);
				//gain a profit of any 4 resources when trading with this card
			}
		}
		if (played.getGodName().equals("Loki")&& godAnswer){
			if(current.getResourceState().CheckState(0, played.getFavorCost(), 0, 0)){
				current.getResourceState().minusResource(0, played.getFavorCost(), 0, 0);
				//steal 5 resources from any single opponent
			}
		}
		

		current.Trade(played, bank);
		return false;		
	}
	boolean Recruit(player current, Card played){
		return false;
	}

	boolean NextAge(player current, NextAgeCard played){
		boolean godAnswer = false;
		if(played.getIsGod())godAnswer = UserInterface.askIfUseGodPower();
		if (played.getGodName().equals("Odin")&& godAnswer){
			if(current.getResourceState().CheckState(0, played.getFavorCost(), 0, 0)){
				current.getResourceState().minusResource(0, played.getFavorCost(), 0, 0);
				//play a fourth action card after all other players have played their third card
			}
		}

		if ( current.NextAge(played)) 
			return true;
		return false;
	}
	void Spoilage(){
		for (int i=0; i<playerList.size();i++)
			playerList.get(i).Spoilage();
	}
	void Discard(){
		for (int i=0; i<playerList.size();i++)
			playerList.get(i).Discard();
	}
}
