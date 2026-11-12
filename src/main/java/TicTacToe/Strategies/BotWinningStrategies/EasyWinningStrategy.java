package TicTacToe.Strategies.BotWinningStrategies;

import TicTacToe.Models.Board;
import TicTacToe.Models.Cell;
import TicTacToe.Models.CellState;
import TicTacToe.Models.Move;

import java.util.List;

public class EasyWinningStrategy implements BotWinningStrategy{

    @Override
    public Move makeMove(Board board) {
        // Make move method consists of algorithm which places its symbol at first empty
        // place in the borad
        for(List<Cell> cells: board.getBoard()){
            for(Cell cell : cells){
                if(cell.getCellState()== CellState.Empty){
                    return new Move(null,cell);
                }
            }
        }
        return null;
    }
}
