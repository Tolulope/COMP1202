import java.util.ArrayList;

public abstract class Appliance {
	
	//variables to do with what the appliance has used 
	public  int electricityUse;
	public  int gasUse;
	public  int waterUse;
	
	//variables to do with whether the Appliance is on or off
	protected int timeOn;
	protected String currentState;
	
	
	//variable telling us whether or not the appliance is on
	public boolean isOn;
	public String applianceName;
	
	Appliance appliance;
	
	//variable for time that has passed since the appliance was turned on
	public int timePassed;

	//list containing meters that are attached the appliance
	ArrayList<Meter> appMeters = new ArrayList<Meter>();
	
	//constructor takes in and assigns the vital variables
	public Appliance (int electricityUse, int gasUse, int waterUse, int timeOn) {
		this.electricityUse = electricityUse;
		this.gasUse = gasUse;
		this.waterUse = waterUse;
		this.timeOn = timeOn;
	
		}

	//setter and getter method 
	// - in case you want to display the name of the appliance
	//in any situation
	public abstract void setName();
	public abstract String getName();
	
	//adds a Meter to an appliance by populating the afore mentioned arrayList
	public void addAppMeter(Meter meter) {
		appMeters.add(meter);
	}
		
	//extension
	public void setCurrentState(String state){
		this.currentState = state;
	}
	//extension
	public String getCurrentState(){
		return currentState;
	}
	
	//extension
	public void setEco(int leccy, int gas, int water){
		currentState = "ECO";
		this.electricityUse = leccy;
		this.gasUse = gas;
		this.waterUse = water;
	}
	//extension
	public void noMoreEco(){
		currentState = "ON";
	}
	
	
	public void timePasses(){
		//checks to see if the appliance is on
		if (isOn == true ){
			//checks to see that the appliance is not always on
			 if (timeOn != -1){
				 //if it isn't always on, increment time passed since
				 //the appliance was turned on
				timePassed++;
			 }
			 //for each meter attached to the appliance
			for(Meter meter: appMeters){
				//if it's an electric meter, 
				//increment the electricity used in 15 minutes 
				if (meter.getType().equals("Electric")){
					meter.incrementConsumed(electricityUse);
					//if it's a water meter, 
					//increment the water used in 15 minutes 
				} else if (meter.getType().equals("Water")){
					meter.incrementConsumed(waterUse);
					//if it's a gas meter, 
					//increment the gas used in 15 minutes 
				} else if (meter.getType().equals("Gas")){
					meter.incrementConsumed(gasUse);
				}
				//if the time passed since the appliance was tuned on
				//is now equal to the time the appliance should be on for
				if (timePassed == timeOn){
					//turn off the appliance
					turnOff();
					//reset the time passed since turned on
					timePassed = 0;
				}
		
			}
			
			
		}
			
	}
	

	//turnOn method which returns an indication that the appliance is on
	public boolean turnOn() {
		currentState = "ON";
		isOn = true;
		return isOn;
		
	
	}
	//turnOff method which returns an indication that the appliance is off
	public boolean turnOff() {
		currentState = "OFF";
		isOn = false;
		return isOn;
	}
	
	
	//getter methods for use of appliances
	public int getElectricityUse() {
		return electricityUse;
	}
	
	public int getGasUse() {
		return gasUse;
	}
	
	public int getWaterUse() {
		return waterUse;
	}

	
	//getter method for the appliance itself
	public Appliance getAppliance(){
		return appliance;
			
	}
	
	//check task method that determines whether the task is fit for the appliance
	public abstract void checkTask(String task);
			

}


