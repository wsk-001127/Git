package LifeGame;

public class Cell
{
	 private boolean alive;//����״̬

	    public Cell()
		{
			alive = false;
	    }
	    public Cell(boolean statue)
		{
			alive=statue;
		}
	    public void reborn()
		{ //��������
	        alive = true;
	    }
	    public void die()
		{ //����
	        alive = false;
	    }

	public void setAlive(boolean alive)
	{
		this.alive = alive;
	}

	public boolean isAlive()
	{ //�ж��Ƿ���
	        return alive;
	}


}
