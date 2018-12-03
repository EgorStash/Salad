package parsers;

import salad.Salad;

import java.nio.file.Path;
import java.util.List;

public interface BestParser {
    public List<Salad> parse() throws Exception;
}
