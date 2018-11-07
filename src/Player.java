import javafx.scene.input.KeyCode;

public class Player extends ObjectParent{

	public Player(String imgPath, int xCord, int yCord) {
		super(imgPath, xCord, yCord);
		
	}
	
	//player movement and speed
	
	public int moveup(int ycord) {
		ycord = ycord - 5 ;
		return ycord;
	}

	public int movedown(int ycord) {
		ycord = ycord+ 5;
		return ycord;
	}

	public int moveleft(int xcord) {
		xcord = xcord - 5;
		return xcord;
	}

	public int moveright(int xcord) {
		xcord = xcord + 5;
		return xcord;
    }
	}


