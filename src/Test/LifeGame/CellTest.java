package LifeGame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wushuaikang
 * @date 2021/9/23-14:52
 */
class CellTest
{
    private static Cell cellTest = new Cell();
    @BeforeEach
    void setUp()
    {
        cellTest.setAlive(false);
    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    void reborn()
    {
        cellTest.reborn();
        assertEquals(true,cellTest.isAlive());
    }

    @Test
    void die()
    {
        cellTest.reborn();
        cellTest.die();
        assertEquals(false,cellTest.isAlive());
    }

    @Test
    void isAlive()
    {
        assertEquals(false,cellTest.isAlive());
        cellTest.reborn();
        assertEquals(true,cellTest.isAlive());
        cellTest.die();
        assertEquals(false,cellTest.isAlive());
    }
}