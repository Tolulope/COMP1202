/*
 * Programming 1 Coursework 2016/17 - Tolulope Ogunremi - Part 1
 */
public class GasMeter extends Meter{
	  
	//constructors depending on how much information is initially given
	//this is to help when reading from the config file

	public GasMeter(int startValue, boolean CanGen) {
		super(startValue,CanGen);
	}
	
	public GasMeter(int startValue){
		this(startValue, false); 
	}
	public GasMeter(boolean CanGen) {
		this(0,CanGen);
	}

	//returns type of meter
	@Override
	public String getType() {
		return "Gas";
	}
	

}
