package com.happyfamily.model;

import java.util.HashMap;
import java.util.Objects;

public abstract class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private HashMap<DayOfWeek, String> schedule;
    private Family family;
    private String[] maleNames = {"Rashad", "Shaig", "Ali", "Rasul"};
    private String[] femaleNames = {"Mansura", "Zulfiyya", "Selcan"};

    public Human(String name, String surname, int year){
        this.name = name;
        this.surname = surname;
        this.year = year;
    }


    public Human(String name, String surname, int year, int iq, Pet pet, HashMap<DayOfWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.schedule = schedule;
    }

    public Human(){

    }

    public void greetPet(){
        System.out.println("Hello" + pet.getNickname());
    }

    public void describePet(){
        String message = pet.getTricklevel() > 50 ?
                String.format("I have an %s is %d years old, he is very sly", pet.getSpecies(), pet.getAge() + "\n")
                : String.format("I have an %s is %d years old, he is almost not sly", pet.getSpecies(),  pet.getAge() + "\n");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public HashMap<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(HashMap<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    public String[] getMaleNames() {
        return maleNames;
    }

    public void setMaleNames(String[] maleNames) {
        this.maleNames = maleNames;
    }

    public String[] getFemaleNames() {
        return femaleNames;
    }

    public void setFemaleNames(String[] femaleNames) {
        this.femaleNames = femaleNames;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", pet=" + pet +
                ", schedule=" + schedule +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(pet, human.pet) && Objects.equals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq, pet, schedule);
    }

    static {
        System.out.println("Human object created");
    }
}
