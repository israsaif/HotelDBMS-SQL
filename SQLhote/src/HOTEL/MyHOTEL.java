package HOTEL;

import java.util.*;

public class MyHOTEL {

	public static void main(String[] args) {

		Scanner sa = new Scanner(System.in);

		do {
			System.out.println("1.CREATE TABLE");
			System.out.println("2.Insert 10,000 hotels ");
			System.out.println("3.Insert 1 hotel");
			System.out.println("4.Print 10 hotels");
			System.out.println("5.Make first 10 hotels 'is_Active' = false");
			System.out.println("6.Print hotel information by user input");
			System.out.println("7.Insert All");
			String bb = sa.next();
			int option = Integer.parseInt(bb);

			switch (option) {

			case 1:

				Hotels HO = new Hotels();
				HO.createHotelsTable();

				Room_Type RT = new Room_Type();
				RT.createRoom_TypeTable();

				Rooms RM = new Rooms();
				RM.createRoomsTable();

				Guests GU = new Guests();
				GU.createGuestsTable();

				EmployeeType EM = new EmployeeType();
				EM.createEmployeeTypeTable();

				Employees EP = new Employees();
				EP.createEmployeesTable();

				break;

			case 2:

				Hotels HH = new Hotels();
				HH.insertIntoTable();


				  
				break;

			case 3:
				Hotels HH1 = new Hotels();
				HH1.insertIntoTable1();

				break;
			case 4:
				Hotels HH2 = new Hotels();
				HH2.readFromTable(10);
				break;

			case 5:
				Hotels HH4 = new Hotels();
				HH4.makeIsActiveFalseById();
				break;

			case 6:
				System.out.println("Enter how many hotel information you want?");
				int information = sa.nextInt();
				Hotels HH3 = new Hotels();
				HH3.readFromTable(information);
				break;

			case 7:
//				Room_Type ROT = new Room_Type(); 
//				ROT.insertIntoTable();
				
//				EmployeeType EMP = new EmployeeType ();
//				EMP.insertIntoTable();
				
//				Rooms ro = new Rooms();
//				ro.insertIntoTable();
//				
				Employees em = new Employees();
				em.insertIntoTable();
				
				break;
			}
		} while (true);
	}
}