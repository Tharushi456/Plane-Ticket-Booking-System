import java.util.*;

public class PlaneManagement {
    // Define seatPlan and tickets arrays
    static int[][] seatPlan = new int[4][];
    static Ticket[] tickets = new Ticket[52];

    public static void main(String[] args) {
        // Initialize seatPlan arrays
        seatPlan[0] = new int[14];
        seatPlan[1] = new int[12];
        seatPlan[2] = new int[12];
        seatPlan[3] = new int[14];

        // Initialize seatPlan arrays with 0 (indicating all seats as available )
        for (int[] elements : seatPlan) {
            Arrays.fill(elements, 0);
        }

        // Initialize Scanner for user input
        Scanner scanner1 = new Scanner(System.in);
        // Display menu options
        System.out.println("""
                Welcome to the Plane Management application
                                
                ************************************************
                *                 MENU OPTIONS                 *
                ************************************************
                     1) Buy a seat
                     2) Cancel a seat
                     3) Find first available
                     4) Show seating plan
                     5) Print tickets information and total sales
                     6) Search ticket
                     0) Quit
                ************************************************""");

        // Loop for user interaction
        boolean userChoice = false;
        while (!userChoice) {
            try {
                // Prompt user to select an option
                System.out.print("\nPlease select an option: ");
                int option = scanner1.nextInt();

                // Process user's choice
                if (option == 1) {
                    // Buy a seat
                    buySeat();

                } else if (option == 2) {
                    // Cancel a seat
                    cancelSeat();

                } else if (option == 3) {
                    // Find the first available seat
                    findFirstAvailableSeat();

                } else if (option == 4) {
                    // Show seating plan
                    showSeatingPlan();

                } else if (option == 5) {
                    // Print tickets information and total sales
                    printTicketsInfo();

                } else if (option == 6) {
                    // Search for a ticket
                    searchTicket();

                } else if (option == 0) {
                    // Quit the application
                    System.out.println("Thank you for choosing us. Safe Travels!");
                    userChoice = true;
                } else {
                    // Invalid option
                    System.out.println("Invalid option. Try again.");
                }
            } catch (InputMismatchException e) {
                // Handle invalid input for menu option
                System.out.println("Invalid option. Try again.");
                scanner1.next();// Consume invalid input
            }
        }
        // Close scanner
        //scanner1.close();
    }


    // Method to buy a seat
    public static void buySeat() {
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Enter the row letter of the seat:  ");
        String rowLetter = scanner2.nextLine();
        while (true) {
            // Check if the entered row letter is valid
            if(rowLetter.equalsIgnoreCase("A") || rowLetter.equalsIgnoreCase("B")
                    || rowLetter.equalsIgnoreCase("C") || rowLetter.equalsIgnoreCase("D")){
                try {
                    System.out.print("Enter the seat number:");
                    int seatNumber = scanner2.nextInt();

                    // Validate the entered seat number
                    if (seatNumber < 1 || seatNumber > seatPlan[0].length) {
                        System.out.println("Invalid seat number. Please try again.");
                    } else {
                        // Process seat purchase based on the row letter
                        if (rowLetter.equalsIgnoreCase("A")) {
                            // Check seat availability in row A
                            if (seatPlan[0][seatNumber - 1] == 0) {
                                seatPlan[0][seatNumber - 1] = 1;
                                // Update seatPlan and add ticket information
                                AddSeatInfo(rowLetter, seatNumber);
                                System.out.println("Seat purchased successfully");

                            } else {
                                System.out.println("Seat is not available.");
                            }

                        } else if (rowLetter.equalsIgnoreCase("B")) {
                            // Check seat availability in row B
                            if (seatPlan[1][seatNumber - 1] == 0) {
                                seatPlan[1][seatNumber - 1] = 1;
                                // Update seatPlan and add ticket information
                                AddSeatInfo(rowLetter, seatNumber);
                                System.out.println("Seat purchased successfully");


                            } else {
                                System.out.println("Seat is not available.");
                            }

                        } else if (rowLetter.equalsIgnoreCase("C")) {
                            // Check seat availability in row C
                            if (seatPlan[2][seatNumber - 1] == 0) {
                                seatPlan[2][seatNumber - 1] = 1;
                                // Update seatPlan and add ticket information
                                AddSeatInfo(rowLetter, seatNumber);
                                System.out.println("Seat purchased successfully");

                            } else {
                                System.out.println("Seat is not available.");
                            }

                        } else if (rowLetter.equalsIgnoreCase("D")) {
                            // Check seat availability in row D
                            if (seatPlan[3][seatNumber - 1] == 0) {
                                seatPlan[3][seatNumber - 1] = 1;
                                // Update seatPlan and add ticket information
                                AddSeatInfo(rowLetter, seatNumber);
                                System.out.println("Seat purchased successfully");

                            } else {
                                System.out.println("Seat is not available.");
                            }

                        } else {
                            // Handle exceptions for invalid row letter
                            System.out.println("Invalid row letter. Please try again.");
                        }
                        break; // Break out of the loop if valid input is provided
                    }
                }catch (InputMismatchException | ArrayIndexOutOfBoundsException e){
                    // Handle exceptions related to input mismatch or array index out of bounds
                    scanner2.nextLine();
                    System.out.println("Invalid seat number. Please try again.");
                }



            } else {
                // Prompt for valid row letter if an invalid one is entered
                System.out.println("Invalid row letter. Please try again.");
                System.out.print("Enter the row letter of the seat:  ");
                rowLetter = scanner2.nextLine();
            }
        }

    }


    //Method to add information for a purchased seat
    private static void AddSeatInfo(String rowLetter, int seatNumber) {
        try {
            int seatPrice;
            // Determine seat price based on seat number
            if (seatNumber <= 5) {
                seatPrice = 200;
            } else if (seatNumber <= 9) {
                seatPrice = 150;
            } else {
                seatPrice = 180;
            }
            Scanner input2 = new Scanner(System.in);
            System.out.print("Enter name: "); // Prompt user to enter name
            String name = input2.nextLine();

            System.out.print("Enter surname: "); // Prompt user to enter surname
            String surname = input2.nextLine();

            System.out.print("Enter email: "); // Prompt user to enter email
            String email = input2.nextLine();

            // Create a Person object with entered information
            Person person = new Person(name, surname, email);

            // Create a Ticket object with seat information and associated person
            Ticket ticket = new Ticket(rowLetter, seatNumber, seatPrice, person);


            // Find the first available position in the tickets array and add the ticket
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] == null) {
                    tickets[i] = ticket;
                    ticket.save(); // Save ticket information
                    break;
                }
            }
        }catch (Exception e){
            System.out.print("Error! please enter again. ");
        }
    }



    // Method to cancel a seat
    public static void cancelSeat() {
        Scanner scanner3 = new Scanner(System.in);
        // Prompt user to enter the row letter of the seat
        System.out.print("Enter the row letter of the seat:  ");
        String rowLetter = scanner3.nextLine();

        // Loop until valid row letter is provided
        while (true) {
            // Check if the entered row letter is valid
            if(rowLetter.equalsIgnoreCase("A") || rowLetter.equalsIgnoreCase("B")
                    || rowLetter.equalsIgnoreCase("C") || rowLetter.equalsIgnoreCase("D")){
                try {
                    System.out.print("Enter the seat number:");
                    int seatNumber = scanner3.nextInt();

                    // Check if the seat number is within valid range
                    if (seatNumber < 1 || seatNumber > seatPlan[0].length) {
                        System.out.println("Invalid seat number. Please try again.");
                    } else {
                        if (rowLetter.equalsIgnoreCase("A")) {
                            // Check seat availability and cancel reservation if valid
                            if (seatPlan[0][seatNumber - 1] == 1) {
                                seatPlan[0][seatNumber - 1] = 0;
                                // Update seatPlan and remove ticket information
                                removeTicket(rowLetter, seatNumber);
                                System.out.println("Ticket cancelled successfully.");

                            } else {
                                System.out.println("Seat is available.");
                            }

                        } else if (rowLetter.equalsIgnoreCase("B")) {
                            // Check seat availability and cancel reservation if valid
                            if (seatPlan[1][seatNumber - 1] == 1) {
                                seatPlan[1][seatNumber - 1] = 0;
                                // Update seatPlan and remove ticket information
                                removeTicket(rowLetter, seatNumber);
                                System.out.println("Ticket cancelled successfully.");

                            } else {
                                System.out.println("Seat is available.");
                            }

                        } else if (rowLetter.equalsIgnoreCase("C")) {
                            // Check seat availability and cancel reservation if valid
                            if (seatPlan[2][seatNumber - 1] == 1) {
                                seatPlan[2][seatNumber - 1] = 0;
                                // Update seatPlan and remove ticket information
                                removeTicket(rowLetter, seatNumber);
                                System.out.println("Ticket cancelled successfully.");

                            } else {
                                System.out.println("Seat is available.");
                            }

                        } else if (rowLetter.equalsIgnoreCase("D")) {
                            // Check seat availability and cancel reservation if valid
                            if (seatPlan[3][seatNumber - 1] == 1) {
                                seatPlan[3][seatNumber - 1] = 0;
                                // Update seatPlan and remove ticket information
                                removeTicket(rowLetter, seatNumber);
                                System.out.println("Ticket cancelled successfully.");

                            } else {
                                System.out.println("Seat is available.");
                            }

                        } else {
                            // Handle exceptions for invalid row letter
                            System.out.println("Invalid row letter.");
                        }
                        break; // Break out of the loop if valid input is provided
                    }
                }catch (InputMismatchException | ArrayIndexOutOfBoundsException e){
                    scanner3.nextLine();
                    System.out.println("Invalid seat number. Please try again.");
                }



            } else {
                System.out.println("Invalid row letter. Please try again.");
                System.out.print("Enter the row letter of the seat:  ");
                rowLetter = scanner3.nextLine();
            }
        }
    }


    // Method to remove ticket information
    private static void removeTicket(String rowLetter, int seatNumber) {
        // Iterate through the tickets array
        for (int i = 0; i < tickets.length; i++) {
            // Check if the ticket matches the given row letter and seat number
            if (tickets[i] != null && tickets[i].getRowLetter().equalsIgnoreCase(rowLetter) &&
                    tickets[i].getSeatNumber() == seatNumber) {
                // Remove the ticket from the tickets array
                tickets[i] = null;
                break;  // Break the loop once the ticket is removed
            }
        }

    }




    // Method to find the first available seat
    public static void findFirstAvailableSeat() {
        boolean firstSeatFound = false;  // Flag to track if the first available seat is found

        // Iterate through seatPlan to find the first available seat
        for (int i = 0; i < seatPlan.length; i++) {
            for (int j = 0; j < seatPlan[i].length; j++) {
                if (seatPlan[i][j] == 0 && !firstSeatFound) {
                    // Return the row and seat number of the first available seat
                    if (i == 0){
                        System.out.println("First available seat found at A" + (j+1) );
                        firstSeatFound = true;
                        break;
                    } else if (i == 1) {
                        System.out.println("First available seat found at B" + (j+1) );
                        firstSeatFound = true;
                        break;
                    } else if (i == 2) {
                        System.out.println("First available seat found at C" + (j+1) );
                        firstSeatFound = true;
                        break;
                    }else if (i == 3) {
                        System.out.println("First available seat  found at D" + (j+1));
                        firstSeatFound = true;
                        break;
                    }
                }
            }
        }
        // Handle case when no seats are available
        if (!firstSeatFound) {
            System.out.println("No seats available");
        }
    }




    // Method to show seating plan
    public static void showSeatingPlan(){
        // Display the seating plan with 'O' for available seats and 'X' for booked seats
        for (int[] rows : seatPlan) {
            for (int seatNum : rows) {
                if (seatNum == 0) {
                    System.out.print("O"); // Print 'O' for available seats
                } else if (seatNum == 1) {
                    System.out.print("X"); // Print 'X' for booked seats
                }
            }
            System.out.println(); // Move to the next row in the seating plan
        }
    }



    // Method to print tickets information and total sales
    public static void printTicketsInfo() {
        int totalSales = 0; // Variable to store total sales
        System.out.println("\nTickets Information:");
        // Iterate through tickets array
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                ticket.printInfoOfATicket();  // Print information of each ticket
                totalSales += ticket.getSeatPrice();  // Calculate and print total sales
            }
        }
        // Check if there were no tickets booked
        if (totalSales == 0){
            System.out.println("No tickets were booked"); // Print message if no tickets were booked
        }else {
            System.out.println("Total Sales: £" + totalSales); // Print total sales if tickets were booked
        }
    }



    // Method to search for a ticket
    public static void searchTicket() {
        Scanner scanner4 = new Scanner(System.in);
        System.out.print("Enter the row letter of the seat:  ");
        String rowLetter = scanner4.nextLine(); // Read row letter input from the user

        while (true) {
            // Check if the provided row letter is valid
            if (rowLetter.equalsIgnoreCase("A") || rowLetter.equalsIgnoreCase("B")
                    || rowLetter.equalsIgnoreCase("C") || rowLetter.equalsIgnoreCase("D")) {
                try {
                    System.out.print("Enter the seat number:");
                    int seatNumber = scanner4.nextInt(); // Read seat number input from the user

                    int maxSeats;
                    // Determine the maximum seat number based on the row letter
                    if (rowLetter.equalsIgnoreCase("B") || rowLetter.equalsIgnoreCase("C")) {
                        maxSeats = seatPlan[1].length;
                    } else {
                        maxSeats = seatPlan[0].length;
                    }
                    // Check if the seat number is within valid range

                    if (seatNumber < 1 || seatNumber > maxSeats) {
                        System.out.println("Invalid seat number. Please try again.");
                    } else {
                        for (Ticket ticket : tickets) {
                            // Search for the ticket with the given row letter and seat number
                            if (ticket != null && ticket.getRowLetter().equalsIgnoreCase(rowLetter) &&
                                    ticket.getSeatNumber() == seatNumber) {
                                ticket.printInfoOfATicket();  // Print ticket information if found

                            }else {
                                // If no matching ticket is found, print a message indicating that the ticket is not found
                                System.out.println("This seat is available.");
                            }
                            break;
                        }
                        break; // Break out of the loop if valid input is provided
                    }
                } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                    // Handle exceptions related to input mismatch or array index out of bounds
                    scanner4.nextLine();
                    System.out.println("Invalid seat number. Please try again.");
                }


            } else {
                // Prompt for valid row letter if an invalid one is entered
                System.out.println("Invalid row letter. Please try again.");
                System.out.print("Enter the row letter of the seat:  ");
                rowLetter = scanner4.nextLine();
            }
        }
    }

}



