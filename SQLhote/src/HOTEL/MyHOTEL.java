package HOTEL;
import java.util.*;



public class MyHOTEL {

	public static void main(String[] args) {
		
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
		 
		 
	}

}
