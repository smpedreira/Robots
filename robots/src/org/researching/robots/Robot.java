package org.researching.robots;


public class Robot {

	private int posX;
	private int posY;
	private CardinalPoint cardinalPoint;
	
	public Robot(){}
	
	public Robot(int x, int y, CardinalPoint cardinalPoint){
		posX = x;
		posY = y;
		this.cardinalPoint = cardinalPoint;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosY() {
		return posY;
	}

	public void setCardinalPoint(CardinalPoint cardinalPoint) {
		this.cardinalPoint = cardinalPoint;
	}

	public CardinalPoint getCardinalPoint() {
		return cardinalPoint;
	}

	public void showSituation() {
		System.out.println( posX + " " + posY + " "+ ((cardinalPoint == null)? "" : cardinalPoint.toString()));
	}

	public boolean process(Meseta plat, Direction direction){
		int newPosX = posX;
		int newPosY = posY;

		switch(direction){
			case L:
				this.cardinalPoint =  this.cardinalPoint.getCardinalToLeft();
				break;
			case R:
				this.cardinalPoint =  this.cardinalPoint.getCardinalToRight();
				break;
			case M:
				newPosX = this.cardinalPoint.getPosX(newPosX);
				newPosY = this.cardinalPoint.getPosY(newPosY);
				if(plat.validPosition(newPosX,newPosY)){
					this.posX = newPosX;
					this.posY = newPosY;
				}else{
					return false;
				}
				break;
		}
		return true;
	}

}
