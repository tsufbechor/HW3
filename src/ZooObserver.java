import java.util.ArrayList;
public class ZooObserver {
    private String name;

    public ZooObserver(String name) {
        this.name = name;
    }

    public void notifyObserver(String animal) {
            System.out.println("[" + this.name + "] " + animal + " has been added to the Zoo!");
    }
    public void notifyFood(String animal,String food)
    {
        switch(animal) {
            case "Zebra":
                System.out.println("The zebra is running...");
            case "Unicorn":
                System.out.println("The unicorn is flying...");
            case "Monkey":
                System.out.println("The monkey is hanging on trees...");
        }
    }
    public void notifyPlay(String animal,String verb)
    {
        switch(animal) {
            case "Zebra":
                System.out.println("The zebra is eating grass...");
            case "Unicorn":
                System.out.println("The unicorn is eating rainbow cakes...");
            case "Monkey":
                System.out.println("The monkey is eating a banana...");
        }
    }
}
