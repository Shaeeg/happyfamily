package com.happyfamily.controller;

import com.happyfamily.exceptions.FamilyOverFlowException;
import com.happyfamily.model.Family;
import com.happyfamily.model.Human;
import com.happyfamily.model.Pet;
import com.happyfamily.service.FamilyService;

import java.util.List;
import java.util.Set;

public class FamilyController {
    private FamilyService familyService;
    private final int MAX_FAMILY_SIZE = 10;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return familyService.getFamiliesBiggerThan(count);
    }

    public List<Family> getFamiliesLessThan(int count) {
        return familyService.getFamiliesLessThan(count);
    }

    public int countFamiliesWithMemberNumber(int count) {
        return familyService.countFamiliesWithMemberNumber(count);
    }

    public void createNewFamily(Human mother, Human father) {
        familyService.createNewFamily(mother, father);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyService.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String masculineName, String feminineName) {
        if (family.countFamily() + 1 > MAX_FAMILY_SIZE) {
            throw new FamilyOverFlowException("Cannot add child. Family size exceeds " + MAX_FAMILY_SIZE + " members.");
        }
        return familyService.bornChild(family, masculineName, feminineName);
    }

    public Family adoptChild(Family family, Human child) {
        if (family.countFamily() + 1 > MAX_FAMILY_SIZE) {
            throw new FamilyOverFlowException("Cannot adopt child. Family size exceeds " + MAX_FAMILY_SIZE + " members.");
        }
        return familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int index) {
        return familyService.getFamilyById(index);
    }

    public Set<Pet> getPets(int familyIndex) {
        return familyService.getPets(familyIndex);
    }

    public void addPet(int familyIndex, Pet pet) {
        familyService.addPet(familyIndex, pet);
    }

    public void saveData() {
        familyService.saveData();
    }

    public void loadData() {
        familyService.loadData();
    }
}