package Games.Simulation;

public class Creature extends Entity{
    private int speed;

    private int hp;

    public Creature(int speed, int hp) {
        this.speed = speed;
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "speed=" + speed +
                ", hp=" + hp +
                '}';
    }

    public String makeMove() {
        return null;
    }

}
