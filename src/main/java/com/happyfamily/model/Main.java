package com.happyfamily.model;

import com.happyfamily.model.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Happy Family Project Test Started (Azerbaijani Names) ---");

        // --- Create Pet Instances ---
        Dog garabash = new Dog("Garabash", 4, 70, new String[]{"bark", "run", "sleep"});
        DomesticCat pamuk = new DomesticCat("Pamuk", 2, 85, new String[]{"meow", "purr", "play"});
        Fish qizil_baliq = new Fish("Qızılbalıq", 1, 15, new String[]{"swim"});
        RoboCat robot_pisik = new RoboCat("RobotPişik", 6, 90, new String[]{"charge", "guard"});

        Set<Pet> initialFamilyPets = new HashSet<>();
        initialFamilyPets.add(garabash);
        initialFamilyPets.add(pamuk);

        // --- Create Human Instances with HashMap schedule ---
        HashMap<DayOfWeek, String> fatherSchedule = new HashMap<>();
        fatherSchedule.put(DayOfWeek.MONDAY, "work");
        fatherSchedule.put(DayOfWeek.SATURDAY, "play football");

        Man father = new Man("Əli", "Əliyev", 1968, 95, null, fatherSchedule);

        HashMap<DayOfWeek, String> motherSchedule = new HashMap<>();
        motherSchedule.put(DayOfWeek.TUESDAY, "shopping");
        motherSchedule.put(DayOfWeek.SUNDAY, "relax");

        Woman mother = new Woman("Zəhra", "Əliyeva", 1972, 92, null, motherSchedule);

        HashMap<DayOfWeek, String> childSchedule = new HashMap<>();
        childSchedule.put(DayOfWeek.MONDAY, "do homework");
        childSchedule.put(DayOfWeek.WEDNESDAY, "play games");
        childSchedule.put(DayOfWeek.FRIDAY, "go to party");

        Human child = new Human("Elvin", "Əliyev", 1995, 90, null, childSchedule);

        // --- Create a Family Instance with a Set of pets ---
        Family aliyevFamily = new Family(mother, father);
        aliyevFamily.setPets((HashSet<Pet>) initialFamilyPets);

        aliyevFamily.addChild(child);
        aliyevFamily.addChild(new Human("Aysel", "Əliyeva", 2000, 88, null, new HashMap<>()));

        System.out.println("Initial Family:\n" + aliyevFamily.toString());
        System.out.println("Family size: " + aliyevFamily.countFamily());

        // --- Demonstrate Human methods with multiple pets (if applicable) ---
        child.setPet(garabash);
        child.greetPet();
        child.describePet();
        child.feedPet(true);

        father.setPet(pamuk);
        father.greetPet();
        father.describePet();

        System.out.println("\n--- Testing Schedule (HashMap) ---");
        System.out.println("Father's schedule on Monday: " + father.getSchedule().get(DayOfWeek.MONDAY));
        System.out.println("Child's schedule on Friday: " + child.getSchedule().get(DayOfWeek.FRIDAY));
        System.out.println("Child's schedule on Sunday: " + child.getSchedule().get(DayOfWeek.SUNDAY));

        // --- Demonstrate adding/removing pets in Family's Set ---
        System.out.println("\n--- Testing Family's Pet Set ---");
        System.out.println("Pets in family initially: " + aliyevFamily.getPets().size());
        aliyevFamily.getPets().add(qizil_baliq);
        System.out.println("Pets in family after adding Qızılbalıq: " + aliyevFamily.getPets().size());
        System.out.println("Family details with Qızılbalıq added:\n" + aliyevFamily.toString());

        aliyevFamily.getPets().remove(garabash);
        System.out.println("Pets in family after removing Garabash: " + aliyevFamily.getPets().size());
        System.out.println("Family details with Garabash removed:\n" + aliyevFamily.toString());

        // --- Demonstrate deleteChild(int index) and deleteChild(Human) ---
        System.out.println("\n--- Testing Child Deletion ---");
        System.out.println("Family children before deletion: " + aliyevFamily.getChildren().size());
        boolean deleted = aliyevFamily.deleteChild(0); // Aysel will be at index 0
        System.out.println("Child deleted by index (Aysel): " + deleted);
        System.out.println("Family children after deletion by index: " + aliyevFamily.getChildren().size());
        System.out.println("Family after child deletion by index:\n" + aliyevFamily.toString());

        Human anotherChild = new Human("Leyla", "Əliyeva", 2010, 75, null, new HashMap<>());
        aliyevFamily.addChild(anotherChild);
        System.out.println("\nAdded another child (Leyla). Family children: " + aliyevFamily.getChildren().size());
        System.out.println("Attempting to delete Leyla (by object):");
        deleted = aliyevFamily.deleteChild(anotherChild);
        System.out.println("Leyla deleted by object: " + deleted);
        System.out.println("Family children after deletion by object: " + aliyevFamily.getChildren().size());
        System.out.println("Family after deleting Leyla by object:\n" + aliyevFamily.toString());

        // --- Demonstrate equals() and hashCode() ---
        System.out.println("\n--- Testing equals() and hashCode() ---");
        Human human1 = new Human("Test", "İstifadəçi", 1990, 70, null, new HashMap<>());
        Human human2 = new Human("Test", "İstifadəçi", 1990, 80, null, new HashMap<>());
        Human human3 = new Human("Başqa", "İstifadəçi", 1990, 75, null, new HashMap<>());
        System.out.println("Human1 equals Human2: " + human1.equals(human2));
        System.out.println("Human1 equals Human3: " + human1.equals(human3));
        System.out.println("Human1 hash: " + human1.hashCode());
        System.out.println("Human2 hash: " + human2.hashCode());
        System.out.println("Human3 hash: " + human3.hashCode());

        // --- HW03: finalize() and Garbage Collector ---
        System.out.println("\n--- HW03: finalize() and Garbage Collector ---");
        System.out.println("Creating many Human objects to trigger GC...");
        List<Human> humansToDiscard = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            humansToDiscard.add(new Human("Disposable", "Human" + i, 2020, 50, null, new HashMap<>()));
        }
        humansToDiscard = null;
        System.gc();
        System.out.println("GC requested. Check console for finalize messages.");

        // --- HW04: Inheritance and Polymorphism ---
        System.out.println("\n--- HW04: Inheritance and Polymorphism ---");

        Man dadPolymorphism = new Man("Kamran", "Quliyev", 1970, 90, pamuk, new HashMap<>());
        Woman momPolymorphism = new Woman("Aynur", "Quliyeva", 1972, 88, qizil_baliq, new HashMap<>());

        dadPolymorphism.greetPet();
        momPolymorphism.greetPet();
        dadPolymorphism.repairCar();
        momPolymorphism.makeup();

        // --- Advanced Task: bornChild ---
        System.out.println("\n--- Advanced Task: bornChild ---");
        Family bornChildFamily = new Family(momPolymorphism, dadPolymorphism);
        bornChildFamily.setPets(new HashSet<>(Arrays.asList(garabash, pamuk)));

        System.out.println("Family before child birth: " + bornChildFamily.countFamily());
        // Note: The bornChild method in Family.java still picks from a generic list of names.
        // To make the newly born child also have an Azerbaijani name, you would need to modify
        // the `randomNames` list directly in the `Family.bornChild` implementation.
        Human newChild = bornChildFamily.bornChild(bornChildFamily, dadPolymorphism.getName(), momPolymorphism.getName());
        System.out.println("Newly born child: " + newChild.toString());
        System.out.println("Family after child birth: " + bornChildFamily.countFamily());
        System.out.println("Family children list: " + Arrays.toString(bornChildFamily.getChildren().toArray()));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}