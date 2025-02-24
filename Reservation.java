
public class Reservation{

    private int id;
    private String check_in;
    private String check_out;
    private String roomPreference;
    private String name;
    private long contact;
    private int user_id;
    public Reservation(int id,String check_in,String check_out,String roomPreference,String name , long contact,int user_id){
        this.id = id;
        this.check_in = check_in;
        this.check_out = check_out;
        this.roomPreference = roomPreference;
        this.name = name;
        this.contact = contact;
        this.user_id = user_id;
    }
    public void setId(int id){
        this.id = id;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public void setRoomPreference(String roomPreference) {
        this.roomPreference = roomPreference;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public int getId(){
        return id;
    }
    public String getCheckIn(){
        return check_in;
    }
    public String getCheckOut(){
        return check_out;
    }
    public String getRoomPreference(){
        return roomPreference;
    }
    public String getName(){
        return name;
    }
    public long getContact(){
        return contact;
    }
    public String toString(){
        return "Reservation ID: " + id+", Check In: "+check_in+", Check Out: "+check_out+", Room: "+roomPreference;
    }
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}