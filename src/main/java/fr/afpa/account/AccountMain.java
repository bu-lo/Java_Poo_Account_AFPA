package fr.afpa.account;

/**
 * Classe principale du projet, contient la fonction "main"
 */
class AccountMain
{
	public static void main(String[] args) 
	{
		System.out.println("\n----- Exercice de programmation objet - classes \"Account\" & \"Customer\" -----");

		// TODO instancier des objets de la classe "Account"

		Account account1 = new Account("FR7630001007941234567890185", 5000, -500);
		Account account2 = new Account("FR7630001007941234567890186", 1000, 0 );

		//TEST SUB AMOUNT ON ACCOUNT1
		try{
			account1.removeMoney(5000);
		} catch (Exception exceptionToProcess){
			System.out.println(exceptionToProcess.getMessage());
		}

		//TRANSFER MONEY BETWEEN ACCOUNT1 -> ACCOUNT2
		transferMoney(6000, account1, account2); 
		System.out.println("Balance account 1: " + account1.getBalance());
		System.out.println("Balance account 2: " + account2.getBalance());


		//TO STRING()
		System.out.println(account1.toString());
		System.out.println(account2.toString());





		// TODO instancier des objets de la classe "Customer"
		
		// TODO ajouter un ou plusieurs objet de "Account" à des "Customer"

		// TODO afficher les informations des employés avec System.out.println
	}
}

 