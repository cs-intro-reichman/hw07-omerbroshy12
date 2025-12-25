/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) 
	{
		if (n == 0) 
		{
            StdDraw.line(x1, y1, x2, y2); 
            return;
		}

		double xa = x1 + (x2 - x1) / 3.0;
        double ya = y1 + (y2 - y1) / 3.0;
        
        double xb = x1 + 2.0 * (x2 - x1) / 3.0;
        double yb = y1 + 2.0 * (y2 - y1) / 3.0;
        
        double angleFactor = Math.sqrt(3) / 6.0;
        double xc = (x1 + x2) / 2.0 + angleFactor * (y1 - y2);
        double yc = (y1 + y2) / 2.0 + angleFactor * (x2 - x1);

        curve(n - 1, x1, y1, xa, ya);    
        curve(n - 1, xa, ya, xc, yc);    
        curve(n - 1, xc, yc, xb, yb);    
        curve(n - 1, xb, yb, x2, y2);    
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) 
	{
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		
		double x1 = 0.2, y1 = 0.75;  
        double x2 = 0.8, y2 = 0.75;          
        double height = (0.6 * Math.sqrt(3)) / 2; 
        double x3 = 0.5, y3 = 0.75 - height; 

        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
	}
}
