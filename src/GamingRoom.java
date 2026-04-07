public class GamingRoom {
    private String name;
    private int capacity;
    private String[] bookedEmails;
    private int bookedCount = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
        this.bookedEmails = new String[capacity];
        this.bookedCount = 0;
    }

    public boolean bookWithEmail(String email) {
        if (bookedCount < capacity) {
            bookedEmails[bookedCount] = email;
            bookedCount++;
            return true;
        }
        return false;
    }

    public void printBookings() {
        if (bookedCount == 0) {
            System.out.println("No bookings yet.");
        } else {
            System.out.println("Bookings:");
            for (int i = 0; i < bookedCount; i++) {
                System.out.println("- " + bookedEmails[i]);
            }
        }
    }

    @Override
    public String toString() {
        return "GamingRoom{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", bookedSpaces=" + bookedCount + "/" + capacity +
                '}';
    }
}
