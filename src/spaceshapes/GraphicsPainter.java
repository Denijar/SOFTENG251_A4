package spaceshapes;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
		_g.setColor(new Color(212, 212, 212));
	}

	/**
	 * @see spaceshapes.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}

	/**
	 * @see spaceshapes.Painter.fillRect.
	 */
	public void fillRect(int x, int y, int width, int height) {
		_g.fillRect(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.getColor.
	 */
	public Color getColor() {
		return _g.getColor();
	}

	/**
	 * @see spaceshapes.Painter.setColor
	 */
	public void setColor(Color c) {
		_g.setColor(c);
	}

	/**
	 * @see spaceshapes.Painter.translate
	 */
	public void translate(int x, int y) {
		_g.translate(x, y);
	}

	/**
	 * @see spaceshapes.Painter.drawCentredText
	 */
	public void drawCentredText(String text, int x, int y, int width, int height) {
		FontMetrics metrics = _g.getFontMetrics();
		
		int textX = x + (width/2) - (metrics.stringWidth(text)/2);
		int textY = y + (height/2);
			
		//ascentchecks to adjust placement
		int ascent = metrics.getAscent();
		int descent = metrics.getDescent();		
		
		if (ascent == descent) {
			_g.drawString(text, textX, textY);
		}
		else if (ascent > descent) {
			textY += (ascent - descent)/2;
			_g.drawString(text, textX, textY);
		}
		//ascent < descent
		else {
			textY -= (ascent - descent)/2;
			_g.drawString(text, textX, textY);
		}
	}
	
	/**
	 * @see spaceshapes.Painter.drawImage
	 */
	public void drawImage(Image img, int x, int y, int width, int height) {
		_g.drawImage(img, x, y, width, height, null);
	}
	
}
