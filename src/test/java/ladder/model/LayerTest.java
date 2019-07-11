package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LayerTest {

    @Test
    @DisplayName("lastDirection")
    void lastDirection() {
        assertThat(Layer.lastDirection(Arrays.asList(true))).isEqualTo(Direction.LEFT);
        assertThat(Layer.lastDirection(Arrays.asList(false))).isEqualTo(Direction.PASS);
    }
}
