package LifeGame;

public class MockField implements FieldInterface{
    Cell dead = new Cell();//死细胞
    Cell alive = new Cell(true);//活细胞
    Cell[] cells1 = {dead, dead, dead, dead, alive, alive, alive, dead};
    Cell[] cells2 = {dead, dead, dead, dead, alive, alive, alive, alive};
    @Override
    public boolean place(int x, int y, Cell cell) {
        return false;
    }

    @Override
    public Cell getCell(int x, int y) {
        return null;
    }

    @Override
    public Cell[] getNeighbors(int x, int y) {
        dead.die();
        alive.reborn();
        if(x == y) return cells1;
        else return cells2;
    }

    @Override
    public int getHeight() {
        return 3;
    }

    @Override
    public int getWidth() {
        return 3;
    }
}
