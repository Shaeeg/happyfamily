package com.happyfamily.model;

import java.util.HashMap;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private Human mother;
    private Human father;
    private HashMap<DayOfWeek, String> schedule;

    public Human(String name, String surname, int year){
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year,Human father, Human mother){
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, int iq, Pet pet, Human mother, Human father, HashMap<DayOfWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
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

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", pet=" + pet +
                ", mother=" + mother +
                ", father=" + father +
                ", schedule=" + schedule +
                '}';
    }
}
