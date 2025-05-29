package com.happyfamily.controller;

import com.happyfamily.dao.impl.CollectionFamilyDAO;
import com.happyfamily.dao.inter.FamilyDAO;
import com.happyfamily.model.Family;
import com.happyfamily.service.inter.FamilyService;
import com.happyfamily.service.impl.FamilyServiceImpl;

import java.util.List;

public class FamilyController {
    private final FamilyService familyService;

    public FamilyController() {
        FamilyDAO dao = new CollectionFamilyDAO();
        this.familyService = new FamilyServiceImpl(dao);
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public Family getFamilyByIndex(int index) {
        return familyService.getFamilyByIndex(index);
    }

    public boolean deleteFamily(int index) {
        return familyService.deleteFamily(index);
    }

    public boolean deleteFamily(Family family) {
        return familyService.deleteFamily(family);
    }

    public void saveFamily(Family family) {
        familyService.saveFamily(family);
    }
}
