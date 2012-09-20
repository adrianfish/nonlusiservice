package uk.ac.lancs.sakai.nonlusiservice;

public class Module {
	
	public String id = "";
	public String sortorder = "";
	public String shortname = "";
	public String fullname = "";
	public String idnumber = "";
	public long startdate = 0L;
	public int visible = 1;
	public String url = "";
	public String moduleid = "";
	public String yearid = "";
	
	public Module() {
	}
	
	public Module(String siteId, String title, String url, String moduleId, String yearId) {
		super();
		
		this.id = siteId;
		this.shortname = title;
		this.fullname = title;
		this.idnumber = siteId;
		this.url = url;
		moduleid = moduleId;
		yearid = yearId;
	}
}
