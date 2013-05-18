package org.researching.robots;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Controller {

	private Meseta plat;
	private Robot robot;
	private List<Direction> directions;
	private ReadSystem in;

	public Controller(Meseta plat,Robot robot,List<Direction> directions,ReadSystem in){
		this.plat = plat;
		this.robot = robot;
		this.directions = directions;
		this.in = in;
	}

	public void start(){
	    int idx = 0;
	    boolean result = true;
	    do{
           result = robot.process(plat, directions.get(idx));
           ++idx;
	    }while(result && idx < directions.size());
	    
		if(!result){
			System.out.println("The orders are wrong. The robot cannot continue");
		}
		getRobot().showSituation();
	}

	public boolean initDirections() {
		System.out.println("Enter the orders. Ex.(MMRM)): ");
		try{
			String orders = in.nextLine();
			orders = orders.replace(" ", "").toUpperCase();
			
			for(int i=1; i <= orders.length(); ++i){
				String dir = orders.substring(i-1, i);
				directions.add(Direction.valueOf(dir));
			}
			return true;
		}catch(Exception e){
    		System.out.println("Orders for the robot are wrong.");
    		if(isContinue()){
    			System.out.println("");
    			return initDirections();
    		}else{
    			return false;
    		}
		}
	}

	public boolean initRobot() {
		try{
			System.out.println("Enter coordinates and the cardinal point of the robot. Ex.(0 0 N)");
  	  		int x = in.nextInt();
  	  		int y = in.nextInt();
  	  		String cardinal = in.nextLine();
  	  		
  	  		robot.setPosX(x);
  	  		robot.setPosY(y);
  	  		robot.setCardinalPoint(CardinalPoint.valueOf(cardinal.replace(" ","").toUpperCase()));
  	  		
  	  		return true;
		}catch(RuntimeException e){
			in.nextLine();
    		System.out.println("coordinates of the robot are wrong.");
    		if(isContinue()){
    			System.out.println("");
    			return initRobot();
    		}else{
    			return false;
    		}
    	}
	}

	public boolean initPlat() {
		try{
			System.out.println("Enter the upper-right coordinates of the plateau. (x,y)");
  	  		int x = in.nextInt();
  	  		int y = in.nextInt();
  	  	
  	  		System.out.println("x: "+x);
  	  		System.out.println("y: "+y);

  	  		getPlat().setX(x);
  	  		getPlat().setY(y);

  	  		return true;
		}catch(Exception e){
			in.nextLine();
    		System.out.println("upper-right coordinates are wrong.");
    		if(isContinue()){
    			System.out.println("");
    			return initPlat();
    		}else{
    			return false;
    		}
    	}
	}

	public boolean isContinue(){
	    System.out.println("Do you want to continue and try it again.(y/n): ");
        String resp = in.nextLine();
        return ("y".equalsIgnoreCase(resp) || "yes".equalsIgnoreCase(resp));
	}

	public void setPlat(Meseta plat) {
		this.plat = plat;
	}

	public Meseta getPlat() {
		return plat;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public Robot getRobot() {
		return robot;
	}

	public void setDirections(List<Direction> directions) {
		this.directions = directions;
	}

	public List<Direction> getDirections() {
		return directions;
	}

}
