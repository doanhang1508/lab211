/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doctor_manager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Thanh Hang
 */
public class DoctorHash {

    private HashMap<String, Doctor> data;

    public DoctorHash() {
        data = new HashMap<>();
    }

    public boolean addDoctor(Doctor doctor) {
        data.put(doctor.getCode(), doctor);
        return true;
    }

    public boolean updateDoctor(Doctor doctor) {
        data.replace(doctor.getCode(), doctor);
        return true;
    }

    public boolean deleteDoctor(Doctor doctor) {
        if (!data.containsKey(doctor.getCode())) {
            System.err.println("Data don't have this code");
            return false;
        }
        data.remove(doctor.getCode());
        return true;
    }

    public HashMap<String, Doctor> searchDoctor(String input) {
        HashMap<String, Doctor> result = new HashMap<>();
        for (Doctor d : data.values()) {
            if (d.getCode().trim().toLowerCase().contains(input.toLowerCase())
                    || d.getName().trim().toLowerCase().contains(input.toLowerCase())
                    || d.getSpecialization().trim().toLowerCase().contains(input.toLowerCase())) {
                result.put(d.getCode(), d);
            }
        }
        return result;
    }

    public HashMap<String, Doctor> getData() {
        return data;
    }

    public boolean checkData() {
        if (data.isEmpty()) {
            System.err.println("Database is empty");
            return false;
        }
        return true;
    }

    public void displayAll() {
        System.out.printf("%-10s %-15s %-20s %-12s\n", "Code", "Name", "Spec", "Avail");
        for (Doctor d : data.values()) {

            System.out.println(d);
        }
    }

    public void sortByCode() {
        List<Doctor> list = new ArrayList<>(data.values());

        // Bubble Sort theo Code
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getCode().compareTo(list.get(j + 1).getCode()) > 0) {
                    // đổi chỗ
                    Doctor temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

        // In kết quả
        System.out.printf("%-10s %-15s %-20s %-12s\n",
                "Code", "Name", "Specialization", "Availability");
        for (Doctor d : list) {
            System.out.printf("%-10s %-15s %-20s %-12d\n",
                    d.getCode(), d.getName(), d.getSpecialization(), d.getAvailability());
        }
    }

    public void sortByName() {
        List<Doctor> list = new ArrayList<>(data.values());

        // Bubble Sort theo Name
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getName().compareTo(list.get(j + 1).getName()) > 0) {
                    // đổi chỗ
                    Doctor temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

        // In kết quả
        System.out.printf("%-10s %-15s %-20s %-12s\n",
                "Code", "Name", "Specialization", "Availability");
        for (Doctor d : list) {
            System.out.printf("%-10s %-15s %-20s %-12d\n",
                    d.getCode(), d.getName(), d.getSpecialization(), d.getAvailability());
        }
    }

}
