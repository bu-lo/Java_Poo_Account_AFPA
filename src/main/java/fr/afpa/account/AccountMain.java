package fr.afpa.account;

/**
 * Main class project, contains the "main" function
 */
class AccountMain
{
	public static void main(String[] args) 
	{
		System.out.println("\n----- Exercice de programmation objet - classes \"Account\" & \"Customer\" -----");

		// Objects "Account" Class
		Account account1 = new Account("FR7630001007941234567890185", 5000, -500);
		Account account2 = new Account("FR7630001007941234567890185", 1000, 0 );
		Account account3 = new Account("FR7630001007941234567890185", 0, 0);
		Account account4 = new Account("FR7630001007941234567890185", 400, -200);
		Account account5 = new Account("FR7630001007941234567890185", 10000, 2000);

		//TO STRING() Accounts
		System.out.println("\n................... ACCOUNTS");
		System.out.println(account1.toString());
		System.out.println(account2.toString());
		System.out.println(account3.toString());
		System.out.println(account4.toString());
		System.out.println(account5.toString());

		System.out.println("\n------------------------------------------------------------");

		// Objects"Customer"class
		System.out.println("\n................... CUSTOMERS ");
		Customer customer1 = new Customer(1234, "Chloé", "Boivin");
		Customer customer2 = new Customer(1235, "Tess", "Boivin");
		Customer customer3 = new Customer(1236, "Ambre", "Boivin");

		//TO STRING() Customers
		System.out.println(customer1.toString());
		System.out.println(customer2.toString());
		System.out.println(customer3.toString());

		System.out.println("\n------------------------------------------------------------");

		//Adding one or more objects "Account" to "Customer"
		System.out.println("\n................... Adding accounts");
		customer1.addAccount(account1);
		customer2.addAccount(account2);
		customer3.addAccount(account3);
		customer3.addAccount(account4);
		customer3.addAccount(account5);

		System.out.println("\n------------------------------------------------------------");

		//TO STRING() Customers
		System.out.println("\n................... CUSTOMERS & ACCOUNTS");
		System.out.println("Customer 1 : " +customer1.toString());
		System.out.println("Customer 2 : " +customer2.toString());
		System.out.println("Customer 3 : " +customer3.toString());
		

		System.out.println("\n------------------------------------------------------------");
		
		//TESTS
		System.out.println("\n................... TESTS & TRANSFERS");

		//TEST SUB AMOUNT on account1
		System.out.println("\n.... TEST sub amount on Account1");
		try{
			account1.removeMoney(5000);
			System.out.println("Removing of 5000 on account1 done, overdraft authorization ok.");
		} catch (Exception exceptionToProcess){
			System.out.println(exceptionToProcess.getMessage());
		}

		//TRANSFER MONEY between account1 -> account2
		System.out.println("\n.... TEST transfer money between account1 -> account2");
		try{
			Account.transferMoney(6000, account1, account2); 
		} catch (Exception e) {
            System.out.println("ERROR: DEBTOR's balance too low..");
			for (StackTraceElement st : e.getStackTrace()){          //*** Can see where the problem is from
				System.out.println(st);                              //From wich function in the try
			}
		}

		System.out.println("Balance account 1: " + account1.getBalance());
		System.out.println("Balance account 2: " + account2.getBalance());

		//IBAN COORECT ?
		System.out.println("\n.... TEST correct IBAN ?");
		boolean isCorrectIban = Account.checkIban("FR7630001007941234567890185");
		System.out.println("FR7630001007941234567890185 : It's a " + isCorrectIban + " IBAN");

		//Removing one object "Account" 3 to "Customer" 3
		System.out.println("\n.... TEST removing account3 to customer3");
		customer3.removeAccount(account5);
		System.out.println(customer3.toString());


		System.out.println("\n------------------------------------------------------------");
		
		//CONCLUSION

		//Printing all informations with System.out.println
		System.out.println("\n................... RECAP AFTER OPERATIONS");
		System.out.println(customer1);
		System.out.println(customer2);
		System.out.println(customer3);
		System.out.println("\n------------------------------------------------------------");

	}
}

 