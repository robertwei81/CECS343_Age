
import java.util.ArrayList;
import java.util.Collections;
public class RandomDeck {
	private ArrayList<Card> randomDeck = new ArrayList<Card>(); 
	private String race;
	public RandomDeck(String r){
			race = r;
			setAll();
		}
		void reshuffleDeck (){
			if (race == "Norse"){
			resetNorseDeck();
		}
		if (race == "Greek"){
			resetGreekDeck();
		}
		if (race == "Egypt"){
			resetEgyptDeck();
		}
	}
	public void setAll(){
		if(race == "Norse"){
		setNorseDeck();
		}
		if(race == "Greek"){
		setGreekDeck();
		}
		if(race == "Egypt"){
		setEgyptDeck();
		}
	}
	public void resetNorseDeck(){
		randomDeck = new ArrayList<Card>();
		setNorseDeck();
	}
	public void resetGreekDeck(){
		randomDeck = new ArrayList<Card>();
		setGreekDeck();
	}	
	public void resetEgyptDeck(){
		randomDeck = new ArrayList<Card>();
		setEgyptDeck();
	}
	private void setNorseDeck(){
		for (int i=0;i<5;i++){
			Card a = new GatherCard(1, "Gather", false, false, 0, "None"); // "All Resource"
			randomDeck.add(a);
		}
		for (int i=0;i<4;i++){
			Card a = new TradeCard(1, "Trade", false, false, 0, "None"); //"any 1 for any 1"
			randomDeck.add(a);
		}
		for (int i=0;i<3;i++){
			Card a = new NextAgeCard(3, 4, 5, "NextAge", false, false, 0, "None"); //modifier 1 "Cost -1/-1/-1/-1"
			randomDeck.add(a);
			Card b = new BuildCard(3, "Build", false, false, 0, "None"); //modifier 3 "3 buildings"
			randomDeck.add(b);
		}
		for (int i=0;i<2;i++){
			Card a = new BuildCard(2, "Build", false, false, 0, "None"); //modifier 2 "2 buildings"
			randomDeck.add(a);
			Card b = new ExploreCard(0, "Explore", false, false, 0, "None"); //modifier 0 "same as players"
			randomDeck.add(b);
			Card c = new ExploreCard(5, "Explore", false, false, 0, "None"); //modifier 2 "2 more than players"
			randomDeck.add(c);
			/*
			Card d = new Card("Recruit", false, false, 3, race); //modifier 3 "max 3 units"
			randomDeck.add(d);
			Card e = new Card("Recruit", false, false, 4, race); //modifier 4 "max 4 units"
			randomDeck.add(e);
			Card f = new Card("Recruit", false, false, 5, race); //modifier 5 "max 5 units"
			randomDeck.add(f);
			Card g = new Card("Attack", false, false, 7, race); //modifier 7 "max send 7 units"
			randomDeck.add(g);
			Card h = new Card("Attack", false, false, 5, race); //modifier 5 "max send 5 units"
			randomDeck.add(h);
			*/
		}
		Card a = new BuildCard(4, "Build", false, false, 0, "None"); //modifier 4 "4 buildings"
		randomDeck.add(a);
		/*
		a = new Card("Attack", 6); //modifier 6 "max send 6 units"
		randomDeck.add(b);
		*/
		// Norse god cards
		a = new TradeCard(0, "Trade", false, true, 1, "Forseti");
		randomDeck.add(a);
		a = new TradeCard(0, "Trade", false, true, 2, "Loki");
		randomDeck.add(a);
		a = new NextAgeCard(3, 4, 5, "NextAge", false, true, 1, "Odin");
		randomDeck.add(a);
		a = new BuildCard(4, "Build", false, true, 1, "Njord");
		randomDeck.add(a);
		a = new ExploreCard(3, "Explore", false, true, 1, "Baldr");
		randomDeck.add(a);
		a = new GatherCard(0, "Gather", false, true, 1, "Thor");
		randomDeck.add(a);
		a = new GatherCard(0, "Gather", false, true, 1, "Freyja");
		randomDeck.add(a);
		a = new GatherCard(0, "Gather", false, true, 1, "Skadi");
		Collections.shuffle(randomDeck);
	}
	private void setGreekDeck(){
		for (int i=0;i<5;i++){
			Card a = new TradeCard(1, "Trade", false, false,0, "None"); //modifier 1 "any 1 for any 1"
			randomDeck.add(a);
			Card b = new GatherCard(1, "Gather", false, false, 0, "None"); //modifier 2 "all resource"
			randomDeck.add(b);
		}
		for (int i=0;i<3;i++){
			Card a = new BuildCard(3, "Build", false, false, 0, "None"); //modifier 3 "3 buildings"
			randomDeck.add(a);
		}
		for (int i=0;i<2;i++){
			Card a = new BuildCard(2, "Build", false, false, 0, "None"); //modifier 2 "2 buildings"
			randomDeck.add(a);
			Card c = new ExploreCard(5, "Explore", false, false, 0, "None"); //modifier 2 "2 more than players"
			randomDeck.add(c);
			Card j = new ExploreCard(3, "Explore", false, false, 0, "None"); //modifier 0 "same as players"
			randomDeck.add(j);
			Card k = new NextAgeCard(3, 4, 5, "NextAge", false, false, 0, "None"); //modifier 1 "Cost -1/-1/-1/-1"
			randomDeck.add(k);

			/*
			Card b = new RecruitCard("Recruit", 4); //modifier 4 "max 5 units"
			randomDeck.add(b);
			Card d = new RecruitCard("Recruit", 3); //modifier 3 "max 3 units"
			randomDeck.add(d);
			Card f = new RecruitCard("Recruit", 5); //modifier 5 "max 5 units"
			randomDeck.add(f);
			Card h = new AttackCard("Attack", 5); //modifier 5 "max send 5 units"
			randomDeck.add(h);
			Card g = new AttackCard("Attack", 7); //modifier 7 "max send 7 units"
			randomDeck.add(g);
			Card e = new AttackCard("Attack", 6); //modifier 6 "max send 6 units"
			randomDeck.add(e);
			*/
		}
		Card a = new BuildCard(4, "Build", false, false, 0, "None"); //modifier 4 "4 buildings"
		randomDeck.add(a);
		//Greek god cards
		a = new TradeCard(0, "Trade", false, true, 1, "Hermes");
		randomDeck.add(a);
		a = new BuildCard(3, "Build", false, true, 1, "Hera");
		randomDeck.add(a);
		a = new ExploreCard(5, "Explore", false, true, 1, "Artemis");
		randomDeck.add(a);
		a = new GatherCard(0, "Gather", false, true, 1, "Poseidon");
		randomDeck.add(a);
		a = new GatherCard(0, "Gather", false, true, 1, "Hades");
		randomDeck.add(a);
		a = new GatherCard(2, "Gather", false, true, 2, "Dionysus");
		randomDeck.add(a);
		a = new NextAgeCard(3, 4, 5, "NextAge", false, true, 2, "Hephaestos");
		randomDeck.add(a);
		a = new NextAgeCard(3, 4, 5, "NextAge", false, true, 2, "Zeus");
		randomDeck.add(a);
		Collections.shuffle(randomDeck);
	}
	private void setEgyptDeck(){
		for (int i=0;i<7;i++){
			Card a = new GatherCard(1, "Gather", false, false, 0, "None"); //modifier 2 "All Resource"
			randomDeck.add(a);
		}
		for (int i=0;i<6;i++){
			Card a = new TradeCard(1, "Trade", false, false, 0, "None"); //modifier 1 "any 1 for any 1"
			randomDeck.add(a);
		}
		for (int i=0;i<2;i++){
			Card a = new BuildCard(2, "Build", false, false, 0, "None"); //modifier 2 "2 buildings"
			randomDeck.add(a);
			Card b = new BuildCard(3, "Build", false, false, 0, "None"); //modifier 2 "3 buildings"
			randomDeck.add(b);
			Card c = new ExploreCard(5, "Explore", false, false, 0, "None"); //modifier 2 "2 more than players"
			randomDeck.add(c);
			Card j = new ExploreCard(3, "Explore", false, false, 0, "None"); //modifier 0 "same as players"
			randomDeck.add(j);
			Card k = new NextAgeCard(3, 4, 5, "NextAge", false, false, 0, "None"); //modifier 1 "Cost -1/-1/-1/-1"
			randomDeck.add(k);
			/*
			Card d = new RecruitCard("Recruit", 3); //modifier 3 "max 3 units"
			randomDeck.add(d);
			Card h = new AttackCard("Attack", 5); //modifier 5 "max send 5 units"
			randomDeck.add(h);
			Card e = new AttackCard("Attack", 6); //modifier 5 "max send 5 units"
			randomDeck.add(e);
			*/

		}
		/*
		Card g = new AttackCard("Attack", 7); //modifier 7 "max send 7 units"
		randomDeck.add(g);
		Card e = new RecruitCard("Recruit", 4); //modifier 4 "max 4 units"
		randomDeck.add(e);
		Card f = new RecruitCard("Recruit", 5); //modifier 5 "max 5 units"
		randomDeck.add(f);
		*/
		Card a = new BuildCard(4, "Build", false, false, 0, "None"); //modifier 4 "4 buildings"
		randomDeck.add(a);
		//egypt god cards
		a = new BuildCard(3, "Build", false, true, 2, "Nephthys");
		randomDeck.add(a);
		a = new BuildCard(3, "Build", false, true, 1, "Horus");
		randomDeck.add(a);
		a = new ExploreCard(5, "Explore", false, true, 1, "Ptah");
		randomDeck.add(a);
		a = new GatherCard(1, "Gather", false, true, 2, "Ra");
		randomDeck.add(a);
		a = new NextAgeCard(3, 4, 5, "NextAge", false, true, 1, "Set");
		randomDeck.add(a);
		a = new NextAgeCard(3, 4, 5, "NextAge", false, true, 1, "Hathor");
		randomDeck.add(a);
		Collections.shuffle(randomDeck);
	}
	
	public Card Draw(){
		System.out.println("made it to draw");
		return randomDeck.remove(1);
	}
	public void cardBack(Card cardUsed) {
		randomDeck.add(cardUsed);
	}
	public String toString(){
		for(Card c : randomDeck) System.out.println(c);
		return null;
	}
}