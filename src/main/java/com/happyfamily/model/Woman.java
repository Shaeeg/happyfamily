package com.happyfamily.model;

import java.io.Serializable;
import java.util.Random;

public class Woman extends Human implements HumanCreator {
    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }
    public void makeUp(){
        System.out.println("Woman is doing makeup");
    }

    @Override
    public Human bornChild() {
        Random random = new Random();
        int a= random.nextInt(2);
        if(a==0){
            return new Man(getMaleNames()[random.nextInt(getMaleNames().length)],family.getFather().getSurname(), (family.getFather().getIq() + family.getMother().getIq()/2);
        }
        else{
            return new Woman(getFemaleNames()[random.nextInt(getFemaleNames().length)],family.getFather().getSurname(), (family.getFather().getIq() + family.getMother().getIq()/2));
        }
    }
}
