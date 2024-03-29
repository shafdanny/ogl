package fr.unice.polytech.ogl.islac.data;

public class Pos {

	int x;
	int y;
	
	
	public Pos(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public Pos(Pos pos) {
		this.x=pos.x;
		this.y=pos.y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pos other = (Pos) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public int getX() {
		
		return x;
		
	}
public int getY() {
		
		return y;
		
	}

public void setY(int y){
	this.y=y;
}


	public void setX(int x) {
		this.x = x;
	}
	
	public String toString()
	{
		return x+" "+y;
	}
	
	
}
