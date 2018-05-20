package utils;

import data.Cell;
import data.Grid;

import java.util.LinkedList;
import java.util.List;

/**
 * Diese Klasse beinhaltet Methoden, die helfen koennen, um Sudokus zu loesen.
 *
 * @autor Yan Berkel, Thomas Wieschermann, Till Brinkhus
 */

public class GridSolvingUtils implements GridSolvingUtil {
    private BlockUtils blockUtils = new BlockUtils();
    private ColUtils colUtils = new ColUtils();
    private RowUtils rowUtils = new RowUtils();

    /**
     * Die Methode entscheidet, ob im Gitter eine zulaessige Belegung vorliegt.
     * @param grid Gitter, das untersucht wird
     * @return true, falls Gitter zulaessig belegt, sonst false
     * @autor Till Brinkhus
     */
    @Override
    public boolean isValid(Grid grid) {
        //zulaessige Einheiten werden gezaehlt (jede Einheit muss 9 mal zulaessig sein, damit Gitter zulaessig ist)
       int validRows = 0;
       int validColls =0;
       int validBlocks = 0;

       int rowIndex = 1, colIndex = 1;  //Indizes werden fuer isValidBlock Abfrage gebraucht, da hier keine for-Schleife funktioniert


        //Gehe alle Ankerzellen der Reihen durch und ueberpruefe, ob Reihe zulaessig belegt ist
        for(int rIndex = 1; rIndex <=9; rIndex++){
            if (rowUtils.isValidRow(grid, new Cell(rIndex, 1))){
                validRows++;                                                        //falls Reihe zulaessig belegt, erhoehe validRows um eins
            }
        }

        //Gehe alle Ankerzellen der Spalten durch und ueberpruefe, ob Spalte zulaessig belegt ist
        for(int cIndex = 1; cIndex <=9; cIndex++){
            if (colUtils.isValidCol(grid, new Cell(1, cIndex))){
                validColls++;                                                        //falls Spalte zulaessig belegt, erhoehe validColl um eins
            }
        }

        //Gehe alle Ankerzellen der Bloecke durch und ueberpruefe, ob Block zulaessig belegt ist
        while (rowIndex <=9) {
            while (colIndex <=9) {
                if (blockUtils.isValidBlock(grid, new Cell(rowIndex, colIndex))) {  //falls Block zulaessig belegt,erhoehe validBlocks um eins
                    validBlocks++;
                }
                colIndex = colIndex + 3;
            }
            rowIndex = rowIndex + 3;
            colIndex = 1;
        }

        //sind alle Reihen, Spalten und Bloecke zulaessig belegt (jeweils 9 mal zulaessig belegt), gib true zurueck
        if(validRows == 9 && validColls == 9 && validBlocks == 9)
            return true;
        else
            return false;

    }

    /**
     * Methode sucht nach nicht belegten Zellen im Gitter, also Zellen, die -1 sind.
     *
     * @param grid Gitter, was untersucht wird
     * @return aufsteigend sortierte Liste der nicht belegten Zellen; Liste ist leer, falls es keine leeren Zellen gibt
     * @author Till Brinkhus
     */
    @Override
    public List<Cell> getWhiteSpaces(Grid grid) {
        List<Cell> whiteSpaces = new LinkedList<>();

        //gehe die WhiteSpaces fuer jede Reihe des Gitters durch und fuege die WhiteSpaces einer neuen Reihe immer hinten an die Liste an
      for(int rIndex = 1; rIndex <=9; rIndex++){
                whiteSpaces.addAll(rowUtils.getRowWhiteSpaces(grid,new Cell(rIndex, 1)));
        }
        return whiteSpaces;
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
