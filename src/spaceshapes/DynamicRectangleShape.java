	package spaceshapes;

import java.awt.Color;

public class DynamicRectangleShape extends Shape {

	private Color _color;
	//Shape is initially drawn as a solid rectangle
	private boolean _isDrawnSolid = true;

	/**
	 * Default constructor that creates a DynamicShape instance whose instance
	 * variables are set to default values.
	 */
	public DynamicRectangleShape() {
		super();
		_color = new Color(212, 212, 212);
	}

	/**
	 * Creates a DynamicShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
		_color = new Color(212, 212, 212);
	}
	
	/**
	 * Creates a DynamicShape with specified values for location, velocity,
	 * direction, width and height.
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}

	/**
	 * Creates a DynamicShape instance with specified values for instance 
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
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height, text);
		_color = new Color(212, 212, 212);
	}
	
	/**
	 * Creates a DynamicShape instance with specified values for instance 
	 * variables.
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, Color color) {
		super(x,y,deltaX,deltaY,width,height);
		_color = color;
	}


	/**
	 * Creates a DynamicShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 * @param r red amount in RGB color specification
	 * @param g green amount in RGB color specification
	 * @param b blue amount in RGB color specification
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text, Color color) {
		super(x,y,deltaX,deltaY,width,height,text);
		_color = color;
	}

	/**
	 * Moves this DynamicShape object within the specified bounds. On hitting a 
	 * boundary the Shape instance bounces off and back into the two- 
	 * dimensional world. Bouncing determines how the shape should subsequently be drawn
	 * @param width - width of two-dimensional world.
	 * @param height - height of two-dimensional world.
	 */
	@Override
	public void move(int width, int height) {

		//Shape isDrawnSolid following a bounce off the left or right
		//Shape !isDrawnSolid following a bounce off the top or bottom
		//If both bounce occurrences occur in the same move, left/right takes priority
		
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		//Bounce off top
		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
			_isDrawnSolid = false;
		//Bounce off bottom
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
			_isDrawnSolid = false;
		}

		//Bounce off left
		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
			_isDrawnSolid = true;
		//Bounce off right
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
			_isDrawnSolid = true;
		}

		_x = nextX;
		_y = nextY;
	}


	protected void doPaint(Painter painter) {
		
		//Change to the specified color
		Color temp = painter.getColor();
		painter.setColor(_color);
		
		//Draw as a solid rectangle
		if(_isDrawnSolid) {
			painter.drawRect(_x, _y, _width, _height);
			painter.fillRect(_x, _y, _width, _height);
			
		}
		//Draw as a gem outline
		else {
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
		
		//Reset color back to original
		painter.setColor(temp);

	}


}
