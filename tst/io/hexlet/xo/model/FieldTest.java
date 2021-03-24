package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void testGetSize() {
        final Field field = new Field();

        assertEquals(3, field.getSize());
    }

    @Test
    public void testGetFigure() {
    }

    @Test
    public void testSetFigure() throws InvalidPointException, AlreadyOccupiedException {
        final Field field = new Field();

        final Point inputPoint = new Point(0, 0);

        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws InvalidPointException, AlreadyOccupiedException {
        final Field field = new Field();

        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThanZero() throws InvalidPointException, AlreadyOccupiedException {
        final Field field = new Field();

        final Point inputPoint = new Point(-1, 0);

        final Figure actualFigure;
        try {
            actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        assertNull(actualFigure);
    }

}