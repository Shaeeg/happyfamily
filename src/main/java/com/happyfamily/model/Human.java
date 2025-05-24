package com.happyfamily.model;

import java.util.HashMap;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private HashMap<DayOfWeek, String> schedule;

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
