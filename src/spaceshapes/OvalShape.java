package spaceshapes;

public class OvalShape extends Shape {
	
	/**
	 * Default constructor that creates an OvalShape instance whose instance
	 * variables are set to default values.
	 */
	public OvalShape() {
		super();
	}
	
	/**
	 * Creates an OvalShape instance with specified values for instance
	 * variables
	 * @param x x position
	 * @param y y position
	 */
	public OvalShape(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Creates an OvalShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public OvalShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	/**
	 * Creates a OvalShape with specified values for location, velocity,
	 * direction, width and height.
	 */
	public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	/**
	 * Creates an OvalShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 * @param text the text to write with the shape
	 */
	public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height,text);
	}
	
	/**
	 * Paints this OvalShape object using the supplied Painter object.
	 */
	protected void doPaint(Painter painter) {
		painter.drawOval(_x,_y,_width,_height);
	}

}
