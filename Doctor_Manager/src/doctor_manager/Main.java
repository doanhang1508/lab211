/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package doctor_manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static Scanner sc = new Scanner(System.in);

    private static DoctorHash dh = new DoctorHash();

    public static void main(String[] args) {
       while (true) {
            System.out.println("\nDOCTOR MANAGEMENT PROGRAM");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Display");
            System.out.println("6. sortByCode");
            System.out.println("7. sortByName");
            System.out.println("8. Exit");


            int choice = Validation.inputInteger("Enter your choice: ", 1, 8);
            try {
                switch (choice) {
                    case 1: addDoctorUI(); break;
                    case 2: if(dh.checkData()) updateDoctorUI(); break;
                    case 3: if(dh.checkData()) deleteDoctorUI(); break;
                    case 4: if(dh.checkData()) searchDoctorUI(); break;
                    case 5 :if(dh.checkData()) dh.displayAll();break;
                    case 6: if(dh.checkData()) dh.sortByCode(); break;
                    case 7: if(dh.checkData()) dh.sortByName(); break;
                    case 8:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    public static void addDoctorUI(){
        System.out.println("---Add Doctor---");
        String code;
        while(true){
            code = Validation.inputString("Enter code: ", "[A-Za-z0-9 ]+").trim().toUpperCase();
            if(dh.getData().containsKey(code)){
                System.err.println("Doctor code is duplicated");
            }else{
                break;
            }  
        }
        
        String name = Validation.inputString("Enter name: ", "[A-Za-z ]+");
        String spec = Validation.inputString("Enter specialization: ", "[A-Za-z ]+");
        String avail = Validation.inputAvailability("Enter availability: ","[0-9 ]+");
        
        dh.addDoctor(new Doctor(code, name, spec, Integer.parseInt(avail)));
        System.out.println("Doctor added successfully");
    }
    public static void updateDoctorUI(){
        System.out.println("---UpdateDoctor---");
        String code= Validation.inputString("Enter code: ", "[A-Za-z0-9 ]+").trim().toUpperCase();
        Doctor oldDoc=dh.getData().get(code);
        if(oldDoc==null){
            System.err.println("Doctor code not exist");
            return;
    }
       
        System.out.println("\nCurrent information:");
        System.out.printf("%-12s %-20s %-25s %-12s\n", 
                         "Code", "Name", "Specialization", "Availability");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(oldDoc);
        
        String name = Validation.inputString("Enter new name: ", "[A-Za-z ]+");
        if(name.isEmpty()){
            System.err.println("Keeping old value.");
        }else{
            oldDoc.setName(name);
        }
        String spec = Validation.inputString("Enter new spec: ", "[A-Za-z ]+");
        if(spec.isEmpty()){
            System.err.println("Keeping old value.");
        }else{
            oldDoc.setSpecialization(spec);
        }
       String avail = Validation.inputAvailability("Enter new availability: ","[0-9 ]+");
       if(avail.isEmpty()){
            System.err.println("Keeping old value.");
        }else{
            oldDoc.setAvailability(Integer.parseInt(avail));
        }
        dh.updateDoctor(oldDoc);
        System.out.println("Doctor updated successfull");
    }  
        
    public static void deleteDoctorUI(){
        System.out.println("---Delete Doctor----");
        String code= Validation.inputString("Enter code: ", "[A-Za-z0-9 ]+").trim().toUpperCase();
        Doctor oldDoc=dh.getData().get(code);
         if(oldDoc==null){
            System.err.println("Doctor code not exist");
            return;
    }
//        System.out.print("Are you sure you want to delete this doctor? (Y/N): ");
//        String confirm = SCANNER.nextLine().trim().toUpperCase();
        
//        if (confirm.equals("Y")) {
//            try {
//           
//                if (manager.deleteDoctor(doctorToDelete)) {
//                    System.out.println("Doctor deleted successfully!");
//                }
//            } catch (Exception e) {
//                System.out.println("Error: " + e.getMessage());
//            }
//        } else {
//            System.out.println("Delete operation cancelled.");
//        }
        dh.deleteDoctor(oldDoc);
        System.out.println("Doctor deleted successfully");
    }
    public static void searchDoctorUI(){
        System.out.println("---Search Doctor---");
        String key = Validation.inputString("Enter text: ", "[A-Za-z0-9 ]+").trim().toUpperCase();
        HashMap<String,Doctor> result= dh.searchDoctor(key);
        if(result.isEmpty()){
            System.out.println("No doctor found");
        }else{
            System.out.printf("%-10s %-15s %-20s %-12s\n","Code","Name","Spec","Avail");
            for(Doctor d: result.values()){
                System.out.println(d);
                       
            }
        }
        
    }
   
}
