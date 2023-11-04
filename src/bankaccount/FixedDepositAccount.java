package ws2;


public class FixedDepositAccount extends BankAccount{
    
    float interest = 0.03f;
    int duration = 6;

    // constructors
    public FixedDepositAccount(String name, float balance){
        super(name, balance);
    }
    public FixedDepositAccount(String name, float balance, float interest){
        super(name, balance);
        this.interest = interest;
    }
    public FixedDepositAccount(String name, float balance, float interest, Integer duration){
        super(name, balance);
        this.interest = interest;
        this.duration = duration;
    }

    //set account duration and interest rate
    public void setInterest(float newInterest){
        if(interest != 0.03f){
             throw new IllegalArgumentException("Interest has been updated once");
        }
        interest = newInterest;
    }

    public void setDuration(Integer newDuration){
        if(duration != 6){
             throw new IllegalArgumentException("Duration has been updated once");
        }
        this.duration = newDuration;
    }

    public void setAccountBalance(){
        this.accountBalance = (1+interest)* (duration/6) *accountBalance;
    }

    //Withdraw and Deposit Methods perform no operation
    @Override
    public void Deposit(float amountDeposit, String date){
        System.out.println("Fixed Deposit Account - No operation Made");
    }

    @Override
    public void Withdraw(float amountWithdraw, String date){
        System.out.println("Fixed Deposit Account - No operation Made");
    }

    //update balance
    public float getAccountBalance(){
        return accountBalance;
    }

}