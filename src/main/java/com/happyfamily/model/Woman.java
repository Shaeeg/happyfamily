package com.happyfamily.model;

import java.util.HashMap;

public final class Woman extends Human {
    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, int iq, Pet pet, HashMap<DayOfWeek, String> schedule) {
        super(name, surname, year, iq, pet, schedule);
    }

    @Override
    public void greetPet() {
        System.out.printf("Oh, my sweet %s! Mommy missed you so much!\n", getPet() != null ? getPet().getNickname() : "darling pet");
    }

    public void makeup() {
        System.out.println("Applying a fresh coat of lipstick for a glamorous day!");
    }
}