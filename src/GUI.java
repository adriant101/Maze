import java.io.File;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUI extends Application {
	
	 
	
	private Scene mainScene;
	private Group mainGroup = new Group();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Random myran = new Random();
	
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
			for (int i = 0; i < 5; i++){
		    for (int j = 0; j < 10; j++) {
		      if (thisarray[i][j]== 0) {
		    	  System.out.println("do nothing");
		      }else if (thisarray[i][j] == 1) {
		    	  xcords = 50*j;
		    	  ycords = 50*i;
		    	  Image myimage = new Image("file:src\\brick.jpg");
		    	 ImageView blockimage = new ImageView(myimage);
		    	  blockimage = new ImageView(myimage);
		    	  blockimage.setLayoutX(xcords);
		    	  blockimage.setLayoutY(ycords);
		    	  mainGroup.getChildren().add(blockimage);
		    	  System.out.println("block generate");
		      }
		    	  }
		    }
		
		mainScene = new Scene(mainGroup, 500, 250, Color.CYAN);
		primaryStage.setScene(mainScene);
        primaryStage.setTitle("Lab 9");
        primaryStage.show();
	}

}
