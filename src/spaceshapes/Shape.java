package spaceshapes;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract superclass to represent the general concept of a Shape. This class
 * defines state common to all special kinds of Shape instances and implements
 * a common movement algorithm. Shape subclasses must override method paint()
 * to handle shape-specific painting.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public abstract class Shape {
	// === Constants for default values. ===
	protected static final int DEFAULT_X_POS = 0;
	
	protected static final int DEFAULT_Y_POS = 0;
	
	protected static final int DEFAULT_DELTA_X = 5;
	
	protected static final int DEFAULT_DELTA_Y = 5;
	
	protected static final int DEFAULT_HEIGHT = 35;

	protected static final int DEFAULT_WIDTH = 25;
	
	protected static final String DEFAULT_TEXT = "";
	// ===

	// === Instance variables, accessible by subclasses.
	protected int _x;

	protected int _y;

	protected int _deltaX;

	protected int _deltaY;

	protected int _width;

	protected int _height;
	
	protected String _text;
	// ===
	
	// === Parent CarrierShape
	protected CarrierShape _parentShape;
	/// ===

	/**
	 * Creates a Shape object with default values for instance variables.
	 */
	public Shape() {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_TEXT);
	}
	
	/**
	 * Creates a Shape object with a specified x and y position.
	 */
	public Shape(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_TEXT);
	}
	
	/**
	 * Creates a Shape instance with specified x, y, deltaX and deltaY values.
	 * The Shape object is created with a default width and height.
	 */
	public Shape(int x, int y, int deltaX, int deltaY) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_TEXT);
	}
	
	/**
	 * Creates a Shape instance with specified x, y, deltaX, deltaY, width,
	 * and height values. Shape is created with default text.
	 * The Shape object is created with a default width and height.
	 */
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height) {
		this(x, y, deltaX, deltaY, width, height, DEFAULT_TEXT);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX, deltaY, width,
	 * height and text values.
	 */
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
		_text = text;
	}
	
	/**
	 * Moves this Shape object within the specified bounds. On hitting a 
	 * boundary the Shape instance bounces off and back into the two- 
	 * dimensional world. 
	 * @param width - width of two-dimensional world.
	 * @param height - height of two-dimensional world.
	 */
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
		}

		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
		}

		_x = nextX;
		_y = nextY;
	}

	/**
	 * Template method that cannot be overridden by concrete subclasses
	 * @param painter the Painter object used for drawing.
	 */
	public final void paint(Painter painter) {
		painter.drawCentredText(_text, _x, _y, _width, _height);
		doPaint(painter);
		
	}
	
	/**
	 * Method to be implemented by concrete subclasses to handle subclass
	 * specific painting.
	 * @param painter the Painter object used for drawing.
	 */
	protected abstract void doPaint(Painter painter);

	/**
	 * Returns this Shape object's x position.
	 */
	public int x() {
		return _x;
	}
	
	/**
	 * Returns this Shape object's y position.
	 */
	public int y() {
		return _y;
	}
	
	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaX() {
		return _deltaX;
	}
	
	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaY() {
		return _deltaY;
	}
	
	/**
	 * Returns this Shape's width.
	 */
	public int width() {
		return _width;
	}
	
	/**
	 * Returns this Shape's height.
	 */
	public int height() {
		return _height;
	}
	
	/**
	 * Returns a String whose value is the fully qualified name of this class 
	 * of object. E.g., when called on a RectangleShape instance, this method 
	 * will return "spaceshapes.RectangleShape".
	 */
	public String toString() {
		return getClass().getName();
	}
	
	//Assignment 3 methods
	
	/** Returns the CarrierShape that contains the Shape that method
	 * parents is called on. If the callee object is not a child within a
	 * CarrierShape instance this method returns null.
	 */
	public CarrierShape parent() {
		return _parentShape;
	}
	
	/**
	 * Removes the parent shape that the callee object is currently
	 * associated with by setting the field to null
	 */
	public void removeParent(){
		_parentShape = null;
	}
	
	/**
	 * Returns an ordered list of Shape objects. The first item within
	 * the list is the root CarrierShape of the containment hierarchy.
	 * The last item within the list is the callee object (hence this
	 * methods always returns a list with at least one item). Any
	 * intermediate items are CarrierShapes that connect the root
	 * CarrierShape to the callee Shape. E.g., given:
	 * 
	 * 	CarrierShape root = new CarrierShape();
	 * 	CarrierShape intermediate = new CarrierShape();
	 * 	Shape oval = new OvalShape();
	 * 	root.add(intermediate);
	 * 	intermediate.add(oval);
	 * 
	 * a call to oval.path() yields: [root,intermediate,oval]
	 */
	
	public List<Shape> path(){
		List<Shape> path = new ArrayList<>();
		if (_parentShape != null) {
			path = _parentShape.path();
		}
		path.add(this);
		return path;
	}
	
	/**
	 * Set the text that is associated with the the shape
	 * This can override the text set using the constructor
	 */
	public void setText(String text) {
		_text = text;
	}
	
	public String text() {
		return _text;
	}
	
}
