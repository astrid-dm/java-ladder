package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Point;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String CONNECTION = "-----";
    private static final String DISCONNECTION = "     ";
    private static final String LEG = "|";

    private ResultView() {
    }

    public static void printParticipantNames(List<Name> names) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
        System.out.println(names.stream()
                .map(name -> String.format("%6s", name))
                .collect(Collectors.joining()));
    }

    public static void printResult(List<String> results) {
        System.out.println(results.stream()
                .map(result -> String.format("%6s", result))
                .collect(Collectors.joining()));
    }

    public static void printLadder(List<Line> ladder) {
        System.out.println(ladder.stream()
                .map(line -> printLine(line.getLine()))
                .collect(Collectors.joining("\n")));
    }
    public static void printAllParticipantsResult(List<String> results, Ladder ladder, List<String> names) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println(names.stream()
                .map(name -> name + " : " + results.get(ladder.pathFind(names.indexOf(name))))
                .collect(Collectors.joining("\n")));
    }

    public static void printParticipantResult(List<String> results, Ladder ladder, int ParticipantIndex) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println(results.get(ladder.pathFind(ParticipantIndex)));
    }

    public static void notParticipant() {
        System.out.println();
        System.out.println("사다리게임 참가자가 아닙니다.");
    }

    private static String printLine(List<Point> line) {
        return line.stream()
                .map(ResultView::makeStep)
                .collect(Collectors.joining());
    }

    private static String makeStep(Point point) {
        if (point.isLeftConnected()) {
            return connectionStep();
        }
        return disconnectionStep();
    }

    private static String connectionStep() {
        return CONNECTION + LEG;
    }

    private static String disconnectionStep() {
        return DISCONNECTION + LEG;
    }
}
