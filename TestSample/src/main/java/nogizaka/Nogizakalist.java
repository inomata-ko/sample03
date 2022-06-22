package nogizaka;

public class Nogizakalist {
	private int ID;
	private String Name;
	private int Dateofbirth;
	private int Old;
	private String Birthplace;
    private String Detail;
    
    public int getID() {
    	return ID;
    }
    public String getName() {
    	return Name;
    }
    public int getDateofbirth() {
    	return Dateofbirth;
    }
    public int getOld() {
    	return Old;
    }
    public String getBirthplace() {
    	return Birthplace;
    }
     
    public String getDetail() {
    	return Detail;
    }
    public void setID(int ID) {
    	this.ID=ID;
    }
    public void setName(String Name) {
    	this.Name=Name;
    }
    public void setDateofbirth(int Dateofbirth) {
    	this.Dateofbirth=Dateofbirth;
    }
    public void setOld(int Old) {
    	this.Old=Old;
    }
    public void setBirthplace(String Birthplace) {
    	this.Birthplace=Birthplace;
    }
    public void setDetail(String Detail) {
    	this.Detail=Detail;
    }
    public Nogizakalist(int ID, String Name, int Dateofbirth, int Old, String Birthplace, String Detail) {
    	this.ID = ID;
    	this.Name = Name;
    	this.Dateofbirth = Dateofbirth;
    	this.Old = Old;
    	this.Birthplace = Birthplace;
    	this.Detail = Detail;
    }
}
