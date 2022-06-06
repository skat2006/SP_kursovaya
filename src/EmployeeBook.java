public class EmployeeBook {
    private int size = 0;
    private int employeeID = 0;
    //private final String[] departments = new String[]{"None", "Администрация", "Бухгалтерия", "Кадры", "Технический", "Производство"}; //0.1.2.3.4.5
    private ArrayOfDepartment arrayOfDepartment;
    private Employee[] employees = new Employee[10]; //содержит информацию: ID, Ф., И., О., отделе, зарплате сотрудника.

    EmployeeBook() {
        addEmployee("Шикунов Андрей Владимирович", 4, 81000);
        addEmployee("Иванов", "Иван", "Владимирович", 1, 165000);
        addEmployee("Парфенова", "Ольга", "Ивановна", 2, 95000);
        addEmployee("Лизунов", "Игорь", "Павлович", 3, 69000);
        addEmployee("Дацук", "Иван", "Олегович", 1, 111000);
        addEmployee("Софрин", "Абрэк", "Улинович", 5, 31000);
        addEmployee("Дацук", "Ольга", "Серафимовна", 2, 50000);
        addEmployee("Соколов Иван Тарасович", 1, 165000);
        addEmployee("Парфенов", "Петр", "Константинович", 5, 44000);
        addEmployee("Ногов", "Александр", "Олегович", 4, 61000);
        addEmployee("Тарасов", "Тарас", "Тарасович", 1, 87000);
        addEmployee("Слухов", "Ибрагим", "Герасимович", 2, 75000);
        addEmployee("Панков Пан Панович", 4, 99000);
        addEmployee("Лепрозоев", "Лепрозорий", "Ильич", 1, 105000);
        addEmployee("Находкова", "Елена", "Петровна", 2, 88000);
    }

    public void addEmployee(String lastName, String firstName, String midName, int department, int salary) {
        if (lastName.trim().equals("") || firstName.trim().equals("")) {
            System.out.println("!!! - Имя или фамилия сотрудника заданы не верно! ЧЕЛОВЕК НЕ ДОБАВЛЕН!");
        } else {
            employees[size] = new Employee(employeeID, lastName, firstName, midName, department, salary);
            employeeID++;
            System.out.println(employees[size].getFIO() + " добавлен в базу");
            size++;
            if (size == employees.length) {
                employees = ArrayWork.increaseArray(employees);
            }
        }
    }

    public void addEmployee(String FIO, int department, int salary) {
        if (new Employee(employeeID, FIO, department, salary).setFIO(FIO.trim())) {
            employees[size] = new Employee(employeeID, FIO, department, salary);
            employeeID++;
            System.out.println(employees[size].getFIO() + " добавлен в базу");
            size++;
            if (size == employees.length) {
                employees = ArrayWork.increaseArray(employees);
            }
        } else {
            System.out.println("!!! - Имя или фамилия сотрудника заданы не верно! ЧЕЛОВЕК НЕ ДОБАВЛЕН!");
        }
    }

    private int findEmployeeByID(int ID) {
        for (int i = 0; i < size; i++) {
            if (ID == employees[i].getId()) {
                return i;
            }
        }
        return -1;
    }

    public String getEmployeeByID(int ID) {
        int foundEmployee = findEmployeeByID(ID);
        if (foundEmployee != -1) {
            return employees[foundEmployee].getRowData();
        }
        return "Работник с ID:" + ID + " не найден.";
    }

    public void getAllEmployees() {
        System.out.println("Список сотрудников (" + size + " чел.):   ( ID Фамилия Имя Отчество Отдел Зарплата )");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i].getRowData());
        }
        System.out.println();
    }

    public void getAllEmployeesFIO() {
        System.out.println("Список сотрудников (" + size + " чел.):   ( Фамилия Имя Отчество )");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i].getFIO());
        }
        System.out.println();
    }

    public void getAllDepartmentEmployees(int department) {
        if (ArrayWork.checkDepartment(department)) {
            arrayOfDepartment = new ArrayOfDepartment(employees, size, department);
            arrayOfDepartment.getAllDepartmentEmployees(true);
        }
    }

    public void getAllEmployeesSortedByDepartments() {
        System.out.println("Список по отделам:");
        for (int department = 1; department < 6; department++) {
            arrayOfDepartment = new ArrayOfDepartment(employees, size, department);
            arrayOfDepartment.getAllDepartmentEmployees(false);
        }
    }

    public int getSize() {
        return size;
    }

    public void getMaxSalaryID() {
        int ID = ArrayWork.findIDofMinMaxSalary(true, employees, size);
        if (ID != -1) {
            System.out.println("Самая большая ЗП у: " + getEmployeeByID(ID) + "\n");
        } else {
            System.out.println("Ошибка поиска максимальной ЗП.\n");
        }
    }

    public void getMaxSalaryID(int department) {
        if (ArrayWork.checkDepartment(department)) {
            arrayOfDepartment = new ArrayOfDepartment(employees, size, department);
            int ID = ArrayWork.findIDofMinMaxSalary(true, arrayOfDepartment.getDepartmentArray(), arrayOfDepartment.getSize());
            if (ID != -1) {
                System.out.println("Самая большая ЗП у: " + getEmployeeByID(ID) + "\n");
            } else {
                System.out.println("Ошибка поиска максимальной ЗП.\n");
            }
        }
    }

    public void getMinSalaryID() {
        int ID = ArrayWork.findIDofMinMaxSalary(false, employees, size);
        if (ID != -1) {
            System.out.println("Самая маленькая ЗП у: " + getEmployeeByID(ID) + "\n");
        } else {
            System.out.println("Ошибка поиска минимальной ЗП.\n");
        }
    }

    public void getMinSalaryID(int department) {
        if (ArrayWork.checkDepartment(department)) {
            arrayOfDepartment = new ArrayOfDepartment(employees, size, department);
            int ID = ArrayWork.findIDofMinMaxSalary(false, arrayOfDepartment.getDepartmentArray(), arrayOfDepartment.getSize());
            if (ID != -1) {
                System.out.println("Самая маленькая ЗП у: " + getEmployeeByID(ID) + "\n");
            } else {
                System.out.println("Ошибка поиска максимальной ЗП.\n");
            }
        }
    }

    public void getAllWithSalaryLowerThen(int salary) {
        Employee[] arrayOfEmployees = new Employee[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() < salary) {
                arrayOfEmployees[count] = employees[i];
                count++;
            }
        }
        System.out.println("Найдено работников с з/п меньше " + salary + " (" + count + "чел.):");
        for (int i = 0; i < count; i++) {
            System.out.println(arrayOfEmployees[i].getRowDataNoDepartment());
        }
        System.out.println();
    }

    public void getAllWithSalaryHigherThen(int salary) {
        Employee[] arrayOfEmployees = new Employee[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() >= salary) {
                arrayOfEmployees[count] = employees[i];
                count++;
            }
        }
        System.out.println("Найдено работников с з/п больше или равной " + salary + " (" + count + "чел.):");
        for (int i = 0; i < count; i++) {
            System.out.println(arrayOfEmployees[i].getRowDataNoDepartment());
        }
        System.out.println();
    }

    public int getTotalSalary() {
        int summary = 0;
        for (int i = 0; i < size; i++) {
            summary += employees[i].getSalary();
        }
        return summary;
    }

    public int getTotalSalary(int department) {
        if (ArrayWork.checkDepartment(department)) {
            int summary = 0;
            for (int i = 0; i < size; i++) {
                if (employees[i].getDepartment() == department) {
                    summary += employees[i].getSalary();
                }
            }
            return summary;
        }
        return -1;
    }

    public int getAverageSalary() {
        return getTotalSalary() / (size);
    }

    public int getAverageSalary(int department) {
        if (ArrayWork.checkDepartment(department)) {
            arrayOfDepartment = new ArrayOfDepartment(employees, size, department);
            return getTotalSalary(department) / arrayOfDepartment.getSize();
        }
        return -1;
    }

    public void setEmployeeDepartmentByID(int ID, int department) {
        if (ArrayWork.checkDepartment(department)) {
            int row = findEmployeeByID(ID);
            if (row != -1) {
                employees[row].setDepartment(department);
                System.out.println("Работник с ID " + ID + " переведен в отдел " + department + "\n");
            } else {
                System.out.println("Перевод: работник с ID " + ID + " не найден.\n");
            }
        }
    }

    public void setEmployeeDepartmentByFIO(String FIO, int department) {
        int row = ArrayWork.findEmployeeRowByFIO(employees, size, FIO);
        if (row != -1) {
            employees[row].setDepartment(department);
            System.out.println("Работник " + FIO + " переведен в отдел " + department + "\n");
        } else {
            System.out.println("Перевод: работник " + FIO + " не найден.\n");
        }
    }

    public void setEmployeeSalaryByID(int ID, int salary) {
        int row = findEmployeeByID(ID);
        if (row != -1) {
            employees[row].setSalary(salary);
            System.out.println("Зарплата работника с ID " + ID + " изменена на " + salary + "\n");
        } else {
            System.out.println("ЗП: работник с ID " + ID + " не найден.\n");
        }
    }

    public void setEmployeeSalaryByFIO(String FIO, int salary) {
        int row = ArrayWork.findEmployeeRowByFIO(employees, size, FIO);
        if (row != -1) {
            employees[row].setSalary(salary);
            System.out.println("Зарплата работника " + FIO + " изменена на " + salary + "\n");
        } else {
            System.out.println("ЗП: работник " + FIO + " не найден.\n");
        }
    }

    public void setSalaryIndexation(int percent) {
        for (int i = 0; i < size; i++) {
            float increasedSalary = employees[i].getSalary() * (1 + ((float) percent / 100));
            employees[i].setSalary((int) increasedSalary);
        }
        System.out.println("Индексация на " + percent + "% осуществлена.\n");
    }

    public void setSalaryIndexation(int percent, int department) {
        if (ArrayWork.checkDepartment(department)) {
            arrayOfDepartment = new ArrayOfDepartment(employees, size, department);
            for (int i = 0; i < arrayOfDepartment.getSize(); i++) {
                float increasedSalary = arrayOfDepartment.getDepartmentArray()[i].getSalary() * (1 + ((float) percent / 100));
                arrayOfDepartment.getDepartmentArray()[i].setSalary((int) increasedSalary);
            }
            System.out.println("Индексация в отделе " + department + " на " + percent + "% осуществлена.\n");
        }
    }

    private void delEmployeeRow(int row) {
        if (size - row >= 0) {
            System.arraycopy(employees, row + 1, employees, row, size - row);
            size--;
        }
    }

    public void delEmployeeByID(int ID) {
        int row = findEmployeeByID(ID);
        if (row != -1) {
            delEmployeeRow(row);
            System.out.println("Работник с ID " + ID + " удален.\n");
            return;
        }
        System.out.println("Работник с ID " + ID + " не найден.\n");
    }

    public void delEmployeeByFIO(String FIO) {
        int row = ArrayWork.findEmployeeRowByFIO(employees, size, FIO);
        if (row != -1) {
            delEmployeeRow(row);
            System.out.println("Работник " + FIO + " удален.\n");
        } else {
            System.out.println("Работник " + FIO + " не найден.\n");
        }
    }
}
