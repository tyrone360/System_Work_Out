/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system_admin;

/**
 *
 * @author nsumo_a3gijbh
 */
public class WardClient extends ClientRecord {
  // shows how many beds are available for a patient and how many beds will be free to be used 
         //This will help save time
    
    private String wardNumber;
    private String bedNumber;

    public WardClient(String clientId, String firstName, String lastName,
                      int age, String gender, String medicalCondition,
                      String wardNumber, String bedNumber) {

        super(clientId, firstName, lastName, age, gender,
              medicalCondition, CaseType.INPATIENT);
        
         
        this.wardNumber = wardNumber;
        this.bedNumber = bedNumber;
    }

    public String getWardNumber() {
        return wardNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();

        System.out.println("Ward Number: " + wardNumber);
        System.out.println("Bed Number: " + bedNumber);
    }
}