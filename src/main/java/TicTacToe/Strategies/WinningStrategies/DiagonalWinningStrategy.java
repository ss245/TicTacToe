package TicTacToe.Strategies.WinningStrategies;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;
import TicTacToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategies{

    Map<Integer, Map<Symbol, Integer>> ldHMs = new HashMap<>();
    Map<Integer,Map<Symbol,Integer>> rdHMs = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        int column = move.getCell().getColumn();
        if(row==column){
            if (!ldHMs.containsKey(column)) {
                ldHMs.put(column, new HashMap<Symbol, Integer>());
            }
            Map<Symbol, Integer> hm = ldHMs.get(column);
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

        if(row+column==(board.getDimension()-1)){
            if (!rdHMs.containsKey(column)) {
                rdHMs.put(column, new HashMap<Symbol, Integer>());
            }
            Map<Symbol, Integer> hm = rdHMs.get(column);
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
        return false;
    }
}
