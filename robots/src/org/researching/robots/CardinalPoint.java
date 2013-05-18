package org.researching.robots;

public enum CardinalPoint {

	N(0,1, "W", "E"),
	S(0,-1,"E", "W"),
	W(-1,0,"S", "N"),
	E(1,0,"N","S");

	private int stepY;
	private int stepX;
	private String moveToLeft;
	private String moveToRight;

	CardinalPoint(int x, int y, String left, String right){
		this.stepX = x;
		this.stepY = y;
		moveToLeft = left;
		moveToRight = right;
	}
	
	public int getPosY(int y){
		return y+stepY;
	}

	public int getPosX(int x){
		return x+stepX;
	}

	public CardinalPoint getCardinalToLeft(){
		return CardinalPoint.valueOf(moveToLeft);
	}
	
	public CardinalPoint getCardinalToRight(){
		return CardinalPoint.valueOf(moveToRight);
	}
}
