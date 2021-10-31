package lesson7;

public class TestCatEating {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик", 5);
        Cat cat2 = new Cat("Мурзик", 10);
        Cat cat3 = new Cat("Рыжик", 6);
        Cat cat4 = new Cat("Тимоша", 8);
        Cat cat5 = new Cat("Васька", 7);
        Cat cat6 = new Cat("Космос", 11);
        Cat cat7 = new Cat("Леопольд", 9);
        Plate plate = new Plate(35);

        Cat[] cats = {cat1, cat2, cat3, cat4, cat5, cat6, cat7};

        for (Cat cat : cats)
            cat.eat(plate);

        plate.plateinfo();
        plate.addFood(20);
        plate.plateinfo();
    }

}
