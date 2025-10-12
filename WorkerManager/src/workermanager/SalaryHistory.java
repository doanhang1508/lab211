/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workermanager;

/**
 *
 * @author Thanh Hang
 */
public class SalaryHistory {
    private String id;
    private String name;
    private int age;
    private double salary;
    private String status;
    private String date; // Lưu dạng chuỗi dd/MM/yyyy

    public SalaryHistory(String id, String name, int age, double salary, String status, String date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
        this.date = date;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getStatus() { return status; }
    public String getDate() { return date; }
}
