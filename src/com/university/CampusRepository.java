package com.university;

import com.university.AcademicUnit.Equipment;
import com.university.Interfaces.Repository;

public class CampusRepository implements Repository<Equipment> {
    @Override
    public void add(Equipment obj) {

    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void update(int id, Equipment obj) {

    }

    @Override
    public Equipment get(int id) {
        return null;
    }
}

