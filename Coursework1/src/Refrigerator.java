
public class Refrigerator extends Appliance{

	// default constructor followed by constructors 
	//depending on how much information is initially given
	//this is to help when reading from the config file
	public Refrigerator() {
		this(1, 0, 0);
		
	}
	
	public Refrigerator(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse, gasUse, waterUse, -1);
	}
	public Refrigerator(int electricityUse, int gasUse){
		this(electricityUse, gasUse, 0);
	}
	public Refrigerator(int electricityUse){
		this(electricityUse, 0, 0);
	}

	//fridge is always on so it never receives tasks
	public void checkTask(String task){
		
	}
	

	//setter and getter methods for appliance name
	public void setName() {
		applianceName = "Refrigerator";
	}
	public String getName() {
		return applianceName;
	}
	
	//this overrides the appliance timePasses() method 
	public void timePasses() {
		for(Meter a: appMeters){
			//incremnts electric use each timepPasses as the fridge is always on
			if (a.getType().equals("Electric")){
				a.incrementConsumed();
		}
	}
	}
}
