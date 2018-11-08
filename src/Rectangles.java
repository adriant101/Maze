import javafx.scene.shape.Rectangle;

public class Rectangles {
	

		//drawing rectangle
		public Rectangle  getBounds(double x, double y, double width, double height) {
			Rectangle recto = new Rectangle();
			recto.setX(x);
			recto.setY(y);
			recto.setWidth(width);
			recto.setHeight(height);
			return recto ;
			
		}
}
