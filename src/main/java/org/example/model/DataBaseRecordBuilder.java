package org.example.model;

import java.time.LocalDate;

public class DataBaseRecordBuilder {
    public DataBaseRecord build(String name, String surname, String patronymicName, LocalDate birthdate, Long phoneNumber, Gender gender){
        return new DataBaseRecord(name, surname, patronymicName, birthdate, phoneNumber, gender);
    }
}
