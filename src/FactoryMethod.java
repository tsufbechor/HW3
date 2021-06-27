public class FactoryMethod {
    AnimalFactory unicornFactory = new UnicornFactory();
    Animal myAnimal = unicornFactory.createAnimal();

}
