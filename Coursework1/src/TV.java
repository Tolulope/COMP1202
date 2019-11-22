
public class TV extends Appliance{

	// default constructor followed by constructors 
	//depending on how much information is initially given
	//this is to help when reading from the config file
	public TV() {
		this(1, 0, 0);
		
	}
	
	public TV(int electricityUse, int gasUse, int waterUse){
		super(electricityUse, gasUse, waterUse, 0);
	}
	public TV(int electricityUse, int gasUse) {
		this(electricityUse, gasUse, 0);
	}

	public TV(int electricityUse) {
		this(electricityUse, 0, 0);
	}


	//determines whether the task received 
	//is suitable for this appliance
	//if so, perform task given
	public void checkTask(String task){
		if (task == "TurnOnTV") {
		turnOn();
		
		} else if (task == "TurnOffTV") {
		turnOff();
		
		} 
		
	}
	


	//setter and getter methods for appliance name
	public void setName() {
		applianceName = "TV";
	}
	public String getName() {
		return applianceName;
	}
}
