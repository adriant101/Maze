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
		if (direction == 1 && array[row][column]== 0) {
			row = row-1;
			System.out.println(array[row][column]);
			}else if (direction ==2 && array[row][column]== 0 ) {
			row = row + 1;
			System.out.println( array[row][column]);
			}else if (direction == 3 && array[row][column]== 0 ) {
			column = column - 1;
			System.out.println(array[row][column]);
			}else if (direction == 4 && array[row][column]== 0 ) {
			column = column +1;
			System.out.println( array[row][column]);
			}
			
			if (array[row][column] == 0) {
				return true;
			}else if (direction == 1 && array[row][column]== 1 || row < 0) {
				row = row+1;
			}else if (direction ==2 && array[row][column]== 1||row > 4 ) {
				row = row - 1;
				
				}else if (direction == 3 && array[row][column]== 1 || column < 0) {
				column = column + 1;
				
				}else if (direction == 4 && array[row][column]== 1 || column > 9 ) {
				column = column -1;
				
				}/*else if (row < -1 || row > 4 || column < 0 || column >9) {
					return false;
				}*/
			return false;
			
		
		
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