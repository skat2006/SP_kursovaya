public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();

        book.getAllEmployees();
        book.delEmployeeByID(10);
        book.setEmployeeSalaryByID(11, 500_000);
        book.setEmployeeDepartmentByID(11, 5);

        book.getMaxSalaryID();
        book.getMinSalaryID();
        System.out.println("Месячный ФОТ: " + book.getTotalSalary() + " рублей\n");
        System.out.println("Средняя заработная плата " + book.getAverageSalary() + " рублей\n");
        book.getAllEmployeesFIO();
        book.setSalaryIndexation(20);
        book.getAllEmployees();

        int requestDepartment = 4;
        book.getAllDepartmentEmployees(requestDepartment);
        System.out.println("Месячный ФОТ отдела: " + book.getTotalSalary(requestDepartment) + " рублей\n");
        System.out.println("Средняя заработная плата в отделе " + book.getAverageSalary(requestDepartment) + " рублей\n");
        book.setSalaryIndexation(10, requestDepartment);
        book.getMinSalaryID(requestDepartment);
        book.getMaxSalaryID(requestDepartment);

        book.delEmployeeByFIO("Шикунов Андрей Владимирович");
        book.getAllDepartmentEmployees(2);
        book.getAllWithSalaryLowerThen(100_000);
        book.getAllWithSalaryHigherThen(100_000);

        book.addEmployee("Шикунов", "Андрей", "Владимирович", 2, 50_000);
        book.setEmployeeDepartmentByFIO("Шикунов Андрей Владимирович", 1);
        book.setEmployeeSalaryByFIO("Шикунов Андрей Владимирович",250_000);

        book.getAllEmployeesSortedByDepartments();
    }
}