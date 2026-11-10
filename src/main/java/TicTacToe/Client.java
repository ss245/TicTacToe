package TicTacToe;

import TicTacToe.Controllers.GameController;
import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Exceptions.InvalidPlayerCountException;
import TicTacToe.Models.*;
import TicTacToe.Strategies.WinningStrategies.ColumnWinningStrategy;
import TicTacToe.Strategies.WinningStrategies.DiagonalWinningStrategy;
import TicTacToe.Strategies.WinningStrategies.RowWinningStrategy;
import TicTacToe.Strategies.WinningStrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException, InvalidPlayerCountException {
    //  Game game = Game.getBuilder().setDimension(3).setPlayers(new ArrayList<>()).setWinningStrategies(new ArrayList<>()).Build();
      int dimension = 3;
      List<Player> players = new ArrayList<>();
      players.add(new Player("Shivkumar", new Symbol('X'), PlayerType.Human));
      players.add(new Player("Shubham",new Symbol('O'), PlayerType.Human));
      List<WinningStrategies> winningStrategies=new ArrayList<>();
      winningStrategies.add(new RowWinningStrategy());
      winningStrategies.add(new ColumnWinningStrategy());
      winningStrategies.add(new DiagonalWinningStrategy());
      GameController gameController = new GameController();
      Game game = gameController.startGame(dimension,players,winningStrategies);
      gameController.printBoard(game);

      while(game.getGameState().equals(GameState.In_Progress)){
        // Before a Player make a move , he wants to see the board
        // So print the board
        gameController.printBoard(game);
        // Ask the user where to make the move
        gameController.makeMove(game);
      }

      // After we came out from the above loop i.e. Game is Ended.
      if(game.getGameState().equals(GameState.Ended)){
        // After the Game Ended print the board
        gameController.printBoard(game);
        // Print the Player who won the Game
        System.out.println("Game Winner is  "+ gameController.getGameWinner(game).getName());
      }
      else {
        System.out.println("Game is Drawn.");
      }
    }
}
