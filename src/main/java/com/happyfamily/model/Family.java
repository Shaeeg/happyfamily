package com.happyfamily.model;

import com.happyfamily.exceptions.ChildNotFoundException;

import java.util.*;

public class Family implements HumanCreator {
    private Human mother;
    private Human father;
    private List<Human> children;
    private HashSet<Pet> pets;

    public Family() {
        this.children = new ArrayList<Human>();
        this.pets = new HashSet<>();
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    @Override
    public Human bornChild(Family family, String fatherName, String motherName) {
        Random random = new Random();
        List<String> maleNames = Arrays.asList("Rasul", "Nejat", "Ali", "Rashad", "Nihad");
        List<String> femaleNames = Arrays.asList("Mansura", "Zulfiyya", "Turkan", "Selcan", "Nigar");
        int childIq = (this.getMother().getIq() + this.getFather().getIq()) / 2;
        int currentYear = java.time.Year.now().getValue();

        Human child;
        if (random.nextBoolean()) {
            String childName = maleNames.get(random.nextInt(maleNames.size()));
            child = new Man(childName, father.getSurname(), currentYear, childIq, null, null);
        } else {
            String childName = femaleNames.get(random.nextInt(femaleNames.size()));
            child = new Woman(childName, father.getSurname(), currentYear, childIq, null, null);
        }

        child.setFamily(this);
        this.addChild(child);
        return child;
    }

    public void addChild(Human child) {
        if (child != null) {
            this.children.add(child);
            child.setFamily(this);
        }
    }

    public boolean deleteChild(int index) {
        if (index >= 0 && index < children.size()) {
            Human removedChild = children.remove(index);
            if (removedChild != null) {
                removedChild.setFamily(null);
            }
            return true;
        }
        return false;
    }

    public boolean deleteChild(Human child) {
        if (child == null) {
            return false;
        }
        boolean removed = children.remove(child);
        if (removed) {
            child.setFamily(null);
        }
        return removed;
    }

    public int countFamily() {
        return 2 + this.children.size() + this.pets.size();
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public HashSet<Pet> getPets() {
        return pets;
    }

    public void setPets(HashSet<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + children +
                ", pets=" + pets +
                '}';
    }

    static {
        System.out.println("Family class is being loaded.");
    }


    {
        System.out.println("A new Family object is being created.");
    }
}
