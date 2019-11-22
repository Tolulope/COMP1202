
public class PowerShower extends Shower {

	// default constructor followed by constructors 
	//depending on how much information is initially given
	//this is to help when reading from the config file
	public PowerShower() {
		this(0, 10, 5);
	}
	
	public PowerShower(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse, gasUse, waterUse, 1);
	}
	public PowerShower(int electricityUse, int gasUse){
		this(electricityUse, gasUse, 5);
	}
	public PowerShower(int electricityUse){
		this(electricityUse, 10, 5);
	}
	
	


	//determines whether the task received 
	//is suitable for this appliance
	//if so, perform task given
	public void checkTask(String task){
		if (task == "Shower") {
		shower();
		}
	}
	
	//setter and getter methods for appliance name
	public void setName() {
		applianceName = "PowerShower";
	}
	public String getName() {
		return applianceName;
	}
}
