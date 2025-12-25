/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) 
	{
		double[] x = { 0.0, 1.0, 0.5 };
        double[] y = { 0.0, 0.0, Math.sqrt(3) / 2.0 };

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledPolygon(x, y);

        sierpinski(n, x[0], x[1], x[2], y[0], y[1], y[2]);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) 
	{
		if (n == 0) 
			return;

        double x12 = (x1 + x2) / 2.0;
        double y12 = (y1 + y2) / 2.0;
        
        double x23 = (x2 + x3) / 2.0;
        double y23 = (y2 + y3) / 2.0;
        
        double x31 = (x3 + x1) / 2.0;
        double y31 = (y3 + y1) / 2.0;

        StdDraw.setPenColor(StdDraw.WHITE);
        double[] xWhite = { x12, x23, x31 };
        double[] yWhite = { y12, y23, y31 };
        StdDraw.filledPolygon(xWhite, yWhite);

        sierpinski(n - 1, x1, x12, x31, y1, y12, y31);
        sierpinski(n - 1, x12, x2, x23, y12, y2, y23);
        sierpinski(n - 1, x31, x23, x3, y31, y23, y3);
	}
}
