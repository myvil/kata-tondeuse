package com.kata.latondeuse.domain.usecases;

import com.kata.latondeuse.domain.entities.Command;
import com.kata.latondeuse.domain.entities.Instruction;
import com.kata.latondeuse.domain.entities.Position;
import com.kata.latondeuse.domain.entities.Tondeuse;
import com.kata.latondeuse.infra.CommandFileAdapter;

import java.util.List;
import java.util.stream.Collectors;

public class ExploreSurface {
    private CommandProvider commandProvider;

    public ExploreSurface() {
        commandProvider = new CommandFileAdapter();
    }

    public List<Position> handle() {
        List<Command> commands = commandProvider.buildCommand();
        return commands.stream()
                .map(command -> new Tondeuse(command.getStartPosition()).executeInstructions(command.getInstructions()
                .toArray(new Instruction[0])))
                .collect(Collectors.toList());
    }
}
