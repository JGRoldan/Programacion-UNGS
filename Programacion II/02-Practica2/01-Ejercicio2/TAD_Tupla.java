package tad_ej2;

import java.util.ArrayList;

public class TAD_Tupla{
	
	private int x; 
	private int y;
	
	public TAD_Tupla(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public void setX(int X) {
		this.x = X;
	}

	public void setY(int Y) {
		this.y = Y;
	}

	@Override
	public String toString() {
		return "TAD_Tupla [x=" + x + ", y=" + y + "]";
	} 
	

}
