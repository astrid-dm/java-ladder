package ladder.domain;

import ladder.util.RandomUtil;

public class MoveDirection {
    public static final String CANNOT_MOVE_BOTH_SIDE_MESSAGE = "양쪽 다 이동할 수는 없습니다.";

    private final boolean left;
    private final boolean right;

    private MoveDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(CANNOT_MOVE_BOTH_SIDE_MESSAGE);
        }
        this.left = left;
        this.right = right;
    }

    public static MoveDirection first(boolean right) {
        return new MoveDirection(false, right);
    }

    public static MoveDirection first() {
        return first(RandomUtil.randomBoolean());
    }

    public boolean canMoveRight() {
        return right;
    }

    public boolean canMoveLeft() {
        return left;
    }

    public MoveDirection next(boolean right) {
        return new MoveDirection(this.right, right);
    }

    public MoveDirection last() {
        return new MoveDirection(this.right, false);
    }

    public MoveDirection next() {
        if (this.right) {
            return next(false);
        }
        return next(RandomUtil.randomBoolean());
    }
}
