package homeWorks.homeWork14.task3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;


    public Employee(String name, String company, int salary, int age) {
        setName(name);
        setCompany(company);
        setSalary(salary);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    /**
     * Метод генерации объектов класса Employee
     * @param num Количество объектов
     * @return Список объектов класса Employee
     */
    public static List<Employee> employeeGenerator(int num){
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"};
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"};

        ArrayList<Employee> employees = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < num; i++) {
            int age = random.nextInt(40) + 21;
            int salary = random.nextInt(150000);
            String name = names[random.nextInt(names.length)];
            String company = companies[random.nextInt(companies.length)];

            employees.add(new Employee(name, company, salary, age));
        }

        return employees;
    }

    public static class NameComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class SalaryComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getSalary(), o2.getSalary());
        }
    }

    public static class AgeComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }

    public static class CompanyComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getCompany().compareTo(o2.getCompany());
        }
    }
}
