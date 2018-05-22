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

    Cell [] anchorRow = {new Cell(1,1), new Cell(2,1),new Cell(3,1),
            new Cell(4,1), new Cell(5,1), new Cell(6,1),
            new Cell(7,1), new Cell(8,1), new Cell(9,1)};

    Cell [] anchorCol = {new Cell(1,1), new Cell(1,2),new Cell(1,3),
            new Cell(1,4), new Cell(1,5), new Cell(1,6),
            new Cell(1,7), new Cell(1,8), new Cell(1,9)};

    Cell [] anchorBlock = {new Cell(1,1), new Cell(1,4),new Cell(1,7),
                           new Cell(4,1), new Cell(4,4), new Cell(4,7),
                           new Cell(7,1), new Cell(7,4), new Cell(7,7)};

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

    /**
     *  Methode entscheidet, ob im Gitter eine FullHouse-Einheit existiert.
     * @param grid Gitter, was untersucht wird
     * @return true, falls Gitter FullHouse-Einheit bestitzt, sonst false
     * @autor Till Brinkhus
     */
    @Override
    public boolean hasFullHouseUnit(Grid grid) {
        //schaue in jeder Einheit nach, ob sie eine FullHouse Zelle besitzt. Wenn eine der Einheiten eine FullHouse Zelle besitzt, return true
        if(blockUtils.hasFullHouseBlock(grid) || rowUtils.hasFullHouseRow(grid) || colUtils.hasFullHouseCol(grid))
            return true;
        else
            return false;
    }

    /**
     * Diese Methode entscheidet, ob das Gitter mindestens eine NakedSingle-Zelle enthaelt.
     * @param grid Gitter, was untersucht wird
     * @return true, falls Gitter mindestens eine NakedSingle-Zelle besitzt, sonst false
     * @autor  Till Brinkhus
     */
    @Override
    public boolean hasNakedSingleCell(Grid grid) {
        //gehe fuer alle Ankerzellen der Reihen,Spalten und Bloecke jeweils die Einheit durch und schaue ob eine NakedSingle Zelle existiert,falls ja,return true
        for (int i = 0; i < 9; i++) {
            if (blockUtils.isBlockWithNakedSingleCell(grid, anchorBlock[i]) || rowUtils.isRowWithNakedSingleCell(grid, anchorRow[i])
                    || colUtils.isColWithNakedSingleCell(grid, anchorCol[i]))
                return true;
        }
        return false;
    }

    /**
     * Methode Gibt die minimale NakedSingle-Zelle der Gitters zurueck.
     * @param grid Gitter, in dem die NakedSingle gesucht wird
     * @return minimale NakedSingle Zelle des Gitters
     * @autor  Till Brinkhus
     */
    @Override
    public Cell getMinimalNakedSingleCell(Grid grid) {
        LinkedList <Cell> allNakesSingleCells = new LinkedList<>();  //Liste in der alle NakedSingles zuerst gespeichert werden
        Cell aktMinNakedSingle;

        //falls keine NakedSingles enthalten sind, return null
       if(hasNakedSingleCell(grid)== false)
           return null;

       else{
           //gehe alle Reihen, Spalten, Bloecke durch und fuege alle NakedSingles zu einer Liste hinzu
           for (int i=0;i<9; i++){
               if(rowUtils.isRowWithNakedSingleCell(grid,anchorRow[i]))
                   allNakesSingleCells.add(rowUtils.getRowMinimalNakedSingleCell(grid,anchorRow[i]));  //fuege NakedSingles der Reihe zur Liste hinzu

               if(colUtils.isColWithNakedSingleCell(grid, anchorCol[i]))
                   allNakesSingleCells.add(colUtils.getColMinimalNakedSingleCell(grid,anchorCol[i])); //der Spalte

               if(blockUtils.isBlockWithNakedSingleCell(grid, anchorBlock[i]))
                   allNakesSingleCells.add(blockUtils.getBlockMinimalNakedSingleCell(grid, anchorBlock[i])); //des Blocks
           }

           //setze zuerst NakedSingle gleich die erste NakedSingle der Liste und gehe dann jede einzelne NakedSingle Zelle
           //der Liste durch und schaue, ob sie kleiner ist als die aktuelle minNakedSingle Zelle, falls ja, setzte die
           //aktuelle minNakedSingle gleich gerade verglichenen der NakedSingle Zelle der Liste

           aktMinNakedSingle = allNakesSingleCells.getFirst();

           for(int i =1; i<allNakesSingleCells.size();i++){

               if(isMinimal(aktMinNakedSingle, allNakesSingleCells.get(i)))
                   aktMinNakedSingle =  allNakesSingleCells.get(i);
           }

           return aktMinNakedSingle;
       }
    }

    /**
     * Methode ueberprueft, ob die zweite uebergebene Zelle (newCell) kleiner ist als die aktuelle Zelle.
     * @param curCell Zelle, die aktuell am kleinsten ist
     * @param newCell Zelle, bei der ueberprueft wird, ob sie kleiner ist als die aktuelle Zelle
     * @return true, falls neue Zelle kleiner ist als die alte (curCell), falls aktuelleZelle kleiner ist, wird false zurueckgegeben
     * @autor Till Brinkhus
     */
    private boolean isMinimal(Cell curCell, Cell newCell) {
        //falls rIndex der neuen Zelle kleiner ist oder rIndex von neuer Zelle und aktueller Zelle gleich sind und der
        // cIndex der neuer Zelle kleiner ist als der der aktuellen Zelle

        if(newCell.getrIndex()< curCell.getrIndex() ||
                (newCell.getrIndex()== curCell.getrIndex() && newCell.getcIndex()<curCell.getcIndex()))
            return true;
        else
            return false;

    }

    @Override
    public boolean hasHiddenSingleCell(Grid grid1, Cell anchor) {
        return false;
    }

    @Override
    public Cell getMinimalHiddenSingleCell(Grid grid) {
        return null;
    }

    /**
     * Methode  entscheidet, ob das Gitter ein NakedPair-Zellpaar enthaelt.
     * @param grid Gitter, was untersucht wird
     * @return true, falls Gitter mindestens ein NakedPair besitzt, sonst false
     * @autor Till Brinkhus
     */
    @Override
    public boolean hasNakedPair(Grid grid) {
        if(getMinimalNakedPairCells(grid).length==0)
            return false;
        else
            return true;
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
