package lesson7;

public class Cat {
    private final String name;
    private final int appetit;
    private boolean satiety = false;

    public Cat(String name, int appetit) {
        this.name = name;
        this.appetit = appetit;
    }

    public void eat(Plate plate) {
        if (satiety)
            System.out.println("Кот " + name + " cыт");
        else {
            satiety = plate.decreaseFood(appetit);
            if (satiety) System.out.println("Кот " + name + " поел");
            else System.out.println("Кот" + name + " не поел. Не хватило еды");
        }
    }

    public void infoSatiety() {
        if (satiety)
            System.out.println("Кот " + name + " сыт");
        else
            System.out.println("Кот " + name + " голоден");
    }

}
