package Main_Pakcage;

import java.util.ArrayList;
import java.util.List;

/**
 * @version alpha version
 * @author Weitong Sun, Chen Dai, Zhenghan Wang, Xinyi Sun, Ruoxi Jin
 * This is model class. 
 * The model represents the data in the application
 * it is the bridge between the control and the view.
 */

public class Model {
	
	static List<Plant> plants = new ArrayList<>();
	static List<Garden> gardens = new ArrayList<Garden>();
	
	private double viewWidth;
	private double viewHeight;
	
	public Model(double viewWidth, double viewHeight) {
		super();
		this.viewWidth = viewWidth;
		this.viewHeight = viewHeight;
	}

}
