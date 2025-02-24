
public class Room {
    private int id;
 public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
private String room;
 private String roomStatus;
 private String dateAvailability;
 private double priceRange;
 private String place;
//  private int customer_id;
//  public int getCustomer_id() {
//     return customer_id;
// }
// public void setCustomer_id(int customer_id) {
//     this.customer_id = customer_id;
// }
public Room(int id,String room,String roomStatus,String dateAvailability,double priceRange,String place){
    this.id=id;
	 this.room = room;
	 this.roomStatus = roomStatus;
	 this.dateAvailability = dateAvailability;
	 this.priceRange = priceRange;
	 this.place = place;
    // this.customer_id=customer_id;
 }
 public String getRoom() {
	 return room;
 }
 public String getDateAvailability() {
	return dateAvailability;
 }
 public double getPriceRange() {
	 return priceRange;
 }
 public String getPlace() {
	 return place;
 }
 public String getRoomStatus() {
	return roomStatus;
}
 public void setRoomStatus(String roomStatus) {
	 this.roomStatus = roomStatus;
 }
 public void setDateAvailability(String dateAvailability) {
	 this.dateAvailability = dateAvailability;
 }
 public String toString() {
	 return "Room: "+room+", Room Status: "+roomStatus+", Date Available: "+dateAvailability+", Price: "+priceRange+", Place: "+place;
 }
}
