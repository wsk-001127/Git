package LifeGame;

public class Clock
{
	 private static long theTick;//ҳ����µļ��
	 public Boolean OK = false; //�ж���Ϸ�Ƿ���Կ�ʼ
	    public Clock(long tick)
		{
	        theTick = tick/100;
	    }

	    public static void pause() throws InterruptedException
		{//ϵͳ����ͣʱ��
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
