package com.kata.latondeuse;

public class Tondeuse {
    private Position position;

    public Tondeuse(Position position) {
        this.position = position;
    }

    public Position move(Command[] commands) {
        for (Command command :
                commands) {
            move(command);
        }
        return this.position;
    }

    public Position move(Command command) {
        switch (command) {
            case D:
                this.position.rotateRight();
                break;
            case G :
                this.position.rotateLeft();
                break;
            case A :
                this.position.move();
                break;
            default: throw new UnsupportedOperationException(command + "Is not a managed command");
        }
        return this.position;
    }

    public Position getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return "Tondeuse{" +
                "position=" + position +
                '}';
    }
}
