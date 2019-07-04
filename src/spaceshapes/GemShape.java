package spaceshapes;

public class GemShape extends Shape {
	
	/**
	 * Default constructor that creates a GemShape instance whose instance
	 * variables are set to default values.
	 */
	public GemShape() {
		super();
	}

	/**
	 * Creates a GemShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public GemShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	/**
	 * Creates a GemShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 */
	public GemShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	/**
	 * Creates a GemShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 * @param text the text to draw with the shape
	 */
	public GemShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height,text);
	}
	
	/**
	 * Paints this GemShape object using the supplied Painter object.
	 * This is done through multiple calls to the drawLine function
	 */
	protected void doPaint(Painter painter) {
		
		//Case for when the width is larger than 40 pixels
		if(_width > 40) {
			painter.drawLine((_x + 20), _y, (_x + _width - 20), _y);
			painter.drawLine((_x + _width - 20), _y, (_x + _width), (_y + _height/2));
			painter.drawLine((_x + _width), (_y + _height/2), (_x + _width - 20), (_y + _height));
			painter.drawLine((_x + _width - 20), (_y + _height), (_x + 20), (_y + _height));
			painter.drawLine((_x + 20), (_y + _height), _x, (_y + _height/2));
			painter.drawLine(_x, (_y + _height/2), (_x + 20), _y);
		}
		//Case for when the width is 40 pixels or less
		else {
			painter.drawLine((_x + _width/2), _y, (_x + _width), (_y + _height/2));
			painter.drawLine((_x + _width), (_y + _height/2), (_x + _width/2), (_y + _height));
			painter.drawLine((_x + _width/2), (_y + _height), _x, (_y + _height/2));
			painter.drawLine(_x, (_y + _height/2), (_x + _width/2), _y);
		}
		
	}

}
