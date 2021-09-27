package recurssion;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FloodFill {
//https://leetcode.com/problems/flood-fill/
	@Test
	public void test1() {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1;
		int sc = 1;
		int newColor = 2;
		Assert.assertTrue(Arrays.equals(new int[][] { { 2, 2, 2 }, { 2, 2, 0 }, { 2, 0, 1 } },
				floodFill(image, sr, sc, newColor)));
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) { //Working only Assertion wrong
		if (image[sr][sc] == newColor) {
			
			return image;
		}
		fill(image, sr, sc, image[sr][sc], newColor);
		
		return image;
	}

	private void fill(int[][] image, int sr, int sc, int color, int newColor) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) {
			return;
		}
		image[sr][sc] = newColor;
		fill(image, sr + 1, sc, color, newColor);
		fill(image, sr - 1, sc, color, newColor);
		fill(image, sr, sc + 1, color, newColor);
		fill(image, sr, sc - 1, color, newColor);
	
	}
}
