
public class VictoryCard {
	String cardName;
	int cubeCount;
	public VictoryCard(String name){
		cardName = name;
	}
	public void placeCube(){
		cubeCount++;
	}
	public int removeCubes(){ 
		// isn't this only done when game over? do we need to reset the count?
		int cubes = cubeCount;
		cubeCount = 0;
		return cubes;
	}
}
