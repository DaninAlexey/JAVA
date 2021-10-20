package lesson6;

public abstract class Animal {
    protected String name;
    protected int distRun;
    protected int distSwim;

    public Animal(String name, int distRun, int distSwim) {
        this.name = name;
        this.distRun = distRun;
        this.distSwim = distSwim;
    }

    protected abstract void run(int dist);

    protected abstract void swim(int dist);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistRun() {
        return distRun;
    }

    public void setDistRun(int distRun) {
        this.distRun = distRun;
    }

    public int getDistSwim() {
        return distSwim;
    }

    public void setDistSwim(int distSwim) {
        this.distSwim = distSwim;
    }
}
