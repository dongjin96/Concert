package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class seat {

    int seat_num ;
    String member_id;
    
    public seat() {
    }
    
    public seat(int seat_num, String member_id) {
	super();
	this.seat_num = seat_num;
	this.member_id = member_id;
    }

    public int getSeat_num() {
        return seat_num;
    }
    public void setSeat_num(int seat_num) {
        this.seat_num = seat_num;
    }
    public String getMember_id() {
        return member_id;
    }
    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }
    
    @Override
    public String toString() {
       
        return seat_num + "   " + member_id;
    }
    
    
}
