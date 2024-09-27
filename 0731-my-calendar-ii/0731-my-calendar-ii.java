import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    private List<int[]> bookings;
    private List<int[]> doubleBookings;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        doubleBookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] db : doubleBookings) {
            if (Math.max(start, db[0]) < Math.min(end, db[1])) {
                return false; 
            }
        }

        for (int[] b : bookings) {
            if (Math.max(start, b[0]) < Math.min(end, b[1])) {
                doubleBookings.add(new int[]{
                    Math.max(start, b[0]), Math.min(end, b[1])
                });
            }
        }

        bookings.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
