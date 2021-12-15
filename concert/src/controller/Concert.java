package controller;

import java.util.ArrayList;

import model.seat;
import view.Application;

public class Concert {
   
    public static ArrayList<seat>seatlist=Application.seatlist;
    
    
	public static void seatview() {
	    
	    
	    for(int i=0; i<30; i++) {
		if(i%10==0) {
		    System.out.println();
		}
		if (i==0) {
		    System.out.print("S ");
		    
		}
		if (i==10) {
		    System.out.print("A ");
		    
		}
		if (i==20) {
		    System.out.print("C ");
		    
		}
		
		
		if(seatlist.get(i).getName().equals("name")) { 
		    System.out.print("--- ");
		}else {
		    System.out.print(seatlist.get(i).getName()); 
		}
		
	    }
	    
	}
	
	
	}//ce