import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.io.BufferedWriter;
import java.io.BufferedReader;
public class source {
	public static void main(String[] args) throws SQLException {
		System.out.println("WELCOME TO THE JOB-SHOP ACCOUNTING DATABASE SYSTEM");
		// Connect to database
		final String hostName = "mans8927-sql-server.database.windows.net";
		final String dbName = "Job-Shop-Accounting-Database-System";
		final String user = "mans8927";
		final String password = "ClaEli2718";
		final String url =
				String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host NameInCertificate=*.database.windows.net;loginTimeout=30;",hostName, dbName, user, password);
		try (final Connection connection = DriverManager.getConnection(url)) {
			final String schema = connection.getSchema();
			Scanner scanner = new Scanner(System.in);
			System.out.print("(1) ADD A CUSTOMER"
					+ "\n (2) ADD A DEPARTMENT"
					+ "\n (3) ORDER AN ASSEMBLY"
					+ "\n (4) CREATE A PROCESS"
					+ "\n (5) CREATE AN ACCOUNT"
					+ "\n (6) START A JOB"
					+ "\n (7) COMPLETE A JOB"
					+ "\n (8) ADD A TRANSACTION"
					+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
					+ "\n (10) RETRIEVE TOTAL LABOR"
					+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
					+ "\n (12) RETRIEVE JOBS"
					+ "\n (13) RETRIEVE CUSTOMERS"
					+ "\n (14) DELETE CUT-JOB"
					+ "\n (15) CHANGE PAINT COLOR"
					+ "\n (16) INPORT"
					+ "\n (17) EXPORT"
					+ "\n (18) QUIT");
			int input = scanner.nextInt();
			String insertSql;
			//begins the loop for user input of cases
			while(input != 18) {
				switch(input) {
				//Takes input from user and inserts into table 
				case 1:
					System.out.print("Enter name: ");
					String name = scanner.next();
					System.out.print("Enter address: ");
					String address = scanner.next();
					System.out.print("Enter category");
					int category = scanner.nextInt();
					insertSql = "INSERT INTO Customer (CustomerName, CustomerAddress, Category) "
							+ "VALUES ('" + name + "', '" + address + "', '" + category + "')";
					try {
						final Statement statement = connection.createStatement();
						statement.executeUpdate(insertSql);
						System.out.print("(1) ADD A CUSTOMER"
								+ "\n (2) ADD A DEPARTMENT"
								+ "\n (3) ORDER AN ASSEMBLY"
								+ "\n (4) CREATE A PROCESS"
								+ "\n (5) CREATE AN ACCOUNT"
								+ "\n (6) START A JOB"
								+ "\n (7) COMPLETE A JOB"
								+ "\n (8) ADD A TRANSACTION"
								+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
								+ "\n (10) RETRIEVE TOTAL LABOR"
								+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
								+ "\n (12) RETRIEVE JOBS"
								+ "\n (13) RETRIEVE CUSTOMERS"
								+ "\n (14) DELETE CUT-JOB"
								+ "\n (15) CHANGE PAINT COLOR"
								+ "\n (16) INPORT"
								+ "\n (17) EXPORT"
								+ "\n (18) QUIT");
						input = scanner.nextInt();
						break;
					}
					catch (Exception e) {
						System.out.print(e.getMessage());
					}
				//Takes input from user and inserts into table 
				case 2:
					System.out.print("Enter department number: ");
					int departmentNumber = scanner.nextInt();
					System.out.print("Enter department data: ");
					String departmentData = scanner.next();
					insertSql = "INSERT INTO Department (DepartmentNumber, DepartmentData) "
							+ "VALUES ('" + departmentNumber + "', '" + departmentData + "')";
					try {
						final Statement statement = connection.createStatement();
						statement.executeUpdate(insertSql);
						System.out.print("(1) ADD A CUSTOMER"
								+ "\n (2) ADD A DEPARTMENT"
								+ "\n (3) ORDER AN ASSEMBLY"
								+ "\n (4) CREATE A PROCESS"
								+ "\n (5) CREATE AN ACCOUNT"
								+ "\n (6) START A JOB"
								+ "\n (7) COMPLETE A JOB"
								+ "\n (8) ADD A TRANSACTION"
								+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
								+ "\n (10) RETRIEVE TOTAL LABOR"
								+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
								+ "\n (12) RETRIEVE JOBS"
								+ "\n (13) RETRIEVE CUSTOMERS"
								+ "\n (14) DELETE CUT-JOB"
								+ "\n (15) CHANGE PAINT COLOR"
								+ "\n (16) INPORT"
								+ "\n (17) EXPORT"
								+ "\n (18) QUIT");
						input = scanner.nextInt();
						break;
					}
					catch(Exception e) {
						System.out.print(e.getMessage());
					}
				//Takes input from user and inserts into table 
				case 3:
					System.out.print("Enter Customer name: ");
					name = scanner.next();
					System.out.print("Enter assembly details: ");
					String assemblyDetails = scanner.next();
					System.out.print("Enter assembly ID: ");
					int assemblyID = scanner.nextInt();
					System.out.print("Enter Date Ordered");
					String dateOrdered = scanner.next();
					insertSql = "INSERT INTO Assembly (AssemblyID, DateOrdered, AssemblyDetails, CustomerName) "
							+ "VALUES ('" + assemblyID + "', '" + dateOrdered + "', '" + assemblyDetails + "', '" + name + "')";
					try {
						final Statement statement = connection.createStatement();
						statement.executeUpdate(insertSql);
						System.out.print("(1) ADD A CUSTOMER"
								+ "\n (2) ADD A DEPARTMENT"
								+ "\n (3) ORDER AN ASSEMBLY"
								+ "\n (4) CREATE A PROCESS"
								+ "\n (5) CREATE AN ACCOUNT"
								+ "\n (6) START A JOB"
								+ "\n (7) COMPLETE A JOB"
								+ "\n (8) ADD A TRANSACTION"
								+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
								+ "\n (10) RETRIEVE TOTAL LABOR"
								+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
								+ "\n (12) RETRIEVE JOBS"
								+ "\n (13) RETRIEVE CUSTOMERS"
								+ "\n (14) DELETE CUT-JOB"
								+ "\n (15) CHANGE PAINT COLOR"
								+ "\n (16) INPORT"
								+ "\n (17) EXPORT"
								+ "\n (18) QUIT");
						input = scanner.nextInt();
						break;
					}
					catch(Exception e) {
						System.out.print(e.getMessage());
					}
				//Takes input from user and inserts into table 
				case 4:
					System.out.print("Enter a process ID: ");
					int processID = scanner.nextInt();
					System.out.print("Enter a department number: ");
					int department = scanner.nextInt();
					System.out.print("Enter process type. Fit, Paint, or Cut : ");
					String type = scanner.next();
					//checks if input is paint
					if(type.equalsIgnoreCase("Paint")) {
						System.out.print("Enter paint color: ");
						String paintColor = scanner.next();
						System.out.print("Enter painting method: ");
						String paintMethod = scanner.next();
						insertSql = "INSERT INTO Process (ProcessID, DepartmentNumber) "
								+ "VALUES ('" + processID + "', '" + department + "')";
						String insertSql2 = "INSERT INTO Paint (PaintType, PaintingMethod, ProcessID) "
								+ "VALUES ('" + paintColor + "', '" + paintMethod + "', '" + processID + "')";
						
						try {
							final Statement statement = connection.createStatement();
							statement.executeUpdate(insertSql);
							statement.executeUpdate(insertSql2);
							System.out.print("(1) ADD A CUSTOMER"
									+ "\n (2) ADD A DEPARTMENT"
									+ "\n (3) ORDER AN ASSEMBLY"
									+ "\n (4) CREATE A PROCESS"
									+ "\n (5) CREATE AN ACCOUNT"
									+ "\n (6) START A JOB"
									+ "\n (7) COMPLETE A JOB"
									+ "\n (8) ADD A TRANSACTION"
									+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
									+ "\n (10) RETRIEVE TOTAL LABOR"
									+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
									+ "\n (12) RETRIEVE JOBS"
									+ "\n (13) RETRIEVE CUSTOMERS"
									+ "\n (14) DELETE CUT-JOB"
									+ "\n (15) CHANGE PAINT COLOR"
									+ "\n (16) INPORT"
									+ "\n (17) EXPORT"
									+ "\n (18) QUIT");
							input = scanner.nextInt();
							break;
						}
						catch(Exception e) {
							System.out.print(e.getMessage());
						}
					}
					//checks if input is cut
					else if(type.equalsIgnoreCase("Cut")) {
						System.out.print("Enter cutting type: ");
						String cutType = scanner.next();
						System.out.print("Enter machine type: ");
						String machineType = scanner.next();
						insertSql = "INSERT INTO Process (ProcessID, DepartmentNumber) "
								+ "VALUES ('" + processID + "', '" + department + "')";
						String insertSql2 = "INSERT INTO Cut (CuttingType, MachineType, ProcessID) "
								+ "VALUES ('" + cutType + "', '" + machineType + "', '" + processID + "')"; 
						try {
							final Statement statement = connection.createStatement();
							statement.executeUpdate(insertSql);
							statement.executeUpdate(insertSql2);
							System.out.print("(1) ADD A CUSTOMER"
									+ "\n (2) ADD A DEPARTMENT"
									+ "\n (3) ORDER AN ASSEMBLY"
									+ "\n (4) CREATE A PROCESS"
									+ "\n (5) CREATE AN ACCOUNT"
									+ "\n (6) START A JOB"
									+ "\n (7) COMPLETE A JOB"
									+ "\n (8) ADD A TRANSACTION"
									+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
									+ "\n (10) RETRIEVE TOTAL LABOR"
									+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
									+ "\n (12) RETRIEVE JOBS"
									+ "\n (13) RETRIEVE CUSTOMERS"
									+ "\n (14) DELETE CUT-JOB"
									+ "\n (15) CHANGE PAINT COLOR"
									+ "\n (16) INPORT"
									+ "\n (17) EXPORT"
									+ "\n (18) QUIT");
							input = scanner.nextInt();
							break;
						}
						catch(Exception e) {
							System.out.print(e.getMessage());
						}
					}
					//assumes input is fit
					else {
						System.out.print("Enter fit type: ");
						String fitType = scanner.next();
						insertSql = "INSERT INTO Process (ProcessID, DepartmentNumber) "
								+ "VALUES ('" + processID + "', '" + department + "')";
						String insertSql2 = "INSERT INTO Fit (FitType, ProcessID) "
								+ "VALUES ('" + fitType + "', '" + processID + "')"; 
						try {
							final Statement statement = connection.createStatement();
							statement.executeUpdate(insertSql);
							statement.executeUpdate(insertSql2);
							System.out.print("(1) ADD A CUSTOMER"
									+ "\n (2) ADD A DEPARTMENT"
									+ "\n (3) ORDER AN ASSEMBLY"
									+ "\n (4) CREATE A PROCESS"
									+ "\n (5) CREATE AN ACCOUNT"
									+ "\n (6) START A JOB"
									+ "\n (7) COMPLETE A JOB"
									+ "\n (8) ADD A TRANSACTION"
									+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
									+ "\n (10) RETRIEVE TOTAL LABOR"
									+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
									+ "\n (12) RETRIEVE JOBS"
									+ "\n (13) RETRIEVE CUSTOMERS"
									+ "\n (14) DELETE CUT-JOB"
									+ "\n (15) CHANGE PAINT COLOR"
									+ "\n (16) INPORT"
									+ "\n (17) EXPORT"
									+ "\n (18) QUIT");
							input = scanner.nextInt();
							break;
						}
						catch(Exception e) {
							System.out.print(e.getMessage());
						}
					}
				//Takes input from user and inserts into table 
				case 5:
					System.out.print("Enter account number: ");
					int accountNumber = scanner.nextInt();
					System.out.print("Enter established date: ");
					String date = scanner.next();
					System.out.print("Enter which type of account. Assembly, Department, or Process: ");
					String account = scanner.next();
					//checks input
					if(account.equalsIgnoreCase("Assembly")) {
						System.out.print("Enter assembly ID: ");
						int assembleID = scanner.nextInt();
						System.out.print("Enter cost: $");
						double cost = scanner.nextDouble();
						insertSql = "IF NOT EXISTS (SELECT AccountNumber FROM Account WHERE AccountNumber = " + accountNumber + ") BEGIN "
								+ "INSERT INTO Account (AccountNumber, EstablishDate) "+ 
								"VALUES ('" + accountNumber + "', '" + date + "') END";
						String insertSql2 = "INSERT INTO AssemblyAccount (Costs, AccountNumber, AssemblyID) "
								+ "VALUES ('" + cost + "', '" + accountNumber + "', '" + assembleID  + "')"; 
						try {
							final Statement statement = connection.createStatement();
							statement.executeUpdate(insertSql);
							statement.executeUpdate(insertSql2);
							System.out.print("(1) ADD A CUSTOMER"
									+ "\n (2) ADD A DEPARTMENT"
									+ "\n (3) ORDER AN ASSEMBLY"
									+ "\n (4) CREATE A PROCESS"
									+ "\n (5) CREATE AN ACCOUNT"
									+ "\n (6) START A JOB"
									+ "\n (7) COMPLETE A JOB"
									+ "\n (8) ADD A TRANSACTION"
									+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
									+ "\n (10) RETRIEVE TOTAL LABOR"
									+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
									+ "\n (12) RETRIEVE JOBS"
									+ "\n (13) RETRIEVE CUSTOMERS"
									+ "\n (14) DELETE CUT-JOB"
									+ "\n (15) CHANGE PAINT COLOR"
									+ "\n (16) INPORT"
									+ "\n (17) EXPORT"
									+ "\n (18) QUIT");
							input = scanner.nextInt();
							break;
						}
						catch(Exception e) {
							System.out.print(e.getMessage());
						}
					}
					//checks input
					else if(account.equalsIgnoreCase("Department")) {
						System.out.print("Enter department number: ");
						int deptNum = scanner.nextInt();
						System.out.print("Enter cost: $");
						double cost = scanner.nextDouble();
						insertSql = "IF NOT EXISTS (SELECT AccountNumber FROM Account WHERE AccountNumber = " + accountNumber + ") BEGIN "
								+ "INSERT INTO Account (AccountNumber, EstablishDate) "+ 
								"VALUES ('" + accountNumber + "', '" + date + "') END";
						String insertSql2 = "INSERT INTO DepartmentAccount (Costs, AccountNumber, DepartmentNumber) "
								+ "VALUES ('" + cost + "', '" + accountNumber + "', '" + deptNum  + "')"; 
						try {
							final Statement statement = connection.createStatement();
							statement.executeUpdate(insertSql);
							statement.executeUpdate(insertSql2);
							System.out.print("(1) ADD A CUSTOMER"
									+ "\n (2) ADD A DEPARTMENT"
									+ "\n (3) ORDER AN ASSEMBLY"
									+ "\n (4) CREATE A PROCESS"
									+ "\n (5) CREATE AN ACCOUNT"
									+ "\n (6) START A JOB"
									+ "\n (7) COMPLETE A JOB"
									+ "\n (8) ADD A TRANSACTION"
									+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
									+ "\n (10) RETRIEVE TOTAL LABOR"
									+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
									+ "\n (12) RETRIEVE JOBS"
									+ "\n (13) RETRIEVE CUSTOMERS"
									+ "\n (14) DELETE CUT-JOB"
									+ "\n (15) CHANGE PAINT COLOR"
									+ "\n (16) INPORT"
									+ "\n (17) EXPORT"
									+ "\n (18) QUIT");
							input = scanner.nextInt();
							break;
						}
						catch(Exception e) {
							System.out.print(e.getMessage());
						}
					}
					//assumes input
					else {
						System.out.print("Enter process ID: ");
						int procID = scanner.nextInt();
						System.out.print("Enter cost: $");
						double cost = scanner.nextDouble();
						insertSql = "IF NOT EXISTS (SELECT AccountNumber FROM Account WHERE AccountNumber = " + accountNumber + ") BEGIN "
								+ "INSERT INTO Account (AccountNumber, EstablishDate) "+ 
								"VALUES ('" + accountNumber + "', '" + date + "') END";
						String insertSql2 = "INSERT INTO ProcessAccount (Costs, AccountNumber, ProcessID) "
								+ "VALUES ('" + cost + "', '" + accountNumber + "', '" + procID + "')"; 
						try {
							final Statement statement = connection.createStatement();
							statement.executeUpdate(insertSql);
							statement.executeUpdate(insertSql2);
							System.out.print("(1) ADD A CUSTOMER"
									+ "\n (2) ADD A DEPARTMENT"
									+ "\n (3) ORDER AN ASSEMBLY"
									+ "\n (4) CREATE A PROCESS"
									+ "\n (5) CREATE AN ACCOUNT"
									+ "\n (6) START A JOB"
									+ "\n (7) COMPLETE A JOB"
									+ "\n (8) ADD A TRANSACTION"
									+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
									+ "\n (10) RETRIEVE TOTAL LABOR"
									+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
									+ "\n (12) RETRIEVE JOBS"
									+ "\n (13) RETRIEVE CUSTOMERS"
									+ "\n (14) DELETE CUT-JOB"
									+ "\n (15) CHANGE PAINT COLOR"
									+ "\n (16) INPORT"
									+ "\n (17) EXPORT"
									+ "\n (18) QUIT");
							input = scanner.nextInt();
							break;
						}
						catch(Exception e) {
							System.out.print(e.getMessage());
						}
					}
				//Takes input from user and inserts into table 
				case 6:
					System.out.print("Enter a job number: ");
					int jobNumber = scanner.nextInt();
					System.out.print("Enter assembly ID: ");
				    assemblyID = scanner.nextInt();
				    System.out.print("Enter process ID: ");
				    processID = scanner.nextInt();
				    System.out.print("Enter start date of job: ");
				    date = scanner.next();
				    insertSql = "INSERT INTO Job (JobNumber, ProcessID, AssemblyID, StartDate) "
							+ "VALUES ('" + jobNumber + "', '" + processID + "', '" + assemblyID + "', '" + date + "')";
					try {
						final Statement statement = connection.createStatement();
						statement.executeUpdate(insertSql);
						System.out.print("(1) ADD A CUSTOMER"
								+ "\n (2) ADD A DEPARTMENT"
								+ "\n (3) ORDER AN ASSEMBLY"
								+ "\n (4) CREATE A PROCESS"
								+ "\n (5) CREATE AN ACCOUNT"
								+ "\n (6) START A JOB"
								+ "\n (7) COMPLETE A JOB"
								+ "\n (8) ADD A TRANSACTION"
								+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
								+ "\n (10) RETRIEVE TOTAL LABOR"
								+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
								+ "\n (12) RETRIEVE JOBS"
								+ "\n (13) RETRIEVE CUSTOMERS"
								+ "\n (14) DELETE CUT-JOB"
								+ "\n (15) CHANGE PAINT COLOR"
								+ "\n (16) INPORT"
								+ "\n (17) EXPORT"
								+ "\n (18) QUIT");
						input = scanner.nextInt();
						break;
					}
					catch(Exception e) {
						System.out.print(e.getMessage());
					}
				//Takes input from user and inserts into table 
				case 7:
					System.out.print("Enter the job number: ");
					jobNumber = scanner.nextInt();
					System.out.print("Enter the completion date: ");
					date = scanner.next();
					System.out.print("Enter the job type. Cut-Job, Paint-Job, Fit-Job: ");
					type = scanner.next();
					String updateJobDate = "UPDATE Job SET CompletionDate = '"+ date + "' WHERE JobNumber = " + jobNumber + "";
					//checks input
					if(type.equalsIgnoreCase("Cut-Job")) {
						System.out.print("Enter machine used: ");
						String machine = scanner.next();
						System.out.print("Enter how long machine was used: ");
						String time = scanner.next();
						System.out.print("Enter materials used: ");
						String materials = scanner.next();
						System.out.print("Enter labor time: ");
						Float labor = scanner.nextFloat();
						insertSql = "INSERT INTO CutJob (Machine, MachineTime, Material, Labor, JobNumber) "
								+ "VALUES ('" + machine + "', '" + time + "', '" + materials + "', '" + labor + "', '" + jobNumber + "')";
						try {
							Statement statement = connection.createStatement();
							statement.executeUpdate(insertSql);
							statement.executeUpdate(updateJobDate);
							System.out.print("(1) ADD A CUSTOMER"
									+ "\n (2) ADD A DEPARTMENT"
									+ "\n (3) ORDER AN ASSEMBLY"
									+ "\n (4) CREATE A PROCESS"
									+ "\n (5) CREATE AN ACCOUNT"
									+ "\n (6) START A JOB"
									+ "\n (7) COMPLETE A JOB"
									+ "\n (8) ADD A TRANSACTION"
									+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
									+ "\n (10) RETRIEVE TOTAL LABOR"
									+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
									+ "\n (12) RETRIEVE JOBS"
									+ "\n (13) RETRIEVE CUSTOMERS"
									+ "\n (14) DELETE CUT-JOB"
									+ "\n (15) CHANGE PAINT COLOR"
									+ "\n (16) INPORT"
									+ "\n (17) EXPORT"
									+ "\n (18) QUIT");
							input = scanner.nextInt();
							break;
						}
						catch(Exception e) {
							System.out.print(e.getMessage());
						}
					}
					//checks input
					else if(type.equalsIgnoreCase("Paint-Job")) {
						System.out.print("Enter color: ");
						String color = scanner.next();
						System.out.print("Enter volume: ");
						String volume = scanner.next();
						System.out.print("Enter labor time: ");
					    Float labor = scanner.nextFloat();
						insertSql = "INSERT INTO PaintJob (Color, Volume, Labor, JobNumber) "
								+ "VALUES ('" + color + "', '" + volume + "', '" + labor + "', '" +  jobNumber +  "')";
						try {
							Statement statement = connection.createStatement();
							statement.executeUpdate(insertSql);
							statement.executeUpdate(updateJobDate);
							System.out.print("(1) ADD A CUSTOMER"
									+ "\n (2) ADD A DEPARTMENT"
									+ "\n (3) ORDER AN ASSEMBLY"
									+ "\n (4) CREATE A PROCESS"
									+ "\n (5) CREATE AN ACCOUNT"
									+ "\n (6) START A JOB"
									+ "\n (7) COMPLETE A JOB"
									+ "\n (8) ADD A TRANSACTION"
									+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
									+ "\n (10) RETRIEVE TOTAL LABOR"
									+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
									+ "\n (12) RETRIEVE JOBS"
									+ "\n (13) RETRIEVE CUSTOMERS"
									+ "\n (14) DELETE CUT-JOB"
									+ "\n (15) CHANGE PAINT COLOR"
									+ "\n (16) INPORT"
									+ "\n (17) EXPORT"
									+ "\n (18) QUIT");
							input = scanner.nextInt();
							break;
						}
						catch(Exception e) {
							System.out.print(e.getMessage());
						}
					}
					//assumes input
					else {
						System.out.print("Enter labor time: ");
						Float labor = scanner.nextFloat();
						insertSql = "INSERT INTO FitJob (Labor, JobNumber) "
								+ "VALUES ('" + labor + "', '" +  jobNumber +  "')";
						try {
							Statement statement = connection.createStatement();
							statement.executeUpdate(insertSql);
							statement.executeUpdate(updateJobDate);
							System.out.print("(1) ADD A CUSTOMER"
									+ "\n (2) ADD A DEPARTMENT"
									+ "\n (3) ORDER AN ASSEMBLY"
									+ "\n (4) CREATE A PROCESS"
									+ "\n (5) CREATE AN ACCOUNT"
									+ "\n (6) START A JOB"
									+ "\n (7) COMPLETE A JOB"
									+ "\n (8) ADD A TRANSACTION"
									+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
									+ "\n (10) RETRIEVE TOTAL LABOR"
									+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
									+ "\n (12) RETRIEVE JOBS"
									+ "\n (13) RETRIEVE CUSTOMERS"
									+ "\n (14) DELETE CUT-JOB"
									+ "\n (15) CHANGE PAINT COLOR"
									+ "\n (16) INPORT"
									+ "\n (17) EXPORT"
									+ "\n (18) QUIT");
							input = scanner.nextInt();
							break;
						}
						catch(Exception e) {
							System.out.print(e.getMessage());
						}
					}
				//Takes input from user and updates tables 
				case 8:
					System.out.print("Enter transaction ID: ");
					int transactionID = scanner.nextInt();
					System.out.print("Enter account number: ");
					accountNumber = scanner.nextInt();
					System.out.print("Enter sup cost: ");
					double supCost = scanner.nextDouble();
					insertSql = "INSERT INTO Transactions (TransactionNumber, SupCost) "
							+ "VALUES ('" + transactionID + "', '" + supCost +  "')";
					String searchAssembly = "SELECT Costs FROM AssemblyAccount WHERE AccountNumber = " + accountNumber + " ";
					String searchDepartment = "SELECT Costs FROM DepartmentAccount WHERE AccountNumber = " + accountNumber + " ";
					String searchProcess = "SELECT Costs FROM ProcessAccount WHERE AccountNumber = " + accountNumber + " ";
					try {
						Statement statement = connection.createStatement();
						statement.executeUpdate(insertSql);
						ResultSet resultAssembly = statement.executeQuery(searchAssembly);
						while(resultAssembly.next()) {
							double temp = resultAssembly.getDouble("Costs");
							temp = temp + supCost;
							statement.executeUpdate("UPDATE AssemblyAccount SET Costs = "+ temp + " WHERE AccountNumber = " + accountNumber + " ");
						}
					}
					catch(Exception e) {
						
					}
					try {
						Statement statement = connection.createStatement();
						ResultSet resultDepartment = statement.executeQuery(searchDepartment);
						while(resultDepartment.next()) {
							double temp = resultDepartment.getDouble("Costs");
							temp = temp + supCost;
							statement.executeUpdate("UPDATE DepartmentAccount SET Costs = "+ temp + " WHERE AccountNumber = " + accountNumber + " ");
						}
					}
					catch(Exception e) {
						
					}
					try {
						Statement statement = connection.createStatement();
						ResultSet resultProcess = statement.executeQuery(searchProcess);
						while(resultProcess.next()) {
							double temp = resultProcess.getDouble("Costs");
							temp = temp + supCost;
							statement.executeUpdate("UPDATE ProcessAccount SET Costs = "+ temp + " WHERE AccountNumber = " + accountNumber + " ");
						}
					}
					catch(Exception e) {
						
					}
					System.out.print("(1) ADD A CUSTOMER"
							+ "\n (2) ADD A DEPARTMENT"
							+ "\n (3) ORDER AN ASSEMBLY"
							+ "\n (4) CREATE A PROCESS"
							+ "\n (5) CREATE AN ACCOUNT"
							+ "\n (6) START A JOB"
							+ "\n (7) COMPLETE A JOB"
							+ "\n (8) ADD A TRANSACTION"
							+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
							+ "\n (10) RETRIEVE TOTAL LABOR"
							+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
							+ "\n (12) RETRIEVE JOBS"
							+ "\n (13) RETRIEVE CUSTOMERS"
							+ "\n (14) DELETE CUT-JOB"
							+ "\n (15) CHANGE PAINT COLOR"
							+ "\n (16) INPORT"
							+ "\n (17) EXPORT"
							+ "\n (18) QUIT");
					input = scanner.nextInt();
					break;
				//Takes input from user and searches 
				case 9:
					System.out.print("Enter an assembly ID: ");
					int id = scanner.nextInt();
					String searchSql = "Select Costs FROM AssemblyAccount WHERE AssemblyID = " + id + " ";
					try {
						final Statement statement = connection.createStatement();
						ResultSet result = statement.executeQuery(searchSql);
						while(result.next()) {
							System.out.println("Costs");
							System.out.println("-----------------------------------------------");
							double temp = result.getDouble("Costs");
							System.out.println(temp);
						}
						System.out.print("(1) ADD A CUSTOMER"
								+ "\n (2) ADD A DEPARTMENT"
								+ "\n (3) ORDER AN ASSEMBLY"
								+ "\n (4) CREATE A PROCESS"
								+ "\n (5) CREATE AN ACCOUNT"
								+ "\n (6) START A JOB"
								+ "\n (7) COMPLETE A JOB"
								+ "\n (8) ADD A TRANSACTION"
								+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
								+ "\n (10) RETRIEVE TOTAL LABOR"
								+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
								+ "\n (12) RETRIEVE JOBS"
								+ "\n (13) RETRIEVE CUSTOMERS"
								+ "\n (14) DELETE CUT-JOB"
								+ "\n (15) CHANGE PAINT COLOR"
								+ "\n (16) INPORT"
								+ "\n (17) EXPORT"
								+ "\n (18) QUIT");
						input = scanner.nextInt();
						break;
					}
					catch(Exception e) {
						System.out.print(e.getMessage());
					}
				//Takes input from user and searches 
				case 10:
					List<Float> timelist = new ArrayList<Float>();
					System.out.print("Enter a completion date: ");
					String completionDate = scanner.next();
					String searchFit = "SELECT Labor FROM Job, FitJob WHERE Job.CompletionDate = '"
							+ completionDate + "' AND FitJob.JobNumber = Job.JobNumber";
					String searchCut = "SELECT Labor FROM Job, CutJob WHERE Job.CompletionDate = '"
							+ completionDate + "' AND CutJob.JobNumber = Job.JobNumber";
					String searchPaint = "SELECT Labor FROM Job, PaintJob WHERE Job.CompletionDate = '"
							+ completionDate + "' AND PaintJob.JobNumber = Job.JobNumber";
					try {
						Statement statement = connection.createStatement();
						ResultSet resultFit = statement.executeQuery(searchFit);
						while(resultFit.next()) {
							timelist.add(Float.parseFloat(resultFit.getString("Labor")));
						}
						ResultSet resultPaint = statement.executeQuery(searchPaint);
						while(resultPaint.next()) {
							timelist.add(Float.parseFloat(resultPaint.getString("Labor")));
						}
						ResultSet resultCut = statement.executeQuery(searchCut);
						while(resultCut.next()) {
							timelist.add(Float.parseFloat(resultCut.getString("Labor")));
						}
						float temp = 0;
						for(int i  = 0; i < timelist.size(); i++) {
							temp = temp + timelist.get(i);
						}
						Float sum = (float) ((float) Math.round(temp * 100.00) / 100.00);
						System.out.println(sum);
					}
					catch(Exception e) {
						System.out.print(e.getMessage());
					}
					System.out.print("(1) ADD A CUSTOMER"
							+ "\n (2) ADD A DEPARTMENT"
							+ "\n (3) ORDER AN ASSEMBLY"
							+ "\n (4) CREATE A PROCESS"
							+ "\n (5) CREATE AN ACCOUNT"
							+ "\n (6) START A JOB"
							+ "\n (7) COMPLETE A JOB"
							+ "\n (8) ADD A TRANSACTION"
							+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
							+ "\n (10) RETRIEVE TOTAL LABOR"
							+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
							+ "\n (12) RETRIEVE JOBS"
							+ "\n (13) RETRIEVE CUSTOMERS"
							+ "\n (14) DELETE CUT-JOB"
							+ "\n (15) CHANGE PAINT COLOR"
							+ "\n (16) INPORT"
							+ "\n (17) EXPORT"
							+ "\n (18) QUIT");
					input = scanner.nextInt();
					break;
				//Takes input from user and searches 
				case 11:
					System.out.print("Enter Assembly-id: ");
					int idassem = scanner.nextInt();
					String searchingSql = "SELECT Process.ProcessID, Department.DepartmentNumber "
							+ "FROM Assembly, Process, Department, Job WHERE Job.AssemblyID = " + idassem + 
							" AND Job.AssemblyID = Assembly.AssemblyID AND Job.ProcessID = Process.ProcessID "
							+ "AND Process.DepartmentNumber = Department.DepartmentNumber ORDER BY Job.StartDate";
					try {
						final Statement statement = connection.createStatement();
						ResultSet result = statement.executeQuery(searchingSql);
						System.out.println("Process IDs AND Department numbers");
						System.out.println("------------------------------------");
						while(result.next()) {
							int temp = result.getInt("ProcessID");
							int other = result.getInt("DepartmentNumber");
							System.out.println("Process ID: " + Integer.toString(temp)+ "| Department Number: " + Integer.toString(other));
						}
					}
					catch(Exception e) {
						System.out.print(e.getMessage());
					}
					
					System.out.print("(1) ADD A CUSTOMER"
							+ "\n (2) ADD A DEPARTMENT"
							+ "\n (3) ORDER AN ASSEMBLY"
							+ "\n (4) CREATE A PROCESS"
							+ "\n (5) CREATE AN ACCOUNT"
							+ "\n (6) START A JOB"
							+ "\n (7) COMPLETE A JOB"
							+ "\n (8) ADD A TRANSACTION"
							+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
							+ "\n (10) RETRIEVE TOTAL LABOR"
							+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
							+ "\n (12) RETRIEVE JOBS"
							+ "\n (13) RETRIEVE CUSTOMERS"
							+ "\n (14) DELETE CUT-JOB"
							+ "\n (15) CHANGE PAINT COLOR"
							+ "\n (16) INPORT"
							+ "\n (17) EXPORT"
							+ "\n (18) QUIT");
					input = scanner.nextInt();
					break;
				//Takes input from user and searches 
				case 12:
					System.out.print("not complete.");
					System.out.print("(1) ADD A CUSTOMER"
							+ "\n (2) ADD A DEPARTMENT"
							+ "\n (3) ORDER AN ASSEMBLY"
							+ "\n (4) CREATE A PROCESS"
							+ "\n (5) CREATE AN ACCOUNT"
							+ "\n (6) START A JOB"
							+ "\n (7) COMPLETE A JOB"
							+ "\n (8) ADD A TRANSACTION"
							+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
							+ "\n (10) RETRIEVE TOTAL LABOR"
							+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
							+ "\n (12) RETRIEVE JOBS"
							+ "\n (13) RETRIEVE CUSTOMERS"
							+ "\n (14) DELETE CUT-JOB"
							+ "\n (15) CHANGE PAINT COLOR"
							+ "\n (16) INPORT"
							+ "\n (17) EXPORT"
							+ "\n (18) QUIT");
					input = scanner.nextInt();
					break;
				//Takes input from user and searches 
				case 13:
					System.out.print("Enter lower bound: ");
					int lower = scanner.nextInt();
					System.out.print("Enter upper bound: ");
					int upper = scanner.nextInt();
					String searchSQL = "SELECT CustomerName FROM Customer WHERE Category >= " + lower + " AND Category <= " + upper + "";
					try {
						final Statement statement = connection.createStatement();
						ResultSet result = statement.executeQuery(searchSQL);
						while(result.next()) {
							System.out.print("Names");
							System.out.println("-----------------------------------------------");
							String temp = result.getString("CustomerName");
							System.out.println(temp);
						}
						System.out.print("(1) ADD A CUSTOMER"
								+ "\n (2) ADD A DEPARTMENT"
								+ "\n (3) ORDER AN ASSEMBLY"
								+ "\n (4) CREATE A PROCESS"
								+ "\n (5) CREATE AN ACCOUNT"
								+ "\n (6) START A JOB"
								+ "\n (7) COMPLETE A JOB"
								+ "\n (8) ADD A TRANSACTION"
								+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
								+ "\n (10) RETRIEVE TOTAL LABOR"
								+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
								+ "\n (12) RETRIEVE JOBS"
								+ "\n (13) RETRIEVE CUSTOMERS"
								+ "\n (14) DELETE CUT-JOB"
								+ "\n (15) CHANGE PAINT COLOR"
								+ "\n (16) INPORT"
								+ "\n (17) EXPORT"
								+ "\n (18) QUIT");
						input = scanner.nextInt();
						break;
					}
					catch(Exception e) {
						System.out.print(e.getMessage());
					}
				//Takes input from user and searches 
				case 14:
					System.out.print("Enter lower bounds: ");
					int lowerbounds = scanner.nextInt();
					System.out.print("Enter uppder bounds: ");
					int upperbounds = scanner.nextInt();
					String deleteSql = "DELETE FROM CutJob WHERE JobNumber >= " + lowerbounds + "AND JobNumber <= " + upperbounds + "";
					try {
						final Statement statement = connection.createStatement();
						statement.executeUpdate(deleteSql);
						System.out.print("(1) ADD A CUSTOMER"
								+ "\n (2) ADD A DEPARTMENT"
								+ "\n (3) ORDER AN ASSEMBLY"
								+ "\n (4) CREATE A PROCESS"
								+ "\n (5) CREATE AN ACCOUNT"
								+ "\n (6) START A JOB"
								+ "\n (7) COMPLETE A JOB"
								+ "\n (8) ADD A TRANSACTION"
								+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
								+ "\n (10) RETRIEVE TOTAL LABOR"
								+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
								+ "\n (12) RETRIEVE JOBS"
								+ "\n (13) RETRIEVE CUSTOMERS"
								+ "\n (14) DELETE CUT-JOB"
								+ "\n (15) CHANGE PAINT COLOR"
								+ "\n (16) INPORT"
								+ "\n (17) EXPORT"
								+ "\n (18) QUIT");
						input = scanner.nextInt();
						break;
					}
					catch(Exception e) {
						System.out.print(e.getMessage());
					}
				//Takes input from user and searches 
				case 15:
					System.out.print("Enter a job number: ");
					int newNumber = scanner.nextInt();
					System.out.print("Enter paint color: ");
					String color = scanner.next();
					String updateSql = "UPDATE PaintJob SET Color = '"+color + "' WHERE JobNumber = " + newNumber + "";
					try {
						final Statement statement = connection.createStatement();
						statement.executeUpdate(updateSql);
						System.out.print("(1) ADD A CUSTOMER"
								+ "\n (2) ADD A DEPARTMENT"
								+ "\n (3) ORDER AN ASSEMBLY"
								+ "\n (4) CREATE A PROCESS"
								+ "\n (5) CREATE AN ACCOUNT"
								+ "\n (6) START A JOB"
								+ "\n (7) COMPLETE A JOB"
								+ "\n (8) ADD A TRANSACTION"
								+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
								+ "\n (10) RETRIEVE TOTAL LABOR"
								+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
								+ "\n (12) RETRIEVE JOBS"
								+ "\n (13) RETRIEVE CUSTOMERS"
								+ "\n (14) DELETE CUT-JOB"
								+ "\n (15) CHANGE PAINT COLOR"
								+ "\n (16) INPORT"
								+ "\n (17) EXPORT"
								+ "\n (18) QUIT");
						input = scanner.nextInt();
						break;
					}
					catch(Exception e) {
						System.out.print(e.getMessage());
					}
				//Populates database from file
				case 16:
					System.out.print("not complete.");
					System.out.print("(1) ADD A CUSTOMER"
							+ "\n (2) ADD A DEPARTMENT"
							+ "\n (3) ORDER AN ASSEMBLY"
							+ "\n (4) CREATE A PROCESS"
							+ "\n (5) CREATE AN ACCOUNT"
							+ "\n (6) START A JOB"
							+ "\n (7) COMPLETE A JOB"
							+ "\n (8) ADD A TRANSACTION"
							+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
							+ "\n (10) RETRIEVE TOTAL LABOR"
							+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
							+ "\n (12) RETRIEVE JOBS"
							+ "\n (13) RETRIEVE CUSTOMERS"
							+ "\n (14) DELETE CUT-JOB"
							+ "\n (15) CHANGE PAINT COLOR"
							+ "\n (16) INPORT"
							+ "\n (17) EXPORT"
							+ "\n (18) QUIT");
					input = scanner.nextInt();
					break;
				//Creates file from database
				case 17:
					System.out.print("not complete.");
					System.out.print("(1) ADD A CUSTOMER"
							+ "\n (2) ADD A DEPARTMENT"
							+ "\n (3) ORDER AN ASSEMBLY"
							+ "\n (4) CREATE A PROCESS"
							+ "\n (5) CREATE AN ACCOUNT"
							+ "\n (6) START A JOB"
							+ "\n (7) COMPLETE A JOB"
							+ "\n (8) ADD A TRANSACTION"
							+ "\n (9) RETRIEVE COSTS ON AN ASSEMBLY"
							+ "\n (10) RETRIEVE TOTAL LABOR"
							+ "\n (11) RETRIEVE PROCESSES AND DEPARTMENT"
							+ "\n (12) RETRIEVE JOBS"
							+ "\n (13) RETRIEVE CUSTOMERS"
							+ "\n (14) DELETE CUT-JOB"
							+ "\n (15) CHANGE PAINT COLOR"
							+ "\n (16) INPORT"
							+ "\n (17) EXPORT"
							+ "\n (18) QUIT");
					input = scanner.nextInt();
					break;
				}
			}
			System.out.print("Goodbye...");
		}
	}
}