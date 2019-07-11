package ladder;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {

        Players players = InputView.askPlayers();
        Rewards rewards = InputView.askRewards();
        int height = InputView.askHeight();

        Ladder ladder = Ladder.of(players.size(), height);

        LadderGame ladderGame = new LadderGame(ladder, players, rewards);
        Result result = ladderGame.start();

        OutputView.print(players, ladder, rewards);

        String name = InputView.askResult();
        OutputView.print(name, result);


    }
}
