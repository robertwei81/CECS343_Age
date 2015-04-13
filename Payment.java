
public class Payment {
	String resourceType;
	int quantity;
	public Payment(){
		//NULL
	}
	public Payment(String type, int cost){
		resourceType=type;
		quantity=cost;
	}
	public int GetPaid(){
		return quantity;
	}
	public String GetType(){
		return resourceType;
	}
	public static Payment PaymentNote(String type, int amount){
		return new Payment(type, amount);
	}
}
