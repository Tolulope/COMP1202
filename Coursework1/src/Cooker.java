
public abstract class Cooker extends Appliance{

	public Cooker(int electricityUse, int gasUse, int waterUse, int timeOn) {
		super(electricityUse, gasUse, waterUse, timeOn);
		
	}
	
	//cook method for all cookers
	//turns on cooker so that it uses resources when timePasses
	public void cook(){
		currentState = "ON";
		isOn = true;
		turnOn();
	}
}
