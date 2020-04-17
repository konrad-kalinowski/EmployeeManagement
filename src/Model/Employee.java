package Model;

public class Employee {


    private static final int CURRENT_YEAR = 2020;
    private final String name;
    private final int birthYear;
    private final Gender gender;
    private final int hireYear;
    private Position position;
    private final Department department;
    private double salary;
    private final double salarySupplement;

    public Employee(String name, Gender gender, double salary, double salarySupplement, int birthYear,
                    int hireYear, Position position,
                    Department department) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.hireYear = hireYear;
        this.position = position;
        this.department = department;
        this.salary = salary;
        this.salarySupplement = salarySupplement;
    }

    public Employee(String name, Gender gender, double salary, int birthYear,
                    int hireYear, Position position,
                    Department department) {
        this(name, gender, salary, 0, birthYear, hireYear, position, department);

    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Gender getGender() {
        return gender;
    }

    public int getHireYear() {
        return hireYear;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        if (newSalary < this.position.getMinPayment()) {
            newSalary = this.position.getMinPayment();
        } else if (newSalary > this.position.getMaxPayment()) {
            newSalary = this.position.getMaxPayment();
        }
        this.salary = newSalary;
    }

    public boolean isSalaryValid(double newSalary) {
        return newSalary >= this.position.getMinPayment() && newSalary <= this.position.getMaxPayment();
    }

    public double getSalarySupplement() {
        return salarySupplement;
    }

    public int calculateDurationOfEmployment() {
        return CURRENT_YEAR - this.hireYear;
    }

    public int calculateAge() {
        return CURRENT_YEAR - this.birthYear;
    }

    public int calculateYearsToTheRetirement() {
        return this.gender.getRetirementAge() - calculateAge();
    }

    public double calculateFullSalary() {
        return salary + salarySupplement;
    }

    public double calculateSalaryAfterTaxes() {
        return this.calculateFullSalary() * 0.82;
    }

    public void printEmployeeDescription() {
        System.out.println(name + " Okres zatrudnienia w latach: " + calculateDurationOfEmployment());
        System.out.println("WIek: " + calculateAge());
        System.out.println("Liczna lat do emerytury: " + calculateYearsToTheRetirement());
        System.out.println("Całkowite wynagrodzenie: " + calculateFullSalary());
        System.out.println("Wynagrodzenie po opodatkowaniu: " + calculateSalaryAfterTaxes());
    }


}
