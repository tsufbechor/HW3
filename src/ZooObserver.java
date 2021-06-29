import java.util.ArrayList;
public class ZooObserver {
    private String name;

    public ZooObserver(String name) {
        this.name = name;
    }

    public void notifyObserver(String animal) {
        switch(animal) {
            case "fed":
                System.out.println("[" + this.name + "] The animals are being fed");
                break;
            case "watch":
                System.out.println("[" + this.name + "] The animals are being watched");
                break;
            default :
                System.out.println("[" + this.name + "] " + animal + " has been added to the zoo!");
        }

    }
    public void notifyFood(String animal)
    {
        switch(animal) {
            case "Zebra":
                System.out.println("The zebra is running...");
                break;
            case "Unicorn":
                System.out.println("The unicorn is flying...");
                break;
            case "Monkey":
                System.out.println("The monkey is hanging on trees...");
                break;
        }
    }
    public void notifyPlay(String animal)
    {
        switch(animal) {
            case "Zebra":
                System.out.println("The zebra is eating grass...");
                break;
            case "Unicorn":
                System.out.println("The unicorn is eating rainbow cakes...");
                break;
            case "Monkey":
                System.out.println("The monkey is eating a banana...");
                break;
        }
    }
}
