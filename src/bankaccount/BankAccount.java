package ws2;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import static java.time.format.FormatStyle.SHORT;


public class BankAccount {

    private String accountHolder;
    public String accountNumber;
    public float accountBalance = 0;
    public LinkedList<String> transactions;
    public boolean closed = false;
    public String dateCreated;
    public String dateClosed;
    


    //constructor 1
    public BankAccount(String accountHolder){
        this.accountHolder = accountHolder;
        Random r = new Random();
        int randomNumber = 100000 + r.nextInt(1000000);
        this.accountNumber = String.valueOf(randomNumber);
        this.transactions = new LinkedList<>();
        this.dateCreated = new String();
    }

    //constructor 2
    public BankAccount(String accountHolder, float accountBalance){
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
        Random r = new Random();
        int randomNumber = 100000 + r.nextInt(1000000);
        this.accountNumber = String.valueOf(randomNumber);
        this.transactions = new LinkedList<>();
    }

    //set date
    static String currentDate(){
        LocalDateTime newDate = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDateTime(SHORT);
        return fmt.format(newDate);
    }

    
    // Deposit Method
    public void Deposit(float amountDeposit, String date) throws IllegalArgumentException{
        if(amountDeposit<=0 | closed == true){
            throw new IllegalArgumentException("Input positive amount or account is closed");
        }
        else {
            accountBalance += amountDeposit;
            String newTransaction = String.format("Deposit $%.2f at %s",amountDeposit, date);
            this.transactions.add(newTransaction);
        }
    }

    // Withdraw Method
    public void Withdraw(float amountWithdraw, String date) throws IllegalArgumentException{
        if(amountWithdraw<=0 | closed == true){
            throw new IllegalArgumentException("Input positive amount or account is closed");
        }
        else {
            accountBalance -= amountWithdraw;
            String newTransaction = String.format("Withdraw $%.2f at %s",amountWithdraw, date);
            this.transactions.add(newTransaction);
        }
    }
    //method to close account
    public void setCloseAcc(String date){
        closed = true;
        System.out.printf("Account closing Date: %s", date);
    }

    public void setDateCreated(String date){
        this.dateCreated = date;
    }


    //get data
    public String getAccountHolder(){
        return accountHolder;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public float getAccountBalance(){
        return accountBalance;
    }

    public LinkedList<String> getTransactions(){
        return transactions;
    }

    public boolean isClosed(){
        return closed;
    }

    public String getDateCreated(){
        return dateCreated;
    }

    


}

