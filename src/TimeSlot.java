package src;

public class TimeSlot {
    private int startTime;
    private int endTime;
    public boolean isBooked;

    TimeSlot(int start, int end) {
        startTime = start;
        endTime = end;
        isBooked = false;
    }

    public void changeBookingState() { isBooked = !isBooked; }

    public String getInfo() {
        String returnVal = 
            "Start time: " + startTime + " -- "+ "end time: " + endTime + "\n" +
            "State: " + (isBooked? "Booked" : "Available");
        return returnVal;
    }

}
