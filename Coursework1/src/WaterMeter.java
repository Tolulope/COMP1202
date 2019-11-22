/*
 * Programming 1 Coursework 2016/17 - Tolulope Ogunremi - Part 1
 */
public class WaterMeter extends Meter{
  
	//constructors depending on how much information is initially given
	//this is to help when reading from the config file
	public WaterMeter(int startValue, boolean CanGenerate) {
		super(startValue,CanGenerate);
	}
	
	public WaterMeter(int startValue){
		this(startValue, false); 
	}
	public WaterMeter(boolean CanGenerate) {
		this(0,CanGenerate);
	}

	//returns type of meter
	@Override
	public String getType() {
		return "Water";
	}

}
