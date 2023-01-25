package com.kata.latondeuse.domain.entities;

import static com.kata.latondeuse.domain.entities.Instruction.*;

public enum Orientation {
    N, S, W, E;

    public static Orientation rotate(Orientation orientation, Instruction instruction) {
        switch (orientation) {
            case E : return instruction == G ? N : S;
            case S : return instruction == G ? E : W;
            case W : return instruction == G ? S : N;
            case N : return instruction == G ? W : E;
            default: throw new UnsupportedOperationException(orientation + " Is not a managed orientation");
        }
    }
}
