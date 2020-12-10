package Main_Pakcage;

public class Plant {

	public int x;
	public int y;
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Plant [x=" + x + ", y=" + y + ", name=" + name + "]";
	}
	
	
	
	
	
	
	
	
	
}
