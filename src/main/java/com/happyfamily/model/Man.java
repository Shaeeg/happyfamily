package com.happyfamily.model;

import java.util.HashMap;

public final class Man extends Human {

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, String birthDate, int iq, Pet pet, HashMap<DayOfWeek, String> schedule) {
        super(name, surname, birthDate, iq, pet, schedule);
    }

    @Override
    public void greetPet() {
        System.out.printf("Hey there, buddy! %s, how's it going?\n", getPet() != null ? getPet().getNickname() : "my pet");
    }

    public void repairCar() {
        System.out.println("Time to get my hands dirty and fix this engine!");
    }
}