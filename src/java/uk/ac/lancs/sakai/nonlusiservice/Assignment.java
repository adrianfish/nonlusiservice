package uk.ac.lancs.sakai.nonlusiservice;

import java.util.List;
import java.util.ArrayList;

public class Assignment {
	
	public String name = "";
    public boolean tii = false;
    public boolean lusi = false;
	public String url = "";
	public long duedate = 0L;
	
	public Assignment() {
	}
	
	public Assignment(String name, boolean tii,boolean lusi,String url,long duedate) {

		super();
		
		this.name = name;
		this.tii = tii;
		this.lusi = lusi;
		this.url = url;
		this.duedate = duedate;
	}
}
