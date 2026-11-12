package TicTacToe.Factory;

import TicTacToe.Models.BotDifficultyLevel;
import TicTacToe.Strategies.BotWinningStrategies.BotWinningStrategy;
import TicTacToe.Strategies.BotWinningStrategies.EasyWinningStrategy;
import TicTacToe.Strategies.BotWinningStrategies.HardWinningStrategy;
import TicTacToe.Strategies.BotWinningStrategies.MediumWinningStrategy;

public class BotWinningStrategyFactory {
    public static BotWinningStrategy getBotWinningStrategy(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel.equals(BotDifficultyLevel.Easy)){
            return new EasyWinningStrategy();
        }
        else if(botDifficultyLevel.equals(BotDifficultyLevel.Medium)){
            return new MediumWinningStrategy();
        }
        else{
            return new HardWinningStrategy();
        }
    }

}
