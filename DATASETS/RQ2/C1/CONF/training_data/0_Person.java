public class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;
    
    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
    
    @Override
    public String toString() {
        return "Person: " + name;
    }
}

public class Employee extends Person {
    private int employeeId;
    
    public Employee(String name, String address, String phoneNumber, String emailAddress, int employeeId) {
        super(name, address, phoneNumber, emailAddress);
        this.employeeId = employeeId;
    }
    
    @Override
    public String toString() {
        return "Employee: " + super.toString();
    }
}
