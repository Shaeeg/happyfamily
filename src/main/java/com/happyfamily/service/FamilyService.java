package com.happyfamily.service;

import com.happyfamily.dao.impl.CollectionFamilyDAO;
import com.happyfamily.dao.inter.FamilyDAO;
import com.happyfamily.model.*;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.stream.Collectors;

public class FamilyService {
    private FamilyDAO familyDao;
    private Random random = new Random();
    private List<String> maleNames = List.of("Michael", "David", "John", "Chris", "Daniel");
    private List<String> femaleNames = List.of("Sarah", "Emily", "Jessica", "Olivia", "Sophia");

    public FamilyService(FamilyDAO familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> families = familyDao.getAllFamilies();
        if (families.isEmpty()) {
            System.out.println("No families to display.");
            return;
        }
        families.forEach( (family) -> System.out.println((families.indexOf(family) + 1) + ". " + family.prettyFormat()));
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() > count)
                .collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int count) {
        return familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() < count)
                .collect(Collectors.toList());
    }

    public int countFamiliesWithMemberNumber(int count) {
        return (int) familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() == count)
                .count();
    }

    public void createNewFamily(Human mother, Human father) {
        Family newFamily = new Family(mother, father);
        familyDao.saveFamily(newFamily);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String masculineName, String feminineName) {
        Human child;
        String surname = family.getFather().getSurname();
        int iq = (family.getMother().getIq() + family.getFather().getIq()) / 2;
        long birthDate = System.currentTimeMillis();
        Map<DayOfWeek, String> schedule = new HashMap<>();

        if (random.nextBoolean()) {
            child = new Man(masculineName, surname, birthDate, iq, family, schedule);
        } else {
            child = new Woman(feminineName, surname, birthDate, iq, family, schedule);
        }
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyDao.getAllFamilies().forEach(family -> {
            List<Human> childrenToRemove = family.getChildren().stream()
                    .filter(child -> {
                        LocalDate birth = Instant.ofEpochMilli(child.getBirthDate()).atZone(ZoneId.systemDefault()).toLocalDate();
                        LocalDate now = LocalDate.now();
                        Period period = Period.between(birth, now);
                        return period.getYears() > age;
                    })
                    .collect(Collectors.toList());
            childrenToRemove.forEach(family::deleteChild);
            familyDao.saveFamily(family);
        });
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public Set<Pet> getPets(int familyIndex) {
        Family family = familyDao.getFamilyByIndex(familyIndex);
        return family != null ? family.getPets() : null;
    }

    public void addPet(int familyIndex, Pet pet) {
        Family family = familyDao.getFamilyByIndex(familyIndex);
        if (family != null) {
            family.addPet(pet);
            familyDao.saveFamily(family);
        }
    }

    public void saveData() {
        ((CollectionFamilyDAO) familyDao).saveAll();
    }

    public void loadData() {

        ((CollectionFamilyDAO) familyDao).loadAll();
    }
}