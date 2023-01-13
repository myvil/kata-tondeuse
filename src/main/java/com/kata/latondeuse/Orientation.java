package com.kata.latondeuse;

public enum Orientation {
    N, S, W, E;

    public static Orientation rotateG(Orientation orientation) {
        switch (orientation) {
            case E: return N;
            case N : return W;
            case W : return S;
            case S : return E;
            default: throw new UnsupportedOperationException(orientation + " Is not a managed orientation");
        }
    }

    public static Orientation  rotateD(Orientation orientation) {
        switch (orientation) {
            case E : return S;
            case S : return W;
            case W : return N;
            case N : return E;
            default: throw new UnsupportedOperationException(orientation + " Is not a managed orientation");
        }
    }
}
