package canvas;

import java.util.Arrays;

public class Canvas {
	
	private char[][] canvas;

	private static int bordersize = 1;

	public Canvas(int width, int height) {
		width = width + bordersize * 2;
		height = height + bordersize * 2;
		canvas = new char[height][width];
		// draw borders for canvas
		for (int i = 0; i < height; i++) {
			canvas[i][0] = '|';
			canvas[i][width - 1] = '|';
		}
		for (int i = 0; i < width; i++) {
			canvas[0][i] = '-';
			canvas[height - 1][i] = '-';
		}
	}

	public void display() {
		for (int i = 0; i < canvas.length; i++) {
			System.out.println(Arrays.toString(canvas[i]));
		}
	}

	public void drawLine(int x1, int y1, int x2, int y2) {
		if (x1 == x2) {
			// draw between y1 and y2
			for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
				canvas[i][x1] = 'x';
			}
		} else {
			// draw between x1 and x2
			for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
				canvas[y1][i] = 'x';
			}
		}
	}

	public void drawBox(int x1, int y1, int x2, int y2) {
		drawLine(x1, y1, x1, y2);
		drawLine(x1, y1, x2, y1);
		drawLine(x2, y2, x1, y2);
		drawLine(x2, y2, x2, y1);
	}

	public void fill(int x, int y, char color) {
		if (canvas[y][x] != '|' && canvas[y][x] != '-' && canvas[y][x] != 'x' && canvas[y][x] != color) {
			canvas[y][x] = color;
			fill(x-1, y, color);
			fill(x+1, y, color);
			fill(x, y-1, color);
			fill(x, y+1, color);
		}
	}

}
