package com.kata.latondeuse;

import com.kata.latondeuse.domain.entities.Instruction;
import com.kata.latondeuse.domain.entities.Tondeuse;
import com.kata.latondeuse.domain.entities.Command;
import com.kata.latondeuse.infra.CommandFileAdapter;
import com.kata.latondeuse.domain.usecases.TondeuseProvider;


public class Application {

    public static void main(String[] args) {
        TondeuseProvider tondeuseAdapter = new TondeuseProvider();
        CommandFileAdapter commandFileAdapter = new CommandFileAdapter();
        for (Command command :
                commandFileAdapter.buildCommand()) {
            Tondeuse tondeuse = tondeuseAdapter.createTondeuse(command.getStartPosition());
            tondeuseAdapter.explore(tondeuse, command.getInstructions().toArray(new Instruction[0]));
            tondeuseAdapter.printResult(tondeuse);
        }
    }
}
