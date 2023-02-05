package com.kata.latondeuse.domain.entities;

import static com.kata.latondeuse.domain.entities.Instruction.*;

public enum Orientation {
    N () {
        Orientation rotate(Instruction instruction) {
            return instruction == G ? W : E;
        }
    },
    S () {
         Orientation rotate(Instruction instruction) {
            return instruction == G ? E : W;
        }
    },
    W () {
         Orientation rotate(Instruction instruction) {
            return instruction == G ? S : N;
        }
    },
    E() {
         Orientation rotate(Instruction instruction) {
            return instruction == G ? N : S;
        }
    };

    abstract Orientation rotate(Instruction instruction);

}
