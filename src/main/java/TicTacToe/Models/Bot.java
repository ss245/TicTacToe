package TicTacToe.Models;

import TicTacToe.Strategies.BotWinningStrategies.BotWinningStrategy;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;
    private BotWinningStrategy botWinningStrategy;

    public Bot(String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel, BotWinningStrategy botWinningStrategy){
        super(name, symbol, PlayerType.Bot);
        this.botDifficultyLevel=botDifficultyLevel;
        this.botWinningStrategy=botWinningStrategy;
    }


    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotWinningStrategy getBotWinningStrategy() {
        return botWinningStrategy;
    }

    public void setBotWinningStrategy(BotWinningStrategy botWinningStrategy) {
        this.botWinningStrategy = botWinningStrategy;
    }
}
