package com.kata.latondeuse;

import com.kata.latondeuse.application.TondeuseAdapter;
import com.kata.latondeuse.domain.entities.Position;

import java.util.stream.Collectors;


public class Application {

    public static void main(String[] args) {
        System.out.println(new TondeuseAdapter().explore().stream().map(Position::toString).collect(Collectors.joining(" ")));
    }
}
