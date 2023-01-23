package com.kata.latondeuse.domain;

import java.util.List;

public class Tondeuse {
    private Position position;
    private List<Instruction> instructions;

    public Tondeuse(Position position) {
        this.position = position;
    }

    public void setCommands(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public Position executeCommand(Instruction[] instructions) {
        for (Instruction instruction :
                instructions) {
            executeCommand(instruction);
        }
        return this.position;
    }

    public Position executeCommand(Instruction instruction) {
        switch (instruction) {
            case D:
            case G :
                this.position.rotate(instruction);
                break;
            case A :
                this.position.move();
                break;
            default: throw new UnsupportedOperationException(instruction + "Is not a managed command");
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
        return executeCommand(this.instructions.toArray(new Instruction[0]));
    }
}
