package lesson6;

public class Cat extends Animal {

    public Cat(String name, int distRun, int distSwim )
    {super(name, distRun, distSwim);}

    public void run(int dist)
    {if (dist<=this.distRun)
        System.out.printf("Кот %s пробежал %d метров\n",this.name, dist);
        else
            System.out.printf("Кот %s не может пробежать такое расстояние\n", this.name);
    }

    public void swim(int dist)
    {if (dist<=this.distSwim)
        System.out.printf("Кот %s проплыл %d метров\n",this.name, dist);
    else
        System.out.printf("Кот %s не может проплыть такое расстояние\n", this.name);
    }
}
