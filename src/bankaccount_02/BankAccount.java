package bankaccount_02;

import static java.time.format.FormatStyle.SHORT;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


// take note of transaction list  and dateCreated initialised in constructor

public class BankAccount {

    private String name;
    private String accountNumber;
    private float accountBalance;
    private List<String> transactions;
    private boolean isClosed;
    private String dateCreated;
    private String dateClosed;

    BankAccount(String name){
        this.name = name;
        this.accountBalance = 0;

        Random r = new Random();
        int randomNumber = 100000 + r.nextInt(1000000);
        this.accountNumber = String.valueOf(randomNumber);

        this.transactions = new LinkedList<>();

        LocalDateTime createdDate = LocalDateTime.now().minusMonths(10);
        DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDateTime(SHORT);
        this.dateCreated = fmt.format(createdDate);

    }
    

    BankAccount(String name, float accountBalance){
        this.name = name;
        this.accountBalance = accountBalance;

        Random r = new Random();
        int randomNumber = 100000 + r.nextInt(1000000);
        this.accountNumber = String.valueOf(randomNumber);
        this.transactions = new LinkedList<>();

        LocalDateTime createdDate = LocalDateTime.now().minusMonths(10);
        DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDateTime(SHORT);
        this.dateCreated = fmt.format(createdDate);

    }


    //set date
    public static String currentDate(){
        LocalDateTime newDate = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDateTime(SHORT);
        return fmt.format(newDate);
    }


    public float getAccountBalance() {
        System.out.printf("Account balance = $%.2f", accountBalance);
        return accountBalance;
    }


    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }


    public List<String> getTransactions() {
        System.out.println("Transaction History:");
        for (int i =0; i<transactions.size(); i++){
            System.out.println(transactions.get(i));
        }
        return transactions;
    }


    public boolean isClosed() {
        return isClosed;
    }


    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }


    public String getDateCreated() {
        System.out.println("Date created:"+dateCreated);
        return dateCreated;
    }


   /*  public void setDateCreated() {
        LocalDateTime createdDate = LocalDateTime.now().minusMonths(10);
        DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDateTime(SHORT);
        this.dateCreated = fmt.format(createdDate);
    } */


    public String getDateClosed() {
        System.out.println(dateClosed);
        return dateClosed;
    }


    public void setDateClosed() {
        if (!isClosed){
            this.dateClosed = "account is still open";
        }
        else{

        LocalDateTime closedDate = LocalDateTime.now().plusDays(10);
        DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDateTime(SHORT);
        this.dateClosed = fmt.format(closedDate);

        }
    }

    public void deposit(float depositAmount, String date){

        if (depositAmount<0 | isClosed == true) {
            throw new IllegalArgumentException("Input positive amount or account is closed");}

        else{
            accountBalance += depositAmount;
            transactions.add(String.format("deposit $%.2f at %s", depositAmount,date));

        }
    }


    public void withdraw(float withdrawAmount, String date){

        if (withdrawAmount<0 | isClosed == true) {
            throw new IllegalArgumentException("Input positive amount or account is closed");}

        else{
            accountBalance -= withdrawAmount;
            transactions.add(String.format("withdraw $%.2f at %s", withdrawAmount,date));

        }
    }
    


}
