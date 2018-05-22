package utils;

import data.Cell;
import data.Grid;

/**
 * GridUtils2 bietet Methoden im Zusammenhang mit Spiegelungen von Gittern.
 * @author Yan Berkel (yb1@gmx.net)
 */

public class GridUtils2 implements GridUtil2 {

    /**
     * reflect spiegelt ein uebergebenes Gitter (grid) ueber eine Zeile/Spalte.
     * Diese wird ueber ihre Ankerzelle (anchor), welche der Methode ebenfalls uebergeben wird, festgelegt
     * @param grid Gitter das gespiegelt werden soll
     * @param anchor Ankerzelle der Zeile/Spalte ueber die gespiegelt werden soll
     */

    @java.lang.Override
    public void reflect(Grid grid, Cell anchor) {

        int[] tmp;
        int indexplus;
        int indexminus;
        int anchorrIndex = anchor.getrIndex();
        int anchorcIndex = anchor.getcIndex();
        int dim = grid.getRowValues(1).length;

        /**
         * Zunaechst wird anhand des Reihenindex des Ankers geprueft, ob es sich um eine horizontale, oder
         * eine vertikale Spiegelung handelt. Ist der Reihenindex > 1, ist der Spaltenindex demzufolge = 1 und es
         * muss horizontal gespiegelt werden. Sollte der Reihenindex nicht > 1 sein, kann er nur = 1 sein, es muesste
         * dann vertikal gespiegelt werden. Zu beachten ist ausserdem, ob die Reihe, ueber die gespiegelt werden soll,
         * sich am Rande des Gitters befindet, da in diesen Faellen nicht gespiegelt werden kann.
         * Dies kann dadurch ausgeschlossen werden, dass wir zum einen schon wissen, dass der ausschlaggebende
         * Index > 1 ist, und durch Ueberpruefung, dass dieser kleiner als die Dimension des Gitters ist.
         */

        if(anchorrIndex > 1 && anchorrIndex < dim){
            indexplus = anchor.getrIndex();
            indexminus = indexplus;

            /**
             * Es werden nun, von der Reihe die den Anker beinhaltet ausgehend, die Werte der Reihen vertauscht.
             * Die Reihe die den Anker beinhaltet wird hierbei ausgelassen, da indexplus und indexminus direkt zu
             * Anfang der Schleife um 1 erhöht, bzw. verringert wird. Die Vertauschung wird solange ausgefuehrt,
             * bis entweder an den linken, oder den rechten Rand des Gitters gestossen wird.
             */

            while(indexminus >= 1 && indexplus <= dim){
                indexplus++;
                indexminus--;
                tmp = grid.getRowValues(indexplus);
                grid.setRowValues(indexplus, grid.getRowValues(indexminus));
                grid.setRowValues(indexminus, tmp);
            }
        }else if(anchorcIndex > 1 && anchorcIndex < dim){
            indexplus = anchor.getcIndex();
            indexminus = indexplus;
            while(indexminus >= 1 && indexplus <= dim){
                indexplus++;
                indexminus--;
                tmp = grid.getColValues(indexplus);
                grid.setColValues(indexplus, grid.getColValues(indexminus));
                grid.setColValues(indexminus, tmp);
            }

        }

    }

    /**
     * isReflection() ueberprueft, ob es sich bei zwei Gittern (grid1, grid2) um Spiegelungen voneinander handelt.
     * Hierzu werden der Methode beide zu ueberpruefende Objekte vom Typ Grid uebergeben, woraufhin das Ergebnis als
     * boolean (result) zurueckgegeben wird. Wir machen uns hier zu nutzen,
     * dass die Methode getReflectionAnchor() nur einen Anker finden kann,
     * wenn es sich tatsaechlich um eine Spiegelung handelt. Sollte getReflectionAnchor() "null"
     * wiedergeben und somit keinen Anker gefunden haben, ist klar, dass es sich nicht um Spiegelungen voneinander handelt.
     * @param grid1 erstes der beiden Gitter
     * @param grid2 zweites der beiden Gitter
     * @return Boolean, der das Ergebnis des Vergleiches darstellt
     */

    @java.lang.Override
    public boolean isReflection(Grid grid1, Grid grid2) {
        boolean result = false;
        Cell anchor = getReflectionAnchor(grid1, grid2);

        if(anchor != null){
            result = true;
        }

        return result;
    }

    /**
     * getReflectionAnchor ermittelt, sofern moeglich, aus zwei Gittern die Ankerzelle der Zeile/Spalte,
     * ueber welche diese gespiegelt das jeweils andere ergeben.
     * @param grid1 erstes der beiden Gitter
     * @param grid2 zweites der beiden Gitter
     * @return Ankerzelle der Reihe/Spalte über die gespiegelt wurde
     */
    @java.lang.Override
    public Cell getReflectionAnchor(Grid grid1, Grid grid2) {

        Grid reflection;
        Cell anchor = null;
        Cell tmpAnchor;
        int dim = grid1.getRowValues(1).length;

        /**
         * Wir benutzen die Methode reflect(), um eine Spiegelung von grid1 zu erzeugen (reflection), welche dann
         * mit grid2 verglichen wird. Da reflect() zusaetzlich zum zu spiegelnden Gitter auch die gesuchte Anker-Zelle
         * der Spiegelkante übergeben werden muss, muessen wir alle Moeglichekeiten, sowohl senkrecht,
         * als auch horizontal, für diese einzeln durchgehen. Sobald wir eine Uebereinstimmung gefunden haben,
         * geben wir die zugehoerige Anker-Zelle zurueck. Sollte keine Uebereinstimmung gefunden werden, geben wir
         * "null" zurueck.
         */

        for(int i=0; i<dim; i++){
            reflection = grid1;
            tmpAnchor = reflection.getCell(i+1, 1);
            reflect(reflection, tmpAnchor);
            if(grid2 == reflection){
                anchor =  tmpAnchor;
                break;
            }
        }

        if(anchor == null){
            for(int i=0; i<dim; i++){
                reflection = grid1;
                tmpAnchor = reflection.getCell(1, i+1);
                reflect(reflection, tmpAnchor);
                if(grid2 == reflection){
                    anchor = tmpAnchor;
                    break;
                }
            }
        }

        return anchor;


    }
}
