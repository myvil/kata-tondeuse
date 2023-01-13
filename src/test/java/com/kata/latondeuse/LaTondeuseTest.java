package com.kata.latondeuse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.kata.latondeuse.Command.*;
import static com.kata.latondeuse.Orientation.*;
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
        tondeuse.move(D);
        assertThat(tondeuse.getPosition().getX(), equalTo(0));
        assertThat(tondeuse.getPosition().getOrientation(), equalTo(E));
    }

    @Test
    void shouldMoveToWest() {
        Command[] commands = {G,A};
        tondeuse.move(commands);
        assertThat(tondeuse.getPosition().getX(), equalTo(0));
        assertThat(tondeuse.getPosition().getOrientation(), equalTo(W));
    }

    @Test
    void shouldMoveToNorth() {
        tondeuse.move(A);
        assertThat(tondeuse.getPosition().getY(), equalTo(1));
        assertThat(tondeuse.getPosition().getOrientation(), equalTo(N));
    }

    @Test
    void shouldMoveToSouth() {
        Command[] commands = {D,D,A};
        tondeuse.move(commands);
        assertThat(tondeuse.getPosition().getY(), equalTo(-1));
        assertThat(tondeuse.getPosition().getOrientation(), equalTo(S));
    }

    @Test
    void shouldThrowUnexpectedOperationIfOrientationIsNotKnown() {
        Exception thrown = Assertions.assertThrows(UnsupportedOperationException.class, () -> tondeuse.move(Command.UNKNOWN));
        assertThat(thrown.getMessage(), equalTo(Command.UNKNOWN.name() + "Is not a managed command"));
    }

    @Test
    void shouldNotMoveIfPositionOutOfLawn() {
        Command[] commands = {D,A, A, A, A, A, A};
        tondeuse.move(commands);
        assertThat(tondeuse.getPosition().getX(), equalTo(5));
        assertThat(tondeuse.getPosition().getY(), equalTo(0));
        assertThat(tondeuse.getPosition().getOrientation(), equalTo(E));
    }

}
