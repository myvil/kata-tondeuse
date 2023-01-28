package com.kata.latondeuse.application;

import com.kata.latondeuse.domain.entities.Position;
import com.kata.latondeuse.domain.usecases.ExploreSurface;

import java.util.List;

public class TondeuseAdapter {

    private ExploreSurface exploreSurface;

    public TondeuseAdapter() {
        this.exploreSurface = new ExploreSurface();
    }

    public List<Position> explore() {
        return exploreSurface.handle();
    }
}
