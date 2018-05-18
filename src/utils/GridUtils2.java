package utils;

import data.Cell;
import data.Grid;

public class GridUtils2 implements  GridUtil2 {
    @Override
    public void reflect(Grid grid, Cell anchor) {

    }

    @Override
    public boolean isReflection(Grid grid1, Grid grid2) {
        return false;
    }

    @Override
    public Cell getReflectionAnchor(Grid grid1, Grid grid2) {
        return null;
    }
}
