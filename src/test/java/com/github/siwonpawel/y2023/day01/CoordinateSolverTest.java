package com.github.siwonpawel.y2023.day01;

import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.github.siwonpawel.y2023.FileReader;

import static org.assertj.core.api.Assertions.*;

class CoordinateSolverTest extends FileReader
{

    private CoordinateSolver solver = new CoordinateSolver();


    @Test
    @Disabled("moving to part 2")
    void shouldCalculateCorrectCoordinatesForTestInputOfPart1()
    {
        // given
        List<String> read = read("test_input_1.txt");

        // when
        int result = solver.count(read);

        // then
        assertThat(result).isEqualTo(142);
    }

    @Test
    @Disabled("moving to part 2")
    void shouldCalculateCorrectCoordinatesForInputOfPart1()
    {
        // given
        List<String> read = read("input.txt");

        // when
        int result = solver.count(read);

        // then
        assertThat(result).isEqualTo(55_108);
    }

    @Test
    void shouldCalculateCorrectCoordinatesForTestInputOfPart2()
    {
        // given
        List<String> read = read("test_input_2.txt");

        // when
        int result = solver.count(read);

        // then
        assertThat(result).isEqualTo(281);
    }

    @Test
    void shouldCalculateCorrectCoordinatesForInputOfPart2()
    {
        // given
        List<String> read = read("input.txt");

        // when
        int result = solver.count(read);

        // then
        assertThat(result).isEqualTo(56_324);
    }

}