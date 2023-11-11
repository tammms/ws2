package bankaccount;

import java.util.LinkedList;

public class Main{
    public static void main(String[] args){

        String currentDate = BankAccount.currentDate();
        BankAccount newacc = new BankAccount("tammy");
        System.out.printf("Account Holder Name: %s\n", newacc.getAccountHolder());
        System.out.printf("Account Number: %s\n", newacc.getAccountNumber());
        newacc.setDateCreated(currentDate);
        System.out.printf("Date created: %s\n",newacc.getDateCreated());


        // input transactions
        //System.out.printf(currentDate);
        newacc.Deposit(100, currentDate);
        newacc.Withdraw(300, currentDate);
        
        //print transaction history
        System.out.println("Transaction History:");
        LinkedList<String> transactions = newacc.getTransactions();
        for (int i=0; i<transactions.size(); i++){
            System.out.println(transactions.get(i));
        }
        System.out.printf("Current Account Balance: $%.2f\n",newacc.getAccountBalance());

        //to close bank account
        //newacc.setCloseAcc(currentDate);
        //System.out.printf("%b",newacc.isClosed());


        ///////////////////////// FIXED DEPOSIT /////////////////////////////////
        System.out.printf("\n\nFIXED ACCOUNT \n");
        FixedDepositAccount fixedacc = new FixedDepositAccount("tammy", 100f);
        System.out.printf("Account Holder Name: %s\n", fixedacc.getAccountHolder());
        System.out.printf("Account Number: %s\n", fixedacc.getAccountNumber());
        fixedacc.Withdraw(100, currentDate);
        fixedacc.setInterest(0.5f);
        fixedacc.setAccountBalance();
        System.out.printf("Account balance: $%s\n", fixedacc.getAccountBalance());


    }
}