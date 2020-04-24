package project;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import edu.princeton.cs.introcs.StdDraw;

public class SnakeGame {

	public static void drawSnake (List<Double> x, List<Double> y) {
		for (int i = 0; i<x.size(); i++) {
			StdDraw.setPenColor(StdDraw.ORANGE);
			StdDraw.filledCircle(x.get(i), y.get(i), 0.02);
		}
	}

	public static boolean outofBound (List<Double> x, List<Double> y) {
		if (x.get(x.size()-1)<0||x.get(x.size()-1)>1||y.get(y.size()-1)<0||y.get(y.size()-1)>1) {
			return true;
		}
		return false;
	}

	public static boolean hitItself (List<Double>x, List<Double>y) {	
		for (int i = 0; i<x.size()-2; i++) {
			if (Math.abs(x.get(x.size()-1)-x.get(i))<0.005&&Math.abs(y.get(y.size()-1)-y.get(i))<0.005) {
				return true;
			}
		}
		return false;
	}

	public static void drawFood(List<Double>food) {
		double xFood = Math.random();
		double yFood = Math.random();
		food.add(xFood);
		food.add(yFood);
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.filledCircle(food.get(0), food.get(1), 0.02);
	}

	public static boolean eatFood (List<Double>x, List<Double>y,List<Double>food) {
		if (Math.abs(x.get(0)-food.get(0))<0.04 && Math.abs(y.get(0)-food.get(1))<0.04) {
			food.remove(0);
			food.remove(1);
			food.add(Math.random());
			food.add(Math.random());
			return true;
		}
		return false;	
	}

	public static void endScene() {
		StdDraw.clear(StdDraw.GRAY);
		StdDraw.setFont(new Font(Font.MONOSPACED, 24, 24));
		StdDraw.text(0.5, 0.5, "Game Over");
		StdDraw.show();
	}

	public static void main(String[] args) {
		boolean end = false;
		//		System.out.println("I'm a snaaaaaaaake! HISSSSSSSSSSSssssss.....");
		List<Double>xSnake = new LinkedList<Double>(); //snake x-coordinate
		List<Double>ySnake = new LinkedList<Double>(); //snake y-coordinate
		List<Double>food = new LinkedList<Double>(); //food location

		xSnake.add(0.4);
		xSnake.add(0.4);
		xSnake.add(0.4);
		xSnake.add(0.4);
		xSnake.add(0.4);
		xSnake.add(0.4);
		xSnake.add(0.4);
		xSnake.add(0.4);
		xSnake.add(0.4);
		xSnake.add(0.4);

		ySnake.add(0.40);
		ySnake.add(0.41);
		ySnake.add(0.42);
		ySnake.add(0.43);
		ySnake.add(0.44);
		ySnake.add(0.45);
		ySnake.add(0.46);
		ySnake.add(0.47);
		ySnake.add(0.48);
		ySnake.add(0.49);
		StdDraw.enableDoubleBuffering();
		
		while (!end) {
			StdDraw.clear();
			drawFood(food);
			drawSnake(xSnake,ySnake);

			if (StdDraw.hasNextKeyTyped()) {
				char key = StdDraw.nextKeyTyped();		
				if (key=='a') {
					while (!StdDraw.hasNextKeyTyped()) {
						StdDraw.clear();
						xSnake.add(xSnake.get(xSnake.size()-1)-0.01);
						ySnake.add(ySnake.get(ySnake.size()-1));
						if (eatFood(xSnake,ySnake, food)==false) {
							xSnake.remove(xSnake.get(0));
							ySnake.remove(ySnake.get(0));
						}
						drawFood(food);
						drawSnake(xSnake,ySnake);
						StdDraw.show(20);
						if (outofBound(xSnake,ySnake)==true||hitItself(xSnake,ySnake)) {
							endScene();
							end=true;
							break;
						}
					}
				}

				if (key == 'd') {
					while (!StdDraw.hasNextKeyTyped()) {
						StdDraw.clear();
						xSnake.add(xSnake.get(xSnake.size()-1)+0.01);
						ySnake.add(ySnake.get(ySnake.size()-1));
						if (eatFood(xSnake,ySnake, food)==false) {
							xSnake.remove(xSnake.get(0));
							ySnake.remove(ySnake.get(0));
						}
						drawFood(food);
						drawSnake(xSnake,ySnake);
						StdDraw.show(20);
						if (outofBound(xSnake,ySnake)==true||hitItself(xSnake,ySnake)) {
							endScene();
							end=true;
							break;
						}
					}
				}

				if (key == 'w') {
					while (!StdDraw.hasNextKeyTyped()) {
						StdDraw.clear();
						xSnake.add(xSnake.get(xSnake.size()-1));
						ySnake.add(ySnake.get(ySnake.size()-1)+0.01);
						if (eatFood(xSnake,ySnake,food)==false) {
							xSnake.remove(xSnake.get(0));
							ySnake.remove(ySnake.get(0));
						}
						drawFood(food);
						drawSnake(xSnake,ySnake);
						StdDraw.show(20);
						if (outofBound(xSnake,ySnake)==true||hitItself(xSnake,ySnake)) {
							endScene();
							end=true;
							break;
						}
					}
				}
				if (key == 's') {
					while (!StdDraw.hasNextKeyTyped()) {
						StdDraw.clear();
						xSnake.add(xSnake.get(xSnake.size()-1));
						ySnake.add(ySnake.get(ySnake.size()-1)-0.01);
						if (eatFood(xSnake,ySnake,food)==false) {
							xSnake.remove(xSnake.get(0));
							ySnake.remove(ySnake.get(0));
						}
						drawFood(food);
						drawSnake(xSnake,ySnake);
						StdDraw.show(20);
						if (outofBound(xSnake,ySnake)==true||hitItself(xSnake,ySnake)) {
							endScene();
							end=true;
							break;
						}
					}
				}
			}
			StdDraw.show(20);
		}
	}


}
