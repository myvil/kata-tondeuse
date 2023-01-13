package com.kata.latondeuse;

public class Position {
    private Coordinate coordinate;
    private Orientation orientation;

    Position(Coordinate coordinate, Orientation orientation) {
        this.coordinate = coordinate;
        this.orientation = orientation;
    }

    public void move() {
        switch (this.orientation) {
            case E : coordinate.moveX(1); break;
            case W : coordinate.moveX(-1); break;
            case N : coordinate.moveY(1); break;
            case S : coordinate.moveY(-1); break;
        }
    }

    public int getY() {
        return this.coordinate.getY();
    }

    public int getX() {
        return this.coordinate.getX();
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public void rotate(Command command) {
        this.orientation = Orientation.rotate(this.orientation, command);
    }

    @Override
    public String toString() {
        return coordinate.getX() + " " + coordinate.getY() + " " + orientation;
    }
}
