package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class seat {

    private String s_seat;
    private String name;
    private int num;
    
    public seat() { }

    
    
    
    
    public seat(String s_seat, String name, int num) {
	super();
	this.s_seat = s_seat;
	this.name = name;
	this.num = num;
	
    }
    

    
    
    
    
   





	public seat(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}





	public String getS_seat() {
        return s_seat;
    }

    public void setS_seat(String s_seat) {
        this.s_seat = s_seat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

   
    
    
    
    
    
    
}
