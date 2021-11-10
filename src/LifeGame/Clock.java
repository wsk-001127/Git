package LifeGame;

public class Clock
{
	 private static long theTick;//页面更新的间隔
	 public Boolean OK = false; //判断游戏是否可以开始
	    public Clock(long tick)
		{
	        theTick = tick/100;
	    }

	    public static void pause() throws InterruptedException
		{//系统的暂停时间
	        Thread.sleep(theTick);
	    }
	    
	    public Boolean getOK()
		{
			return OK;
		}
	    
	    public void notOK()
		{
			OK = !OK;
		}
}
