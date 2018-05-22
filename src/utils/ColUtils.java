package utils;

import data.Cell;
import data.Grid;
import java.util.*;

public class ColUtils implements ColIsoUtil, ColSolvingUtil {

    @java.lang.Override
    public void applyBlockInternColPermutation(Grid grid, Cell anchor, int[] image) {

    }

    @java.lang.Override
    public boolean isBlockInternColPermutation(Grid grid1, Grid grid2) {
        return false;
    }

    @java.lang.Override
    public int[] getBlockInternColPermutationImage(Grid grid1, Grid grid2, Cell anchor) {
        return new int[0];
    }

    @java.lang.Override
    public void applyColValuePermutation(Grid grid, Cell anchor, int[] image) {

    }

    @java.lang.Override
    public int[] getColValuePermutationImage(Grid grid1, Grid grid2, Cell anchor) {
        return new int[0];
    }

    @java.lang.Override
    public boolean isColValuePermutation(Grid grid1, Grid grid2, Cell anchor) {
        return false;
    }

    @java.lang.Override
    public boolean isValidCol(Grid grid, Cell anchor) {
        int cIndex = anchor.getcIndex();
        int rIndex = anchor.getrIndex();
        int dim = grid.getColValues(cIndex).length;
        Cell cell;
        List possibleValues = new LinkedList(1,2,3,4,5,6,7,8,9);

        while(rIndex <= dim){
            cell = grid.getCell(rIndex, cIndex);
            cellValue = cell.getValue();
            if(possibleValues.contains(cellValue)){
                possibleValues.remove(cellValue);
            }else if(cellValue == -1){

            }

        }


        return false;
    }


    /**
     *
     * @param grid Gitter, welches die Spalte enthaelt
     * @param anchor Ankerzelle, der Spalte
     * @return Liste der Zellen, die mit Value -1
     */

    @java.lang.Override
    public List<Cell> getColWhiteSpaces(Grid grid, Cell anchor) {
        int cIndex = anchor.getcIndex();
        int rIndex = anchor.getrIndex();
        int dim = grid.getColValues(cIndex).length;
        Cell cell;
        List list = new LinkedList();

        while(rIndex <= dim){
            cell = grid.getCell(rIndex, cIndex);
            if(cell.getValue() == -1){
                list.addLast(listIndex, cell);
            }
            rIndex++;
        }
        return list;
    }
yx
    @java.lang.Override
    public boolean hasFullHouseCol(Grid grid) {
        return false;
    }

    @java.lang.Override
    public boolean isFullHouseCol(Grid grid, Cell anchor) {
        return false;
    }

    @java.lang.Override
    public boolean isColWithNakedSingleCell(Grid grid, Cell anchor) {
        return false;
    }

    @java.lang.Override
    public Cell getColMinimalNakedSingleCell(Grid grid, Cell anchor) {
        return null;
    }

    @java.lang.Override
    public boolean isColWithHiddenSingleCell(Grid grid, Cell anchor) {
        return false;
    }

    @java.lang.Override
    public Cell getColMinimalHiddenSingleCell(Grid grid, Cell anchor) {
        return null;
    }

    @java.lang.Override
    public boolean isColWithNakedPairCells(Grid grid, Cell anchor) {
        return false;
    }

    @java.lang.Override
    public Cell[] getColMinimalNakedPairCells(Grid grid, Cell anchor) {
        return new Cell[0];
    }

    @java.lang.Override
    public boolean isColWithHiddenPairCells(Grid grid, Cell anchor) {
        return false;
    }

    @java.lang.Override
    public Cell[] getColMinimalHiddenPairCells(Grid grid, Cell anchor) {
        return new Cell[0];
    }

    @java.lang.Override
    public List<Grid> solveColBased(Grid grid) {
        return null;
    }
}
