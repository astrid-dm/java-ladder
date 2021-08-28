package ladder.view;

import ladder.domain.ladder.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.domain.result.Result;
import ladder.domain.result.Results;
import ladder.domain.user.User;
import ladder.domain.user.Users;
import ladder.utils.StringUtil;

import java.util.List;
import java.util.Map;

public final class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String EMPTY_DISPLAY = " ";
    private static final String EXECUTE_RESULT_MESSAGE = "실행 결과";
    private static final String EXECUTE_SEPARATOR = " : ";
    private static final String LADDER_RESULT_PRE_MESSAGE = "사다리 결과";
    private static final String LADDER_VERTICAL_DISPLAY = "|";
    private static final String LADDER_HORIZONTAL_DISPLAY = "-";

    private OutputView() {
    }

    public static void showLadderGameResult(final Ladder ladder,
                                            final Users users,
                                            final Results results) {
        System.out.print(LINE_SEPARATOR + LADDER_RESULT_PRE_MESSAGE + LINE_SEPARATOR + LINE_SEPARATOR);
        showStartPoint(users);
        System.out.print(LINE_SEPARATOR);
        showLadders(ladder.getLines());
        showEndPoint(results);
    }

    private static void showStartPoint(final Users users) {
        users.getUsers().stream()
                .map(User::toString)
                .map(OutputView::positionFormat)
                .forEach(System.out::print);
    }

    private static void showEndPoint(final Results results) {
        results.getResults().stream()
                .map(Result::toString)
                .map(OutputView::positionFormat)
                .forEach(System.out::print);
    }

    private static String positionFormat(final String input) {
        return StringUtil.fillRightBlank(input, User.MAX_NAME_LENGTH + 1);
    }

    private static void showLadders(final List<Line> lines) {
        lines.stream()
                .map(OutputView::getLine)
                .forEach(System.out::println);
    }

    private static String getLine(final Line line) {
        return line.getPoints().stream()
                .map(OutputView::getDirection)
                .reduce(String::concat).orElse(EMPTY_DISPLAY);
    }

    private static String getDirection(final Point point) {
        if (point.compareDirection(Direction.RIGHT)) {
            return directionFormat(LADDER_HORIZONTAL_DISPLAY);
        }
        return directionFormat(EMPTY_DISPLAY);
    }

    private static String directionFormat(final String input) {
        return LADDER_VERTICAL_DISPLAY + StringUtil.fillGivenString(input, User.MAX_NAME_LENGTH);
    }

    public static void result(final Result result) {
        showResultBeforeMessage();
        System.out.print(result);
    }

    public static void result(final Map<User, Result> map) {
        showResultBeforeMessage();
        map.forEach((user, result) -> System.out.print(user + EXECUTE_SEPARATOR + result + LINE_SEPARATOR));
    }

    public static void showResultBeforeMessage() {
        System.out.print(LINE_SEPARATOR + EXECUTE_RESULT_MESSAGE + LINE_SEPARATOR);
    }
}
