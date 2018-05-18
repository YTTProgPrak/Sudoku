package utils;

import data.Cell;
import data.Grid;

import java.util.List;

public class RowUtils implements RowIsoUtil, RowSolvingUtil {
    @Override
    public void applyBlockInternRowPermutation(Grid grid, Cell anchor, int[] image) {

    }

    @Override
    public boolean isBlockInternRowPermutation(Grid grid1, Grid grid2) {
        return false;
    }

    @Override
    public int[] getBlockInternRowPermutationImage(Grid grid1, Grid grid2, Cell anchor) {
        return new int[0];
    }

    @Override
    public void applyRowValuePermutation(Grid grid, Cell anchor, int[] image) {

    }

    @Override
    public int[] getRowValuePermutationImage(Grid grid1, Grid grid2, Cell anchor) {
        return new int[0];
    }

    @Override
    public boolean isRowValuePermutation(Grid grid1, Grid grid2, Cell anchor) {
        return false;
    }

    @Override
    public boolean isValidRow(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public List<Cell> getRowWhiteSpaces(Grid grid, Cell anchor) {
        return null;
    }

    @Override
    public boolean hasFullHouseRow(Grid grid) {
        return false;
    }

    @Override
    public boolean isFullHouseRow(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public boolean isRowWithNakedSingleCell(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public Cell getRowMinimalNakedSingleCell(Grid grid, Cell anchor) {
        return null;
    }

    @Override
    public boolean isRowWithHiddenSingleCell(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public Cell getRowMinimalHiddenSingleCell(Grid grid, Cell anchor) {
        return null;
    }

    @Override
    public boolean isRowWithNakedPairCells(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public Cell[] getRowMinimalNakedPairCells(Grid grid, Cell anchor) {
        return new Cell[0];
    }

    @Override
    public boolean isRowWithHiddenPairCells(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public Cell[] getRowMinimalHiddenPairCells(Grid grid, Cell anchor) {
        return new Cell[0];
    }

    @Override
    public List<Grid> solveRowBased(Grid grid) {
        return null;
    }
}
