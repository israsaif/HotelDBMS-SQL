package HOTEL;
import java.util.*;



public class MyHOTEL {

	public static void main(String[] args) {
		
		
		 
			Scanner sa = new Scanner(System.in);
			
			do{
				System.out.println("1.CREATE TABLE");
				System.out.println("2.INSERT TABLE ");
				System.out.println("3.readFromTable");
				System.out.println("4. getById");
				System.out.println("5.");
				System.out.println("6.");
				System.out.println("7.Exit ");

				String bb = sa.next();
				int option = Integer.parseInt(bb);
				
				switch (option) {

				case 1:
					
					 Hotels HO = new  Hotels(); 
					 HO.createHotelsTable();
					 
					 Room_Type RT= new  Room_Type(); 
					 RT.createRoom_TypeTable();
					  
					 Rooms RM= new Rooms(); 
					 RM.createRoomsTable();
					 
					 Guests GU = new  Guests();
					 GU.createGuestsTable();
					 
					 EmployeeType EM = new EmployeeType();
					 EM.createEmployeeTypeTable();
					 
					 Employees EP = new Employees();
					 EP.createEmployeesTable();
					
					
					break;
				
	           
			   case 2:
				 
				
				  Hotels HH = new Hotels();
				  HH.insertIntoTable();
				  
//				  Room_Type RTY = new  Room_Type();
//				  RTY.insertIntoTable2();
//				  
				break;
				
			   case 3:
				Hotels.readFromTable();
					
					break;
			   case 4:
					
						
						break;
			}
           }while(true);
          }
         }