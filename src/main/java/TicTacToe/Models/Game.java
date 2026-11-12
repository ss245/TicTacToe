package TicTacToe.Models;

import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Exceptions.InvalidMoveException;
import TicTacToe.Exceptions.InvalidPlayerCountException;
import TicTacToe.Strategies.WinningStrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerMoveIndex;
    private List<WinningStrategies> winningStrategies;

    // create private constructor so that we can create object of Game
    // Using Builder design pattern only

    private Game( int dimension, List<Player> players, List<WinningStrategies> winningStrategies){
        this.board=new Board(dimension);
        this.players=players;
        this.winningStrategies=winningStrategies;
        this.moves=new ArrayList<>();
        this.gameState=GameState.In_Progress;
        this.nextPlayerMoveIndex=0;
    }


    // To be able to create a game we are going to use Builder Design Pattern

    // to be able to create object of Builder Class we need a static getBuilder method

    public static Builder getBuilder(){
        return new Builder();
    }

    // Validating the move made by the current player
    public void validateMove(Board board,Move move) throws InvalidMoveException {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        if(row<0 || row>board.getDimension()-1 || col<0 || col> board.getDimension()-1 || board.getBoard().get(row).get(col).getCellState()==CellState.Filled){
            throw new InvalidMoveException("Your Move is Invalid");
        }

    }

    // Method for checking if its the current player who played the move is winner or not
    public boolean checkWinner(Move move){
        // Check the row, column,and diagonal(if applicable)
        for(WinningStrategies winningStrategies1:winningStrategies){
            if(winningStrategies1.checkWinner(move, board)){
                return true;
            }
        }
        return false;
    }




    public void makeMove() throws InvalidMoveException {
        // In order to make move first we get the player
        Player currentPlayer = players.get(nextPlayerMoveIndex);
        System.out.println("Its "+currentPlayer.getName()+ " 's move");
        Move move = currentPlayer.makeMove(board);

        //Validate the move made by the current player
        validateMove(board, move);


        // This is valid move and now lets execute this move on to the board
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.Filled);
        cell.setPlayer(currentPlayer);

        nextPlayerMoveIndex = (nextPlayerMoveIndex+1)%players.size();
        Move finalMove = new Move(currentPlayer,cell);
        moves.add(finalMove);

        // Check if its the winning move
        if(checkWinner(finalMove)){
            winner = currentPlayer;
            gameState=GameState.Ended;
        }
        else if(moves.size()== board.getDimension()* board.getDimension()){
            gameState=GameState.Draw;
        }
    }

    public void printBoard() {
        board.print();
    }

    // To be able to help build a Game object we need a builder class i.e. Static Builder Class

    public static class Builder {
        private int dimension;
        private List<Player> players;
        private List<WinningStrategies> winningStrategies;

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStrategies> getWinningStrategies() {

            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategies> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        // Do we need to perform some validation checks before creating a Game

        private void validateBotCount() throws InvalidBotCountException {
            int botCount=0;
            for(Player player:players){
                if(player.getPlayerType()==PlayerType.Bot) {
                    botCount++;
                }
            }
            if(botCount>1){
                throw new InvalidBotCountException("Bot count is greater than 1");
            }
        }

        private void validatePlayerCount() throws InvalidPlayerCountException {
            if(players.size()!= dimension-1){
                throw new InvalidPlayerCountException("Player count is invalid.");
            }
        }

        private void validateUniqueSymbolForEachPlayer(){

        }

        public void validate() throws InvalidBotCountException, InvalidPlayerCountException {
            validateBotCount();
            validatePlayerCount();
            validateUniqueSymbolForEachPlayer();
        }

        // before creating the Game object, first we validate the Game Object
        public Game Build() throws InvalidBotCountException, InvalidPlayerCountException {
            validate();
            return new Game(dimension,players,winningStrategies);
        }
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public List<WinningStrategies> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategies> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

}