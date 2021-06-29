class Zebra implements Animal {

    @Override
    public String getAnimal() {
        return "Zebra";
    }
    public void feedAnimal(){System.out.println("The zebra is eating grass...");}
    public void watchAnimal(){System.out.println("The zebra is running...");}
}