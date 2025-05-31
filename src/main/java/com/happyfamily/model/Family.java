package com.happyfamily.model;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Family implements Serializable {
    private static final long serialVersionUID = 1L;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

    static {
        System.out.println("Family class is being loaded.");
    }

    {
        System.out.println("Family object is being created.");
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.pets = new HashSet<>();
        this.mother.setFamily(this);
        this.father.setFamily(this);
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

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public void addChild(Human child) {
        children.add(child);
        child.setFamily(this);
    }

    public boolean deleteChild(Human child) {
        boolean removed = children.remove(child);
        if (removed) {
            child.setFamily(null);
        }
        return removed;
    }

    public boolean deleteChild(int index) {
        if (index >= 0 && index < children.size()) {
            Human child = children.remove(index);
            child.setFamily(null);
            return true;
        }
        return false;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public int countFamily() {
        return 2 + children.size() + pets.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Family{");
        sb.append("mother=").append(mother.toString());
        sb.append(", father=").append(father.toString());
        sb.append(", children=").append(children.toString());
        sb.append(", pets=").append(pets.toString());
        sb.append('}');
        return sb.toString();
    }

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("family:\n");
        sb.append("\tmother: {").append(mother.prettyFormat().trim()).append("},\n");
        sb.append("\tfather: {").append(father.prettyFormat().trim()).append("},\n");
        if (!children.isEmpty()) {
            sb.append("\tchildren: [\n");
            for (Human child : children) {
                String childType = (child instanceof Man) ? "boy" : (child instanceof Woman) ? "girl" : "child";
                sb.append(String.format("\t\t%s: {%s}\n", childType, child.prettyFormat().trim()));
            }
            sb.append("\t]\n");
        }
        if (!pets.isEmpty()) {
            sb.append("\tpets: [\n");
            String petsFormatted = pets.stream()
                    .map(pet -> "\t\t{" + pet.prettyFormat().replace("\n", "\n\t\t").trim() + "}")
                    .collect(Collectors.joining(",\n"));
            sb.append(petsFormatted.replace("\t\t}","}").replace(",\n\t\t}","},\n\t\t"));
            sb.append("\t]\n");
        }
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return mother.equals(family.mother) &&
                father.equals(family.father) &&
                children.equals(family.children) &&
                pets.equals(family.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pets);
    }
}