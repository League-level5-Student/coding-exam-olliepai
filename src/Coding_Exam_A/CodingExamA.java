package Coding_Exam_A;

import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information. 1. How
		 * many robots 2. The color of the shapes 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the
		 * requested number of robots each draw the requested shape in the requested
		 * color. The robots should execute at the same time so Threads will need to be
		 * used. Arrange the robots so that the shapes do not overlap. For full credit,
		 * define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product
		 * should look like.
		 */

		String numberRobots = JOptionPane.showInputDialog("How many robots?");
		int num = Integer.parseInt(numberRobots);
		String color = JOptionPane.showInputDialog("What color? (red, blue, green)");
		String numberSides = JOptionPane.showInputDialog("How many sides should each shape have? (>0)");
		int sides = Integer.parseInt(numberSides);

		for (int i = 0; i < num; i++) {
			new Thread(() -> {
				Robot r = new Robot();
				r.setSpeed(10);
				r.setX(new Random().nextInt(500));
				r.setY(new Random().nextInt(500));

				if (color.equals("red")) {
					r.setPenColor(Color.RED);
				} else if (color.equals("blue")) {
					r.setPenColor(Color.BLUE);
				} else if (color.equals("green")) {
					r.setPenColor(Color.GREEN);
				}

				r.penDown();

				for (int j = 0; j < sides; j++) {
					r.move(50);
					r.turn(360 / sides);
				}
			}).start();
		}
	}
}
