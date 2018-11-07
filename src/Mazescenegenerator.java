import java.util.Scanner;

import javafx.scene.Group;
import javafx.scene.Scene;

public class Mazescenegenerator {
	Scanner thescanner;
public Mazescenegenerator(Scanner thescanner) {
	this.thescanner = thescanner;
}
public int[][] Mazescenebuilder() {
	int[][] array = new int[5][10];
	for (int i = 0; i<5; i++) {
		for (int j = 0; j<10; j++) {
			array[i][j] = thescanner.nextInt();
		}
	}

	return array;
	}

	
	
}

