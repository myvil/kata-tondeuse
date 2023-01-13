package com.kata.latondeuse;

import java.util.List;

public class Tondeuse implements Runnable {
    private Position position;
    private List<Command> commands;

    public Tondeuse(Position position) {
        this.position = position;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void run() {
        System.out.println(executeCommands());
    }

    public Position executeCommand(Command[] commands) {
        for (Command command :
                commands) {
            executeCommand(command);
        }
        return this.position;
    }

    public Position executeCommand(Command command) {
        switch (command) {
            case D:
            case G :
                this.position.rotate(command);
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

    public Position executeCommands() {
        return executeCommand(this.commands.toArray(new Command[0]));
    }
}
