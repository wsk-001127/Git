package LifeGame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wushuaikang
 * @date 2021/9/23-14:53
 */
class GameControlTest
{
    private FieldInterface field = new MockField();
    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void getField()
    {
    }

    @Test
    void initField()
    {
        int count = 0;
        for(int row = 0; row < field.getHeight(); row++)
            for(int col = 0; col < field.getWidth(); col++) {
                count++;
                assertEquals(false,field.place(row, col, new Cell()));
            }
        assertEquals(9, count);
//        for(int row = 0; row < field.getHeight(); row++)
//            for(int col = 0; col < field.getWidth(); col++) {
//                Cell cell = field.getCell(row, col);
//                assertEquals(null, field.getCell(row, col));
//            }
    }

    @Test
    void updateView()
    {
        Cell cell = new Cell();
        Cell cells[] = field.getNeighbors(1, 1);
        int count = 0;
        for(Cell o : cells) {
            if(o != null && o.isAlive()) count++;
        }
        switch (count) {
            case 1: {
                cell.die();
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                cell.reborn();
                break;
            }
            default:{
                cell.die();
            }
        }
        assertEquals(true, cell.isAlive());
        cells = field.getNeighbors(0,1);
        count = 0;
        for(Cell o : cells) {
            if(o != null && o.isAlive()) count++;
        }
        switch (count) {
            case 1: {
                cell.die();
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                cell.reborn();
                break;
            }
            default:{
                cell.die();
            }
        }
        assertEquals(false, cell.isAlive());
    }
}

