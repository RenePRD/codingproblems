package canvas;

import java.util.Scanner;

public class Main {

	/*
	 * You're given the task of writing a simple console version of a drawing
	 * program. At this time, the functionality of the program is quite limited but
	 * this might change in the future. In a nutshell, the program should work as
	 * follows: 1. Create a new canvas 2. Start drawing on the canvas by issuing
	 * various commands 3. Quit
	 * 
	 * 
	 * Command Description C w h Should create a new canvas of width w and height h.
	 * L x1 y1 x2 y2 Should create a new line from (x1,y1) to (x2,y2). Currently
	 * only horizontal or vertical lines are supported. Horizontal and vertical
	 * lines will be drawn using the 'x' character. R x1 y1 x2 y2 Should create a
	 * new rectangle, whose upper left corner is (x1,y1) and lower right corner is
	 * (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.
	 * B x y c Should fill the entire area connected to (x,y) with "colour" c. The
	 * behavior of this is the same as that of the "bucket fill" tool in paint
	 * programs. Q Should quit the program.
	 */

	public static void main(String[] args) {
		Canvas c = null;
		Scanner sc = new Scanner(System.in);
		boolean isFinished = false;
		do {
			System.out.print("Enter command: ");
			String[] command = sc.nextLine().split(" ");
			switch (command[0]) {
			case "C":
				int width = Integer.parseInt(command[1]);
				int height = Integer.parseInt(command[2]);
				c = new Canvas(width, height);
				c.display();
				break;
			case "L":
				int x1 = Integer.parseInt(command[1]);
				int y1 = Integer.parseInt(command[2]);
				int x2 = Integer.parseInt(command[3]);
				int y2 = Integer.parseInt(command[4]);
				c.drawLine(x1, y1, x2, y2);
				c.display();
				break;
			case "R":
				x1 = Integer.parseInt(command[1]);
				y1 = Integer.parseInt(command[2]);
				x2 = Integer.parseInt(command[3]);
				y2 = Integer.parseInt(command[4]);
				c.drawBox(x1, y1, x2, y2);
				c.display();
				break;
			case "B":
				int x = Integer.parseInt(command[1]);
				int y = Integer.parseInt(command[2]);
				char color = command[3].charAt(0);
				c.fill(x, y, color);
				c.display();
				break;
			case "Q":
				isFinished = true;
				break;
			default:
				System.out.println("asdf");
			}
		} while (!isFinished);
		sc.close();
	}

}
