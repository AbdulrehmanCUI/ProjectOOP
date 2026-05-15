package com.university.Interfaces;

public interface Repository<T> {
    void add(T obj);
    boolean delete(int id);
    T get(int id);
    void update(int id, T obj);
}