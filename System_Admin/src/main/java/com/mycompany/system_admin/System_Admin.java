/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.system_admin;

/**
 *
 * @author nsumo_a3gijbh
 */

import java.util.Scanner;

public class System_Admin {//start of class
                          //cration of a string that will ask the user to enter 
                          //to enter an integer not a string
   private static Scanner input = new Scanner(System.in);
   private static ClinicManager manager = new ClinicManager();

    public static void main(String[] args) {

        int choice = -1;

        do {

            try {

                displayMenu();
                   //display an out put message +
                //for an user to choose the switch
                System.out.print("Enter your choice: ");

                choice = Integer.parseInt(input.nextLine());

                switch (choice) {
//
                    case 1:
                        registerClient();
                        break;

                    case 2:
                        searchClient();
                        break;

                    case 3:
                        updateClient();
                        break;

                    case 4:
                        deleteClient();
                        break;

                    case 5:
                        manager.showClients();
                        break;

                    case 6:
                        manager.showWard();
                        break;

                    case 7:
                        allocateBed();
                        break;

                    case 8:
                        releaseBed();
                        break;

                    case 9:
                        manager.showAvailableBeds();
                        break;

                    case 10:
                        manager.showOccupiedBeds();
                        break;

                    case 11:
                        displayReport();
                        break;

                    case 12:
                        sortClients();
                        break;

                    case 0:
                        System.out.println(
                                "Thank you for using the system.");

                        break;

                    default:
                        System.out.println(
                                "Invalid menu option.");
                }
 
            } catch (NumberFormatException e) {
                     //creation of a string that will allow only integer to 
                    //continue if not then the project will crush
                    //this will make an user to crash the project
                System.out.println(
                        "Invalid input. Please enter a number.");
//
                choice = -1;
            }

        } while (choice != 0);
    }

          //creation of a menu pannel that will be displayed 
        //on the system so that any user will easier access the project
     public static void displayMenu() {

        System.out.println();
        System.out.println("==============================");
        System.out.println("       MEDICARE HOSPITAL");
        System.out.println("       SYSTEM ADMIN");
        System.out.println("==============================");
        System.out.println("1. Register Client");
        System.out.println("2. Search Client");
        System.out.println("3. Update Client");
        System.out.println("4. Delete Client");
        System.out.println("5. Display All Clients");
        System.out.println("6. Display Ward");
        System.out.println("7. Allocate Bed");
        System.out.println("8. Release Bed");
        System.out.println("9. Display Available Beds");
        System.out.println("10. Display Occupied Beds");
        System.out.println("11. Hospital Report");
        System.out.println("12. Sort Clients");
        System.out.println("0. Exit");
        System.out.println("==============================");
    }
//
    //craetion of a string that will allow the user to
    //Register client useing their credentials fully
    
    public static void registerClient() {

        try {
            //craetion of a string that will display the user information
            System.out.print("Client ID: ");
            String id = input.nextLine();

            System.out.print("First Name: ");
            String firstName = input.nextLine();

            System.out.print("Last Name: ");
            String lastName = input.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(input.nextLine());

            System.out.print("Gender: ");
            String gender = input.nextLine();

            System.out.print("Medical Condition: ");
            String condition = input.nextLine();
                 
            System.out.println();
            System.out.println("1. Inpatient");
            System.out.println("2. Outpatient");
            System.out.println("3. Emergency");

            System.out.print("Choose category: ");

            int category =
                    Integer.parseInt(input.nextLine());

            ClientRecord client;
          //creation of IF statement Loop it show which project must run
          //whether the user must store their details inside the database
            if (category == 1) {

                client = new WardClient(
                        id,
                        firstName,
                        lastName,
                        age,
                        gender,
                        condition,
                        "Ward 1",
                        "Not allocated"
                );

            } else if (category == 2) {

                client = new ClientRecord(
                        id,
                        firstName,
                        lastName,
                        age,
                        gender,
                        condition,
                        CaseType.OUTPATIENT
                );

            } else if (category == 3) {

                client = new ClientRecord(
                        id,
                        firstName,
                        lastName,
                        age,
                        gender,
                        condition,
                        CaseType.EMERGENCY
                );

            } else {

                System.out.println(
                        "Invalid category.");

                return;
            }

            manager.addClient(client);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Please enter valid numerical information.");
        }
    }

    //string statement that will allow users to be
  //Searched if any client did store their detail inside the database
    public static void searchClient() {

        System.out.print("Enter Client ID: ");

        String id = input.nextLine();

        ClientRecord client =
                manager.findClient(id);
             //creationg of IF LOOP statement that will allow used to display their details
        if (client != null) {

            System.out.println();
            client.displayDetails();

        } else {

            System.out.println(
                    "Client was not found.");
        }
    }
//
            //any user which has updated he/her information must able to update client
           //information anytime they wish to
    public static void updateClient() {

        try {

            System.out.print("Enter Client ID: ");
            String id = input.nextLine();

            System.out.print("First Name: ");
            String firstName = input.nextLine();

            System.out.print("Last Name: ");
            String lastName = input.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(input.nextLine());

            System.out.print("Gender: ");
            String gender = input.nextLine();

            System.out.print("Medical Condition: ");
            String condition = input.nextLine();

            boolean updated =
                    manager.updateClient(
                            id,
                            firstName,
                            lastName,
                            age,
                            gender,
                            condition
                    );
               //creating of IF LOOP statement to display if any user information
              //anytime you wish to change
              
            if (updated) {

                System.out.println(
                        "Client updated successfully.");

            } else {

                System.out.println(
                        "Client was not found.");
            }

        } catch (NumberFormatException e) {

            System.out.println(
                    "Age must be a number.");
        }
    }

          //craeting a string that will allow any user 
         //who has already stored their detail
        //to able delete client infformation if they wish too
    public static void deleteClient() {

        System.out.print("Enter Client ID: ");

        String id = input.nextLine();

        boolean deleted =
                manager.removeClient(id);

        if (deleted) {

            System.out.println(
                    "Client deleted successfully.");

        } else {

            System.out.println(
                    "Client was not found.");
        }
    }

            //display the method to  Allocate bed
    public static void allocateBed() {

        System.out.print("Enter Client ID: ");

        String clientId =
                input.nextLine();

        System.out.print(
                "Enter Bed Number (example B01): ");

        String bedNumber =
                input.nextLine();

        manager.allocateBed(
                clientId,
                bedNumber);
    }

          //creation of method that will Release bed
         //as an instate way to reduce conflict
    public static void releaseBed() {

        System.out.print(
                "Enter Bed Number: ");

        String bedNumber =
                input.nextLine();

        manager.releaseBed(bedNumber);
    }

             //use this method to Report then display
            //some certain features
    public static void displayReport() {

        System.out.println();
        System.out.println("========== HOSPITAL REPORT ==========");

        System.out.println(
                "Registered Clients: "
                + manager.countClients());

        System.out.println(
                "Occupied Beds: "
                + manager.countOccupiedBeds());

        System.out.println(
                "Available Beds: "
                + manager.countAvailableBeds());

        System.out.println(
                "Ward Occupancy: "
                + String.format(
                        "%.2f",
                        manager.occupancyRate())
                + "%");

        System.out.println();

        manager.showAvailableBeds();

        manager.showOccupiedBeds();
    }

    //the system must able to sort everything
    // using an order sorting
    //dont mess things around
    public static void sortClients() {

        try {

            System.out.println();
            System.out.println("1. Sort by Surname");
            System.out.println("2. Sort by Client ID");

            System.out.print("Choose option: ");

            int choice =
                    Integer.parseInt(input.nextLine());
            
               //creation of an if statement to show user that 
               //each  number must be stored accoding to how
               //many users has register
            if (choice == 1) {

                manager.sortBySurname();

            } else if (choice == 2) {

                manager.sortByClientId();

            } else {

                System.out.println(
                        "Invalid option.");

                return;
            }

            manager.showClients();
            
           //add a catch that will allow the system to
           //capture valid number that are stored
          //inside the database
          
        } catch (NumberFormatException e) {

            System.out.println(
                    "Please enter a valid number.");
        }
    }
}//end of class
