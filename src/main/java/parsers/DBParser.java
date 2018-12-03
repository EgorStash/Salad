package parsers;

import jdbc.dao.SaladDao;
import salad.Salad;

import java.nio.file.Path;
import java.util.List;

public class DBParser implements BestParser {

    public static void main(String[] args) {
        List<Salad> salads = SaladDao.parse();
        for (Salad salad : salads) {
            System.out.println(salad);
        }
    }

    @Override
    public List<Salad> parse() throws Exception {
        return SaladDao.parse();
    }
}
