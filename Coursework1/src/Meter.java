/*
 * Programming 1 Coursework 2016/17 - Tolulope Ogunremi - Part 1
 */
public abstract class Meter {
	
	protected int consumed;
	protected int generated;
	protected boolean canGenerate;
	
	//When a meter is initially created, it has neither consumed nor generated energy
	//as no all meters can generated energy, it is safer to put 'false' as the default value for 'canGenerate'
	public Meter(){
		consumed = 0;
		generated = 0;
		canGenerate = false;
	}

	public Meter(int consumed, boolean canGenerate){
		this.consumed = consumed;
		generated = 0;
		this.canGenerate = canGenerate;
	}
	
	public Meter(int consumed){
		this.consumed = consumed;
		generated = 0;
		canGenerate = false;
	}
	
	//increments consumed
	public void incrementConsumed() {
		consumed++;
		
	}                                                       
	
	//increments generated
	public void  incrementGenerated(){
		generated++;
	
	}
	//allows you to increment generated multiple times
	protected void incrementGenerated(int resourceUse){
		for (int i = 1; i <= resourceUse; i++){
			incrementGenerated();
		}
	}
	//allows you to increment consumed multiple times
	protected void incrementConsumed(int resourceUse){
		for (int i = 1; i <= resourceUse; i++){
			incrementConsumed();
		}
	}
	
	
	//returns true if it can Generate energy and false if it cannot
	public boolean canGenerate() {
		return canGenerate;
	}
	
	//returns amount consumed
	public int getConsumed() {
		return consumed;
	}
	
	//returns amount generated
	public int getGenerated() {
		return generated;
	}
	
	//method returning type of meter: gas, electric, etc. 
	//This will have to be implemented by sub-classes when they are created
	public abstract String getType();
	

}
