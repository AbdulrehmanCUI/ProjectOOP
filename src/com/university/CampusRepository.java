package com.university;

import com.university.Interfaces.Identifiable;
import com.university.Interfaces.Repository;

import javax.management.ObjectInstance;
import java.io.*;
import java.util.ArrayList;

public class CampusRepository<T extends Identifiable> implements Repository<T>, Serializable {

    ArrayList<T> list = new ArrayList<>();

    // Add method
    @Override
    public void add(T obj) {
        try{
            list.add(obj);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    // Delete
    @Override
    public void delete(int id) {
        try{
            for(int i = 0; i < list.size();i++){
                if(list.get(i).getID() == id){
                    list.remove(i);
                    return;
                }
            }
        System.out.println("Successfully Removed...");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    // Update method
    @Override
    public void update(T obj) {
        try{
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getID() == obj.getID()) {
                    list.set(i,obj);
                    return;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    // getID method
    @Override
    public T getID(int id) {
        try{
            for(T obj : list){
                if(obj.getID() == id){
                    return obj;
                }
            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // All the items in the array list
    public ArrayList<T> getAll(){
        try{
            return list;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    // Save File
    public void save() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"));
            oos.writeObject(list);

            System.out.println("File Saved Successfully...");

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Load method
    public void load(){
        try{
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream("university.dat"));
            list = (ArrayList<T>) oos.readObject();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}

