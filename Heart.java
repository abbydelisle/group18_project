import java.util.ArrayList;


public class Heart {
    private int life = 5;
    private int y = 10;
    private ArrayList<Integer> heartList = new ArrayList<Integer>();
    final int HEART_INCREASE_X_COORD = 30;


    public void createHeartList(int j) {
        for (int i = 0; i < getLife(); i++) {
            heartList.add(j + i * HEART_INCREASE_X_COORD);
        }
    }

    public void removeHeartList() {
        heartList.clear();
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        if (life >= 0) {
            this.life = life;
        }
    }

    public ArrayList<Integer> getHeartList() {
        return heartList;
    }

    public void setHeartList(ArrayList<Integer> heartList) {
        this.heartList = heartList;
    }

    public int getY() {
        return y;
    }

    public void loseLife() {
        setLife(getLife() - 1);
    }

    public void setY(int y) {
        this.y = y;
    }

}
