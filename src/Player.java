import javafx.scene.input.KeyCode;

public class Player extends ObjectParent{
	private int[][] array;
	private int playerpostion;
	private int row = 0;
	private int column = 0;
	
	public Player(String imgPath, int xCord, int yCord, int[][] array) {
		super(imgPath, xCord, yCord);
		this.array = array;
		
	}
	
	
	//player movement and speed
	public boolean check2d(int direction) {
		if (direction ==1) {
		row = row-1;
		}else if (direction ==2) {
		row = row + 1;
		}else if (direction == 3) {
		column = column - 1;
		}else if (direction == 4) {
		column = column +1;
		}
		playerpostion = array[row][column];
		if (playerpostion == 0) {
			return true;
		}else {
			return false;
		}
		
	}
	public int moveup(int ycord) {
		ycord = ycord - 50 ;
		return ycord;
	}

	public int movedown(int ycord) {
		ycord = ycord+ 50;
		return ycord;
	}

	public int moveleft(int xcord) {
		xcord = xcord - 50;
		return xcord;
	}

	public int moveright(int xcord) {
		xcord = xcord + 50;
		return xcord;
    }
	}