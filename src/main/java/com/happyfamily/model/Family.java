package com.happyfamily.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private HashSet<Pet> pets;
    private Family family;

    public Family() {
        this.children = new ArrayList<Human>();
        this.pets = new HashSet<>();
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<Human>();
        this.pets = new HashSet<>();
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public void deleteChild(Human child) {
        this.children.remove(child);
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

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + children +
                ", pets=" + pets +
                ", family=" + family +
                '}';
    }

    static {
        System.out.println("Family object created");
    }
}
