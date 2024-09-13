import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Transaction {
	
	private LocalDateTime date;
	private String type; // "Deposit", "Withdraw", "Transfer"
	private Double amount;
	private String details;
	
	public Transaction(String type, Double amount, String details) {
		this.date = LocalDateTime.now();
		this.type = type;
		this.amount = amount;
		this.details = details;
	}
	
}
