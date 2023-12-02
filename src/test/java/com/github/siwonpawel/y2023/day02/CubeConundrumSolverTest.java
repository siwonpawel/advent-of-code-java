package com.github.siwonpawel.y2023.day02;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.github.siwonpawel.y2023.FileReader;

import static org.assertj.core.api.Assertions.*;

class CubeConundrumSolverTest extends FileReader
{

    private final CubeConundrumSolver solver = new CubeConundrumSolver();

    @Test
    @Disabled("moving to part 2")
    void shouldCorrectlySolveExampleInputForPart1()
    {
        // given
        List<String> input = read("test_input_1.txt");

        // when
        int result = solver.doFinal(input);

        // then
        assertThat(result)
                .isEqualTo(8);
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
                .isEqualTo(8);
    }

}