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

    // METHODS

    // ADDMONEY
    public int addMoney(int amount) {
        return this.balance = balance + amount;
    }

    // REMOVEMONEY
    public int removeMoney(int amount) throws Exception {
        if ((balance - amount) > overdraftAuthorization) {
            balance -= amount;
        } else {
            throw new Exception("ERROR: balance too low..");
        }
        return balance;
    }

    // TRANSFER
    public static void transferMoney(int amount, Account debtorAccount, Account creditorAccount) throws Exception {
    
            debtorAccount.removeMoney(amount);
            creditorAccount.addMoney(amount);
    
    }

    // CHECKIBAN FR
    // 1. Check the length = 27
    // 2. 2 first ch = FR ?
    // 3. 4th firth ch to the end of the string
    // 4. Letters -> Numbers
    // 5. Modulo 97

    public static boolean checkIban(String stringToCheck) {
        boolean isCorrectIban = false;

        if (stringToCheck.length() != 27) { // 1. Check the length = 27
            return false;
        }

        if (!stringToCheck.startsWith("FR")) { // 2. 2 first ch = FR ?
            return false;
        }

        String modifIban = stringToCheck.substring(4) + stringToCheck.substring(0, 4); // 3. 4th firth ch to the end of
                                                                                       // the string
        StringBuilder numIban = new StringBuilder(); // 4. Letters -> Numbers

        for (char ch : modifIban.toCharArray()) {
            if (Character.isDigit(ch)) {
                numIban.append(ch);
            } else if (Character.isLetter(ch)) {
                numIban.append(Character.getNumericValue(ch));
            } else {
                return false;
            }
        }

        String strNumIban = numIban.toString(); // 5. Modulo 97
        int mod97 = calculateMod97(strNumIban);

        if (mod97 == 1) {
            isCorrectIban = true;
        } else {
            return false;
        }

        return isCorrectIban;
    }

    // CALCULATEMOD97 // Suite 5. Modulo 97
    public static int calculateMod97(String strNumIban) {
        int len = strNumIban.length();
        int blockSize = 9;
        long total = 0;

        for (int i = 0; i < len; i += blockSize) {
            int end = Math.min(i + blockSize, len);
            String part = strNumIban.substring(i, end);
            total = Long.parseLong(total + part) % 97;
        }

        return (int) total;
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

    // TO STRING

    @Override
    public String toString() {
        return "Account {"
                + "IBAN: " + getIban()
                + " | Balance: " + getBalance()
                + " | Overdraft Authorization: " + getOverdraftAuthorization()
                + "}";
    }

}
