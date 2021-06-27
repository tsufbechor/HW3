class UnicornFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        ZooObserver.notifyObserver(Unicorn.getAnimal());
        return new Unicorn();
    }
}
