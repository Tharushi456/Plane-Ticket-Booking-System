public class Person {
    private String name;  // The name of the person
    private String surname;  // The surname of the person
    private String email;  // The email address of the person



    // Constructor to initialize a Person object with provided name, surname, and email
    public Person(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    //Getters and Setters
    public String getName() {

        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {

        return this.surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getEmail() {

        return this.email;
    }

    public void setEmail(String email) {

        this.email = email;
    }


    // Method to print information of the person
    public void printInfoOfPerson() {
        System.out.println("Name: " + this.name);
        System.out.println("Surname: " + this.surname);
        System.out.println("Email: " + this.email);
        System.out.println("  ");
    }
}












