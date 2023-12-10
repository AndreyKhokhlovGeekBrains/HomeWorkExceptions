package org.example.model;


import java.io.*;

public class FileHandler {
    private String filePath = "src\\main\\java\\org\\example\\myDatabase";
    public boolean save(DataBase dataBase){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            outputStream.writeObject(dataBase);
            System.out.println("Data saved successfully.");
            return true;
        } catch (FileNotFoundException e){
            System.out.println("Error: File not found. Please check the file path.");
        } catch (IOException e) {
            System.out.println("Error: Unable to save data to the file.");
        }
        return false;
    }

    public DataBase read(){
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))){
            return (DataBase) inputStream.readObject();
        } catch (FileNotFoundException e){
            System.out.println("Error: File not found. Please check the file path.");
        } catch (IOException e){
            System.out.println("Error: Unable to read data from the file.");
        } catch (ClassNotFoundException e){
            System.out.println("Error: Class not found. The file may be corrupted.");
        }
        return null;
    }
}
