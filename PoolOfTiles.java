import java.util.ArrayList;
import java.util.Collections;
public class PoolOfTiles {
	ArrayList<ResourceTile> tileList = new ArrayList<ResourceTile>();
	public PoolOfTiles(){
		this.setTiles();
	}
	public PoolOfTiles(boolean Zero){
		//Zero Elements
	}
	private void setTiles(){
		for (int i=0; i<2;i++){
			ResourceTile x = new ResourceTile("Forest", "Wood", 1);
			tileList.add(x);
			ResourceTile y = new ResourceTile("Forest", "Favor", 1);
			tileList.add(y);
			ResourceTile z = new ResourceTile("Forest", "Gold", 1);
			tileList.add(z);
		}
		for (int i=0; i<3;i++){//3 from fertile, and 2 from mountains
			ResourceTile x = new ResourceTile("Fertile", "Wood", 1);
			tileList.add(x);
			ResourceTile y = new ResourceTile("Fertile", "Favor", 1);
			tileList.add(y);
			ResourceTile z = new ResourceTile("Fertile", "Gold", 1);
			tileList.add(z);
			ResourceTile a = new ResourceTile("Mountain", "Favor", 1);
			tileList.add(a);
			ResourceTile b = new ResourceTile("Mountain", "Wood", 1);
			tileList.add(b);
		}
		for(int i=0;i<4;i++){//4 from swamps and 4 from hills
			ResourceTile a = new ResourceTile("Hills", "Gold", 2);
			tileList.add(a);
			ResourceTile b = new ResourceTile("Hills", "Wood", 1);
			tileList.add(b);
			ResourceTile c = new ResourceTile("Hills", "Food", 1);
			tileList.add(c);
			ResourceTile d = new ResourceTile("Hills", "Favor", 1);
			tileList.add(d);
			ResourceTile e = new ResourceTile("Swamp", "Wood", 1);
			tileList.add(e);
			ResourceTile f = new ResourceTile("Swamp", "Favor", 1);
			tileList.add(f);
			ResourceTile g = new ResourceTile("Swamp", "Food", 1);
			tileList.add(g);
		}
		for(int i=0;i<6;i++){
			ResourceTile x = new ResourceTile("Mountain","Gold", 2);
			tileList.add(x);		
		}
		for(int i=0;i<7;i++){
			ResourceTile x = new ResourceTile("Desert","Favor", 2);
			tileList.add(x);
			ResourceTile y = new ResourceTile("Desert","Gold", 1);
			tileList.add(y);		
		}
		for(int i=0;i<9;i++){
			ResourceTile x = new ResourceTile("Forest","Wood", 2);
			tileList.add(x);
		}
		for (int i=0;i<12;i++){
			ResourceTile x = new ResourceTile("Fertile","Food", 2);
			tileList.add(x);
		}
		Collections.shuffle(tileList);
	}
	public ResourceTile getTile(){
		return tileList.remove(0);
	}
	public void addTile(ResourceTile tile){
		tileList.add(tile);
		Collections.shuffle(tileList);
	}
	public int getNumberOfTiles(){
		return tileList.size();
	}
	public void CombinePools(PoolOfTiles pickFromTiles) {
		while (pickFromTiles.getNumberOfTiles() != 0){
			tileList.add(pickFromTiles.getTile());
		}
	}
}
