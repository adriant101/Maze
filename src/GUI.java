import java.io.File;

import java.util.Random;
import java.util.Scanner;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
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
import javafx.stage.Stage;
import javafx.util.Duration;

public class GUI extends Application {
	
	 
	
	private Scene mainScene;
	private Group mainGroup = new Group();
	private int playerXcords = 0;
	private int playerYcords = 0;
	private Rectangles drawRect = new Rectangles();
	private Bounds blockRectBounds;
	private Rectangle playerRect, blockRect;
	private int collide;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Random myran = new Random();
		mainScene = new Scene(mainGroup, 500, 250, Color.CYAN);
		String filetoscan = null;
		int whichmaze = myran.nextInt(2);
		
		if (whichmaze == 0) {
			filetoscan = "src\\firstmaze.txt";
		}else if (whichmaze ==1) {
			filetoscan = "src\\secondmaze.txt";
		}
		File myfile = new File(filetoscan);
		Scanner myscan = new Scanner(myfile);
		Mazescenegenerator mygen = new Mazescenegenerator(myscan);
		int[][] thisarray = mygen.Mazescenebuilder();
		int xcords = 0;
		int ycords = 0;
		Player player1 = new Player("file:src\\Michael.jpg",playerXcords,playerYcords);
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
		    	  //Drawing rectangles
		    	   blockRect = drawRect.getBounds(xcords, ycords, 50, 50);
		    	   playerRect = drawRect.getBounds(playerXcords, playerYcords, 50, 50);
		  		   blockRectBounds = blockRect.getBoundsInLocal();
		  		  //Collision Detection
		  		 Timeline tl = new Timeline();
		         tl.setCycleCount(Animation.INDEFINITE);
		  		 KeyFrame oneFrame = new KeyFrame(Duration.seconds(200), (ActionEvent evt) -> {
		  			 if (blockRectBounds.intersects(playerRect.getBoundsInLocal())){
		  		 
			  			collide = 1;
			  			System.out.println("collision");
			  		}
		  			 
		  		
		  		  /* while (collide != 1){
		  			 if (blockRectBounds.intersects(playerRect.getBoundsInLocal())){
				  			System.out.println("collision");
				  		}
		  		   }*/
		  		});
		  		 tl.getKeyFrames().add(oneFrame);
		         tl.play();
		  	    
		    	  mainGroup.getChildren().add(blockimage);
		    	  
		      }
		    	  }
		    }
			
			Image playerimg = new Image(player1.getImgPath());
			ImageView playeriv = new ImageView(playerimg);
			mainGroup.getChildren().add(playeriv);
			mainScene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
				if(key.getCode()==KeyCode.W) {
					 playeriv.setY(player1.moveup(playerYcords));
					 playerYcords = player1.moveup(playerYcords);
				    }else if(key.getCode()== KeyCode.A) {
					       playeriv.setX(player1.moveleft(playerXcords));
					       playerXcords = player1.moveleft(playerXcords);
				    }else if(key.getCode()==KeyCode.D) {
				    	 playeriv.setX(player1.moveright(playerXcords));
				    	 playerXcords = player1.moveright(playerXcords);
				    } else if(key.getCode()==KeyCode.S) {
				    	playeriv.setY(player1.movedown(playerYcords));
				    	playerYcords = player1.movedown(playerYcords);
				    }
		});
			
		
		primaryStage.setScene(mainScene);
        primaryStage.setTitle("Lab 9");
        primaryStage.show();
	}

}
