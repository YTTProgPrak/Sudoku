import data.Cell;
import data.Grid;
import utils.BlockUtils;
import utils.GridSolvingUtils;
import utils.GridUtils1;

import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main (String [] args) {

        Grid grid = new Grid(9);
        Grid grid1 = new Grid(9);


        Cell anchor = new Cell(4, 1);
        BlockUtils blockUtils = new BlockUtils();
        GridUtils1 gridUtils1 = new GridUtils1();
        GridSolvingUtils su = new GridSolvingUtils();

        grid.setValue(4, 1, 6);
        grid.setValue(4, 2, 7);
        grid.setValue(4, 3, 9);
        grid.setValue(6, 1, 2);

        grid1.setValue(4, 1, 7);
        grid1.setValue(4, 2, 8);
        grid1.setValue(4, 3, 1);
        grid1.setValue(6, 1, 5);

        List<Cell> l = su.getWhiteSpaces(grid);
        System.out.println(l.get(9).getrIndex()+","+l.get(9).getcIndex());


    }
}
