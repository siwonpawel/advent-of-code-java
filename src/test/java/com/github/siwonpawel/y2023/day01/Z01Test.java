package com.github.siwonpawel.y2023.day01;

import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class Z01Test
{

    private Z01 z01 = new Z01();

    @Test
    void shouldCalculateCorrectCoordinatesForTestInput()
    {
        // given
        List<String> read = read("test_input_1.txt");

        // when
        int result = z01.count(read);

        // then
        assertThat(result).isEqualTo(142);
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