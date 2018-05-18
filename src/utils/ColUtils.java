package utils;

import data.Cell;
import data.Grid;

import java.util.List;

public class ColUtils implements ColIsoUtil, ColSolvingUtil {
    @Override
    public void applyBlockInternColPermutation(Grid grid, Cell anchor, int[] image) {

    }

    @Override
    public boolean isBlockInternColPermutation(Grid grid1, Grid grid2) {
        return false;
    }

    @Override
    public int[] getBlockInternColPermutationImage(Grid grid1, Grid grid2, Cell anchor) {
        return new int[0];
    }

    @Override
    public void applyColValuePermutation(Grid grid, Cell anchor, int[] image) {

    }

    @Override
    public int[] getColValuePermutationImage(Grid grid1, Grid grid2, Cell anchor) {
        return new int[0];
    }

    @Override
    public boolean isColValuePermutation(Grid grid1, Grid grid2, Cell anchor) {
        return false;
    }

    @Override
    public boolean isValidCol(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public List<Cell> getColWhiteSpaces(Grid grid, Cell anchor) {
        return null;
    }

    @Override
    public boolean hasFullHouseCol(Grid grid) {
        return false;
    }

    @Override
    public boolean isFullHouseCol(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public boolean isColWithNakedSingleCell(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public Cell getColMinimalNakedSingleCell(Grid grid, Cell anchor) {
        return null;
    }

    @Override
    public boolean isColWithHiddenSingleCell(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public Cell getColMinimalHiddenSingleCell(Grid grid, Cell anchor) {
        return null;
    }

    @Override
    public boolean isColWithNakedPairCells(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public Cell[] getColMinimalNakedPairCells(Grid grid, Cell anchor) {
        return new Cell[0];
    }

    @Override
    public boolean isColWithHiddenPairCells(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public Cell[] getColMinimalHiddenPairCells(Grid grid, Cell anchor) {
        return new Cell[0];
    }

    @Override
    public List<Grid> solveColBased(Grid grid) {
        return null;
    }
}
