package com.github.siwonpawel.y2023.day03;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.github.siwonpawel.y2023.FileReader;

import static org.assertj.core.api.Assertions.*;

class GearRatiosSolverTest extends FileReader
{

    private final GearRatiosSolver solver = new GearRatiosSolver();

    @Test
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

}