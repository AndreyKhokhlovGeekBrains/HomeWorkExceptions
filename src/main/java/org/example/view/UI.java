package org.example.view;

import org.example.model.Gender;
import org.example.model.Service;
import org.example.model.YorN;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    private Scanner scanner = new Scanner(System.in);
    private Service service;
    private boolean UIOnOff;

    public UI(){
        service = new Service();
        UIOnOff = true;
    }
    public void start() {
        while (UIOnOff) {
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter surname");
            String surname = scanner.nextLine();
            System.out.println("Enter patronymic name");
            String patronymicName = scanner.nextLine();

            LocalDate birthDate = null;
            while (birthDate == null){
                try{
                    System.out.println("Enter birthdate (yyyy-mm-dd)");
                    birthDate = LocalDate.parse(scanner.nextLine());
                } catch (DateTimeParseException e){
                    System.out.println("Invalid date format");
                }
            }

            long phoneNumber = 0;
            while (phoneNumber == 0){
                try{
                    System.out.println("Enter phone number");
                    phoneNumber = scanner.nextLong();
                    scanner.nextLine();
                } catch (InputMismatchException e){
                    System.out.println("Invalid phone number");
                    scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
                }
            }

            Gender gender = null;
            while (gender == null){
                System.out.println("Enter gender (f/m)");
                String genderInput = scanner.nextLine().toLowerCase();
                if("f". equals(genderInput) || "m".equals(genderInput)){
                    gender = Gender.valueOf(genderInput);
                } else {
                    System.out.println("Invalid gender");
                }
            }

            YorN check = null;
            while (check == null){
                try {
                    System.out.println("Continue? (Y/N)");
                    check = YorN.valueOf(scanner.nextLine().toLowerCase());
                } catch (IllegalArgumentException e){
                    System.out.println("Invalid answer");
                }
            }

            UIOnOff = service.createDataBaseRecord(name, surname, patronymicName, birthDate, phoneNumber, gender);
            boolean saveDecisionCheck = false;

            if (UIOnOff){
                System.out.println("Record added successfully.");
                System.out.println(service.getDataBaseInfo());
                UIOnOff = !"n".equals(check.toString()); // If check is not "n", set UIOnOff to true
                saveDecisionCheck = true;
            } else {
                System.out.println("Failed to add record. Please provide all required information.");
//                UIOnOff = !"n".equals(check.toString()); // If check is not "n", set UIOnOff to true
                UIOnOff = true;
            }

            if ("n".equalsIgnoreCase(check.toString()) && saveDecisionCheck){
                YorN saveDecision = null;
                while (saveDecision == null){
                    try {
                        System.out.println("Would you like to save your data? (Y/N)");
                        saveDecision = YorN.valueOf(scanner.nextLine().toLowerCase());
                    } catch (IllegalArgumentException e){
                        System.out.println("Invalid answer");
                    }
                }

                if (YorN.y.equals(saveDecision)){
                    service.save();
                }
            }
        }
    }

    public void load() {
        service.load();
    }
}
