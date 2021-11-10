package LifeGame;
public class GameControl
{
	private Field field;
	private Field field_old;
//    private Field field_old1;
    private int count_zisun = 0;
   // private Field field_old2;

    public Field getField()
    {
        return field;
    }
//    public void Init1()
//    {
//        for(int row = 0; row < field.getHeight(); row++)
//            for(int col = 0; col < field.getWidth(); col++)
//            {
//                field_old.place(row,col,new Cell());
//                field_old1.place(row,col,new Cell());
//            }
//    }


    public void InitField(int width, int height) //初始化地图
    {
        field = new Field(width, height);
        for(int row = 0; row < field.getHeight(); row++)
            for(int col = 0; col < field.getWidth(); col++)
            {
                field.place(row, col, new Cell());
            }
        for(int row = 0; row < field.getHeight(); row++)
            for(int col = 0; col < field.getWidth(); col++)
            {
                Cell cell = field.getCell(row, col);
                if (Math.random() < 0.2)
                {
                    cell.reborn();
                }
            }
    }


    public void updateView() //更新地图
    {
        field_old=new Field(field.getWidth(),field.getHeight());
//        field_old1 = new Field(field.getWidth(), field.getHeight());
//        //field_old2 = new Field(field.getWidth(), field.getHeight());
//        if(count == 0)
//        {
//            Init1();
//            count++;
//        }

//        for(int row = 0; row < field.getHeight(); row++)
//            for(int col = 0; col < field.getWidth(); col++){
//                Cell cell=field_old.getCell(row,col);
//                Cell cell1=new Cell(cell.isAlive());
//                field_old1.place(row,col,cell1);
//            }

//        for(int row = 0; row < field.getHeight(); row++)
//            for(int col = 0; col < field.getWidth(); col++){
//                Cell cell=field_old.getCell(row,col);
//                Cell cell1=new Cell(cell.isAlive());
//                field_old2.place(row,col,cell1);
//            }


        for(int row = 0; row < field.getHeight(); row++)
            for(int col = 0; col < field.getWidth(); col++){
                Cell cell=field.getCell(row,col);
                Cell cell1=new Cell(cell.isAlive());
                field_old.place(row,col,cell1);
            }

        for(int row = 0; row < field.getHeight(); row++)
            for(int col = 0; col < field.getWidth(); col++)
            {
                Cell cell = field.getCell(row, col);

                int count = field_old.getNeighbors(row,col);
                switch (count)
                {
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

            }
            count_zisun++;
            if(count_zisun == 500)
            {
                System.exit(0);
            }
//        if(field.equals(field_old) || field.equals(field_old1))
//        {
//            OK = !OK;
//        }
    }
}
