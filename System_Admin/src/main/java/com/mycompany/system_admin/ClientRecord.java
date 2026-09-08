/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system_admin;

/**
 *
 * @author nsumo_a3gijbh
 */
public class ClientRecord {//creating a string that will allow user to enter ther personal information 
                           //will also return the information enterd 

    private String clientId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String medicalCondition;
    private CaseType caseType;

    public ClientRecord(String clientId, String firstName, String lastName,
                        int age, String gender, String medicalCondition,
                        CaseType caseType) {

        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.medicalCondition = medicalCondition;
        this.caseType = caseType;
    }
// This will stor the information entered 
    public String getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public CaseType getCaseType() {
        return caseType;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public void displayDetails() {// show the personal information of people that will come to the hospital
                                  // This will help to keep the clients information close 
                                  
        System.out.println("Client ID: " + clientId);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Medical Condition: " + medicalCondition);
        System.out.println("Case Type: " + caseType);
    }

    
}