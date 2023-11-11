package bankaccount_02;



public class Main {

    public static void main(String[] args) {
        
        BankAccount account1 = new BankAccount("tammy");

        String date = BankAccount.currentDate();
        
        account1.deposit(100000, date);
        account1.withdraw(100, date);
        account1.getDateCreated();
        account1.getTransactions();
        account1.isClosed();
        
    }
    
}
