package com.happyfamily.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Human implements Serializable {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Family family;
    private Map<DayOfWeek, String> schedule;

    static {
        System.out.println("Human class is being loaded.");
    }

    {
        System.out.println("Human object is being created.");
    }

    public Human(String name, String surname, long birthDate, int iq, Family family, Map<DayOfWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.family = family;
        this.schedule = schedule;
    }

    public Human(String name, String surname, long birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Human(String name, String surname, long birthDate, Family family) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.family = family;
    }

    public Human(String name, String surname, String birthDateString, int iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = parseDateToMillis(birthDateString);
        this.iq = iq;
    }

    public Human(String name, String surname, long birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
    }

    public Human() {
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

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    public void greetPet() {
        Pet pet = null;
        if (family != null && !family.getPets().isEmpty()) {
            pet = family.getPets().iterator().next();
        }

        if (pet != null) {
            System.out.printf("Hello, %s\n", pet.getNickname());
        } else {
            System.out.println("No pet to greet.");
        }
    }


    public void describePet() {
        Pet pet = null;
        if (family != null && !family.getPets().isEmpty()) {
            pet = family.getPets().iterator().next();
        }

        if (pet != null) {
            String slyness = pet.getTrickLevel() > 50 ? "very sly" : "almost not sly";
            System.out.printf("I have an %s, he is %d years old, he is %s.\n",
                    pet.getSpecies().name().toLowerCase(), pet.getAge(), slyness);
        } else {
            System.out.println("No pet to describe.");
        }
    }

    public boolean feedPet(boolean isTimeToFeed) {
        Pet pet = null;
        if (family != null && !family.getPets().isEmpty()) {
            pet = family.getPets().iterator().next();
        }

        if (pet == null) {
            System.out.println("No pet to feed.");
            return false;
        }

        if (isTimeToFeed) {
            System.out.printf("Hm... I will feed %s's %s\n", pet.getNickname(), pet.getSpecies().name().toLowerCase());
            return true;
        } else {
            if (pet.getTrickLevel() > 50) {
                System.out.printf("I think %s is not hungry.\n", pet.getNickname());
                return false;
            } else {
                System.out.printf("Hm... I will feed %s's %s\n", pet.getNickname(), pet.getSpecies().name().toLowerCase());
                return true;
            }
        }
    }

    public String describeAge() {
        LocalDate birth = Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = LocalDate.now();
        Period period = Period.between(birth, now);
        return String.format("My age is %d years, %d months, and %d days.",
                period.getYears(), period.getMonths(), period.getDays());
    }

    @Override
    public String toString() {
        String birthDateFormatted = Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        StringBuilder sb = new StringBuilder("Human{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", birthDate=").append(birthDateFormatted);
        sb.append(", iq=").append(iq);

        if (family != null) {
            if (family.getMother() != null && family.getMother() != this) {
                sb.append(", mother=").append(family.getMother().getName()).append(" ").append(family.getMother().getSurname());
            }
            if (family.getFather() != null && family.getFather() != this) {
                sb.append(", father=").append(family.getFather().getName()).append(" ").append(family.getFather().getSurname());
            }
            if (family.getPets() != null && !family.getPets().isEmpty()) {
                sb.append(", pet=").append(family.getPets().iterator().next().toString());
            }
        }
        sb.append(", schedule=").append(schedule);
        sb.append('}');
        return sb.toString();
    }

    public String prettyFormat() {
        String birthDateFormatted = Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("name='%s'\n", name));
        sb.append(String.format("surname='%s'\n", surname));
        sb.append(String.format("birthDate='%s'\n", birthDateFormatted));
        sb.append(String.format("iq=%d", iq));
        if (schedule != null && !schedule.isEmpty()) {
            sb.append(String.format(", schedule=%s", schedule));
        }
        return sb.toString();
    }

    public static long parseDateToMillis(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate date = LocalDate.parse(dateString, formatter);
            return date.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + dateString + ". Expected DD/MM/YYYY.", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate &&
                iq == human.iq &&
                name.equals(human.name) &&
                surname.equals(human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, iq);
    }
}