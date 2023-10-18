import java.util.*;

public class ATM {
	//--- Instance Variables
	Account myAccount;
	Scanner scan;
	
	//--- Constructors
	public ATM() {
		myAccount = new Account(500.00, 2000.00);
		scan = new Scanner(System.in);
		verification();
	}
	
	//--- Methods
	public void verification() {
		System.out.println("===================");
		System.out.println("        ATM");
		System.out.println("===================");
		System.out.println();
		
		int input = 0;
		while(input != myAccount.getPassword()) {
			System.out.print("Enter Password: ");
			input = scan.nextInt();
			if(input != myAccount.getPassword())
				System.out.println("Password is incorrect, try again.\n");
		}
		System.out.println();
		mainMenu();
	}
	
	public void mainMenu() {
		int menu = 0;
		do {
			System.out.println("===================");
			System.out.println("     MAIN MENU");
			System.out.println("===================");
			System.out.println();
			System.out.println(myAccount.toString());
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Transfer");
			System.out.println("4. Exit");
			System.out.println();

			while (menu == 0) {
				System.out.print("--> ");
				menu = scan.nextInt();
				System.out.println();
				if (menu == 1)
					deposit();
				else if (menu == 2)
					withdraw();
				else if (menu == 3)
					transfer();
				else if (menu != 4) {
					System.out.println("ERROR: PLEASE ENTER VALID SELECTION\n");
					menu = 0;
				}
			}
			if(menu != 4)
				menu = 0;
		} while (menu != 4);
		System.out.print("System Exited. Have a Nice Day");
	}
	
	public void deposit() {
		int depositAcc = 0;
		double deposit = -1;
		System.out.println("===================");
		System.out.println("      DEPOSIT");
		System.out.println("===================");
		System.out.println();
		System.out.println("1. Checking");
		System.out.println("2. Savings");
		System.out.println();
		
		while(depositAcc != 1 && depositAcc != 2) {
		System.out.print("--> ");
		depositAcc = scan.nextInt();
		
		if(depositAcc != 1 && depositAcc != 2)
			System.out.println("\nERROR: PLEASE ENTER VALID SELECTION\n");
		}
		
		while(deposit < 0) {
		System.out.print("\nAmount: ");
		deposit = scan.nextDouble();
		if(deposit < 0)
			System.out.print("\nERROR: PLEASE ENTER POSITIVE VALUE\n");
		deposit = (double)(int)(deposit * 100) / 100;
		}
		
		if(depositAcc == 1)
			myAccount.increaseChecking(deposit);
		else if(depositAcc == 2)
			myAccount.increaseSavings(deposit);
		System.out.println();
	}
	
	public void withdraw() {
		int withdrawAcc = 0;
		double withdraw = -1;
		System.out.println("===================");
		System.out.println("      WITHDRAW");
		System.out.println("===================");
		System.out.println();
		System.out.println("1. Checking");
		System.out.println("2. Savings");
		System.out.println();
		
		while(withdrawAcc != 1 && withdrawAcc != 2) {
		System.out.print("--> ");
		withdrawAcc = scan.nextInt();
		
		if(withdrawAcc != 1 && withdrawAcc != 2)
			System.out.println("\nERROR: PLEASE ENTER VALID SELECTION\n");
		}
		
		while(withdraw < 0) {
		System.out.print("\nAmount: ");
		withdraw = scan.nextDouble();
		if(withdraw < 0)
			System.out.print("\nERROR: PLEASE ENTER POSITIVE VALUE\n");
		withdraw = (double)(int)(withdraw * 100) / 100;
		}
		
		if(withdrawAcc == 1)
			myAccount.decreaseChecking(withdraw);
		else if(withdrawAcc == 2)
			myAccount.decreaseSavings(withdraw);
		System.out.println();
	}
	
	public void transfer() {
		int transferAcc = 0;
		double transfer = -1;
		System.out.println("===================");
		System.out.println("      TRANSFER");
		System.out.println("===================");
		System.out.println();
		System.out.println("1. From Checking to Savings");
		System.out.println("2. From Savings to Checking");
		System.out.println();
		
		while(transferAcc != 1 && transferAcc != 2) {
		System.out.print("--> ");
		transferAcc = scan.nextInt();
		
		if(transferAcc != 1 && transferAcc != 2)
			System.out.println("\nERROR: PLEASE ENTER VALID SELECTION\n");
		}
		
		while(transfer < 0) {
			System.out.print("\nAmount: ");
			transfer = scan.nextDouble();
			if(transfer < 0)
				System.out.print("\nERROR: PLEASE ENTER POSITIVE VALUE\n");
			transfer = (double)(int)(transfer * 100) / 100;
			}
			
			if(transferAcc == 1)
				myAccount.transferToSavings(transfer);
			else if(transferAcc == 2)
				myAccount.transferToChecking(transfer);
			System.out.println();
	}
}