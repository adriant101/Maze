import javafx.scene.image.Image;

//This is the parent class which Blocks, Items, Players inherit from
public class ObjectParent {
private String imgPath;
private int xCord;
private int yCord;

public ObjectParent(String imgPath, int xCord, int yCord) {
	this.setImgPath(imgPath);
	this.xCord = xCord;
	this.yCord = yCord;
	
}

public String getImgPath() {
	return imgPath;
}

public void setImgPath(String imgPath) {
	this.imgPath = imgPath;
}





}