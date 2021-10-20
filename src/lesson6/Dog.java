package lesson6;

public class Dog extends Animal {

    public Dog(String name, int distRun, int distSwim )
    {super(name, distRun, distSwim);}

    public void run(int dist)
    {if (dist<=this.distRun)
        System.out.printf("Пес %s пробежал %d метров\n",this.name, dist);
    else
        System.out.printf("Пес %s не может пробежать такое расстояние\n", this.name);
    }

    public void swim(int dist)
    {if (dist<=this.distSwim)
        System.out.printf("Пес %s проплыл %d метров\n",this.name, dist);
    else
        System.out.printf("Пес %s не может проплыть такое расстояние\n", this.name);
    }
}
