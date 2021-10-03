package selfLearn;

public class disco {
	
	    public static void main(String args[]) {
	        double red = 190;
	        double green = 189;
	        double blue = 127;
	        double white = 0;

	        double cyan = 0;
	        double magenta = 0;
	        double yellow = 0;
	        double black = 0;
	        if (red == 0 && green == 0 && blue == 0) {
	            black = 1;//from ww w.j a  va2 s.co m

	        } else {
	            if ((red / 255) > (green / 255) && (red / 255) > (blue / 255)) {
	                white = red / 255;
	            } else if ((green / 255) > (blue / 255)) {
	                white = green / 255;
	            } else {
	                white = blue / 255;
	            }

	            cyan = (white - (red / 255)) / white;
	            magenta = (white - (green / 255)) / white;
	            yellow = (white - (blue / 255)) / white;
	            black = (1 - white);

	        }
	        System.out.println("cyan value is " + cyan);
	        System.out.println("magenta value is" + magenta);
	        System.out.println("yellow value is" + yellow);
	        System.out.println("black value is " + black);
	    }

	
}
