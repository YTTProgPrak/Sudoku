package utils;

import data.Grid;

/**
 * Diese Klasse enthaelt zwei Methoden, die auf das Gitter angewendet werden koennen, um dieses zu spiegeln oder
 * um zu uberpruefen, ob das eine Gitter eine Spiegelung des anderen ist.
 * @author Till Brinkhus
 */

public class GridUtils1 implements GridUtil1 {

    private Grid gridZwischenspeicher =new Grid(9) ;


    /**
     *Transponiert das Gitter, indem der Wert aus Zelle [rIndex][cIndex] in die Zelle [cIndex][rIndex] geschrieben wird.
     * gridZwischenspeicher wird hier zum Zwischenspeichern der neuen Werte der Zellen benutzt.
     * @param grid uebergebene Gitter, was transponiert wird
     */
    @Override
    public void transponse(Grid grid) {

        for(int rIndex = 1; rIndex<10; rIndex++) {                  //Transposition wird in gridZwischenspeicher gespeichert
            for (int cIndex = 1;cIndex<10; cIndex++) {
                gridZwischenspeicher.setValue(rIndex,cIndex,grid.getValue(cIndex,rIndex));
            }
        }

        for(int rIndex=1; rIndex <10; rIndex++){                //urspruengliche Gitter wird mit dem transponierten aus dem Zwischenspeicher ueberschrieben
            for (int cIndex = 1;cIndex<10; cIndex++){
                grid.setValue(rIndex,cIndex, gridZwischenspeicher.getValue(rIndex,cIndex));
            }
        }
    }

    /**
     * Hier wird ueberprueft, ob grid2 durch Transposition von grid1 entstanden ist.
     * @param grid1 Gitter 1
     * @param grid2 Gitter 2, bei dem geschaut werden soll, ob es durch eine Transposition von Gitter 1 entstanden ist
     * @return true, falls Gitter 2 durch Transposition von Gitter 1 entstanden ist, sonst false
     */
    @Override
    public boolean isTransposition(Grid grid1, Grid grid2) {
        int anzahlUnterschiede=0;

        for(int rIndex = 1; rIndex<10; rIndex++) {                                          //transponieren von Grid 1 und speichern der Transposition in gridZwischenspeicher
            for (int cIndex = 1;cIndex<10; cIndex++) {
                gridZwischenspeicher.setValue(rIndex,cIndex,grid1.getValue(cIndex,rIndex));
            }
        }

        for(int rIndex =1; rIndex<10; rIndex++){                                            //Vergleich der Transposition mit dem Grid 2. Falls es einen Unterschied gibt,
            for (int cIndex = 1;cIndex<10; cIndex++){                                       //wird anzahlUnterschiede um 1 erhoeht
                if(gridZwischenspeicher.getValue(rIndex,cIndex) != grid2.getValue(rIndex,cIndex))
                    anzahlUnterschiede= anzahlUnterschiede+1;
            }
        }

        if (anzahlUnterschiede==0)                                                          //Gab es Unterschiede, wird false zurueckgegeben, da Grid 2 nicht aus Grid 1 entstanden sein kann
            return true;
        else
            return false;
    }
}
