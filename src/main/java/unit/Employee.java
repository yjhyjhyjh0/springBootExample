package unit;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;


    public Employee(int id, String f, String l, String e) {
        this.id = id;
        this.firstName = f;
        this.lastName = l;
        this.emailAddress = e;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAdress) {
        this.emailAddress = emailAdress;
    }
}
