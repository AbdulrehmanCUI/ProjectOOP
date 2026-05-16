package com.university;

import com.university.Interfaces.Identifiable;
import com.university.Interfaces.Repository;
import com.university.Data.*;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CampusRepository<T extends Identifiable> implements Repository<T>, Serializable {

    ArrayList<T> list = new ArrayList<>();

    // Add method
    @Override
    public void add(T obj) {
        list.add(obj);
    }

    // Delete
    @Override
    public void delete(int id) {
        for(int i = 0; i < list.size();i++){
            if(list.get(i).getID() == id){
                list.remove(i);
                return;
            }
        }
        System.out.println("Successfully Removed...");
    }

    // Update method
    @Override
    public void update(T obj) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID() == obj.getID()) {
                list.set(i,obj);
                return;
            }
        }
    }

    // getID method
    @Override
    public T getID(int id) {
        for(T obj : list){
            if(obj.getID() == id){
                return obj;
            }
        }
        return null;
    }

    // All the items in the array list
    public ArrayList<T> getAll(){
        return list;
    }

    public void save(){
            try{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Student.dat"));
                oos.writeObject(list);

                System.out.println("File Saved Successfully...");


            }catch (Exception e){
                System.out.println(e.getMessage());
            }

    }


}

