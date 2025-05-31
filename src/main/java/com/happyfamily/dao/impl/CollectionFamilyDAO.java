package com.happyfamily.dao.impl;

import com.happyfamily.dao.inter.FamilyDAO;
import com.happyfamily.model.Family;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDAO implements FamilyDAO {
    private List<Family> families;
    private static final String FILE_PATH = "families.ser";

    public CollectionFamilyDAO() {
        this.families = new ArrayList<>();
        loadFromFile();
    }

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index >= 0 && index < families.size()) {
            return families.get(index);
        }
        return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index >= 0 && index < families.size()) {
            families.remove(index);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        boolean removed = families.remove(family);
        if (removed) {
            saveToFile();
        }
        return removed;
    }

    @Override
    public void saveFamily(Family family) {
        int index = families.indexOf(family);
        if (index != -1) {
            families.set(index, family);
        } else {
            families.add(family);
        }
        saveToFile();
    }

    @Override
    public void loadData(List<Family> familiesToLoad) {
        this.families.clear();
        if (familiesToLoad != null) {
            this.families.addAll(familiesToLoad);
        }
        saveToFile();
    }

    public void saveAll() {
        saveToFile();
    }

    public void loadAll() {
        loadFromFile();
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(families);
            System.out.println("Families data saved to " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error saving families data: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_PATH);
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                families = (List<Family>) ois.readObject();
                System.out.println("Families data loaded from " + FILE_PATH);
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error loading families data: " + e.getMessage());
                this.families = new ArrayList<>();
            }
        } else {
            System.out.println("No existing families data file found or file is empty. Starting with an empty list.");
            this.families = new ArrayList<>();
        }
    }
}