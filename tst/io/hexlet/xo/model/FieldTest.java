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
    }

    @Test
    public void testGetFigureWhenYIsLessThanZero() throws InvalidPointException, AlreadyOccupiedException {
        final Field field = new Field();

        final Point inputPoint = new Point(0, -1);

        final Figure actualFigure;
        try {
            actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetFigureWhenXIsMoreThanSize() throws InvalidPointException, AlreadyOccupiedException {
        final Field field = new Field();

        final Point inputPoint = new Point(field.getSize() + 1, 0);

        final Figure actualFigure;
        try {
            actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetFigureWhenYIsMoreThanSize() throws InvalidPointException, AlreadyOccupiedException {
        final Field field = new Field();

        final Point inputPoint = new Point(0, field.getSize() + 1);

        final Figure actualFigure;

        try {
            actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSetFigureWhenAlreaduOccupied() throws InvalidPointException, AlreadyOccupiedException {
        final Field field = new Field();

        final Point inputPoint = new Point(0, 0);

        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);

        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (AlreadyOccupiedException e) {
            e.printStackTrace();
        }
    }

}