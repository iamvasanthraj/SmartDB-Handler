package practiceJDBC;

import java.util.Scanner;

class App {
	public void list() throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("---Welcome to my Smart DataBase Handler---");
			int ip;
			do {
				System.out.println();
				System.out.println("1.Access Excisting Database");
				System.out.println("2.Create a New Table");
				System.out.println("3.Display my Database");
				System.out.println("4.Exit");
				System.out.println();
				System.out.println("Enter Number 1 - 4 to Proceed : ");

				ip = sc.nextInt();
				connect c1 = new connect();
				if (ip == 1) {
					String dbname = "student_db";
					System.out.println("Enter your Table Name :");
					String tbname = sc.next();
					boolean isconnected = c1.Connect(dbname);
					if (isconnected == true) {
						marks s = new marks();
						boolean check2 = c1.Updatetable(s, tbname);
						if (check2 == true) {
							sc.nextLine();
							System.out.println("Enter Student Name :");
							s.student_name = sc.nextLine();
							System.out.println("Enter Student Mark 1 : ");
							s.subject1 = sc.nextInt();
							System.out.println("Enter Student Mark 2 : ");
							s.subject2 = sc.nextInt();
							System.out.println("Enter Student Mark 3 : ");
							s.subject3 = sc.nextInt();
							System.out.println("Enter Student Mark 4 : ");
							s.subject4 = sc.nextInt();
							System.out.println("Enter Student Mark 5 : ");
							s.subject5 = sc.nextInt();
							c1.Updatetable(s, tbname);
						}
					}
				} else if (ip == 2) {
					String dbname = "student_db";
					boolean isconnected = c1.Connect(dbname);
					if (isconnected == true) {
						System.out.println("Enter New Table Name :");
						String table = sc.next();
						c1.Createtable(table);
					}
				} else if (ip == 3) {
					String dbname = "student_db";
					boolean isconnected = c1.Connect(dbname);
					if (isconnected == true) {
						System.out.println("Enter your Table to display :");
						String table = sc.next();
						c1.dispalyDb(table);
					}
				} else if (ip == 4) {
					System.out.println("Thank You See you soon Bii");

				} else {
					System.out.println("Enter Valid input from 1 - 4");
				}

			} while (ip != 4);
		} catch (Exception e) {
			System.out.println("Number Only allowed See You Soon Beeey...!");
		}
	}
}