import java.util.ArrayList;
public class ZooObserver {
    private ArrayList<String> observers;

    public ZooObserver(String name) {
        observers = new ArrayList();
    }



    public void addObserver(String observer) {
        observers.add(observer);
    }

    public void removeObserver(String observer) {
        observers.remove(observer);
    }

    public void notifyObserver(String animal) {
        for (String observer : observers) {
            System.out.println("[" + observer + "] " + animal + " has been added to the Zoo!");
        }
    }
}
