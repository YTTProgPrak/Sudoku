package utils;

import data.Cell;
import data.Grid;

import java.util.List;

/**
 * TODO: Kommentar verfassen
 *
 * @autor Yan Berkel, Thomas Wieschermann, Till Brinkhus
 */

public class GridSolvingUtils implements GridSolvingUtil {
    @Override
    public boolean isValid(Grid grid) {
        return false;
    }

    @Override
    public List<Cell> getWhiteSpaces(Grid grid) {
        return null;
    }

    @Override
    public boolean hasFullHouseUnit(Grid grid) {
        return false;
    }

    @Override
    public boolean hasNakedSingleCell(Grid grid) {
        return false;
    }

    @Override
    public Cell getMinimalNakedSingleCell(Grid grid) {
        return null;
    }

    @Override
    public boolean hasHiddenSingleCell(Grid grid1, Cell anchor) {
        return false;
    }

    @Override
    public Cell getMinimalHiddenSingleCell(Grid grid) {
        return null;
    }

    @Override
    public boolean hasNakedPair(Grid grid) {
        return false;
    }

    @Override
    public Cell[] getMinimalNakedPairCells(Grid grid) {
        return new Cell[0];
    }

    @Override
    public boolean hasHiddenPairCells(Grid grid) {
        return false;
    }

    @Override
    public Cell[] getMinimalHiddenPairCells(Grid grid) {
        return new Cell[0];
    }
}
