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
}
