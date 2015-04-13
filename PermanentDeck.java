import java.util.ArrayList;

public class PermanentDeck {
	private ArrayList<Card> permDeck = new ArrayList<Card>();
	public PermanentDeck(){
		setPermDeck();
	}
	public void setPermDeck(){
		Card a = new GatherCard(0, "Gather", true, false, 0, "None");//example of add to the card list or hand
		permDeck.add(a);
		a = new BuildCard(1, "Build", true, false, 0, "None");//example of add to the card list or hand
		permDeck.add(a);
		//a = new AttackCard("Attack");//example of add to the card list or hand
		//permDeck.add(a);
		a = new NextAgeCard(4, 5, 6, "NextAge", true, false, 0, "None");//example of add to the card list or hand
		permDeck.add(a);
		a = new TradeCard(2, "Trade", true, false, 0, "None");//example of add to the card list or hand
		permDeck.add(a);
		//a = new Card("Recruit", false, false, 0, cardType);//example of add to the card list or hand
		//permDeck.add(a);
		a = new ExploreCard(4, "Explore", true, false, 0, "None");//example of add to the card list or hand, i went with 4 since we only have 3 players
		permDeck.add(a);
	}
	public Card Draw(int c){
		return permDeck.remove(c);
	}
	public void cardBack(Card cardUsed) {
		permDeck.add(cardUsed);
	}
	public ArrayList<Card> getPermDeck(){
		return permDeck;
	}
	public String toString(){
		for(Card c : permDeck) System.out.println(c);
		return null;
	}
}

/*	
numOfBuilds=1;
incExplore=1;
typeGather=0;
countRecruit=2;
costTrade=2;
nextAgeCost=4;
unitAttack=4;
*/
