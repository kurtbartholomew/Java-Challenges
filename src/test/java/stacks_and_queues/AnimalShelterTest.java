package stacks_and_queues;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class AnimalShelterTest {

    private AnimalShelter animalShelter;
    private LinkedList<AnimalShelter.Cat> catList;
    private LinkedList<AnimalShelter.Dog> dogList;

    @Before
    public void setUp() {
        catList = new LinkedList<>();
        dogList = new LinkedList<>();
        catList.offer(new AnimalShelter.Cat(1));
        dogList.offer(new AnimalShelter.Dog(2));
        animalShelter = new AnimalShelter(catList,dogList);
        animalShelter.numOfPets = 2;
    }

    @Test
    public void shouldEnqueueADogOrCat() {
        AnimalShelter.Dog dog = new AnimalShelter.Dog();
        animalShelter.enqueue(dog);
        assertEquals(dogList.getLast(),dog);
        AnimalShelter.Cat cat = new AnimalShelter.Cat();
        animalShelter.enqueue(cat);
        assertEquals(catList.getLast(), cat);
    }

    @Test
    public void shouldDequeueCorrectDog() {
        animalShelter.enqueue(new AnimalShelter.Dog());
        assertEquals(2, animalShelter.dequeueDog().id);
        assertEquals(3, animalShelter.dequeueDog().id);
    }

    @Test
    public void shouldDequeueCorrectCat() {
        animalShelter.enqueue(new AnimalShelter.Cat());
        assertEquals(1, animalShelter.dequeueCat().id);
        assertEquals(3, animalShelter.dequeueCat().id);
    }

    @Test
    public void shouldDequeueCorrectCatOrDog() {
        animalShelter.enqueue(new AnimalShelter.Cat());
        animalShelter.enqueue(new AnimalShelter.Dog());
        AnimalShelter.Cat cat = (AnimalShelter.Cat) animalShelter.dequeueAny();
        assertEquals(1, cat.id);
        AnimalShelter.Dog dog = (AnimalShelter.Dog) animalShelter.dequeueAny();
        assertEquals(2, dog.id);
    }
}