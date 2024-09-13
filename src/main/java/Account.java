import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Account implements IAccount {
	protected static final Integer DEFAULT_AGENCY = 1;
	private static Integer SEQUENCE = 1;
	
	protected Integer agency;
	protected Integer number;
	protected Double balance = 0d;
	protected Client client;
	private List<Transaction> transactions = new ArrayList<>();
	
	public Account(Client client) {
		this.agency = Account.DEFAULT_AGENCY;
		this.number = SEQUENCE++;
		this.client = client;
	}
	
	public void addTransaction(String type, Double amount, String details) {
		transactions.add(new Transaction(type, amount, details));
	}
	
	@Override
	public void withdraw(Double value) {
		balance -= value;
		addTransaction("Withdraw", value, "Withdrew " + value);
	}
	
	@Override
	public void deposit(Double value) {
		balance += value;
		addTransaction("Deposit", value, "Deposited " + value);
	}
	
	@Override
	public void transfer(Double value, Account transferAccount) {
		this.withdraw(value);
		transferAccount.deposit(value);
		addTransaction("Transfer", value,
			"Transferred to account " + transferAccount.getNumber());
	}
	
	@Override
	public void printStatus() {
		System.out.println(String.format("Titular: %s", this.client.getName()));
		System.out.println(String.format("Titular: %d", this.agency));
		System.out.println(String.format("Titular: %d", this.number));
		System.out.println(String.format("Titular: %.2f", this.balance));
	}
	
	public void printTransactionHistory() {
		System.out.println("Transaction History:");
		for (Transaction transaction : transactions) {
			System.out.println(transaction.getDate() + " - " + transaction.getType() + ": " + transaction.getAmount() + " (" + transaction.getDetails() + ")");
		}
	}
	
}
