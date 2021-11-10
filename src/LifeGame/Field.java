package LifeGame;

public class Field
{
	private Cell[][] cells;//细胞集合
    private int height;//界面高度
    private int width;//界面宽度
    public Field(int width, int height)
    {
        this.height = height;
        this.width = width;
        cells = new Cell[width][height];
//        for(int row = 0;row < width;row++)
//            for(int col = 0;col < height;col++)
//            {
//                cells[row][col].setAlive(false);
//            }
    }

    public boolean place(int x, int y, Cell cell)//初始化细胞
    {
        if((x < width && x>=0) && (y < height && y >= 0))
        {
            cells[x][y] = cell;
            return true;
        }
        else
        {
            return false;
        }
    }

    public Cell getCell(int x, int y) //得到某个位置的细胞
    {
        //超过边界
        if(x < 0 || x >= width) return null;
        if(y < 0 || y >= height) return null;
        return cells[x][y];
    }

    public int getNeighbors(int x, int y)//得到所有邻居
    {
        Cell[] neighbors = new Cell[8];
        int index = 0;
        for(int i = -1; i <=  1; i++)
        {
            for(int j = -1; j <=1; j++)
            {
                if(i != 0 || j != 0) {//不是本身
                    neighbors[index++] = getCell((i+x+width)%width, (j+y+height)%height);
                }
            }
        }
        int count=0;
        for(Cell o : neighbors)
        {
            if(o != null && o.isAlive()) count++;
        }
        return count;
    }


//    public boolean equals1(Field obj)
//    {
//        boolean equal = true;
//        //int count = 0;
//        while(equal)
//        {
//            for(int row = 0;row < this.getHeight();row++)
//            {
//                for(int col = 0;col < this.getWidth();col++)
//                {
//                    Cell cell1 = this.getCell(row,col);
//                    Cell cell2 = obj.getCell(row,col);
//                    if(cell1.isAlive()!=cell2.isAlive())
//                    {
//                        equal = false;
//                    }
//                }
//            }
//
//        }
//
//        return equal;
//    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public void clear()
    {
        for(int i = 0;i<width;i++)
        {
            for(int j = 0;j<height;j++)
            {
                cells[i][j] = null;
            }
        }
    }
}
