package LifeGame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wushuaikang
 * @date 2021/9/23-14:52
 */
class ClockTest
{
    private static Clock clockTest = new Clock(1000);
    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void pause() throws InterruptedException
    {
        /*
        白盒测试
        代码覆盖标准: 语句覆盖
        代码覆盖率: 100%
         */
        long time1 = new Date().getTime();
        clockTest.pause();
        long time2 = new Date().getTime();
        boolean flag = (time2 - time1) < 1015 ? true : false;
        assertEquals(true, flag);
    }

    @Test
    void getOK()
    {
    }

    @Test
    void notOK()
    {
        assertEquals(false, clockTest.getOK().booleanValue());
        clockTest.notOK();
        assertEquals(true, clockTest.getOK().booleanValue());
        clockTest.notOK();
        assertEquals(false, clockTest.getOK());
    }
}