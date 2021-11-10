package LifeGame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wushuaikang
 * @date 2021/9/23-14:52
 */
class FieldTest
{
    private  final Field fieldTest = new Field(20,20);
    @BeforeEach
    void setUp()
    {
        fieldTest.clear();
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void place()
    {
        boolean mark;
        /*
        黑盒测试: 边界条件测试
        测试用例: (x, y): (-1, -1), (20, 20), (0, 0), (19, 19)
         */
        mark = fieldTest.place(-1, -1, new Cell());
        assertEquals(false, mark);
        mark = fieldTest.place(20, 20, new Cell());
        assertEquals(false, mark);
        mark = fieldTest.place(0, 0, new Cell());
        assertEquals(true, mark);
        mark = fieldTest.place(19, 19, new Cell());
        /*
        白盒测试:
        代码覆盖标准 : 判定条件覆盖
        测试用例 : (x, y): (-1, 5), (7, 29), (7, 8), (29, -1)
         测试覆盖率: 100%
         */
        assertEquals(true, mark);
        mark = fieldTest.place(-1, 5, new Cell());
        assertEquals(false, mark);
        mark = fieldTest.place(7, 29, new Cell());
        assertEquals(false, mark);
        mark = fieldTest.place(7, 8, new Cell());
        assertEquals(true, mark);
        mark = fieldTest.place(29, -1, new Cell());
        assertEquals(false, mark);

    }

    @Test
    void getCell()
    {
         /*
        黑盒测试: 边界条件测试
        测试用例: (x, y): (-1, -1), (20, 20), (0, 0), (19, 19), (10, 10)
         */
        assertEquals(null, fieldTest.getCell(10, 10));
        Cell theCell1 = new Cell();
        fieldTest.place(10, 10, theCell1);
        fieldTest.place(0, 0, theCell1);
        fieldTest.place(19, 19, theCell1);
        assertEquals(theCell1, fieldTest.getCell(10,10));
        assertEquals(null, fieldTest.getCell(-1, -1));
        assertEquals(null, fieldTest.getCell(20, 20));
        assertEquals(theCell1, fieldTest.getCell(0, 0));
        assertEquals(theCell1, fieldTest.getCell(19, 19));
        /*
        白盒测试
        代码覆盖标准: 判定条件覆盖
        测试用例: (x, y): (-1, 10), (10, -1), (10, 10), (20, 20)
        代码覆盖率: 100%
         */
        assertEquals(null, fieldTest.getCell(-1, 10));
        assertEquals(null, fieldTest.getCell(10, -1));
        assertEquals(theCell1, fieldTest.getCell(10, 10));
        assertEquals(null, fieldTest.getCell(20, 20));
    }

    @Test
    void getNeighbors()
    {
        fieldTest.place(1,8,new Cell(true));
        fieldTest.place(2,1,new Cell(true));
        fieldTest.place(2,10,new Cell(true));
        fieldTest.place(3,3,new Cell(true));
        fieldTest.place(3,12,new Cell(true));
        fieldTest.place(3,15,new Cell(true));
        fieldTest.place(3,16,new Cell(true));
        fieldTest.place(4,1,new Cell(true));
        fieldTest.place(4,3,new Cell(true));
        fieldTest.place(4,4,new Cell(true));
        fieldTest.place(4,5,new Cell(true));
        fieldTest.place(4,12,new Cell(true));
        fieldTest.place(4,13,new Cell(true));
        fieldTest.place(4,14,new Cell(true));
        fieldTest.place(4,16,new Cell(true));
        fieldTest.place(4,17,new Cell(true));
        fieldTest.place(5,3,new Cell(true));
        fieldTest.place(5,4,new Cell(true));
        fieldTest.place(5,5,new Cell(true));
        fieldTest.place(5,17,new Cell(true));
        fieldTest.place(5,18,new Cell(true));
        fieldTest.place(6,3,new Cell(true));
        fieldTest.place(6,5,new Cell(true));
        fieldTest.place(6,6,new Cell(true));
        fieldTest.place(6,7,new Cell(true));
        fieldTest.place(6,8,new Cell(true));
        fieldTest.place(6,17,new Cell(true));
        fieldTest.place(6,18,new Cell(true));
        fieldTest.place(7,1,new Cell(true));
        fieldTest.place(7,3,new Cell(true));
        fieldTest.place(7,6,new Cell(true));
        fieldTest.place(7,7,new Cell(true));
        fieldTest.place(7,15,new Cell(true));
        fieldTest.place(7,17,new Cell(true));
        fieldTest.place(8,1,new Cell(true));
        fieldTest.place(8,2,new Cell(true));
        fieldTest.place(8,3,new Cell(true));
        fieldTest.place(8,15,new Cell(true));
        fieldTest.place(8,16,new Cell(true));
        fieldTest.place(8,17,new Cell(true));
        fieldTest.place(9,2,new Cell(true));
        fieldTest.place(9,3,new Cell(true));
        fieldTest.place(9,4,new Cell(true));
        fieldTest.place(9,13,new Cell(true));
        fieldTest.place(9,14,new Cell(true));
        fieldTest.place(9,15,new Cell(true));
        fieldTest.place(10,2,new Cell(true));
        fieldTest.place(10,3,new Cell(true));
        fieldTest.place(10,4,new Cell(true));
        fieldTest.place(11,1,new Cell(true));
        fieldTest.place(11,4,new Cell(true));
        fieldTest.place(11,14,new Cell(true));
        fieldTest.place(11,15,new Cell(true));
        fieldTest.place(12,14,new Cell(true));
        fieldTest.place(11,16,new Cell(true));
        fieldTest.place(13,9,new Cell(true));
        fieldTest.place(13,10,new Cell(true));
        fieldTest.place(13,14,new Cell(true));
        fieldTest.place(13,15,new Cell(true));
        fieldTest.place(13,17,new Cell(true));
        fieldTest.place(14,1,new Cell(true));
        fieldTest.place(14,2,new Cell(true));
        fieldTest.place(14,4,new Cell(true));
        fieldTest.place(14,5,new Cell(true));
        fieldTest.place(14,6,new Cell(true));
        fieldTest.place(14,8,new Cell(true));
        fieldTest.place(14,9,new Cell(true));
        fieldTest.place(14,10,new Cell(true));
        fieldTest.place(14,18,new Cell(true));
        fieldTest.place(15,1,new Cell(true));
        fieldTest.place(15,2,new Cell(true));
        fieldTest.place(15,4,new Cell(true));
        fieldTest.place(15,5,new Cell(true));
        fieldTest.place(15,6,new Cell(true));
        fieldTest.place(15,8,new Cell(true));
        fieldTest.place(15,9,new Cell(true));
        fieldTest.place(15,11,new Cell(true));
        fieldTest.place(16,1,new Cell(true));
        fieldTest.place(16,8,new Cell(true));
        fieldTest.place(16,10,new Cell(true));
        fieldTest.place(16,14,new Cell(true));
        fieldTest.place(16,15,new Cell(true));
        fieldTest.place(17,13,new Cell(true));
        fieldTest.place(18,4,new Cell(true));
        fieldTest.place(18,5,new Cell(true));
        fieldTest.place(18,7,new Cell(true));
        fieldTest.place(18,8,new Cell(true));
        fieldTest.place(18,13,new Cell(true));
        fieldTest.place(18,15,new Cell(true));
        assertEquals(0,fieldTest.getNeighbors(0,0));
        assertEquals(0,fieldTest.getNeighbors(0,1));
        assertEquals(0,fieldTest.getNeighbors(0,2));
        assertEquals(0,fieldTest.getNeighbors(0,3));
        assertEquals(0,fieldTest.getNeighbors(0,4));
        assertEquals(0,fieldTest.getNeighbors(0,5));
        assertEquals(0,fieldTest.getNeighbors(0,6));
        assertEquals(1,fieldTest.getNeighbors(0,7));
        assertEquals(1,fieldTest.getNeighbors(0,8));
        assertEquals(1,fieldTest.getNeighbors(0,9));
        assertEquals(0,fieldTest.getNeighbors(0,10));
        assertEquals(0,fieldTest.getNeighbors(0,11));
        assertEquals(0,fieldTest.getNeighbors(0,12));
        assertEquals(0,fieldTest.getNeighbors(0,13));
        assertEquals(0,fieldTest.getNeighbors(0,14));
        assertEquals(0,fieldTest.getNeighbors(0,15));
        assertEquals(0,fieldTest.getNeighbors(0,16));
        assertEquals(0,fieldTest.getNeighbors(0,17));
        assertEquals(0,fieldTest.getNeighbors(0,18));
        assertEquals(0,fieldTest.getNeighbors(0,19));

        assertEquals(1,fieldTest.getNeighbors(1,0));
        assertEquals(1,fieldTest.getNeighbors(2,0));
        assertEquals(2,fieldTest.getNeighbors(3,0));
        assertEquals(1,fieldTest.getNeighbors(4,0));
        assertEquals(1,fieldTest.getNeighbors(5,0));
        assertEquals(1,fieldTest.getNeighbors(6,0));
        assertEquals(2,fieldTest.getNeighbors(7,0));
        assertEquals(2,fieldTest.getNeighbors(8,0));
        assertEquals(1,fieldTest.getNeighbors(9,0));
        assertEquals(1,fieldTest.getNeighbors(10,0));
        assertEquals(1,fieldTest.getNeighbors(11,0));
        assertEquals(1,fieldTest.getNeighbors(12,0));
        assertEquals(1,fieldTest.getNeighbors(13,0));
        assertEquals(2,fieldTest.getNeighbors(14,0));
        assertEquals(3,fieldTest.getNeighbors(15,0));
        assertEquals(2,fieldTest.getNeighbors(16,0));
        assertEquals(1,fieldTest.getNeighbors(17,0));
        assertEquals(0,fieldTest.getNeighbors(18,0));
        assertEquals(0,fieldTest.getNeighbors(19,0));

        assertEquals(0,fieldTest.getNeighbors(1,19));
        assertEquals(0,fieldTest.getNeighbors(2,19));
        assertEquals(0,fieldTest.getNeighbors(3,19));
        assertEquals(1,fieldTest.getNeighbors(4,19));
        assertEquals(2,fieldTest.getNeighbors(5,19));
        assertEquals(2,fieldTest.getNeighbors(6,19));
        assertEquals(1,fieldTest.getNeighbors(7,19));
        assertEquals(0,fieldTest.getNeighbors(8,19));
        assertEquals(0,fieldTest.getNeighbors(9,19));
        assertEquals(0,fieldTest.getNeighbors(10,19));
        assertEquals(0,fieldTest.getNeighbors(11,19));
        assertEquals(0,fieldTest.getNeighbors(12,19));
        assertEquals(1,fieldTest.getNeighbors(13,19));
        assertEquals(1,fieldTest.getNeighbors(14,19));
        assertEquals(1,fieldTest.getNeighbors(15,19));
        assertEquals(0,fieldTest.getNeighbors(16,19));
        assertEquals(0,fieldTest.getNeighbors(17,19));
        assertEquals(0,fieldTest.getNeighbors(18,19));
        assertEquals(0,fieldTest.getNeighbors(19,19));

        assertEquals(0,fieldTest.getNeighbors(19,1));
        assertEquals(0,fieldTest.getNeighbors(19,2));
        assertEquals(1,fieldTest.getNeighbors(19,3));
        assertEquals(2,fieldTest.getNeighbors(19,4));
        assertEquals(2,fieldTest.getNeighbors(19,5));
        assertEquals(2,fieldTest.getNeighbors(19,6));
        assertEquals(2,fieldTest.getNeighbors(19,7));
        assertEquals(2,fieldTest.getNeighbors(19,8));
        assertEquals(1,fieldTest.getNeighbors(19,9));
        assertEquals(0,fieldTest.getNeighbors(19,10));
        assertEquals(0,fieldTest.getNeighbors(19,11));
        assertEquals(1,fieldTest.getNeighbors(19,12));
        assertEquals(1,fieldTest.getNeighbors(19,13));
        assertEquals(2,fieldTest.getNeighbors(19,14));
        assertEquals(1,fieldTest.getNeighbors(19,15));
        assertEquals(1,fieldTest.getNeighbors(19,16));
        assertEquals(0,fieldTest.getNeighbors(19,17));
        assertEquals(0,fieldTest.getNeighbors(19,18));
    }

    @Test
    void getHeight()
    {
        assertEquals(20, fieldTest.getHeight());
    }

    @Test
    void getWidth()
    {
        assertEquals(20, fieldTest.getWidth());
    }
}