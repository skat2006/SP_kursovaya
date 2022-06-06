public class ArrayOfDepartment{
    private final int department;
    private int size = 0;
    private Employee[] departmentArray;

    public ArrayOfDepartment(Employee[] arrayOfRequest, int arraySize, int department) {
        this.department = department;
        this.departmentArray = new Employee[10];

        for (int i = 0; i < arraySize; i++) {
            if (arrayOfRequest[i].getDepartment() == department) {
                departmentArray[size] = arrayOfRequest[i];
                size++;
                if (size == departmentArray.length) {
                    departmentArray = ArrayWork.increaseArray(departmentArray);
                }
            }
        }
    }

    public void getAllDepartmentEmployees(boolean withIDAndSalary) {
        System.out.println("Сотрудники отдела " + department + " (" + size + " чел.):");
        for (int i = 0; i < size; i++) {
            if (withIDAndSalary) {
                System.out.println(departmentArray[i].getId() + " " + departmentArray[i].getFIO() + " " + departmentArray[i].getSalary());
            } else {
                System.out.println((i+1) + ") " + departmentArray[i].getFIO());
            }
        }
        System.out.println();
    }

    public int getDepartment() {
        return department;
    }

    public int getSize() {
        return size;
    }

    public Employee[] getDepartmentArray() {
        return departmentArray;
    }
}
