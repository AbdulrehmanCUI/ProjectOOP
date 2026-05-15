package com.university.Interfaces;
import java.util.ArrayList;


public interface Repository<T> {
    void add(T obj);
    void delete(int id);
    T getID(int id);
    void update(int id, T obj);
    public ArrayList<T> getAll();

}