package com.happyfamily.dao.impl;

import com.happyfamily.dao.inter.FamilyDAO;
import com.happyfamily.model.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDAO implements FamilyDAO {
    private final List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return families.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        return families.remove(index) != null;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        families.add(family);
    }
}
