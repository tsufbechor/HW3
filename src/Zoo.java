import java.util.ArrayList;
import java.util.HashMap;

public class Zoo {
    /** Initializing the zoo...*/
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
/** Function will print message according to if zoo exists or not*/
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

    /** feedAnimals function will first run 'for loop' and call the feedAnimal function for each animal in the zoo
     * and then notify each observer that the animals have been feed. After that,hunger level will be adjusted if necessary
     */
    public void feedAnimals(){
        for (Animal animal:animals) {
            animal.feedAnimal();
        }
        System.out.println("Notifying observers:");
        for (ZooObserver observer:this.observers) {
            observer.notifyObserver("fed");
        }
        if(this.hunger > MINLEVEL){
            this.hunger--;
        }
    }

    /**watchAnimals function will first run 'for loop' and call the watchAnimal function for each animal in the zoo
     * and then notify all the observers. After that, hunger and happiness levels will be adjusted if necessary
     */
    public void watchAnimals(){
        for (Animal animal:animals) {
            animal.watchAnimal();
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
    /**Function will add animal to zoo, and then notify each and every observer of the addition*/
    public void addAnimal(Animal animal){
        this.animals.add(animal);
        System.out.println("Notifying observers:");
        for (ZooObserver observer: observers) {
            observer.notifyObserver(animal.getAnimal());
        }
    }

    /**Function will print the amount of animals the zoo contains in total,
     *  and then specifically the number of each different animal
     * After this, the happiness and hunger levels will be printed,
     * an according message will be printed if ony of these levels is not of legal value
     */
    public void showAnimalsInfo(){
        System.out.println("The zoo contains total of " + animals.size() + " animals:");
        HashMap<String,Integer> splits=this.animalSplit();
        for (String type: splits.keySet()) {
            System.out.println("- "+ type +": "+ splits.get(type));
        }
        System.out.println("Happiness level: "+this.happiness);
        if(this.happiness < SPLITLEVEL){
            System.out.println("The animals are not happy, you should watch them...");
        }
        else{
            System.out.println("The animals are very happy, keep working hard…");
        }
        System.out.println("Hunger  level: "+this.hunger );
        if(this.hunger  > SPLITLEVEL){
            System.out.println("The animals are hungry, you should feed them…");
        }
    }
    private HashMap<String,Integer> animalSplit(){
        HashMap<String,Integer> splits=new HashMap<>();
        String type;
        for (Animal animal:this.animals) {
            type=animal.getAnimal();
            if(splits.containsKey(type)){//Checking if the animal type is prevalent in zoo,if not hashmap will be adjusted for new animal
               splits.replace(type,splits.get(type)+1);
            }
            else{
                splits.put(type,1);
            }
        }
        return splits;
    }


}
