
public class GasCooker extends Cooker{

	// default constructor followed by constructors 
	//depending on how much information is initially given
	//this is to help when reading from the config file
	public GasCooker() {
		this(0, 4, 0);
		
	}
	public GasCooker(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse, gasUse, waterUse, 4);
	}
	public GasCooker(int electricityUse, int gasUse){
		this(electricityUse, gasUse, 0);
	}
	public GasCooker(int electricityUse){
		this(electricityUse, 4, 0);
	}
	
	//determines whether the task received 
	//is suitable for this appliance
	//if so, perform task given
	public void checkTask(String task){
		if (task == "cook - gas") {
		cook();
		}
	}
	
	//setter and getter methods for appliance name
	public void setName() {
		applianceName = "GasCooker";
	}
	public String getName() {
		return applianceName;
	}
}
