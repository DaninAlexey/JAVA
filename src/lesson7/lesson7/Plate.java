package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void plateinfo() {
        System.out.println("В тарелке " + food + " еды");
    }

    public void addFood(int afood) {
        if (afood >= 0)
            food += afood;
    }

    public boolean decreaseFood(int dfood) {
        if (food - dfood < 0)
            return false;
        else {
            food -= dfood;
            return true;
        }
    }
}
