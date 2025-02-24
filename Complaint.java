
 public class Complaint{
	private String userName;
	private long contactNumber;
	private int roomNumber;
	private String complaintType;
	private int rating;
	public Complaint(String userName,long contactNumber,int roomNumber,String complaintType,int rating){
		this.userName = userName;
		this.contactNumber = contactNumber;
		this.roomNumber = roomNumber;
		this.complaintType = complaintType;
		this.rating = rating;
	}
	public String getUserName() {
		return userName;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public String getComplaintType() {
		return complaintType;
	}
	public int getRating() {
		return rating;
	}
	public String toString() {
		return "Username: "+userName+", Contact No.: "+contactNumber+", Room No.: "+roomNumber+", Complaint Type: "+complaintType+", Rating: "+rating;
	}
}
 
 
//public class Complaint {
//    public Complaint[]complaints;
//    int size;
//    public Complaint() {
//    	complaints = new Complaint[10];
//    	this.size = 0;
//    }
//    
//    public void addNewComplaint(Complaint comp) {
//    	if(size>=complaints.length) {
//    		Complaint[]extend = new Complaint[size*2];
//    		for(int i=0;i<size;i++) {
//    			extend[i] = complaints[i];
//    		}
//    		complaints = extend;
//    	}
//    	else {
//    	  complaints[size++] = comp;
//    	}
//    }
//	
//}


















