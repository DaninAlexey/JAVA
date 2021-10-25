package lesson6;

public class Test6 {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Барсик", 200,10);
        Cat cat2 = new Cat("Мурзик", 300, 0);
        Dog dog1 = new Dog("Барбос", 300, 50);
        Animal dog2 = new Dog("Рекс", 500, 100);
        Animal[] animals = {cat1, cat2, dog1, dog2};
        for (Animal animal : animals) {
            animal.run(300);
            animal.swim(10);
        }
    }

}
