package fr.afpa.account;

/**
 * Class representing a bank account
 */
public class Account {
    private String iban;
    private int balance;
    private int overdraftAuthorization;

    public Account(String iban, int balance, int overdraftAuthorization) {
        this.iban = iban;
        this.balance = balance;
        this.overdraftAuthorization = overdraftAuthorization;
    }

    //METHODS

    //ADDMONEY
    public int addMoney(int amount) {
        return this.balance = balance + amount;
    }

    //REMOVEMONEY
    public int removeMoney(int amount) throws Exception{
        if ((balance - amount) > overdraftAuthorization){
            balance -= amount;
        }else{
            throw new Exception("ERROR: balance too low..");
        } 
        return balance;
    }

    //TRANSFER
    public void transferMoney(int amount, Account debtorAccount, Account creditorAccount){
        try {
            debtorAccount.removeMoney(amount);
            creditorAccount.addMoney(amount);
        } catch (Exception e) {
            System.out.println("ERROR: DEBTOR's balance too low..");
        }
    }

    //CHECKIBAN
    public boolean checkIban(String stringToCheck){
        
    }

    // GETTERS & SETTERS
    // IBAN
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    // BALANCE
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // OVERDRAFTAUTHORIZATION
    public int getOverdraftAuthorization() {
        return overdraftAuthorization;
    }

    public void setOverdraftAuthorization(int overdraftAuthorization) {
        this.overdraftAuthorization = overdraftAuthorization;
    }


    //TO STRING

    @Override
    public String toString(){
        return "Account {"
        + "IBAN: " + getIban()
        + "| Balance: " + getBalance()
        + "| Overdraft Authorization: " + getOverdraftAuthorization()
        + "}";
    }

}
