package com.github.siwonpawel.y2023;

import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class FileReader
{

    protected List<String> read(String filename)
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
