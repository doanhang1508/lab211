/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workermanager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author Thanh Hang
 */
public class Manager {
    private HashMap<String, Worker> workers = new HashMap<>();
    private ArrayList<SalaryHistory> history = new ArrayList<>();

    /**
     * Thêm nhân viên mới vào danh sách (HashMap).
     */
    public boolean addWorker(Worker worker) throws Exception {
        if (workers.containsKey(worker.getId()))
            throw new Exception("Duplicate worker code!");
        if (worker.getAge() < 18 || worker.getAge() > 50)
            throw new Exception("Age must be between 18 and 50!");
        if (worker.getSalary() <= 0)
            throw new Exception("Salary must be greater than 0!");

        workers.put(worker.getId(), worker);
        return true;
    }

    /**
     * Tăng hoặc giảm lương cho nhân viên.
     */
    public boolean changeSalary(String status, String code, double amount) throws Exception {
        Worker w = workers.get(code);
        if (w == null) throw new Exception("Worker not found!");
        if (amount <= 0) throw new Exception("Amount must be greater than 0!");

        if (status.equalsIgnoreCase("UP")) {
            w.setSalary(w.getSalary() + amount);
        } else if (status.equalsIgnoreCase("DOWN")) {
            w.setSalary(w.getSalary() - amount);
        } else {
            throw new Exception("Invalid status!");
        }

        // Nhập ngày từ người dùng
        String date = Validation.checkDate();

        // Lưu lịch sử điều chỉnh
        history.add(new SalaryHistory(w.getId(), w.getName(), w.getAge(), w.getSalary(),
                status.toUpperCase(), date));
        return true;
    }

    /**
     * Hiển thị danh sách thông tin điều chỉnh lương.
     */
    public void displayInformationSalary() {
        if (history.isEmpty()) {
            System.out.println("No worker has adjusted salary yet.");
            return;
        }

        System.out.println("-------------Display Information Salary--------------");
        System.out.printf("%-10s %-15s %-5s %-10s %-10s %-12s\n",
                "Code", "Name", "Age", "Salary", "Status", "Date");

      Comparator<SalaryHistory> byId = new Comparator<SalaryHistory>() {
            @Override
            public int compare(SalaryHistory o1, SalaryHistory o2) {
                return o1.getId().compareTo(o2.getId());
            }
            
        };
        history.sort(byId);

        for (SalaryHistory h : history) {
            System.out.printf("%-10s %-15s %-5d %-10.0f %-10s %-12s\n",
                    h.getId(), h.getName(), h.getAge(),
                    h.getSalary(), h.getStatus(), h.getDate());
        }
    }

    /**
     * (Tùy chọn) Lấy danh sách tất cả worker.
     */
    
    public HashMap<String, Worker> getData() {
        return workers;
    }
}

