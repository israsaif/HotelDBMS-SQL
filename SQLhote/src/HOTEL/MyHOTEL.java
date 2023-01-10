package HOTEL;

import java.util.*;

public class MyHOTEL {

	public static void main(String[] args) {

		Scanner sa = new Scanner(System.in);
		boolean subMenue=true;
		boolean bigMenu = true;
		while (bigMenu) {
			System.out.println("1.CREATE TABLE");
			System.out.println("2.Insert 10,000 hotels ");
			System.out.println("3.Insert 1 hotel");
			System.out.println("4.Print 10 hotels");
			System.out.println("5.Make first 10 hotels 'is_Active' = false");
			System.out.println("6.Print hotel information by user input");
			System.out.println("7.Insert All");
			System.out.println("8.New Task Questions");
			String bb = sa.next();
			int option = Integer.parseInt(bb);

			switch (option) {

			case 1:

//				Hotels HO = new Hotels();
//				HO.createHotelsTable();
//
//				Room_Type RT = new Room_Type();
//				RT.createRoom_TypeTable();

//				Rooms RM = new Rooms();
//				RM.createRoomsTable();

//				Guests GU = new Guests();
//				GU.createGuestsTable();
//
//				EmployeeType EM = new EmployeeType();
//				EM.createEmployeeTypeTable();
//
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
//				
//				Rooms ro = new Rooms();
//				ro.insertIntoTable();
//				System.out.println("Enter how many rows you want");
//				int Rooms4 = sa.nextInt();
//				
//				Employees em = new Employees();
//				em.insertIntoTable(Rooms4);
				Guests guests = new Guests();
				guests.insertIntoTable();
////				
				break;
			case 8:
				while(subMenue){
					System.out.println("1.Guests who's name end with 'E'");
					System.out.println("2.Rooms where guests are paying more than 1000 ");
					System.out.println("3.Count of guests who are staing in 'DELUXE' rooms");
					System.out.println("4.Guests who are staing in rooms and served by employee who have 'A' in their name");
					System.out.println("5.All rooms which are not active but room type is 'Deluxe'");
					System.out.println("6.All room type in hotels who's name have 'H' or are active but have more than 5 rooms.");
					System.out.println("7.Exit from Sub Menu");
					Scanner saa = new Scanner(System.in);

					String bb1 = saa.next();
					int options = Integer.parseInt(bb1);

					switch (options) {

					case 1:
						HotelManagement hotel = new HotelManagement();
						hotel.readFromGuests();

						break;
						
						
					case 2:
						HotelManagement Rooms = new HotelManagement();
						Rooms.RoomsWhereGuestMoreThan1000();
						 break;
						
						 
					case 3:
						HotelManagement Count = new HotelManagement();
						Count.CountOfGuests();
						
						 break;
					case 4:
						HotelManagement gustActive = new HotelManagement();
						gustActive.guestsNotActiveWithDeluxe();
						 
						 break;
					case 5:
						HotelManagement gustActive1 = new HotelManagement();
						gustActive1.hotelswhnamehavEH();
						 
						break;
					case 7:
						subMenue=false;
						bigMenu = true;
						break;
					}
			}subMenue=false;
			break;
				
			}
		}bigMenu = false;
	}
}