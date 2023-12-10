package org.example.model;

import java.time.LocalDate;

public class Service {
    private DataBase<DataBaseRecord> myDataBase;
    private DataBaseRecordBuilder builder;
    private FileHandler fileHandler;
    public Service(){
        myDataBase = new DataBase<>();
        builder = new DataBaseRecordBuilder();
        fileHandler = new FileHandler();
    }

    public void save(){
        fileHandler.save(myDataBase);
    }

    public void load(){
        myDataBase = (DataBase<DataBaseRecord>) fileHandler.read();
        System.out.println("Current database records: \n" + myDataBase.getInfo());
    }

    public boolean createDataBaseRecord(String name, String surname, String patronymicName, LocalDate birthdate, Long phoneNumber, Gender gender) throws MissingInformationException {
        DataBaseRecord record = builder.build(name, surname, patronymicName, birthdate, phoneNumber, gender);
        try {
            checkRecord(record);
            myDataBase.addRecord(record);
            return true;
        } catch (MissingInformationException e) {
            ValidationError errorCode = e.getErrorCode();
            handleMissingInformation(errorCode);
            return false;
        }

    }
    private void checkRecord(DataBaseRecord record) throws MissingInformationException {
        String elements = record.getInfo();
        String[] arrElements =  elements.split(" ");
        for (int i = 0; i < arrElements.length; i++) {
            if(arrElements[i].isBlank()){
                throw new MissingInformationException(ValidationError.values()[i]);
            }
        }
    }
    private void handleMissingInformation(ValidationError errorCode){
        switch (errorCode) {
            case No_name:
                System.out.println("No name entered");
                break;
            case No_surname:
                System.out.println("No surname entered");
                break;
            case No_patronymicName:
                System.out.println("No patronymic name entered");
                break;
            case No_birthDate:
                System.out.println("No birthdate entered");
                break;
            case No_phoneNumber:
                System.out.println("No phone number entered");
                break;
            case No_gender:
                System.out.println("No gender entered");
                break;
            default:
                System.out.println("Unknown error");
        }
    }
    public String getDataBaseInfo(){
        return myDataBase.getInfo();
    }
}
