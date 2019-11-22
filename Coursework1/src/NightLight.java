
public class NightLight extends Appliance{

	// default constructor followed by constructors 
	//depending on how much information is initially given
	//this is to help when reading from the config file
	public NightLight() {
		this(1, 0, 0);
	}
	public NightLight(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse, gasUse, waterUse, 0);
	}
	public NightLight(int electricityUse, int gasUse){
		this(electricityUse, gasUse, 0);
	}
	public NightLight(int electricityUse){
		this(electricityUse, 0, 0);
	}

	//determines whether the task received 
	//is suitable for this appliance
	//if so, perform task given
	public void checkTask(String task){
		if (task == "TurnOnNightLight") {
		turnOn();
		
		} else if (task == "TurnOffNightLight") {
		turnOff();
		}
	}	

	//setter and getter methods for appliance name
	public void setName() {
		applianceName = "NightLight";
	}
	public String getName() {
		return applianceName;
	}
}
