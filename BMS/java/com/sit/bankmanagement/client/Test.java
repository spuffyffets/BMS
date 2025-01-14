package com.sit.bankmanagement.client;

import com.sit.bankmanagement.serviceImpl.Sbi;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Sbi sbi = new Sbi();
		Scanner sc = new Scanner(System.in);

		boolean running = true;

		while (running) {
			System.out.println();
			System.out.println("====>Bank Management System<====");
			System.out.println("1. Create Account");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Check Balance");
			System.out.println("5. Display All Details");
			System.out.println("6. Update Account Details");
			System.out.println("7. Show Transaction History");
//			System.out.println("");
//			System.out.println("");
//			System.err.println("");
//			System.out.println("");
			System.out.println("8. Exit");

			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				sbi.createAccount();
				break;
			case 2:
				sbi.depositeMoney();
				break;
			case 3:
				sbi.withdrawal();
				break;
			case 4:
				sbi.balanceCheck();
				break;
			case 5:
				sbi.displayAllDetails();
				break;
			case 6:
				sbi.updateAccountDetails();
				break;
			case 7:
				sbi.showTransactionHistory();
				break;
			case 8:
				System.out.println("Exiting the system.");
				running = false;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");

				break;
//                    System.exit(0);
			}
		}

		sc.close();
	}
}
