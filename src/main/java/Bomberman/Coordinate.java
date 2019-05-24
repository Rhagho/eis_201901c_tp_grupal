package Bomberman;

import java.util.Objects;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void incrementY() {
        this.y++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public void decrementY() {
        this.y--;
    }

    public void incrementX() {
        this.x++;
    }

    public void decrementX() {
        this.x--;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}