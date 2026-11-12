package TicTacToe.Strategies.WinningStrategies;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;
import TicTacToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategies {
    Map<Integer, Map<Symbol, Integer>> colHMs = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int column = move.getCell().getColumn();
        if (!colHMs.containsKey(column)) {
            colHMs.put(column, new HashMap<Symbol, Integer>());
        }
        Map<Symbol, Integer> hm = colHMs.get(column);
        Symbol symbol = move.getPlayer().getSymbol();
        if (hm.containsKey(symbol)) {
            hm.put(symbol, hm.get(symbol) + 1);
        } else {
            hm.put(symbol, 1);
        }
        if (hm.get(symbol) == board.getDimension()) {
            System.out.println("Player " + move.getPlayer().getName() + " won the Game.");
            return true;
        }
        return false;
    }
}