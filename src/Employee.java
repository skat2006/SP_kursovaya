public class Employee {
    private int id = 0;
    private String lastName;
    private String firstName;
    private String midName;
    private int department;
    private int salary;

    public Employee(int id, String lastName, String firstName, String midName, int department, int salary) {
            this.id = id;
            this.lastName = lastName.trim();
            this.firstName = firstName.trim();
            this.midName = midName.trim();
            this.department = department;
            this.salary = salary;
    }

    public Employee(int id, String FIO, int department, int salary) {
            this.id = id;
            setFIO(FIO.trim());
            this.department = department;
            this.salary = salary;
    }

    public String getFIO() {
        return getLastName() + " " + getFirstName() + " " + getMidName();
    }

    public boolean setFIO(String FIO) {
        String[] row = FIO.trim().split(" ");
        if (row.length > 2) {
            this.lastName = row[0];
            this.firstName = row[1];
            this.midName = row[2];
            return true;
        } else if (row.length > 1) {
            this.lastName = row[0];
            this.firstName = row[1];
            this.midName = null;
            return true;
        }
        return false;
    }

    public String getRowData() {
        return getId() + " " + getFIO() + " " + getDepartment() + " " + getSalary();
    }

    public String getRowDataNoDepartment() {
        return getId() + " " + getFIO() + " " + getSalary();
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
