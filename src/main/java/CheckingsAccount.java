public class CheckingsAccount extends Account{
	public CheckingsAccount(Client client) {
		super(client);
	}
	
	@Override
	public void printStatus() {
		System.out.println("=== Checkings Account status ===");
		super.printStatus();
	}
}
