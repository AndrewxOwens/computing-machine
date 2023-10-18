public class Account {
	//--- Constants
	public static final int PASSWORD = 1234; // user password
	
	//--- Instance Variables
	private double checking;
	private double savings;
	
	//--- Constructors
	public Account() {
		checking = 0;
		savings = 0;
	}
	
	public Account(double checkingInitial, double savingsInitial) {
		checking = checkingInitial;
		savings = savingsInitial;
	}
	
	//--- Methods
	public int getPassword() {
		return PASSWORD;
	}
	
	public double getChecking() {
		return checking;
	}
	
	public double getSavings() {
		return savings;
	}
	
	public void increaseChecking(double increase) {
		checking += increase;
	}
	
	public void decreaseChecking(double decrease) {
		checking -= decrease;
	}
	
	public void increaseSavings(double increase) {
		savings += increase;
	}
	
	public void decreaseSavings(double decrease) {
		savings -= decrease;
	}
	
	public void transferToChecking(double transfer) {
		checking += transfer;
		savings -= transfer;
	}
	
	public void transferToSavings(double transfer) {
		savings += transfer;
		checking -= transfer;
	}
	
	// toString Method
	public String toString() {
		String str;
		str = "Checking = $" + String.format("%.2f", checking) + "\n" + "Savings  = $" + String.format("%.2f", savings) + "\n";
		return str;
	}
}