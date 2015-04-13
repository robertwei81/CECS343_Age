//i've been using this to test things...
public class TesterMain {
	public static void main(String[]args){
		age a = new age("a","b","c");//default a b c
		player p = new player(1, "a");//default race 1, name a
		BuildCard played = new BuildCard(1, "Build", true, false, 0, "None");//example of add to the card list or hand
		//PoolOfBuildings pb = new PoolOfBuildings();
		//CityArea ca = new CityArea(pb);
		/*CitySquare[] CitySquares = new CitySquare[16];
		for(int i = 0; i<16; i++){
			CitySquare cs = new CitySquare();
			CitySquares[i] = cs;			
		}*/
		
		if (a.Build(p, played))
			System.out.println(played.getType()+" card has been played by "+p.getPlayerName()+".");
		else
			System.out.println("Card play failed.");

		if (a.Build(p, played))
			System.out.println(played.getType()+" card has been played by "+p.getPlayerName()+".");
		else
			System.out.println("Card play failed.");

	}
	
	
}
