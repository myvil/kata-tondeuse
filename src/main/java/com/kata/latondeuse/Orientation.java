package com.kata.latondeuse;

import static com.kata.latondeuse.Command.*;

public enum Orientation {
    N, S, W, E;

    public static Orientation rotate(Orientation orientation, Command command) {
        switch (orientation) {
            case E : return command == G ? N : S;
            case S : return command == G ? E : W;
            case W : return command == G ? S : N;
            case N : return command == G ? W : E;
            default: throw new UnsupportedOperationException(orientation + " Is not a managed orientation");
        }
    }
}
