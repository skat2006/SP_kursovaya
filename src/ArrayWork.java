public class ArrayWork {
    public static int findIDofMinMaxSalary(boolean needMax, Employee[] array, int arrSize) {
        int salary = array[0].getSalary();
        int ID = array[0].getId();
        for (int i = 1; i < arrSize; i++) {
            if (needMax) {
                if (salary < array[i].getSalary()) {
                    salary = array[i].getSalary();
                    ID = array[i].getId();
                }
            } else {
                if (salary > array[i].getSalary()) {
                    salary = array[i].getSalary();
                    ID = array[i].getId();
                }
            }
        }
        return ID;
    }

    public static Employee[] increaseArray(Employee[] array) {
        Employee[] newArray = new Employee[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    public static boolean checkDepartment(int department) {
        if (department > 0 && department < 6) return true;
        System.out.println("\nОтдел задан не верно!\n");
        return false;
    }

    public static int findEmployeeRowByFIO(Employee[] array, int size, String FIO) {
        int row = -1;
        for (int i = 0; i < size; i++) {
            if (FIO.equals(array[i].getFIO())) {
                row = i;
            }
        }
        return row;
    }
}
