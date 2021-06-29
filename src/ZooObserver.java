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
        System.out.println("The " + animal + "is eating " + food );
    }
    public void notifyPlay(String animal,String verb)
    {
        System.out.println("The " + animal + "is "+ verb);
    }
}
