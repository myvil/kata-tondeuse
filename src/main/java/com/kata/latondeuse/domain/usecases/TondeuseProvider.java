package com.kata.latondeuse.domain.usecases;

import com.kata.latondeuse.domain.entities.Instruction;
import com.kata.latondeuse.domain.entities.Position;
import com.kata.latondeuse.domain.entities.Tondeuse;

public class TondeuseProvider {
    public Tondeuse createTondeuse(Position startPosition) {
        return new Tondeuse(startPosition);
    }

    public Position explore(Tondeuse tondeuse, Instruction[] instructions) {
        return tondeuse.executeInstructions(instructions);
    }

    public void printResult(Tondeuse tondeuse) {
        System.out.println(tondeuse.getPosition());
    }
}
