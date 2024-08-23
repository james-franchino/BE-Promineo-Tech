package com.promineotech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoJUnitTest {
    private TestDemo testDemo;

    static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
                arguments(2, 4, 6, false),
                arguments(1, 5, 6, false),
                arguments(-1, 5, 0, true),
                arguments(0, 5, 0, true),
                arguments(5, 0, 0, true)
        );
    }

    @BeforeEach
    void setUp() {
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() -> testDemo.addPositive(a, b))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
        assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
    }

    @Test
    void assertThatNumberSquaredIsCorrect() {
        TestDemo mockDemo = spy(testDemo);
        doReturn(5).when(mockDemo).getRandomInt();
        int fiveSquared = mockDemo.randomNumberSquared();
        assertThat(fiveSquared).isEqualTo(25);
    }

    // Your custom test here
    @Test
    void assertThatNumberIsMultipliedByTwoCorrectly() {
        assertThat(testDemo.multiplyByTwo(4)).isEqualTo(8);
        assertThat(testDemo.multiplyByTwo(-3)).isEqualTo(-6);
        assertThat(testDemo.multiplyByTwo(0)).isEqualTo(0);
    }
}