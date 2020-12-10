package Main_Pakcage;

import java.util.ArrayList;
import java.util.List;

public class Garden {
	public double length;
	public double width;
	//TODO add to UML
	public String name;
	//////
	public String location;
	public List<Plant> plants = new ArrayList<Plant>();
	
	
	public static Garden createGarden(double length,double width,String name,String location
			) {
		Garden garden = new Garden();
		garden.length = length;
		garden.width = width;
		garden.name = name;
		garden.location = location;
		return garden;
	}
	
	public void updateGarden(double length,double width,String location) {
		this.length = length;
		this.width = width;
		this.name = name;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Garden [length=" + length + ", width=" + width + ", location=" + location +"]";
	}
	
	

}
