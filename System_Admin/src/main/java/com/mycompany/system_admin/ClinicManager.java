/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system_admin;

/**
 *
 * @author nsumo_a3gijbh
 */
import java.util.ArrayList;
import java.util.Comparator;

public class ClinicManager {

    private ArrayList<ClientRecord> clients;
    private String[][] beds;

    public ClinicManager() {

        clients = new ArrayList<>();
        beds = new String[4][5];

        int number = 1;

        for (int row = 0; row < 4; row++) {

            for (int column = 0; column < 5; column++) {

                beds[row][column] =
                        "B" + String.format("%02d", number);

                number++;
            }
        }
    }
//
    // Register a client
    public boolean addClient(ClientRecord client) {

        if (findClient(client.getClientId()) != null) {

            System.out.println("Client ID already exists.");
            return false;
        }

        clients.add(client);

        System.out.println("Client registered successfully.");
        return true;
    }

    // Search for a client
    public ClientRecord findClient(String id) {

        for (ClientRecord client : clients) {

            if (client.getClientId().equalsIgnoreCase(id)) {
                return client;
            }
        }
//
        return null;
    }

    // Delete client
    public boolean removeClient(String id) {

        ClientRecord client = findClient(id);

        if (client == null) {
            return false;
        }

        clients.remove(client);

        return true;
    }

    // Display all clients
    public void showClients() {

        if (clients.isEmpty()) {

            System.out.println("No clients registered.");
            return;
        }

        System.out.println("========== REGISTERED CLIENTS ==========");

        for (ClientRecord client : clients) {

            System.out.println("----------------------------------");
            client.displayDetails();
        }
    }

    // Update client details
    public boolean updateClient(String id,
                                String firstName,
                                String lastName,
                                int age,
                                String gender,
                                String condition) {

        ClientRecord client = findClient(id);

        if (client == null) {
            return false;
        }//

        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setAge(age);
        client.setGender(gender);
        client.setMedicalCondition(condition);

        return true;
    }

    // Allocate a bed
    public boolean allocateBed(String clientId, String bedNumber) {

        ClientRecord client = findClient(clientId);

        if (client == null) {

            System.out.println("Client not found.");
            return false;
        }

        if (client.getCaseType() != CaseType.INPATIENT) {

            System.out.println(
                    "Only inpatient clients can be allocated a bed.");

            return false;
        }

        // Check if the client already has a bed
        for (int row = 0; row < 4; row++) {

            for (int column = 0; column < 5; column++) {

                if (beds[row][column].contains(":" + clientId)) {

                    System.out.println(
                            "This client already has a bed.");

                    return false;
                }
            }
        }

        // Search for requested bed
        for (int row = 0; row < 4; row++) {

            for (int column = 0; column < 5; column++) {

                String currentBed = beds[row][column];

                if (currentBed.equalsIgnoreCase(bedNumber)) {

                    beds[row][column] =
                            bedNumber.toUpperCase() + ":" + clientId;

                    if (client instanceof WardClient) {

                        WardClient wardClient =
                                (WardClient) client;

                        wardClient.setBedNumber(
                                bedNumber.toUpperCase());
                    }

                    System.out.println(
                            "Bed allocated successfully.");

                    return true;
                }

                if (currentBed.startsWith(
                        bedNumber.toUpperCase() + ":")) {

                    System.out.println(
                            "The bed is already occupied.");

                    return false;
                }
            }
        }
//
        System.out.println("Bed does not exist.");

        return false;
    }

    // This will release a bed
    public boolean releaseBed(String bedNumber) {

        for (int row = 0; row < 4; row++) {

            for (int column = 0; column < 5; column++) {

                if (beds[row][column].startsWith(
                        bedNumber.toUpperCase() + ":")) {

                    String information =
                            beds[row][column];

                    String[] parts =
                            information.split(":");

                    String clientId = parts[1];

                    ClientRecord client =
                            findClient(clientId);

                    if (client instanceof WardClient) {

                        WardClient wardClient =
                                (WardClient) client;

                        wardClient.setBedNumber(
                                "Not allocated");
                    }

                    beds[row][column] =
                            bedNumber.toUpperCase();

                    System.out.println(
                            "Bed released successfully.");

                    return true;
                }
            }
        }
//
        System.out.println("Bed is not occupied.");

        return false;
    }

    // Display complete ward as it is
    public void showWard() {

        System.out.println("========== WARD LAYOUT ==========");

        for (int row = 0; row < 4; row++) {

            for (int column = 0; column < 5; column++) {

                System.out.print(
                        beds[row][column] + "\t");
            }

            System.out.println();
        }
    }

    // Display available beds
    public void showAvailableBeds() {

        System.out.println("========== AVAILABLE BEDS ==========");

        boolean found = false;

        for (int row = 0; row < 4; row++) {

            for (int column = 0; column < 5; column++) {

                if (!beds[row][column].contains(":")) {

                    System.out.print(
                            beds[row][column] + " ");

                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No beds available.");
        }

        System.out.println();
    }

    // This will display occupied beds
    public void showOccupiedBeds() {

        System.out.println("========== OCCUPIED BEDS ==========");

        boolean found = false;

        for (int row = 0; row < 4; row++) {

            for (int column = 0; column < 5; column++) {

                if (beds[row][column].contains(":")) {

                    System.out.print(
                            beds[row][column] + " ");

                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No beds occupied.");
        }

        System.out.println();
    }

    // Count occupied beds
    public int countOccupiedBeds() {

        int count = 0;

        for (int row = 0; row < 4; row++) {

            for (int column = 0; column < 5; column++) {

                if (beds[row][column].contains(":")) {
                    count++;
                }
            }
        }

        return count;
    }

    // Count how many registered clients at the hospital 
    public int countClients() {
        return clients.size();
    }

    // Count how many available beds
    public int countAvailableBeds() {
        return 20 - countOccupiedBeds();
    }

    // Calculate occupancy percentage
    public double occupancyRate() {

        return (countOccupiedBeds() / 20.0) * 100;
    }

    // will sort by surname
    public void sortBySurname() {

        clients.sort(
                Comparator.comparing(
                        ClientRecord::getLastName));

        System.out.println(
                "Clients sorted by surname.");
    }

    // will sort the client by ID
    // This helps when looking for a clients information 
    
    public void sortByClientId() {

        clients.sort(
                Comparator.comparing(
                        ClientRecord::getClientId));

        System.out.println(
                "Clients sorted by Client ID.");
    }

}
