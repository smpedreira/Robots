package org.researching.robots;

public class Meseta {
	
	private int x, y;
	
	public Meseta(){
		
	}

	public Meseta(int x, int y){
		this.setX(x);
		this.setY(y);
	}

	public boolean validPosition(int x, int y){
		return validPositionWith(x, this.getX()) && validPositionWith(y, this.getY());
		
	}
	
	private boolean validPositionWith(int positionToCheck, int position){
		return (positionToCheck >= 0 && positionToCheck < position);
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

}
