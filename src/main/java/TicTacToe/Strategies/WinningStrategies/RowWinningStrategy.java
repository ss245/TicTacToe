package TicTacToe.Strategies.WinningStrategies;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;
import TicTacToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategies{
    Map<Integer, HashMap<Symbol,Integer>> rowHMs = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        if(!rowHMs.containsKey(row)){
            rowHMs.put(row,new HashMap<Symbol,Integer>());
        }
        Map<Symbol,Integer> hm = rowHMs.get(row);
        Symbol symbol = move.getPlayer().getSymbol();
        System.out.println(symbol);
        if(hm.containsKey(symbol)){
            hm.put(symbol,hm.get(symbol)+1);
        }
        else{
            hm.put(symbol,1);
        }
        if(hm.get(symbol)==board.getDimension()){
            System.out.println("Player "+ move.getPlayer().getName() + " won the Game.");
            return true;
        }
        return false;
    }
}
