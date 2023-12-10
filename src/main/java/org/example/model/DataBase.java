package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataBase<DataBaseRecord> implements Serializable {
    private List<DataBaseRecord> dataBase;
    public DataBase(){ // a default constructor that initializes the dataBase variable with an empty ArrayList when a DataBase object is created without any parameters
        this(new ArrayList<>());
    }

    public DataBase(List<DataBaseRecord> dataBase) { // This Parameterized Constructor allows to initialize the database with a provided List<DataBaseRecord>
        this.dataBase = dataBase;
    }

    public boolean addRecord(DataBaseRecord record) {
        if (record == null){
            return false;
        }
        dataBase.add(record);
        return true;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        for(DataBaseRecord record: dataBase){
            sb.append(record);
            sb.append("\n");
        }
        return sb.toString();
    }
}
