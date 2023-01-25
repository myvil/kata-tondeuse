package com.kata.latondeuse;

import com.kata.latondeuse.domain.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.kata.latondeuse.domain.entities.Instruction.*;
import static com.kata.latondeuse.domain.entities.Orientation.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class LaTondeuseTest {

    private Tondeuse tondeuse;
    private Coordinate origin;

    @BeforeEach
    void setUp() {
        origin = new Coordinate(0,0, 5, 5);
        Position startPosition = new Position(origin, N);
        tondeuse = new Tondeuse(startPosition);
    }

    @Test
    void shouldMoveToEast() {
        tondeuse.executeInstructions(D);
        assertThat(tondeuse.getPosition().getX(), equalTo(0));
        assertThat(tondeuse.getPosition().getOrientation(), equalTo(E));
    }

    @Test
    void shouldMoveToWest() {
        tondeuse.executeInstructions(G,A);
        assertThat(tondeuse.getPosition().getX(), equalTo(0));
        assertThat(tondeuse.getPosition().getOrientation(), equalTo(W));
    }

    @Test
    void shouldMoveToNorth() {
        tondeuse.executeInstructions(A);
        assertThat(tondeuse.getPosition().getY(), equalTo(1));
        assertThat(tondeuse.getPosition().getOrientation(), equalTo(N));
    }

    @Test
    void shouldMoveToSouth() {
        tondeuse.executeInstructions(D,D,A);
        assertThat(tondeuse.getPosition().getY(), equalTo(0));
        assertThat(tondeuse.getPosition().getOrientation(), equalTo(S));
    }

    @Test
    void shouldThrowUnexpectedOperationIfOrientationIsNotKnown() {
        Exception thrown = Assertions.assertThrows(UnsupportedOperationException.class, () -> tondeuse.executeInstructions(Instruction.UNKNOWN));
        assertThat(thrown.getMessage(), equalTo(Instruction.UNKNOWN.name() + "Is not a managed command"));
    }

    @Test
    void shouldNotMoveIfPositionOutOfLawn() {
        tondeuse.executeInstructions(D,A, A, A, A, A, A);
        assertThat(tondeuse.getPosition().getX(), equalTo(5));
        assertThat(tondeuse.getPosition().getY(), equalTo(0));
        assertThat(tondeuse.getPosition().getOrientation(), equalTo(E));
    }

}
