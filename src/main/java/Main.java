public class Main {
	public static void main(String[] args) {
		Client willian = new Client();
		willian.setName("Willian");
		
		Account cc = new CheckingsAccount(willian);
		Account sa = new SavingsAccount(willian);
		
		cc.deposit(2200d);
		cc.transfer(1800d, sa);
		
		cc.printStatus();
		sa.printStatus();
		
		cc.printTransactionHistory();
		sa.printTransactionHistory();
	}
}