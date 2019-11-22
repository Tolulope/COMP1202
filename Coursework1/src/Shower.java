
public abstract class Shower extends Appliance{

	public Shower(int electricityUse, int gasUse, int waterUse, int timeOn) {
		super(electricityUse, gasUse, waterUse, timeOn);
	
	}
	
	//shower method for all showers
	//turns on shower so that it uses resources when timePasses
	public void shower(){
		currentState = "ON";
		turnOn();
	}
}



