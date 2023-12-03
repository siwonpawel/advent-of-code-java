package com.github.siwonpawel.y2023.day03;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.github.siwonpawel.y2023.FileReader;

import static org.assertj.core.api.Assertions.*;

class GearRatiosSolverTest extends FileReader
{

    private final GearRatiosSolver solver = new GearRatiosSolver();

    @Test
    @Disabled("moving to part 2")
    void shouldCorrectlySolveExampleInputForPart1()
    {
        // given
        List<String> input = read("test_input.txt");

        // when
        int result = solver.doFinal(input);

        // then
        assertThat(result)
                .isEqualTo(4361);
    }

    @Test
    @Disabled("moving to part 2")
    void shouldCorrectlySolveInputForPart1()
    {
        // given
        List<String> input = read("input.txt");

        // when
        int result = solver.doFinal(input);

        // then
        assertThat(result)
                .isEqualTo(532428);
    }

    @Test
    void shouldCorrectlySolveExampleInputForPart2()
    {
        // given
        List<String> input = read("test_input.txt");

        // when
        int result = solver.doFinal(input);

        // then
        assertThat(result)
                .isEqualTo(467835);
    }

    @Test
    void shouldCorrectlySolveInputForPart2()
    {
        // given
        List<String> input = read("input.txt");

        // when
        int result = solver.doFinal(input);

        // then
        assertThat(result)
                .isEqualTo(84051670);
    }

}