package com.example.EmployeeRestWebService.model;

public class Emoplyee {


    private int employeeId;
    private String name;
    private String email;
    private long salary;

    public Emoplyee(int employeeId, String name, String email, long salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    //-----------------------------------------------------------------


    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getSalary() {
        return salary;
    }
}
