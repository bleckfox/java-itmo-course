package homeWorks.homeWork14.task3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<Employee> employeeList = Employee.employeeGenerator(20);

        Comparator<Employee> nameComparator = new Employee.NameComparator();
        Comparator<Employee> salaryComparator = new Employee.SalaryComparator();
        Comparator<Employee> ageComparator = new Employee.AgeComparator();
        Comparator<Employee> companyComparator = new Employee.CompanyComparator();

        // 2. Отсортировать employeeList: 2.1. по имени
        Collections.sort(employeeList, nameComparator);

        // 2. Отсортировать employeeList: 2.1. по имени и зп
       Collections.sort(
               employeeList,
               nameComparator
                       .thenComparing(salaryComparator)
       );

        // 2. Отсортировать employeeList: 2.1. по имени, зп, возрасту, компании
        Collections.sort(
                employeeList,
                nameComparator
                        .thenComparing(salaryComparator)
                        .thenComparing(ageComparator)
                        .thenComparing(companyComparator)
        );

    }
}
