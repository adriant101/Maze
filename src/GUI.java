import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.Timer;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GUI extends Application {
	
	
	private Items item1 = new Items();
	private Items item2 = new Items();
	public  List<Items> items = new ArrayList<Items>();
	private Scene mainScene;
	private Group mainGroup = new Group();
	private int playerXcords = 0;
	private int playerYcords = 0;
	private Rectangles drawRect = new Rectangles();
	private Bounds blockRectBounds;
	private Rectangle playerRect, blockRect;
	private int collide;
	int xcords = 0;
	int ycords = 0;
	File myfile;
	Scanner myscan;
	Mazescenegenerator mygen;
	int[][] thisarray;
	public List<ImageView> itemImage = new ArrayList<ImageView>();
	private Text winText = new Text(""); 
	

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		items.add(item1);
		items.add(item2);
		for (int i = 0; i < items.size();i++ ) {
			
			 itemImage.add(new ImageView(items.get(i).getitemimage()));
			 itemImage.get(i).setX(items.get(i).getxLocation());
			 itemImage.get(i).setY(items.get(i).getyLocation());
			 itemImage.get(i).setFitHeight(50);itemImage.get(i).setFitWidth(50);
			 mainGroup.getChildren().add(itemImage.get(i));
			 
		
			}
		Random myran = new Random();
		mainScene = new Scene(mainGroup, 500, 250, Color.CYAN);
		String filetoscan = null;
		int whichmaze = myran.nextInt(2);
		
		if (whichmaze == 0) {
			filetoscan = "src\\firstmaze.txt";
			
		}else if (whichmaze ==1) {
			filetoscan = "src\\secondmaze.txt";
		}
		 myfile = new File(filetoscan);
		 myscan = new Scanner(myfile);
		 mygen = new Mazescenegenerator(myscan);
		 thisarray = mygen.Mazescenebuilder();
		
		
		Player player1 = new Player("file:src\\Michael.jpg",playerXcords,playerYcords, thisarray);
			for (int i = 0; i < 5; i++){
		    for (int j = 0; j < 10; j++) {
		      if (thisarray[i][j]== 0) {
		
		      }else if (thisarray[i][j] == 1) {
		    	  xcords = 50*j;
		    	  ycords = 50*i;
		    	  Image myimage = new Image("file:src\\brick.jpg");
		    	 ImageView blockimage = new ImageView(myimage);
		    	  blockimage = new ImageView(myimage);
		    	  blockimage.setLayoutX(xcords);
		    	  blockimage.setLayoutY(ycords);
		    	  
		  	    
		    	  mainGroup.getChildren().add(blockimage);
		    	  
		      }
		    	  }
		    }
			
			Image playerimg = new Image(player1.getImgPath());
			ImageView playeriv = new ImageView(playerimg);
			mainGroup.getChildren().add(playeriv);
			mainScene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
						if(key.getCode()==KeyCode.W) {
						if (player1.check2d(1) == true){
						playeriv.setY(player1.moveup(playerYcords));
						playerYcords = player1.moveup(playerYcords);}else {
						 }}
						if(key.getCode()== KeyCode.A) {
				    	if (player1.check2d(3) == true) {
					       playeriv.setX(player1.moveleft(playerXcords));
					       playerXcords = player1.moveleft(playerXcords);}else {
					    	   }}
				
				    	if(key.getCode()==KeyCode.D) {
				    	if (player1.check2d(4) == true) {
				    	 playeriv.setX(player1.moveright(playerXcords));
				    	 playerXcords = player1.moveright(playerXcords);
				    	 }else {
				    		 }}  
				    	
				    	if(key.getCode()==KeyCode.S) {
				    	if (player1.check2d(2) == true) {
				    	playeriv.setY(player1.movedown(playerYcords));
				    	playerYcords = player1.movedown(playerYcords);
				    	}else {
				    		}}
				    	
				    	if (whichmaze == 0 && playerXcords == 450 && playerYcords == 150) {
							winText.setText("Congrats!");
						}
						if (whichmaze == 1 && playerXcords == 450 && playerYcords == 200) {
							winText.setText("Congrats!");
						} 
			

			});
		
			//win code
			winText.setX(150);winText.setY(150);winText.setFill(Color.GOLD);winText.setStyle("-fx-font: 48 arial;");
			mainGroup.getChildren().add(winText);
			
			
		primaryStage.setScene(mainScene);
        primaryStage.setTitle("Lab 9");
        primaryStage.show();
			
	}}
	


