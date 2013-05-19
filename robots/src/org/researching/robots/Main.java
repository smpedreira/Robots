package org.researching.robots;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Controller controller;
    
    
	public static void main(String[] args){
		Controller controller = getController();
		
		boolean platInitialized = controller.initPlat();
		if(platInitialized){
		    boolean robotInitialized = controller.initRobot();
		    if(robotInitialized){
		        boolean dirInitialized = controller.initDirections();
		        if(dirInitialized) controller.start();
		    }
		}
		System.out.println("controller finished");
	}
	
	private static Controller getController(){
	    if(controller == null){
	        ReadSystem in = ReadSystem.getInstance();
	        setController(new Controller(new Meseta(), new Robot(), new ArrayList<Direction>(), in));
	    }
	    return controller;
	}
	
	public static void setController(Controller cont){
	    controller = cont; 
	}
}
