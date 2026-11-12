package TicTacToe.Models;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    public Player(String name, Symbol symbol, PlayerType playerType){
        this.name=name;
        this.symbol=symbol;
        this.playerType=playerType;
    }

    // create static scanner object to take input
    private Scanner scanner = new Scanner(System.in);


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {
        System.out.println("Enter row no for which you want to make move: ");
        int row = scanner.nextInt();
        System.out.println("Enter col no for which you want to make move: ");
        int col = scanner.nextInt();
        return new Move(this, new Cell (row,col));
    }
}
