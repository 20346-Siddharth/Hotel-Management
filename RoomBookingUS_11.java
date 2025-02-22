public class RoomBookingUS_11 {
    private int bookingID ;
    private String roomTypeSelection;
    private String bookingDetails;
    private double price;
    private int customer_id;
    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public int getBookingID() {
        return bookingID;
    }
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }
    public String getRoomTypeSelection() {
        return roomTypeSelection;
    }
    public void setRoomTypeSelection(String roomTypeSelection) {
        this.roomTypeSelection = roomTypeSelection;
    }
    public String getBookingDetails() {
        return bookingDetails;
    }
    public void setBookingDetails(String bookingDetails) {
        this.bookingDetails = bookingDetails;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public RoomBookingUS_11(int bookingID, String roomTypeSelection, String bookingDetails, double price,int customer_id) {
        this.bookingID = bookingID;
        this.roomTypeSelection = roomTypeSelection;
        this.bookingDetails = bookingDetails;
        this.price = price;
        this.customer_id=customer_id;
    }


    
}
