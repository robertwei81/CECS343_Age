//Production squares are specific squares on the ProductionArea that store ResourceTiles
public class ProductionSquare {
	//variable list
	public String terrain;
	public boolean full;
	public ResourceTile tile = null;
	
	//construction
	public ProductionSquare(String t){
		terrain = t;
		full = false;
	}
	
	//function list here
	public String getTerrain(){
		return terrain;
	}
	public void fill(ResourceTile t){
		full = true;
		tile = t;
	}
	public ResourceTile getTile(){
		return tile;
	}
	public void empty(){
		full = false;
		tile = null;
	}
	public boolean isFull(){
		return full;
	}
}
