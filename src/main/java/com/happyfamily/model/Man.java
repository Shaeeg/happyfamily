package com.happyfamily.model;

public class Man extends Human {
    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int iq) {
        super(name, surname, iq);
    }
    public void repairCar(){
        System.out.println("He is repairing car");
    }

}
