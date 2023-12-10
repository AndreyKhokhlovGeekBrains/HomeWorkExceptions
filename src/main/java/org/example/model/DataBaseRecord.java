package org.example.model;

import java.io.Serializable;
import java.time.LocalDate;

public class DataBaseRecord implements Serializable {
    private String name;
    private String surname;
    private String patronymicName;
    private LocalDate birthdate;
    private Long phoneNumber;
    private Gender gender;

    public DataBaseRecord(String name, String surname, String patronymicName, LocalDate birthdate, Long phoneNumber, Gender gender){
        this.name = name;
        this.surname = surname;
        this.patronymicName = patronymicName;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString(){
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(name)
                .append(" ")
                .append(surname)
                .append(" ")
                .append(patronymicName)
                .append(" ")
                .append(birthdate)
                .append(" ")
                .append(phoneNumber)
                .append(" ")
                .append(gender);

        return sb.toString();
    }
}
