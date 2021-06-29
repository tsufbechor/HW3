import java.util.ArrayList;
import java.util.HashMap;

public class Zoo {
    private static Zoo instance = null;
    private ArrayList<Animal> animals;
    private ArrayList<ZooObserver> observers;
    private int happiness;
    private int hunger ;
    private static final int MAXLEVEL=5;
    private static final int SPLITLEVEL=3;
    private static final int MINLEVEL=1;

    private Zoo(){
        animals = new ArrayList<>();
        observers = new ArrayList<>();
        happiness = 2;
        hunger  = 3;
    }

    public static Zoo getInstance(){
        if(instance == null){
            instance=new Zoo();
            System.out.println("Creating zoo...");
        }
        else{
            System.out.println("The zoo already exists...");
        }
        return instance;
    }
    public void addObserver(ZooObserver observer){
        this.observers.add(observer);
    }
    public void removeObserver(ZooObserver observer){
        this.observers.remove(observer);
    }
    public void feedAnimals(){
        for (Animal animal:animals) {
            if(this.observers!=null) {
                this.observers.get(0).notifyFood(animal.getAnimal());
            }
        }
        System.out.println("Notifying observers:");
        for (ZooObserver observer:this.observers) {
            observer.notifyObserver("fed");
        }
        if(this.hunger > MINLEVEL){
            this.hunger--;
        }
    }
    public void watchAnimals(){
        for (Animal animal:animals) {
            if(this.observers!=null)
                this.observers.get(0).notifyPlay(animal.getAnimal());
        }
        System.out.println("Notifying observers:");
        for (ZooObserver observer:this.observers) {
            observer.notifyObserver("watch");
        }
        if(this.happiness < MAXLEVEL){
            this.happiness++;
        }
        if(this.hunger < MAXLEVEL){
            this.hunger++;
        }
    }
    public void addAnimal(Animal animal){
        this.animals.add(animal);
        System.out.println("Notifying observers:");
        for (ZooObserver observer: observers) {
            observer.notifyObserver(animal.getAnimal());
        }
    }
    public void showAnimalsInfo(){
        System.out.println("The zoo contains total of " + animals.size() + " animals:");
        HashMap<String,Integer> splits=this.animalSplit();
        for (String type: splits.keySet()) {
            System.out.println("- "+ type +":"+ splits.get(type));
        }
        System.out.println("Happiness level:"+this.happiness);
        if(this.happiness < SPLITLEVEL){
            System.out.println("The animals are not happy, you should watch them...");
        }
        else{
            System.out.println("The animals are very happy, keep working hard…");
        }
        System.out.println("Hunger  level:"+this.hunger );
        if(this.hunger  > SPLITLEVEL){
            System.out.println("The animals are hungry, you should feed them…");
        }
    }
    private HashMap<String,Integer> animalSplit(){
        HashMap<String,Integer> splits=new HashMap<>();
        String type;
        for (Animal animal:this.animals) {
            type=animal.getAnimal();
            if(splits.containsKey(type)){
               splits.replace(type,splits.get(type)+1);
            }
            else{
                splits.put(type,1);
            }
        }
        return splits;
    }


}
