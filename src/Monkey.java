class Monkey implements Animal {

    @Override
    public String getAnimal() {
        return "Monkey";
    }
    public void feedAnimal(){System.out.println("The monkey is eating a banana...");}
    public void watchAnimal(){System.out.println("The monkey is hanging on trees...");}
}