package com.happyfamily.model;

import java.util.Map;

public final class Woman extends Human {
    public Woman(String name, String surname, long birthDate, int iq, Family family, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthDate, iq, family, schedule);
    }

    public Woman(String name, String surname, long birthDate) {
        super(name, surname, birthDate);
    }

    public Woman() {
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && getFamily().getPets() != null && !getFamily().getPets().isEmpty()) {
            getFamily().getPets().forEach(pet -> System.out.println("Oh, hello there, my sweet " + pet.getNickname() + "!"));
        } else {
            System.out.println("No pet to greet for a woman.");
        }
    }

    public void doMakeup() {
        System.out.println("Time to put on some makeup!");
    }
}