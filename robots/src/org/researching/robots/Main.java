package org.researching.robots;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		ReadSystem in = ReadSystem.getInstance();
		Controller controller = new Controller(new Meseta(), new Robot(), new ArrayList<Direction>(), in);
		
		boolean platInitialized = controller.initPlat();
		boolean robotInitialized = controller.initRobot();
		boolean dirInitialized = controller.initDirections();

		controller.start();
	}
}
