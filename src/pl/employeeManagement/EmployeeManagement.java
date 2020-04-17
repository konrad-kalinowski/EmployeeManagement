package pl.employeeManagement;

import Model.Department;
import Model.Employee;
import Model.Gender;
import Model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    public static void main(String[] args) {

        Department sales = new Department("Sprzedaż", "2. piętro, pokoje 2.11 - 2.30");
        Department management = new Department("Zarząd", "4. piętro");

        Position director = new Position("Dyrektor", 12000,
                15000);
        Position expert = new Position("Ekspert", 7000,
                9000);

        Gender female = new Gender("F", 60);
        Gender male = new Gender("M", 65);


        Employee nowak = new Employee("Jan Nowak", male, 22000,
                1955, 1990, new Position("Prezes", 18000,
                25000), management);

        Employee mucha = new Employee("Anna Maria Mucha", female, 14000,
                1968, 1991, director, sales);

        Employee srubka = new Employee("Karol Marek Śrubka", male, 7500, 2000,
                1972, 2010, expert, sales);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(nowak);
        employees.add(mucha);
        employees.add(srubka);

        ArrayList<Department> departments = new ArrayList<>();
        departments.add(sales);
        departments.add(management);

        ArrayList<Position> positions = new ArrayList<>();
        positions.add(expert);
        positions.add(director);

        Scanner command = new Scanner(System.in);


        while (true) {
            System.out.println("Dostępne komendy: pracownik, dział, zakończ");
            System.out.println("Wprowadź komende: ");

            switch (command.nextLine()) {
                case "pracownik":
                    System.out.println("Wprowadź dane osobowe pracownika");
                    String employeeName = command.nextLine();
                    Employee employee = findEmployee(employees, employeeName);
                    if (employee == null) {
                        System.out.println("Nie znaleziono " + employeeName);
                    } else {
                        employee.printEmployeeDescription();
                        System.out.println("Czy chcesz edytować dane tego pracownika? (t/n)");
                        String nextLine = command.nextLine();
                        if (nextLine.startsWith("t")) {
                            System.out.println("Dostępne opcje: 1.Pensja 2.Stanowisko");
                            int option = Integer.parseInt(command.nextLine());
                            if (option == 1) {
                                System.out.println("Wprowadź nową pensję: ");
                                double newSalary = Double.parseDouble(command.nextLine());
                                if (!employee.isSalaryValid(newSalary)) {
                                    System.out.println("Wartość poza zakresem pozycji");
                                }
                                employee.setSalary(newSalary);
                                System.out.println("Zapisano.");
                            } else if (option == 2) {
                                System.out.println("Wprowadź nowe stanowisko: ");
                                String newPositionName = command.nextLine();
                                Position foundPosition = findPosition(positions, newPositionName);
                                if (foundPosition == null) {
                                    System.out.println("Nie znalezino takiej pozycji.");
                                } else {
                                    employee.setPosition(foundPosition);
                                    System.out.println("Zmieniono stanowisko.");
                                }
                            }
                        }
                    }
                    break;

                case "dział":
                    System.out.println("Wprowadź nazwę działu: ");
                    String departmentName = command.nextLine();
                    Department department = findDepartment(departments, departmentName);
                    if (department == null) {
                        System.out.println("Nie znaleziono " + department);
                    } else {
                        System.out.println(department.getDepartmentDescription());
                    }
                    break;
                case "zakończ":
                    command.close();
                    return;
                default:
                    System.out.println("Nie rozpoznano komendy.");
                    break;
            }
        }


    }

    public static Employee findEmployee(List<Employee> employees, String name) {
        for (Employee employee : employees) {
            if (name.equals(employee.getName())) {
                return employee;
            }
        }
        return null;
    }

    public static Department findDepartment(List<Department> departments, String name) {
        for (Department department : departments) {
            if (name.equals(department.getName())) {
                return department;
            }
        }
        return null;
    }

    public static Position findPosition(List<Position> positions, String name) {
        for (Position position : positions) {
            if (name.equals(position.getName())) {
                return position;
            }
        }
        return null;
    }


}
