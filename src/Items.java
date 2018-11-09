import java.util.Random;

public class Items {

	private int xLocation;
	private int yLocation;
	private String imagePath;
	
	/* Generate an array of items, which then populates the scene by random index*/
	
	Random rand = new Random();
	//Constructor
	public Items() {
		
		this.xLocation = rand.nextInt(500)+50;
		this.yLocation = rand.nextInt(250)+50;
		this.imagePath = "file:src\\item.jpg";
	}
	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}
	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}
	public int getxLocation() {
		return xLocation;
	}
	public int getyLocation() {
		return yLocation;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public String getitemimage() {
		return imagePath;
	}
	
	public void nextLevelQty() {
		//itemQty +=2;
		
	}
	
	public void raiseScore() {
		
	}}