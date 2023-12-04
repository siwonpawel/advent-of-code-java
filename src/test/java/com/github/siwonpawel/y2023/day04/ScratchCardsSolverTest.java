package com.github.siwonpawel.y2023.day04;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.github.siwonpawel.y2023.FileReader;

import static org.assertj.core.api.Assertions.*;

class ScratchCardsSolverTest extends FileReader
{

    private ScratchCardsSolver solver = new ScratchCardsSolver();

    @Test
    void shouldCorrectlySolveExampleInputForPart1()
    {
        // given
        List<String> input = read("test_input.txt");

        // when
        int result = solver.solvePart1(input);

        // then
        assertThat(result).isEqualTo(13);
    }

    @Test
    void shouldCorrectlySolveInputForPart1()
    {
        // given
        List<String> input = read("input.txt");

        // when
        int result = solver.solvePart1(input);

        // then
        assertThat(result).isEqualTo(25004);
    }

    @Test
    void shouldCorrectlySolveExampleInputForPart2()
    {
        // given
        List<String> input = read("test_input.txt");

        // when
        int result = solver.solvePart2(input);

        // then
        assertThat(result).isEqualTo(30);
    }

    @Test
    void shouldCorrectlySolveInputForPart2()
    {
        // given
        List<String> input = read("input.txt");

        // when
        int result = solver.solvePart2(input);

        // then
        assertThat(result).isEqualTo(14427616);
    }

}