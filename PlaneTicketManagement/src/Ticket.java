import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    private String rowLetter;
    private int seatNumber;
    private int seatPrice;
    private Person person;

    //Constructor
    public Ticket(String rowLetter, int seatNumber, int seatPrice, Person person) {
        this.rowLetter = rowLetter;
        this.seatNumber = seatNumber;
        this.seatPrice = seatPrice;
        this.person = person;
    }


    //Getters and Setters
    public String getRowLetter() {

        return this.rowLetter;
    }

    public void setRowLetter(String row) {

        this.rowLetter = row;
    }

    public int getSeatNumber() {

        return this.seatNumber;
    }

    public void setSeatNumber(int seat) {

        this.seatNumber = seat;
    }

    public int getSeatPrice() {
        return this.seatPrice;
    }

    public void setSeatPrice(int price) {

        this.seatPrice = price;
    }

    public Person getPerson() {

        return this.person;
    }

    public void setPerson(Person person) {

        this.person = person;
    }

    // Method to print information of the ticket
    public void printInfoOfATicket() {
        System.out.println("\nRow: " + this.rowLetter);
        System.out.println("Seat: " + this.seatNumber);
        System.out.println("Price: " + this.seatPrice);
        System.out.println("Person Information");
        person.printInfoOfPerson();  // Utilize the printInfo method from Person class
    }

    public void save(){
        // Generate filename based on row letter and seat number
        String filename = this.rowLetter.toUpperCase() + this.seatNumber + ".txt";
        // Create a File object with the generated filename
        File file = new File(filename);

        try {
            // Create a FileWriter object to write to the file
            FileWriter myWriter = new FileWriter(filename + ".txt");


            // Write ticket information to the file
            myWriter.write("Row: " + getRowLetter().toUpperCase() + "\n");
            myWriter.write("Seat Number: " + getSeatNumber() + "\n");
            myWriter.write("Price: " + getSeatPrice() + "\n");
            myWriter.write("Person Information:\n");
            myWriter.write("Name: " + person.getName() + "\n");
            myWriter.write("Surname: " + person.getSurname() + "\n");
            myWriter.write("Email: " + person.getEmail() + "\n");
            myWriter.close();  // Close the FileWriter

        }catch (IOException e){
            // Handle any IOException that might occur during file writing
            System.out.println("An error occurred.");
        }
    }


}
