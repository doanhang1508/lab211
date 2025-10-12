/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package workermanager;

/**
 *
 * @author Thanh Hang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
       static Manager manager = new Manager();
    public static void main(String[] args) {
     

        while (true) {
            System.out.println("======== Worker Management ========");
            System.out.println("1. Add Worker");
            System.out.println("2. Up salary");
            System.out.println("3. Down salary");
            System.out.println("4. Display Information salary");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            String choice = Validation.inputString("", "[1-5]");

            switch (choice) {
                 case "1":
                    addWorkerUI();
                    break;
                case "2":
                    changeSalaryUI("UP");
                    break;
                case "3":
                    changeSalaryUI("DOWN");
                    break;
                case "4":
                    manager.displayInformationSalary();
                    break;
                case "5":
                    System.out.println("Bye!");
                    return;
            }

            System.out.println();
        }
    }
     private static void addWorkerUI() {
        System.out.println("-------- Add Worker --------");
        try {
            String id = Validation.inputString("Enter Code: ", "[A-Za-z0-9]+");
            String name = Validation.inputString("Enter Name: ", ".+");
            int age = Validation.inputInteger("Enter Age: ", 18, 50);
            double salary = Validation.inputDouble("Enter Salary: ", 0);
            String loc = Validation.inputString("Enter work location: ", ".+");

            Worker w = new Worker(id, name, age, salary, loc);
            manager.addWorker(w);
            System.out.println("✅ Worker added successfully!");
        } catch (Exception e) {
            System.out.println("⚠️ " + e.getMessage());
        }
    }

    private static void changeSalaryUI(String status) {
        System.out.println("-------- Up/Down Salary --------");
        try {
            String code = Validation.inputString("Enter Code: ", "[A-Za-z0-9]+");
            double amount = Validation.inputDouble("Enter Salary: ", 0);
            manager.changeSalary(status, code, amount);
            System.out.println("✅ Salary " + (status.equals("UP") ? "increased!" : "decreased!"));
        } catch (Exception e) {
            System.out.println("⚠️ " + e.getMessage());
        }
    }
    }

    

