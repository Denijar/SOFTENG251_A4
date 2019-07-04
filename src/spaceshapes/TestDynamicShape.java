package spaceshapes;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class TestDynamicShape {

	// Fixture object that is used by the tests.
	private MockPainter _painter;

	/**
	 * This method is called automatically by the JUnit test-runner immediately
	 * before each @Test method is executed. setUp() recreates the fixture so 
	 * that there no side effects from running individual tests.
	 */
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}
	
	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position and appearance after the movement is correct.
	 */
	@Test
	public void testDynamicMoveWithBounceOffLeft() {
		DynamicRectangleShape shape = new DynamicRectangleShape(10, 20, -12, 15, 20, 20, Color.RED);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);  
		assertEquals("(rectangle 10,20,20,20)"
				+ "(rectangle 0,35,20,20)"
				+ "(rectangle 12,50,20,20)" 
				,_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position and appearance after the movement is correct.
	 */
	@Test
	public void testDynamicMoveWithBounceOffRight() {
		DynamicRectangleShape shape = new DynamicRectangleShape(100, 20, 15, 15, 20, 20, Color.RED);
		shape.paint(_painter);
		shape.move(130, 10000);
		shape.paint(_painter);
		shape.move(130, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,20,20)"
				+ "(rectangle 110,35,20,20)"
				+ "(rectangle 95,50,20,20)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top-most boundary and to
	 * ensure that the Shape's position and appearance after the movement is correct.
	 */
	@Test
	public void testDynamicMoveWithBounceOffTop() {
		DynamicRectangleShape shape = new DynamicRectangleShape(100, 10, 15, -15, 20, 20, Color.RED);
		shape.paint(_painter);
		shape.move(10000, 130);
		shape.paint(_painter);
		shape.move(10000, 130);
		shape.paint(_painter);
		//Starts as a rectangle, and ends as a gem
		assertEquals("(rectangle 100,10,20,20)"
				+ "(line 125,0,135,10)(line 135,10,125,20)(line 125,20,115,10)(line 115,10,125,0)"
				+ "(line 140,15,150,25)(line 150,25,140,35)(line 140,35,130,25)(line 130,25,140,15)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom-most boundary and to
	 * ensure that the Shape's position and appearance after the movement is correct.
	 */
	@Test
	public void testDynamicMoveWithBounceOffBottom() {
		DynamicRectangleShape shape = new DynamicRectangleShape(100, 100, 0, 15, 20, 20, Color.RED);
		shape.paint(_painter);
		shape.move(10000, 130);
		shape.paint(_painter);
		shape.move(10000, 130);
		shape.paint(_painter);
		//Starts as a rectangle, ends as a gem
		assertEquals("(rectangle 100,100,20,20)"
				+ "(line 110,110,120,120)(line 120,120,110,130)(line 110,130,100,120)(line 100,120,110,110)"
				+ "(line 110,95,120,105)(line 120,105,110,115)(line 110,115,100,105)(line 100,105,110,95)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off both the top and left boundaries (directly in the corner) and to
	 * ensure that the Shape's position and appearance after the movement is correct.
	 */
	@Test
	public void testDynamicMoveWithBounceOffTopAndLeft() {
		DynamicRectangleShape shape = new DynamicRectangleShape(10, 10, -20, -20, 20, 20, Color.RED);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 10,10,20,20)"
				+ "(rectangle 0,0,20,20)"
				+ "(rectangle 20,20,20,20)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off both the top and right boundaries (directly in the corner) and to
	 * ensure that the Shape's position and appearance after the movement is correct.
	 */
	@Test
	public void testDynamicMoveWithBounceOffTopAndRight() {
		DynamicRectangleShape shape = new DynamicRectangleShape(170, 10, 20, -20, 20, 20, Color.RED);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 170,10,20,20)"
				+ "(rectangle 180,0,20,20)"
				+ "(rectangle 160,20,20,20)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off both the bottom and left boundaries (directly in the corner) and to
	 * ensure that the Shape's position and appearance after the movement is correct.
	 */
	@Test
	public void testDynamicMoveWithBounceOffBottomAndLeft() {
		DynamicRectangleShape shape = new DynamicRectangleShape(10, 170, -20, 20, 20, 20, Color.RED);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 10,170,20,20)"
				+ "(rectangle 0,180,20,20)"
				+ "(rectangle 20,160,20,20)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off both the bottom and right boundaries (directly in the corner) and to
	 * ensure that the Shape's position and appearance after the movement is correct.
	 */
	@Test
	public void testDynamicMoveWithBounceOffBottomAndRight() {
		DynamicRectangleShape shape = new DynamicRectangleShape(10, 10, -20, -20, 20, 20, Color.RED);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		shape.move(200, 200);
		shape.paint(_painter);
		assertEquals("(rectangle 10,10,20,20)"
				+ "(rectangle 0,0,20,20)"
				+ "(rectangle 20,20,20,20)", 
				_painter.toString());
	}

}
