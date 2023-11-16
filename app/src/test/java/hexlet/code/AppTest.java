package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    public void functionTest() {
        boolean expected = true;
        assertThat(expected).isEqualTo(App.testFunction());
    }
}
