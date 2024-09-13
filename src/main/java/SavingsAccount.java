public class SavingsAccount extends Account {
	public SavingsAccount(Client client) {
		super(client);
	}
	
	@Override
	public void printStatus() {
		System.out.println("=== Savings Account Status ===");
		super.printStatus();
	}
}
