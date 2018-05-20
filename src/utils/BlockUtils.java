package utils;

import data.Cell;
import data.Grid;

import java.util.LinkedList;
import java.util.List;

public class BlockUtils implements BlockIsoUtil, BlockSolvingUtil {
    @Override
    public void applyBlockPermutation(Grid grid, Cell[] image) {

    }

    @Override
    public boolean isBlockPermutation(Grid grid1, Grid grid2) {
        return false;
    }

    @Override
    public Cell[] getBlockPermutationImage(Grid grid1, Grid grid2) {
        return new Cell[0];
    }

    @Override
    public void applyBlockValuePermutation(Grid grid, Cell anchor, int[] image) {

    }

    @Override
    public int[] getBlockValuePermutationImage(Grid grid1, Grid grid2, Cell anchor) {
        return new int[0];
    }

    @Override
    public boolean isBlockValuePermutation(Grid grid1, Grid grid2, Cell anchor) {
        return false;
    }

    @Override
    public boolean isValidBlock(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public List<Cell> getBlockWhiteSpaces(Grid grid, Cell anchor) {

        List<Cell> whiteSpaces = new LinkedList<>();
        int laufVarR = anchor.getrIndex() + 3;       //Laufvariable fuer die Zeilen
        int laufVarC = anchor.getcIndex() + 3;       //Laufvariable fuer die Spalten

        for (int rIndex = anchor.getrIndex(); rIndex < laufVarR; rIndex++)                            //Gehe jede Zelle des Blocks durch und pruefe ob diese leer ist
            for (int cIndex = anchor.getcIndex(); cIndex < laufVarC; cIndex++)
                if (grid.getValue(rIndex, cIndex) == -1)                                            //Falls Zelle leer, fuege sie zur Liste hinzu
                    whiteSpaces.add(new Cell(rIndex, cIndex));

        return whiteSpaces;
    }

    @Override
    public boolean hasFullHouseBlock(Grid grid) {
        return false;
    }

    @Override
    public boolean isFullHouseBlock(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public boolean isBlockWithNakedSingleCell(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public Cell getBlockMinimalNakedSingleCell(Grid grid, Cell anchor) {
        return null;
    }

    @Override
    public boolean isBlockWithHiddenSingleCell(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public Cell getBlockMinimalHiddenSingleCell(Grid grid, Cell anchor) {
        return null;
    }

    @Override
    public boolean isBlockWithNakedPair(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public Cell[] getBlockNakedPairCells(Grid grid, Cell anchor) {
        return new Cell[0];
    }

    @Override
    public boolean isBlockWithHiddenPair(Grid grid, Cell anchor) {
        return false;
    }

    @Override
    public Cell[] getBlockHiddenPairCells(Grid grid, Cell anchor) {
        return new Cell[0];
    }

    @Override
    public List<Grid> solveBlockBased(Grid grid) {
        return null;
    }
}
