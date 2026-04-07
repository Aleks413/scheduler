import java.util.Scanner;

public class Scheduler {
    private static final InputReader inputReader = new InputReader();

    static {
        System.out.println("Welcome to Scheduling System");
        System.out.println("University name: " + University.UNIVERSITY_NAME);
        System.out.println("Location: " + University.LOCATION);
        System.out.println("Website: " + University.WEBSITE);
        System.out.println("Official language: " + University.OFFICIAL_LANGUAGE);
    }

    public static void start() {
        int input;
        do {
            System.out.println("********Main Menu*******");
            System.out.println("1. Cohorts");
            System.out.println("2. Courses");
            System.out.println("3. Teachers");
            System.out.println("4. Rooms");
            System.out.println("5. Other Staff");
            System.out.println("6. Cafeteria Management");
            System.out.println("7. Gaming Rooms Management");


            System.out.print("Enter number(O.Exit): ");
            input = inputReader.readInt();
            switch (input) {
                case 0:
                    System.out.println("Goodbye!");
                    break;
                case 1:
                    manageCohorts();
                    break;
                case 2:
                    manageCourses();
                    break;
                case 3:
                    manageTeachers();
                    break;
                case 4:
                    manageRooms();
                    break;
                case 5:
                    manageStaff();
                    break;
                case 6:
                    manageCafeteria();
                    break;
                case 7:
                    manageGamingRooms();
                    break;
                default:
                    System.out.println("Wrong Number!");
            }

        } while (input != 0);
    }

    private static void manageCafeteria() {
        int input;
        do {
            System.out.println("**** Cafeteria Management Menu ****");
            System.out.println("Does cafeteria work right now:" + Cafeteria.isActive());

            System.out.println("1. Change Status to " + !Cafeteria.isActive());
            System.out.print("Enter number (O.Back): ");
            input = inputReader.readInt();

            switch (input) {
                case 1:
                    Cafeteria.setActive(!Cafeteria.isActive());
                    break;
                default:
                    System.out.println("Wrong Number");
            }
        } while (input != 0);
    }

    private static void manageStaff() {
        int input;
        do {
            System.out.println("**** Staff Management Menu ****");
            System.out.println("1. Show Staff");
            System.out.println("2. Add Staff Member");
            System.out.println("3. Remove Staff Member");
            System.out.print("Enter number (O.Back): ");
            input = inputReader.readInt();

            switch (input) {
                case 1:
                    University.printStaff();
                    break;
                case 2:
                    addStaff();
                    break;
                case 3:
                    removeStaff();
                    break;
                default:
                    System.out.println("Wrong Number");
            }
        } while (input != 0);
    }

    private static void removeStaff() {
        University.printStaff();

        System.out.println("Enter the index:");
        int index = inputReader.readInt();

        University.removeStaff(index);
    }

    private static void addStaff() {
        System.out.print("Enter Staff name: ");
        String name = inputReader.readLine();

        System.out.print("Enter Staff age: ");
        byte age = inputReader.readByte();

        System.out.print("Enter Staff email: ");
        String email = inputReader.readLine();
        email = checkAndGetValidEmail(email);

        System.out.print("Enter Staff position: ");
        String position = inputReader.readLine();

        while (!StaffPositionChecker.isValid(position)) {
            System.out.print("Enter Staff position: ");
            position = inputReader.readLine();
        }

        System.out.print("Enter Staff salary: ");
        int salary = inputReader.readInt();

        University.addStaff(name, email, position, salary, age);
    }

    private static void manageCohorts() {
        int input;
        do {
            System.out.println("**** Cohort Management Menu ****");
            System.out.println("1. Show Cohorts");
            System.out.println("2. Add Cohort");
            System.out.println("3. Remove Cohort");
            System.out.print("Enter number (O.Back): ");
            input = inputReader.readInt();

            switch (input) {
                case 1:
                    showCohorts();
                    break;
                case 2:
                    addCohort();
                    break;
                case 3:
                    removeCohort();
                    break;
                default:
                    System.out.println("Wrong Number");
            }
        } while (input != 0);
    }

    private static void showCohorts() {
        University.printCohorts();
    }

    private static void addCohort() {

    }

    private static void removeCohort() {
        Scanner inputReader = new Scanner(System.in);

        showCohorts();

        System.out.println("Enter the index:");
        int index = inputReader.nextInt();

        University.removeCohort(index);
    }

    private static void manageCourses() {
        Scanner inputReader = new Scanner(System.in);
        int input;
        do {
            System.out.println("**** Courses Management Menu ****");
            System.out.println("1. Show Courses");
            System.out.println("2. Add Course");
            System.out.println("3. Remove Course");
            System.out.print("Enter number (O.Back): ");
            input = inputReader.nextInt();

            switch (input) {
                case 1:
                    showCourses();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    removeCohort();
                    break;
                default:
                    System.out.println("Wrong number");
            }
        } while (input != 0);
    }

    private static void showCourses() {
        University.printCourses();
    }

    private static void addCourse() {
        System.out.print("Enter course id: ");
        String id = inputReader.readLine();

        System.out.print("Enter course name: ");
        String name = inputReader.readLine();

        System.out.print("Enter course's credits: ");
        byte credits = inputReader.readByte();

        System.out.print("Enter course's credits: ");
        byte sessionsPerWeek = inputReader.readByte();

        University.addCourse(name, credits, id, sessionsPerWeek);
    }


    private static void manageTeachers() {
        int input;
        do {
            System.out.println("**** Teacher Management Menu ****");
            System.out.println("1. Show Teachers");
            System.out.println("2. Add Teacher");
            System.out.println("3. Remove Teacher");
            System.out.print("Enter number (O.Back): ");
            input = inputReader.readInt();

            switch (input) {
                case 1:
                    showTeachers();
                    break;
                case 2:
                    addTeacher();
                    break;
                case 3:
                    removeTeacher();
                    break;
                default:
                    System.out.println("Wrong number");
            }
        } while (input != 0);
    }

    private static void showTeachers() {
        University.printTeachers();
    }

    private static void addTeacher() {
        System.out.print("Enter teacher's name: ");
        String name = inputReader.readLine();

        System.out.print("Enter teacher's age: ");
        byte age = inputReader.readByte();

        System.out.print("Enter teacher's status: ");
        String status = inputReader.readLine();

        while (!TeacherStatusChecker.isValid(status)) {
            System.out.print("Enter teacher's status: ");
            status = inputReader.readLine();
        }

        System.out.print("Enter teacher's email: ");
        String email = inputReader.readLine();
        email = checkAndGetValidEmail(email);

        University.addTeacher(name, age, status, email);
    }

    private static void removeTeacher() {
        showTeachers();

        System.out.println("Enter the index:");
        int index = inputReader.readInt();

        University.removeTeacher(index);
    }

    private static void manageRooms() {
        int input;
        do {
            System.out.println("**** Room Management Menu ****");
            System.out.println("1. Show Rooms");
            System.out.println("2. Add Room");
            System.out.println("3. Remove Room");
            System.out.print("Enter number (O.Back): ");
            input = inputReader.readInt();

            switch (input) {
                case 1:
                    showRooms();
                    break;
                case 2:
                    addRoom();
                    break;
                case 3:
                    removeRoom();
                    break;
                default:
                    System.out.println("Wrong number");
            }
        } while (input != 0);
    }

    private static void showRooms() {
        University.printRooms();
    }

    private static void addRoom() {
        System.out.print("Enter room's number: ");
        short number = inputReader.readShort();

        System.out.print("Enter room's capacity: ");
        byte capacity = inputReader.readByte();

        System.out.print("Enter room's description: ");
        String description = inputReader.readLine();

        System.out.print("Enter room's busyness: ");
        boolean isBusy = inputReader.readBoolean();

        University.addRoom(number, capacity, description, isBusy);
    }

    private static void removeRoom() {
        showRooms();

        System.out.println("Enter the index:");
        int index = inputReader.readInt();

        University.removeRoom(index);
    }


    private static String checkAndGetValidEmail(String email) {
        if (EmailChecker.isValid(email)) {
            return email;
        }

        System.out.print("Enter teacher's email: ");
        email = inputReader.readLine();

        return checkAndGetValidEmail(email);
    }

    private static void manageGamingRooms() {
        int input;
        do {
            System.out.println("**** Gaming Room Management Menu ****");
            System.out.println("1. Show Gaming Rooms");
            System.out.println("2. Add Gaming Room");
            System.out.println("3. Book a place");
            System.out.println("4. Show bookings for a room");
            System.out.print("Enter number (O.Back): ");
            input = inputReader.readInt();

            switch (input) {
                case 1:
                    University.printGamingRooms();
                    break;
                case 2:
                    addGamingRoom();
                    break;
                case 3:
                    bookGamingRoom();
                    break;
                case 4:
                    showGamingRoomBookings();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong Number");
            }
        } while (input != 0);
    }
    
    private static void addGamingRoom() {
        System.out.print("Enter gaming room name: ");
        String name = inputReader.readLine();

        System.out.print("Enter capacity: ");
        int capacity = inputReader.readInt();

        University.addGamingRoom(name, capacity);
    }

    private static void bookGamingRoom() {
        University.printGamingRooms();
        System.out.print("Enter gaming room index to book: ");
        int index = inputReader.readInt();

        GamingRoom room = University.gamingRooms[index];
        if (room == null) {
            System.out.println("Invalid room index.");
            return;
        }

        System.out.print("Enter student email: ");
        String email = inputReader.readLine();
        email = checkAndGetValidEmail(email);

        boolean success = room.bookWithEmail(email);
        if (success) {
            System.out.println("Successfully booked a place in " + room.getName() + " for " + email);
        } else {
            System.out.println("Sorry, the gaming room is full.");
        }
    }

    private static void showGamingRoomBookings() {
        University.printGamingRooms();
        System.out.print("Enter gaming room index: ");
        int index = inputReader.readInt();

        GamingRoom room = University.gamingRooms[index];
        if (room == null) {
            System.out.println("Invalid room index.");
            return;
        }

        room.printBookings();
    }
}
