package io.hexlet.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testGetName() throws Exception{
        final String inputValue = "Slava";

        final Player player = new Player(inputValue, null);

        final String actualValue = player.getName();

        assertEquals(inputValue, actualValue);
    }

    @Test
    public void testGetFigure() throws Exception {
        final Figure inputValue = Figure.X;

        final Player player = new Player(null, inputValue);

        final Figure actualValue = player.getFigure();

        assertEquals(inputValue, actualValue);
    }
}