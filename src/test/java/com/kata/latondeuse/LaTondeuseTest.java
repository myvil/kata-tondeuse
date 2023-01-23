package com.kata.latondeuse;

import com.kata.latondeuse.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.kata.latondeuse.domain.Instruction.*;
import static com.kata.latondeuse.domain.Orientation.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class LaTondeuseTest {

    private Tondeuse tondeuse;
    private Coordinate origin;

    @BeforeEach
    void setUp() {
        Orientation orientation = N;
        origin = new Coordinate(0,0, 5, 5);
        Position startPosition = new Position(origin, orientation);
        tondeuse = new Tondeuse(startPosition);
    }

    @Test
    void shouldMoveToEast() {
        tondeuse.executeCommand(D);
        assertThat(tondeuse.getPosition().getX(), equalTo(0));
        assertThat(tondeuse.getPosition().getOrientation(), equalTo(E));
    }

    @Test
    void shouldMoveToWest() {
        Instruction[] instructions = {G,A};
        tondeuse.executeCommand(instructions);
        assertThat(tondeuse.getPosition().getX(), equalTo(0));
        assertThat(tondeuse.getPosition().getOrientation(), equalTo(W));
    }

    @Test
    void shouldMoveToNorth() {
        tondeuse.executeCommand(A);
        assertThat(tondeuse.getPosition().getY(), equalTo(1));
        assertThat(tondeuse.getPosition().getOrientation(), equalTo(N));
    }

    @Test
    void shouldMoveToSouth() {
        Instruction[] instructions = {D,D,A};
        tondeuse.executeCommand(instructions);
        assertThat(tondeuse.getPosition().getY(), equalTo(0));
        assertThat(tondeuse.getPosition().getOrientation(), equalTo(S));
    }

    @Test
    void shouldThrowUnexpectedOperationIfOrientationIsNotKnown() {
        Exception thrown = Assertions.assertThrows(UnsupportedOperationException.class, () -> tondeuse.executeCommand(Instruction.UNKNOWN));
        assertThat(thrown.getMessage(), equalTo(Instruction.UNKNOWN.name() + "Is not a managed command"));
    }

    @Test
    void shouldNotMoveIfPositionOutOfLawn() {
        Instruction[] instructions = {D,A, A, A, A, A, A};
        tondeuse.executeCommand(instructions);
        assertThat(tondeuse.getPosition().getX(), equalTo(5));
        assertThat(tondeuse.getPosition().getY(), equalTo(0));
        assertThat(tondeuse.getPosition().getOrientation(), equalTo(E));
    }

}
