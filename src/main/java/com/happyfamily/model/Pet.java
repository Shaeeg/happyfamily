package com.happyfamily.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public abstract class Pet implements Serializable {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private Set<String> habits;

    static {
        System.out.println("Pet class is being loaded.");
    }

    {
        System.out.println("Pet object is being created.");
    }

    public Pet(String nickname) {
        this.nickname = nickname;
        this.species = Species.UNKNOWN;
    }

    public Pet(String nickname, int age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        if (trickLevel >= 1 && trickLevel <= 100) {
            this.trickLevel = trickLevel;
        } else {
            this.trickLevel = 50;
        }
        this.habits = habits;
        this.species = Species.UNKNOWN;
    }

    public Pet() {
        this.species = Species.UNKNOWN;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        if (trickLevel >= 1 && trickLevel <= 100) {
            this.trickLevel = trickLevel;
        }
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public void eat() {
        System.out.println("I am eating");
    }

    public abstract void respond();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel && species == pet.species && Objects.equals(nickname, pet.nickname) && Objects.equals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, (Object) age, (Object) trickLevel, habits);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "species=" + species +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + habits +
                '}';
    }

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\tspecies=%s\n", species.name()));
        sb.append(String.format("\tnickname='%s'\n", nickname));
        sb.append(String.format("\tage=%d\n", age));
        sb.append(String.format("\ttrickLevel=%d\n", trickLevel));
        sb.append(String.format("\thabits=%s\n", habits));
        if (species.canFly()) {
            sb.append("\tcanFly=true\n");
        }
        sb.append(String.format("\tnumberOfLegs=%d\n", species.getNumberOfLegs()));
        if (species.hasFur()) {
            sb.append("\thasFur=true\n");
        }
        return sb.toString();
    }
}