package ss.enums;

public enum Items {
	BLUE(0, 100), YELLOW(1, 200), BLACK(2, 300), PINK(3, 400);
	
	private final int id;
	private final int price;
	
	Items(int id, int price){
		this.id = id;
		this.price = price;
	}
    
	public int getId() {
    	return id;
	}
	
    public int getPrice() {
    	return price;
	}
}