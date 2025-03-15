import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FinanceManager {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        return transactions.stream().mapToDouble(Transaction::getAmount).sum();
    }

    public Map<String, Double> getSpendingByCategory() {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0) // Negative amounts are expenses
                .collect(Collectors.groupingBy(Transaction::getCategory,
                        Collectors.summingDouble(t -> -t.getAmount())));
    }
}