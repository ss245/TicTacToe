package TicTacToe.Controllers;

import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Exceptions.InvalidMoveException;
import TicTacToe.Exceptions.InvalidPlayerCountException;
import TicTacToe.Models.Game;
import TicTacToe.Models.GameState;
import TicTacToe.Models.Player;
import TicTacToe.Strategies.WinningStrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategies> winningStrategies) throws InvalidBotCountException, InvalidPlayerCountException {
         return Game.getBuilder().setDimension(dimension).setPlayers(players).setWinningStrategies(winningStrategies).Build();
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public Player getGameWinner(Game game){
        return game.getWinner();
    }



}
