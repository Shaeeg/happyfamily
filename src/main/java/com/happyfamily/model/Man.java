package com.happyfamily.model;


import java.util.Map;

public final class Man extends Human {
    public Man(String name, String surname, long birthDate, int iq, Family family, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthDate, iq, family, schedule);
    }

    public Man(String name, String surname, long birthDate) {
        super(name, surname, birthDate);
    }

    public Man() {
    }

    @Override
    public void greetPet() {
        if (getFamily() != null && getFamily().getPets() != null && !getFamily().getPets().isEmpty()) {
            getFamily().getPets().forEach(pet -> System.out.println("What's up, " + pet.getNickname() + ", my man!"));
        } else {
            System.out.println("No pet to greet for a man.");
        }
    }

    public void repairCar() {
        System.out.println("I'm fixing the car, darling.");
    }
}