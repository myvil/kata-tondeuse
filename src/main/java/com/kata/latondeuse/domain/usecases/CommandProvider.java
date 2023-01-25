package com.kata.latondeuse.domain.usecases;

import com.kata.latondeuse.domain.entities.Command;

import java.util.List;

public interface CommandProvider {
    List<Command> buildCommand();
}
