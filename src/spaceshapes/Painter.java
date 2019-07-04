package spaceshapes;

import java.awt.Color;
import java.awt.Image;

/** 
 * Interface to represent a type that offers primitive drawing methods.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public interface Painter {
	/**
	 * Draws a rectangle. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawRect(int x, int y, int width, int height);
	
	/**
	 * Draws an oval. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawOval(int x, int y, int width, int height);
	
	/**
	 * Draws a line. Parameters x1 and y1 specify the starting point of the 
	 * line, parameters x2 and y2 the ending point.
	 */
	public void drawLine(int x1, int y1, int x2, int y2);
	
	/**
	 * Fills the specified rectangle using the graphics context's current color.
	 * The resulting rectangle covers an area width pixels wide by height pixels tall.
	 */
	public void fillRect(int x, int y, int width, int height);
	
	/**
	 * Gets this graphics context's current color.
	 */
	public Color getColor();
	
	/**
	 * Sets this graphics context's current color to the specified color.
	 * All subsequent graphics operations using this graphics context use this specified color.
	 */
	public void setColor(Color c);
	
	/**
	 * Changes the coordinate system of the Graphics context
	 */
	public void translate(int x, int y);
	
	/**
	 * Displays specified text so that it is centred (horizontally and vertically)
	 * within a Shape's bounding box.
	 */
	public void drawCentredText(String string, int x, int y, int width, int height);
	
	/**
	 * Draws an image at a specified location
	 */
	public void drawImage(Image img, int x, int y, int width, int height);	
}
