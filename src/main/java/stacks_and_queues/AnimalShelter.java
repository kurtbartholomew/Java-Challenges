package stacks_and_queues;

import java.util.LinkedList;

public class AnimalShelter {

    public int numOfPets;
    private LinkedList<Cat> catStorage;
    private LinkedList<Dog> dogStorage;

    public AnimalShelter() {
        this.catStorage = new LinkedList<>();
        this.dogStorage = new LinkedList<>();
    }

    public AnimalShelter(LinkedList<Cat> catList, LinkedList<Dog> dogList) {
        this.catStorage = catList;
        this.dogStorage = dogList;
    }

    private static abstract class Animal {
        public int id;
    }

    public static class Cat extends Animal {
        public Cat() {}
        public Cat(int id) { this.id = id; }
    }

    public static class Dog extends Animal {
        public Dog() {}
        public Dog(int id) { this.id = id; }
    }

    public <E extends Animal> void enqueue(E animal) {
        animal.id = ++this.numOfPets;
        if(animal instanceof Cat) {
            this.catStorage.offer((AnimalShelter.Cat) animal);
        } else {
            this.dogStorage.offer((AnimalShelter.Dog) animal);
        }
    }

    public Cat dequeueCat() {
        return this.catStorage.poll();
    }

    public Dog dequeueDog() {
        return this.dogStorage.poll();
    }

    public Animal dequeueAny() {
        Cat cat = this.catStorage.peek();
        Dog dog = this.dogStorage.peek();
        if(cat == null && dog != null) {
            this.dogStorage.poll();
            return dog;
        }
        if(dog == null && cat != null) {
            this.catStorage.poll();
            return cat;
        }
        if(dog == null && cat == null) { return null; }
        return cat.id <= dog.id ? this.catStorage.poll() : this.dogStorage.poll();
    }
}
