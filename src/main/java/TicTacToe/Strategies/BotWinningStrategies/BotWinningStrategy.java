package TicTacToe.Strategies.BotWinningStrategies;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;

public interface BotWinningStrategy {
    public Move makeMove(Board board);
}
