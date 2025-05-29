package com.happyfamily.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Pet pet;
    private HashMap<DayOfWeek, String> schedule;
    private Family family;
    private String[] maleNames = {"Rashad", "Shaig", "Ali", "Rasul"};
    private String[] femaleNames = {"Mansura", "Zulfiyya", "Selcan"};

    public Human(String name, String surname, long birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }


    public Human(String name, String surname, String birthDate, int iq, Pet pet, HashMap<DayOfWeek, String> schedule) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(birthDate, formatter);
        this.name = name;
        this.surname = surname;
        this.birthDate = date.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        this.iq = iq;
        this.pet = pet;
        this.schedule = schedule;
    }

    public Human() {

    }

    public String describeAge() {
        LocalDate birth = Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(birth, LocalDate.now());
        return period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days";
    }

    public void greetPet() {
        if (pet != null) {
            System.out.printf("Hello, %s\n", pet.getNickname());
        } else {
            System.out.println("I don't have a pet to greet.");
        }
    }

    public void describePet() {
        if (pet != null) {
            String slyness = (pet.getTrickLevel() > 50) ? "very sly" : "almost not sly";
            System.out.printf("I have an %s, he is %d years old, he is %s.\n",
                    pet.getSpecies().name().toLowerCase(), pet.getAge(), slyness);
        } else {
            System.out.println("I don't have a pet to describe.");
        }
    }

    public boolean feedPet(boolean isFeedingTime) {
        if (pet == null) {
            System.out.println("I don't have a pet to feed.");
            return false;
        }

        if (isFeedingTime) {
            System.out.printf("Hm... I will feed %s's %s.\n", name, pet.getNickname());
            return true;
        } else {
            Random random = new Random();
            int randomNumber = random.nextInt(101);
            if (pet.getTrickLevel() > randomNumber) {
                System.out.printf("Hm... I will feed %s's %s.\n", name, pet.getNickname());
                return true;
            } else {
                System.out.printf("I think %s is not hungry.\n", pet.getNickname());
                return false;
            }
        }
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
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

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) throws IllegalArgumentException {
        if (iq >= 1 && iq <= 100) {
            this.iq = iq;
        } else {
            throw new IllegalArgumentException("Iq must be between 1 and 100");
        }
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate().format(formatter);
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + formattedDate +
                ", iq=" + iq +
                ", pet=" + pet +
                ", schedule=" + schedule +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate);
    }

    static {
        System.out.println("Human object created");
    }
}
