package spaceshapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestGemShape {
	
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
		 * Test to check if a Shape has drawn itself correctly,
		 * given the provided parameters in the constructor
		 * This one tests with a width under 40 (a small gem)
		 */
		@Test
		public void testSmallGemDraw(){
			GemShape shape = new GemShape(0, 0, 10, 10, 20, 20);
			shape.paint(_painter);
			assertEquals("(line 10,0,20,10)(line 20,10,10,20)(line 10,20,0,10)(line 0,10,10,0)", 
					_painter.toString());
		}
		
		/**
		 * Test to check if a Gem has drawn itself correctly,
		 * given the provided parameters in the constructor
		 * This one tests with a width over 40 (a large gem)
		 */
		@Test
		public void testLargeGemDraw(){
			GemShape shape = new GemShape(0, 0, 10, 10, 50, 50);
			shape.paint(_painter);
			assertEquals("(line 20,0,30,0)(line 30,0,50,25)(line 50,25,30,50)(line 30,50,20,50)(line 20,50,0,25)(line 0,25,20,0)",
					_painter.toString());
		}
		
		/**
		 * Test to perform a simple (non-bouncing) movement, and to ensure that a
		 * Shape's position after the movement is correct. For a small gem.
		 */
		@Test
		public void testSmallGemSimpleMove() {
			GemShape shape = new GemShape(100, 100, 10, 5, 20, 20);
			shape.paint(_painter);
			shape.move(500, 500);
			shape.paint(_painter);
			assertEquals("(line 110,100,120,110)(line 120,110,110,120)(line 110,120,100,110)(line 100,110,110,100)"
					+ "(line 120,105,130,115)(line 130,115,120,125)(line 120,125,110,115)(line 110,115,120,105)", 
					_painter.toString());
		}
		
		/**
		 * Test to perform a simple (non-bouncing) movement, and to ensure that a
		 * Shape's position after the movement is correct. For a large gem.
		 */
		@Test
		public void testLargeGemSimpleMove() {
			GemShape shape = new GemShape(100, 100, 20, 10, 50, 50);
			shape.paint(_painter);
			shape.move(500, 500);
			shape.paint(_painter);
			assertEquals("(line 120,100,130,100)(line 130,100,150,125)(line 150,125,130,150)(line 130,150,120,150)(line 120,150,100,125)(line 100,125,120,100)"
					+ "(line 140,110,150,110)(line 150,110,170,135)(line 170,135,150,160)(line 150,160,140,160)(line 140,160,120,135)(line 120,135,140,110)",
					_painter.toString());
		}
		
		/**
		 * Test to perform a bounce movement off the right-most boundary and to
		 * ensure that the Shape's position after the movement is correct. For a large gem.
		 */
		@Test
		public void testLargeGemMoveWithBounceOffRight() {
			GemShape shape = new GemShape(100, 20, 15, 15, 50, 50);
			shape.paint(_painter);
			shape.move(160, 10000);
			shape.paint(_painter);
			shape.move(160, 10000);
			shape.paint(_painter);
			assertEquals("(line 120,20,130,20)(line 130,20,150,45)(line 150,45,130,70)(line 130,70,120,70)(line 120,70,100,45)(line 100,45,120,20)"
					+ "(line 130,35,140,35)(line 140,35,160,60)(line 160,60,140,85)(line 140,85,130,85)(line 130,85,110,60)(line 110,60,130,35)"
					+ "(line 115,50,125,50)(line 125,50,145,75)(line 145,75,125,100)(line 125,100,115,100)(line 115,100,95,75)(line 95,75,115,50)", 
					_painter.toString());
		}

		
		/**
		 * Test to perform a bounce movement off the right-most boundary and to
		 * ensure that the Shape's position after the movement is correct. For a small gem.
		 */
		@Test
		public void testSmallGemMoveWithBounceOffRight() {
			GemShape shape = new GemShape(100, 20, 15, 15, 20, 20);
			shape.paint(_painter);
			shape.move(130, 10000);
			shape.paint(_painter);
			shape.move(130, 10000);
			shape.paint(_painter);
			assertEquals("(line 110,20,120,30)(line 120,30,110,40)(line 110,40,100,30)(line 100,30,110,20)"
					+ "(line 120,35,130,45)(line 130,45,120,55)(line 120,55,110,45)(line 110,45,120,35)"
					+ "(line 105,50,115,60)(line 115,60,105,70)(line 105,70,95,60)(line 95,60,105,50)", 
					_painter.toString());
		}
		
		/**
		 * Test to perform a bounce movement off the left-most boundary and to
		 * ensure that the Shape's position after the movement is correct. For a large gem.
		 */
		@Test
		public void testLargeGemMoveWithBounceOffLeft() {
			GemShape shape = new GemShape(10, 20, -12, 15, 50, 50);
			shape.paint(_painter);
			shape.move(10000, 10000);
			shape.paint(_painter);
			shape.move(10000, 10000);
			shape.paint(_painter);
			assertEquals("(line 30,20,40,20)(line 40,20,60,45)(line 60,45,40,70)(line 40,70,30,70)(line 30,70,10,45)(line 10,45,30,20)"
					+ "(line 20,35,30,35)(line 30,35,50,60)(line 50,60,30,85)(line 30,85,20,85)(line 20,85,0,60)(line 0,60,20,35)"
					+ "(line 32,50,42,50)(line 42,50,62,75)(line 62,75,42,100)(line 42,100,32,100)(line 32,100,12,75)(line 12,75,32,50)", 
					_painter.toString());
		}

		/**
		 * Test to perform a bounce movement off the left-most boundary and to
		 * ensure that the Shape's position after the movement is correct. For a small gem.
		 */
		@Test
		public void testSmallGemMoveWithBounceOffLeft() {
			GemShape shape = new GemShape(10, 20, -12, 15, 20, 20);
			shape.paint(_painter);
			shape.move(10000, 10000);
			shape.paint(_painter);
			shape.move(10000, 10000);
			shape.paint(_painter);
			assertEquals("(line 20,20,30,30)(line 30,30,20,40)(line 20,40,10,30)(line 10,30,20,20)"
					+ "(line 10,35,20,45)(line 20,45,10,55)(line 10,55,0,45)(line 0,45,10,35)"
					+ "(line 22,50,32,60)(line 32,60,22,70)(line 22,70,12,60)(line 12,60,22,50)", 
					_painter.toString());
		}
		
		/**
		 * Test to perform a bounce movement off the bottom right corner and to
		 * ensure that the Shape's position after the movement is correct. For a large gem.
		 */
		@Test
		public void testLargeGemMoveWithBounceOffBottomAndRight() {
			GemShape shape = new GemShape(100, 100, 12, 15, 50, 50);
			shape.paint(_painter);
			shape.move(125, 135);
			shape.paint(_painter);
			shape.move(125, 135);
			shape.paint(_painter);
			assertEquals("(line 120,100,130,100)(line 130,100,150,125)(line 150,125,130,150)(line 130,150,120,150)(line 120,150,100,125)(line 100,125,120,100)"
					+ "(line 95,85,105,85)(line 105,85,125,110)(line 125,110,105,135)(line 105,135,95,135)(line 95,135,75,110)(line 75,110,95,85)"
					+ "(line 83,70,93,70)(line 93,70,113,95)(line 113,95,93,120)(line 93,120,83,120)(line 83,120,63,95)(line 63,95,83,70)",
					_painter.toString());
		}

		/**
		 * Test to perform a bounce movement off the bottom right corner and to
		 * ensure that the Shape's position after the movement is correct. For a large gem.
		 */
		@Test
		public void testSmallGemMoveWithBounceOffBottomAndRight() {
			GemShape shape = new GemShape(100, 100, 12, 15, 20, 20);
			shape.paint(_painter);
			shape.move(125, 135);
			shape.paint(_painter);
			shape.move(125, 135);
			shape.paint(_painter);
			assertEquals("(line 110,100,120,110)(line 120,110,110,120)(line 110,120,100,110)(line 100,110,110,100)"
					+ "(line 115,115,125,125)(line 125,125,115,135)(line 115,135,105,125)(line 105,125,115,115)"
					+ "(line 103,100,113,110)(line 113,110,103,120)(line 103,120,93,110)(line 93,110,103,100)",
					_painter.toString());
		}

}
