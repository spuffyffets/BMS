package com.sit.bankmanagement.serviceImpl;

//import com.sit.bankmanagement.model.Account;
import java.sql.*;
import com.sit.bankmanagement.serviceI.RBI;
import com.sit.bankmanagement.util.DatabaseConnection;
import com.sit.bankmanagement.util.TransactionLimits;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
//import java.util.InputMismatchException;
//import java.util.Random;
//import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sbi implements RBI {

	private Scanner sc = new Scanner(System.in);

//	private Account[] accounts = new Account[10];
	private int accountCount = 0;

	// Define regex patterns
	private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z ]+$"); // Only letters and spaces
	private static final Pattern MOBILE_PATTERN = Pattern.compile("^\\d{10}$"); // Exactly 10 digits
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$"); // Email
																														// sathi
																														// pattern
	private static final Pattern ADHAR_PATTERN = Pattern.compile("^\\d{12}$"); // 12 digits sathi
	private static final Pattern AGE_PATTERN = Pattern.compile("^[0-9]{1,2}$"); // 1 or 2 digit age
	private static final Pattern GENDER_PATTERN = Pattern.compile("^[MF]$"); // M or F
	private static final Pattern PIN_PATTERN = Pattern.compile("^\\d{4}$"); // 4-digit PIN

	// Create Account section
	@Override
	public void createAccount() {
		Connection connection = DatabaseConnection.getConnection();

		if (connection == null) {
			System.out.println("Database connection failed. Exiting...");
			return;
		}

		try {

			long accountNumber = generateAccountNumber();

			String sql = "INSERT INTO Accounts (account_number, account_type, name, mobile_number, email, aadhar_number, gender, age, balance, pin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, accountNumber);

			System.out.println("Choose account type:");
			System.out.println("1. Saving Account");
			System.out.println("2. Current Account");

			int choice = sc.nextInt();
			sc.nextLine();

			String accountType = "";
			if (choice == 1) {
				accountType = "Saving";
			} else if (choice == 2) {
				accountType = "Current";
			} else {
				System.out.println("Invalid option! Exiting...");
				return;
			}

			String name = "";
			while (true) {
				System.out.println("Enter name: ");
				name = sc.nextLine();
				if (name.matches("^[A-Za-z\\s]+$")) {
					break;
				} else {
					System.out.println("Invalid name! Name can only contain letters and spaces.");
				}
			}

			String mobileNumber = "";
			while (true) {
				System.out.println("Enter mobile number (10 digits): ");
				mobileNumber = sc.nextLine();
				if (mobileNumber.matches("\\d{10}")) {
					break;
				} else {
					System.out.println("Invalid mobile number! Please enter a 10-digit mobile number.");
				}
			}

			String email = "";
			while (true) {
				System.out.println("Enter email: ");
				email = sc.nextLine();
				if (email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
					break;
				} else {
					System.out.println("Invalid email format! Please enter a valid email.");
				}
			}

			String aadharNumber = "";
			while (true) {
				System.out.println("Enter Aadhar number (12 digits): ");
				aadharNumber = sc.nextLine();
				if (aadharNumber.matches("\\d{12}")) {
					break;
				} else {
					System.out.println("Invalid Aadhar number! Please enter a 12-digit Aadhar number.");
				}
			}

			String gender = "";
			while (true) {
				System.out.println("Enter gender (M/F): ");
				gender = sc.nextLine();
				if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F")) {
					break;
				} else {
					System.out.println("Invalid gender! Please enter M or F.");
				}
			}

			int age = 0;
			while (true) {
				System.out.println("Enter age: ");
				age = sc.nextInt();
				if (age > 0) {
					break;
				} else {
					System.out.println("Age must be a positive number! Please enter a valid age.");
				}
			}

			double balance = 0;
			while (true) {
				System.out.println("Enter initial deposit (minimum 500): ");
				balance = sc.nextDouble();
				if (balance >= 500) {
					break;
				} else {
					System.out.println("Initial deposit must be at least 500. Please enter again.");
				}
			}

			int pin = 0;
			while (true) {
				System.out.println("Set a 4-digit PIN: ");
				pin = sc.nextInt();
				if (String.valueOf(pin).length() == 4) {
					break;
				} else {
					System.out.println("PIN must be 4 digits! Please enter a 4-digit PIN.");
				}
			}

			preparedStatement.setString(2, accountType);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, mobileNumber);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, aadharNumber);
			preparedStatement.setString(7, gender);
			preparedStatement.setInt(8, age);
			preparedStatement.setDouble(9, balance);
			preparedStatement.setInt(10, pin);

			int rowsInserted = preparedStatement.executeUpdate();

			if (rowsInserted > 0) {
				System.out.println("Account created successfully! Your account number is: " + accountNumber);
			}

		} catch (SQLException e) {
			System.out.println("Error while creating account!");
			e.printStackTrace();
		}
	}

	private long generateAccountNumber() {
		long accountNumber = (long) (Math.random() * 9000000000L) + 1000000000L;

		return accountNumber;
	}

// Deposite Money Section
	@Override
	public void depositeMoney() {
		String accNoStr;
		while (true) {
			System.out.println("Enter Your Account Number:");
			accNoStr = sc.next();
			if (accNoStr.matches("^\\d+$")) {
				long accNoInput = Long.parseLong(accNoStr);
				System.out.println("Enter Your PIN:");
				String pinStr = sc.next();

				if (PIN_PATTERN.matcher(pinStr).matches()) {
					int pinInput = Integer.parseInt(pinStr);

					if (!isAccountValid(accNoInput, pinInput)) {
						System.out.println("Invalid account number or PIN.");
						return;
					}

					System.out.println("Enter Deposit Amount:");
					double depositAmount = 0;
					try {
						depositAmount = sc.nextDouble();
						if (depositAmount < 0) {
							System.out.println("Deposit amount cannot be negative.");
							return;
						}

						if (!checkDepositLimit(accNoInput, depositAmount)) {
							System.out.println(
									"Deposit exceeds daily or monthly limit./n The daily limit is  Rs. 1,00,000");
							return;
						}

						try (Connection connection = DatabaseConnection.getConnection()) {
							double newBalance = updateAccountBalanceInDatabase(connection, accNoInput, depositAmount);
							if (newBalance >= 0) {
								System.out.println("Amount Deposited Successfully...");
								System.out.println("New Balance: " + newBalance);

								logTransaction(connection, accNoInput, "Deposited: Rs. " + depositAmount);
							} else {
								System.out.println("Error updating balance.");
							}
							break;
						} catch (SQLException e) {
							System.out.println("Error while connecting to the database or processing the transaction.");
							e.printStackTrace();
						}
					} catch (InputMismatchException e) {
						System.out.println("Invalid input! Please enter numbers only.");
						sc.next();
					}
				} else {
					System.out.println("Invalid PIN! Please enter a 4-digit PIN.");
				}
			} else {
				System.out.println("Invalid account number! Please enter a valid number.");
			}
		}
	}

	private boolean checkDepositLimit(long accNo, double depositAmount) {
		double dailyDeposit = getDailyDeposit(accNo);
		double monthlyDeposit = getMonthlyDeposit(accNo);

		if ((dailyDeposit + depositAmount) > TransactionLimits.DAILY_DEPOSIT_LIMIT) {
			System.out.println("Exceeds daily deposit limit!");
			return false;
		}
		if ((monthlyDeposit + depositAmount) > TransactionLimits.MONTHLY_DEPOSIT_LIMIT) {
			System.out.println("Exceeds monthly deposit limit!");
			return false;
		}
		return true;
	}

	private double getDailyDeposit(long accNo) {
		return 0.0;
	}

	private double getMonthlyDeposit(long accNo) {
		return 0.0;
	}

	private double updateAccountBalanceInDatabase(Connection connection, long accNo, double depositAmount)
			throws SQLException {
		String selectQuery = "SELECT balance FROM Accounts WHERE account_number = ?";
		String updateQuery = "UPDATE Accounts SET balance = ? WHERE account_number = ?";
		double newBalance = -1;

		try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
			selectStatement.setLong(1, accNo);
			var resultSet = selectStatement.executeQuery();

			if (resultSet.next()) {
				double currentBalance = resultSet.getDouble("balance");
				newBalance = currentBalance + depositAmount;

				try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
					updateStatement.setDouble(1, newBalance);
					updateStatement.setLong(2, accNo);
					int rowsUpdated = updateStatement.executeUpdate();
					if (rowsUpdated > 0) {
						System.out.println("Account balance updated in database successfully.");
					}
				}
			} else {
				System.out.println("Account not found.");
			}
		}
		return newBalance;
	}

	// Withdrawal Money Section

	@Override
	public void withdrawal() {
		String accNoStr;
		while (true) {
			System.out.println("Enter Your Account Number:");
			accNoStr = sc.next();

			if (accNoStr.matches("^\\d+$")) {
				long accNoInput = Long.parseLong(accNoStr);

				System.out.println("Enter Your PIN:");
				String pinStr = sc.next();

				if (pinStr.matches("^\\d{4}$")) {
					int pinInput = Integer.parseInt(pinStr);

					try (Connection connection = DatabaseConnection.getConnection()) {
						String validateQuery = "SELECT balance, pin FROM Accounts WHERE account_number = ?";
						try (PreparedStatement validateStmt = connection.prepareStatement(validateQuery)) {
							validateStmt.setLong(1, accNoInput);
							try (ResultSet resultSet = validateStmt.executeQuery()) {
								if (resultSet.next()) {
									int dbPin = resultSet.getInt("pin");
									double currentBalance = resultSet.getDouble("balance");

									if (dbPin != pinInput) {
										System.out.println("PIN does not match. Please try again.");
										return;
									}

									System.out.println("Enter Withdrawal Amount:");
									double withdrawalAmount;
									try {
										withdrawalAmount = sc.nextDouble();

										// Check if withdrawal exceeds the limits
										if (!checkWithdrawalLimit(accNoInput, withdrawalAmount)) {
											System.out.println("Withdrawal exceeds daily or monthly limit.");
											return;
										}

										if (withdrawalAmount > currentBalance) {
											System.out.println("Insufficient Funds...");
											System.out.println("Current Balance: Rs. " + currentBalance);
										} else if (currentBalance - withdrawalAmount < 500) {
											System.out.println("Minimum balance of Rs. 500 must be maintained.");
											System.out.println("Current Balance: Rs. " + currentBalance);
										} else {
											double newBalance = currentBalance - withdrawalAmount;

											String updateQuery = "UPDATE Accounts SET balance = ? WHERE account_number = ?";
											try (PreparedStatement updateStmt = connection
													.prepareStatement(updateQuery)) {
												updateStmt.setDouble(1, newBalance);
												updateStmt.setLong(2, accNoInput);

												int rowsUpdated = updateStmt.executeUpdate();
												if (rowsUpdated > 0) {
													System.out.println("Amount Withdrawn Successfully...");
													System.out.println("New Balance: Rs. " + newBalance);

													logTransaction(connection, accNoInput,
															"Withdrawn: Rs. " + withdrawalAmount);
												} else {
													System.out.println(
															"Failed to update the account balance. Please try again.");
												}
											}
										}
										break;
									} catch (InputMismatchException e) {
										System.out.println("Invalid input! Please enter numbers only.");
										sc.next();
									}
								} else {
									System.out.println("Account does not exist.");
									return;
								}
							}
						}
					} catch (SQLException e) {
						System.out.println("Error while processing withdrawal.");
						e.printStackTrace();
					}
				} else {
					System.out.println("Invalid PIN! Please enter a 4-digit PIN.");
				}
			} else {
				System.out.println("Invalid account number! Please enter a valid number.");
			}
		}
	}

	private boolean checkWithdrawalLimit(long accNo, double withdrawalAmount) {
		double dailyWithdrawal = getDailyWithdrawal(accNo);
		double monthlyWithdrawal = getMonthlyWithdrawal(accNo);

		if ((dailyWithdrawal + withdrawalAmount) > TransactionLimits.DAILY_WITHDRAWAL_LIMIT) {
			System.out.println("Exceeds daily withdrawal limit!");
			return false;
		}
		if ((monthlyWithdrawal + withdrawalAmount) > TransactionLimits.MONTHLY_WITHDRAWAL_LIMIT) {
			System.out.println("Exceeds monthly withdrawal limit!");
			return false;
		}
		return true;
	}

	private double getDailyWithdrawal(long accNo) {

		return 0.0;
	}

	private double getMonthlyWithdrawal(long accNo) {

		return 0.0;
	}

	private void logTransaction(Connection connection, long accNo, String transactionDetail) {
		String logQuery = "INSERT INTO Transactions (account_number, transaction_detail, transaction_date) VALUES (?, ?, NOW())";
		try (PreparedStatement logStmt = connection.prepareStatement(logQuery)) {
			logStmt.setLong(1, accNo);
			logStmt.setString(2, transactionDetail);
			logStmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error logging the transaction.");
			e.printStackTrace();
		}
	}

	// Check Balance Check

	@Override
	public void balanceCheck() {
		String accNoStr;
		while (true) {
			System.out.println("Enter Your Account Number:");
			accNoStr = sc.next();

			if (accNoStr.matches("^\\d+$")) {
				long accNoInput = Long.parseLong(accNoStr);

				System.out.println("Enter Your PIN:");
				String pinStr = sc.next();

				if (pinStr.matches("^\\d{4}$")) {
					int pinInput = Integer.parseInt(pinStr);

					try (Connection connection = DatabaseConnection.getConnection()) {
						String validateQuery = "SELECT balance, pin FROM Accounts WHERE account_number = ?";
						try (PreparedStatement validateStmt = connection.prepareStatement(validateQuery)) {
							validateStmt.setLong(1, accNoInput);
							try (ResultSet resultSet = validateStmt.executeQuery()) {
								if (resultSet.next()) {
									int dbPin = resultSet.getInt("pin");
									double currentBalance = resultSet.getDouble("balance");

									if (dbPin != pinInput) {
										System.out.println("PIN does not match. Please try again.");
										return;
									}

									System.out.println("Your Balance is: Rs. " + currentBalance);
								} else {
									System.out.println("Account does not exist.");
								}
							}
						}
					} catch (SQLException e) {
						System.out.println("Error while checking balance.");
						e.printStackTrace();
					}
					break;
				} else {
					System.out.println("Invalid PIN! Please enter a 4-digit PIN.");
				}
			} else {
				System.out.println("Invalid account number! Please enter a valid number.");
			}
		}
	}

	// Display All Details
	@Override
	public void displayAllDetails() {
		String accNoStr;
		while (true) {
			System.out.println("Enter Your Account Number:");
			accNoStr = sc.next();

			if (accNoStr.matches("^\\d+$")) {
				long accNoInput = Long.parseLong(accNoStr);

				System.out.println("Enter Your PIN:");
				String pinStr = sc.next();

				if (pinStr.matches("^\\d{4}$")) {
					int pinInput = Integer.parseInt(pinStr);

					try (Connection connection = DatabaseConnection.getConnection()) {
						// Validate account and PIN
						String validateQuery = "SELECT * FROM Accounts WHERE account_number = ?";
						try (PreparedStatement validateStmt = connection.prepareStatement(validateQuery)) {
							validateStmt.setLong(1, accNoInput);
							try (ResultSet resultSet = validateStmt.executeQuery()) {
								if (resultSet.next()) {
									int dbPin = resultSet.getInt("pin");

									if (dbPin != pinInput) {
										System.out.println("PIN does not match. Please try again.");
										return;
									}

									System.out.println("Account Details:");
									System.out.println("Account Number: " + resultSet.getLong("account_number"));
									System.out.println("Account Type: " + resultSet.getString("account_type"));
									System.out.println("Name: " + resultSet.getString("name"));
									System.out.println("Mobile Number: " + resultSet.getLong("mobile_number"));
									System.out.println("Email: " + resultSet.getString("email"));
									System.out.println("Aadhar Number: " + resultSet.getLong("aadhar_number"));
									System.out.println("Gender: " + resultSet.getString("gender"));
									System.out.println("Age: " + resultSet.getInt("age"));
									System.out.println("Balance: Rs. " + resultSet.getDouble("balance"));
								} else {
									System.out.println("Account does not exist.");
									System.out.println("Do you want to create a new account? (yes/no)");
									sc.nextLine();
									String response = sc.nextLine();
									if (response.equalsIgnoreCase("yes")) {
										createAccount();
									} else {
										System.out.println("Exiting...");
									}
								}
							}
						}
					} catch (SQLException e) {
						System.out.println("Error while fetching account details.");
						e.printStackTrace();
					}
					break;
				} else {
					System.out.println("Invalid PIN! Please enter a 4-digit PIN.");
				}
			} else {
				System.out.println("Invalid account number! Please enter a valid number.");
			}
		}
	}

	// showTransactionHistory section
	@Override
	public void showTransactionHistory() {
		String accNoStr;
		while (true) {
			System.out.println("Enter Your Account Number:");
			accNoStr = sc.next();

			if (accNoStr.matches("^\\d+$")) {
				long accNoInput = Long.parseLong(accNoStr);

				System.out.println("Enter Your PIN:");
				String pinStr = sc.next();

				if (pinStr.matches("^\\d{4}$")) {
					int pinInput = Integer.parseInt(pinStr);

					try (Connection connection = DatabaseConnection.getConnection()) {

						String validateQuery = "SELECT pin FROM Accounts WHERE account_number = ?";
						try (PreparedStatement validateStmt = connection.prepareStatement(validateQuery)) {
							validateStmt.setLong(1, accNoInput);
							try (ResultSet resultSet = validateStmt.executeQuery()) {
								if (resultSet.next()) {
									int dbPin = resultSet.getInt("pin");

									if (dbPin != pinInput) {
										System.out.println("PIN does not match. Please try again.");
										return;
									}

									String transactionQuery = "SELECT transaction_detail FROM Transactions WHERE account_number = ? ORDER BY transaction_date DESC";
									try (PreparedStatement transactionStmt = connection
											.prepareStatement(transactionQuery)) {
										transactionStmt.setLong(1, accNoInput);
										try (ResultSet transactionResult = transactionStmt.executeQuery()) {
											System.out.println("Transaction History For account no :" + accNoInput);
											System.out.println("------------------------------------------------");
											while (transactionResult.next()) {
												String transaction = transactionResult.getString("transaction_detail");
												// System.out.println("------------------------------------------------");
												System.out.println(transaction);

											}

										}
									}
								} else {
									System.out.println("Account does not exist.");
									return;
								}
							}
						}
					} catch (SQLException e) {
						System.out.println("Error while fetching transaction history.");
						e.printStackTrace();
					}
					break;
				} else {
					System.out.println("Invalid PIN! Please enter a 4-digit PIN.");
				}
			} else {
				System.out.println("Invalid account number! Please enter a valid number.");
			}
		}
	}

//updateAccountDetails Section
	@Override
	public void updateAccountDetails() {
		String accNoStr;
		while (true) {
			System.out.println("Enter Your Account Number:");
			accNoStr = sc.next();

			if (accNoStr.matches("^\\d+$")) {
				long accNoInput = Long.parseLong(accNoStr);

				System.out.println("Enter Your PIN:");
				String pinStr = sc.next();

				if (pinStr.matches("^\\d{4}$")) {
					int pinInput = Integer.parseInt(pinStr);

					try (Connection connection = DatabaseConnection.getConnection()) {
						String validateQuery = "SELECT pin FROM Accounts WHERE account_number = ?";
						try (PreparedStatement validateStmt = connection.prepareStatement(validateQuery)) {
							validateStmt.setLong(1, accNoInput);
							try (ResultSet resultSet = validateStmt.executeQuery()) {
								if (resultSet.next()) {
									int dbPin = resultSet.getInt("pin");

									if (dbPin != pinInput) {
										System.out.println("PIN does not match. Please try again.");
										return;
									}

									System.out.println("Select detail to update:");
									System.out.println("1. Name");
									System.out.println("2. Mobile Number");
									System.out.println("3. Email");
									System.out.println("4. Aadhar Number");
									System.out.println("5. Age");
									System.out.println("6. Gender");
									int choice = sc.nextInt();
									sc.nextLine();

									switch (choice) {
									case 1:
										System.out.println("Enter New Name:");
										String newName = sc.nextLine();
										if (NAME_PATTERN.matcher(newName).matches()) {
											String updateNameQuery = "UPDATE Accounts SET name = ? WHERE account_number = ?";
											try (PreparedStatement updateStmt = connection
													.prepareStatement(updateNameQuery)) {
												updateStmt.setString(1, newName);
												updateStmt.setLong(2, accNoInput);
												int rowsUpdated = updateStmt.executeUpdate();
												if (rowsUpdated > 0) {
													System.out.println("Name updated successfully.");
												} else {
													System.out.println("Failed to update Name.");
												}
											}
										} else {
											System.out.println("Invalid name! Please use only letters and spaces.");
										}
										break;
									case 2:
										System.out.println("Enter New Mobile Number:");
										String newMobNoStr = sc.nextLine();
										if (MOBILE_PATTERN.matcher(newMobNoStr).matches()) {
											String updateMobileQuery = "UPDATE Accounts SET mobile_number = ? WHERE account_number = ?";
											try (PreparedStatement updateStmt = connection
													.prepareStatement(updateMobileQuery)) {
												updateStmt.setLong(1, Long.parseLong(newMobNoStr));
												updateStmt.setLong(2, accNoInput);
												int rowsUpdated = updateStmt.executeUpdate();
												if (rowsUpdated > 0) {
													System.out.println("Mobile Number updated successfully.");
												} else {
													System.out.println("Failed to update Mobile Number.");
												}
											}
										} else {
											System.out
													.println("Invalid mobile number! Please enter a 10-digit number.");
										}
										break;
									case 3:
										System.out.println("Enter New Email:");
										String newEmail = sc.nextLine();
										if (EMAIL_PATTERN.matcher(newEmail).matches()) {
											String updateEmailQuery = "UPDATE Accounts SET email = ? WHERE account_number = ?";
											try (PreparedStatement updateStmt = connection
													.prepareStatement(updateEmailQuery)) {
												updateStmt.setString(1, newEmail);
												updateStmt.setLong(2, accNoInput);
												int rowsUpdated = updateStmt.executeUpdate();
												if (rowsUpdated > 0) {
													System.out.println("Email updated successfully.");
												} else {
													System.out.println("Failed to update Email.");
												}
											}
										} else {
											System.out.println("Invalid email format!");
										}
										break;
									case 4:
										System.out.println("Enter New Aadhar Number:");
										String newAdharNoStr = sc.nextLine();
										if (ADHAR_PATTERN.matcher(newAdharNoStr).matches()) {
											String updateAdharQuery = "UPDATE Accounts SET aadhar_number = ? WHERE account_number = ?";
											try (PreparedStatement updateStmt = connection
													.prepareStatement(updateAdharQuery)) {
												updateStmt.setLong(1, Long.parseLong(newAdharNoStr));
												updateStmt.setLong(2, accNoInput);
												int rowsUpdated = updateStmt.executeUpdate();
												if (rowsUpdated > 0) {
													System.out.println("Aadhar Number updated successfully.");
												} else {
													System.out.println("Failed to update Aadhar Number.");
												}
											}
										} else {
											System.out
													.println("Invalid Aadhar number! Please enter a 12-digit number.");
										}
										break;
									case 5:
										System.out.println("Enter New Age:");
										String newAgeStr = sc.nextLine();
										if (AGE_PATTERN.matcher(newAgeStr).matches()
												&& Integer.parseInt(newAgeStr) > 0) {
											String updateAgeQuery = "UPDATE Accounts SET age = ? WHERE account_number = ?";
											try (PreparedStatement updateStmt = connection
													.prepareStatement(updateAgeQuery)) {
												updateStmt.setInt(1, Integer.parseInt(newAgeStr));
												updateStmt.setLong(2, accNoInput);
												int rowsUpdated = updateStmt.executeUpdate();
												if (rowsUpdated > 0) {
													System.out.println("Age updated successfully.");
												} else {
													System.out.println("Failed to update Age.");
												}
											}
										} else {
											System.out.println(
													"Invalid age! Please enter a positive number up to 2 digits.");
										}
										break;
									case 6:
										System.out.println("Enter New Gender (M/F):");
										String newGender = sc.nextLine();
										if (GENDER_PATTERN.matcher(newGender).matches()) {
											String updateGenderQuery = "UPDATE Accounts SET gender = ? WHERE account_number = ?";
											try (PreparedStatement updateStmt = connection
													.prepareStatement(updateGenderQuery)) {
												updateStmt.setString(1, newGender);
												updateStmt.setLong(2, accNoInput);
												int rowsUpdated = updateStmt.executeUpdate();
												if (rowsUpdated > 0) {
													System.out.println("Gender updated successfully.");
												} else {
													System.out.println("Failed to update Gender.");
												}
											}
										} else {
											System.out.println("Invalid gender! Please enter M or F.");
										}
										break;
									default:
										System.out.println("Invalid choice.");
										break;
									}
									break;
								} else {
									System.out.println("Account does not exist or PIN is incorrect.");
								}
							}
						}
					} catch (SQLException e) {
						System.out.println("Error updating account details.");
						e.printStackTrace();
					}
				} else {
					System.out.println("Invalid PIN! Please enter a 4-digit PIN.");
				}
			} else {
				System.out.println("Invalid account number! Please enter a valid number.");
			}
		}
	}

	// isAccountValid Section
	@Override
	public boolean isAccountValid(long accNo, int pin) {
		String query = "SELECT * FROM Accounts WHERE account_number = ? AND pin = ?";
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setLong(1, accNo);
			preparedStatement.setInt(2, pin);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				return resultSet.next();
			}
		} catch (SQLException e) {
			System.out.println("Error while validating account or PIN.");
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	 public void Dstatement() {
		
		
	}

	@Override
	public void getLoan() {

	}

	@Override
	public void largeAmountaccNo() {

	}

	@Override
	public void viewsallaccNo() {
	}

	// findAccount Section
//	private Account findAccount(long accNo) {
//		for (int i = 0; i < accountCount; i++) {
//			if (accounts[i].getAccNo() == accNo) {
//				return accounts[i];
//			}
//		}
//		return null;
//	}

}
