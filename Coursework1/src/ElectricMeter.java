/*
 * Programming 1 Coursework 2016/17 - Tolulope Ogunremi - Part 1
 */
public class ElectricMeter extends Meter {

	//constructors depending on how much information is initially given
	//this is to help when reading from the config file
	public ElectricMeter(int startValue, boolean CanGenerate) {
		super(startValue,CanGenerate);
	}
	
	public ElectricMeter(int startValue){
		this(startValue, false); 
	}
	public ElectricMeter(boolean CanGenerate) {
		this(0,CanGenerate);
	}


	//returns type of meter
	public String getType() {	
	return "Electric";
	}

	
	
}
