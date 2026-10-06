package ex03;

import java.util.UUID;

public interface TransactionsList {

	public void addTransaction(Transaction transaction);

	public void removeTransaction(UUID ID);

	public void printAllTransactions();

}
