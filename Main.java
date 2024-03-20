package com.payroll;

import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    //Ctor
    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    //abstract method
    public abstract double calculateSalary();
    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }


}
class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary=monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }

}

class PartTimeEmployee extends Employee{

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name, id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked*hourlyRate;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){//class ka ctor h , mtlb ki jb PayrollSystem chalega to ye ek nya arraylist bna dega employeelist naam ka

        employeeList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee:employeeList){
            if(employee.getId() == id){
                employeeToRemove = employee;
                System.out.println(employee);
                break;
            }
        }
        if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees(){
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }

}

public class Main{
    public static void main(String[] args){
        PayrollSystem ps = new PayrollSystem();
        FullTimeEmployee e1 = new FullTimeEmployee("Rishika", 1,70000);
        PartTimeEmployee e2 = new PartTimeEmployee("Alexander", 2, 2,40);
        ps.addEmployee(e1);
        ps.addEmployee(e2);
        System.out.println("Initial Employee Details: ");
        ps.displayEmployees();
        System.out.println("Removing Employee:");
        ps.removeEmployee(2);
        System.out.println("Remaining Employee Details: ");
        ps.displayEmployees();
    }
}
