package com.happyfamily.service.impl;

import com.happyfamily.dao.inter.FamilyDAO;
import com.happyfamily.model.Family;
import com.happyfamily.service.inter.FamilyService;

import java.util.List;

public class FamilyServiceImpl implements FamilyService {
    private final FamilyDAO familyDAO;

    public FamilyServiceImpl(FamilyDAO familyDAO) {
        this.familyDAO = familyDAO;
    }

    @Override
    public List<Family> getAllFamilies() {
        return familyDAO.getAllFamilies();
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index < 0 || index > familyDAO.getAllFamilies().size()) {
            throw new IllegalArgumentException("Invalid index");
        }
        return familyDAO.getFamilyByIndex(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index < 0 || index >= familyDAO.getAllFamilies().size()) {
            throw new IllegalArgumentException("Invalid index");
        }
      return familyDAO.deleteFamily(index);
    }

    @Override
    public boolean deleteFamily(Family family) {
        if (family == null) {
            throw new IllegalArgumentException("Invalid family");
        }
        return familyDAO.deleteFamily(family);
    }

    @Override
    public void saveFamily(Family family) {
        if (family == null) {
            throw new IllegalArgumentException("Invalid family");
        }
        familyDAO.saveFamily(family);
    }
}
