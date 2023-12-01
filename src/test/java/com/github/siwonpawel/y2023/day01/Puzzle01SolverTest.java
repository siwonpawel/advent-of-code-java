package com.github.siwonpawel.y2023.day01;

import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class Puzzle01SolverTest
{

    private Solver solver = new Puzzle01Solver();

    @Test
    void shouldCalculateCorrectCoordinatesForTestInput()
    {
        // given
        List<String> read = read("test_input_1.txt");

        // when
        int result = solver.count(read);

        // then
        assertThat(result).isEqualTo(142);
    }

    @Test
    void shouldCalculateCorrectCoordinatesForInput()
    {
        // given
        List<String> read = read("input.txt");

        // when
        int result = solver.count(read);

        // then
        assertThat(result).isEqualTo(55_108);
    }

    private List<String> read(String filename)
    {
        try (var in = getClass().getResourceAsStream(filename))
        {
            return IOUtils.readLines(in, Charset.defaultCharset());
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}