import org.example.Zoo;
import org.example.animals.*;
import org.example.cages.BirdCage;
import org.example.cages.LionCage;
import org.example.cages.UngulateCage;
import org.example.exceptions.AnimalNotFoundException;
import org.example.exceptions.CageFullException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.*;

public class ZooTest {

    private LionCage lionCage;
    private UngulateCage<Ungulate> ungulateCage;
    private BirdCage<Bird> birdCage;

    @BeforeEach
    public void setUp() {
        lionCage = new LionCage(2);
        ungulateCage = new UngulateCage<>(3);
        birdCage = new BirdCage<>(5);
    }

    @Test
    public void testAddRemoveAndCounts() {
        Lion l1 = new Lion("Simba");
        Lion l2 = new Lion("Mufasa");
        lionCage.addAnimal(l1);
        lionCage.addAnimal(l2);

        assertEquals(2, lionCage.getCurrentCount());
        assertEquals(2, lionCage.getMaxCapacity());

        ungulateCage.addAnimal(new Zebra("Zebr"));
        ungulateCage.addAnimal(new Giraffe("Melman"));

        birdCage.addAnimal(new Eagle("Baldur"));

        Zoo zoo = new Zoo();
        zoo.addCage(lionCage);
        zoo.addCage(ungulateCage);
        zoo.addCage(birdCage);

        assertEquals(5, zoo.getCountOfAnimals());
    }

    @Test
    public void testCapacity() {
        LionCage small = new LionCage(1);
        small.addAnimal(new Lion("L1"));
        assertThrows(CageFullException.class, () -> small.addAnimal(new Lion("L2")));
    }

    @Test
    public void testRemoveNonExisting() {
        Lion l = new Lion("Unique");
        assertThrows(AnimalNotFoundException.class, () -> lionCage.removeAnimal(l));
    }


    @Test
    public void testRemovalByEquals() {
        Lion a = new Lion("Leo");
        lionCage.addAnimal(a);

        Lion b = new Lion("Leo");
        lionCage.removeAnimal(b);

        assertEquals(0, lionCage.getCurrentCount());
    }

    @Test
    public void testBirdCageGeneric() {
        birdCage.addAnimal(new Eagle("E1"));
        birdCage.addAnimal(new Eagle("E2"));

        assertEquals(2, birdCage.getCurrentCount());

        BirdCage<Eagle> eagleCage = new BirdCage<>(2);
        eagleCage.addAnimal(new Eagle("E3"));
        assertEquals(1, eagleCage.getCurrentCount());
    }

    @Test
    public void testUngulateCage() {
        ungulateCage.addAnimal(new Zebra("Z1"));
        ungulateCage.addAnimal(new Giraffe("G1"));
        assertEquals(2, ungulateCage.getCurrentCount());
    }

}
