public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String newFullName, String newPosition, String newEmail, String newPhoneNumber, int newSalary, int newAge) {
        fullName = newFullName;
        position = newPosition;
        email = newEmail;
        phoneNumber = newPhoneNumber;
        salary = newSalary;
        age = newAge;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "fullName = '" + fullName + '\'' +
                ", position = '" + position + '\'' +
                ", email = '" + email + '\'' +
                ", phoneNumber = " + phoneNumber +
                ", salary = " + salary +
                ", age = " + age +
                '}';
    }

    public void print() {
        System.out.println(this);
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        final int SIZE = 5;
        Employee[] persArray = new Employee[SIZE];
        persArray[0] = new Employee("Ivanov Ivan Ivanovich", "Engineer", "ivivan@mailbox.com", "89813454312", 30130, 41);
        persArray[1] = new Employee("Sidorov Oleja", "Programmer", "iasdcdn@mailbox.com", "89233454312", 43000, 30);
        persArray[2] = new Employee("Jsdcsd al-Aclk Scds", "Tester", "aasdcvan@mailbox.com", "89272543312", 12000, 47);
        persArray[3] = new Employee("Asdccsd Ddclk", "Designer", "fgbff@mailbox.com", "89334522312", 48000, 17);
        persArray[4] = new Employee("Qsdcsd Ddlk Dscsd", "Manager", "ewtfvgf@mailbox.com", "8926459182", 92000, 44);
        System.out.println("Only 40+ years old employees:");
        for (int i = 0; i < SIZE; i++) {
            if (persArray[i].getAge() > 40) persArray[i].print();
        }
    }
}
