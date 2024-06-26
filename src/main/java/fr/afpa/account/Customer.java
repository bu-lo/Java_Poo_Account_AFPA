package fr.afpa.account;

import java.util.ArrayList;

/**
 * Class that represents a client, bank account owner
 */

public class Customer {
    private final int id;
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts;

public Customer(int id, String firstName, String lastName){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.accounts = new ArrayList<>();
}


//GETTERS & SETTERS

//ID
public int getId() {
    return id;
}

//FIRSTNAME
public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

//LASTNAME
public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

//ARRAYLIST
public ArrayList<Account> getAccounts() {
    return accounts;
}

public void setAccounts(ArrayList<Account> accounts) {
    this.accounts = accounts;
}


//METHODS

//METHOD TO ADD AN ACCOUNT
public void addAccount (Account account){
    accounts.add(account);
    System.out.println("Adding of the account : " + account + " to " + this.lastName);   
}

//METHOD TO REMOVE AN ACCOUNT
public void removeAccount (Account account){
    accounts.remove(account);
    System.out.println("Removing of the account: " + account + "to" + this.lastName);
}

//TO STRING 
@Override
public String toString(){
    return "Customer {"
        + "Id : " + getId()
        + " | First Name : " + getFirstName()
        + " | Last Name : " + getLastName()
        + " | Account(s) : " + getAccounts ()        
        + " }";
}

}
