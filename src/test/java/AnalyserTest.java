import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static junit.framework.TestCase.assertTrue;

public class AnalyserTest
{

    private Map<Integer, String> values = new HashMap<>();
    private Random random;

    @Test
    public void test() {
        final ArrayList<Integer> numbers = new ArrayList<>(values.keySet());
        Integer number = numbers.get(random.nextInt(numbers.size()));
        String value = Translator.translateToString(number).trim();
        assertTrue(value.equalsIgnoreCase(values.get(number)));
    }
    @Before
    public void setUp()
    {
        random = new Random();
        initValuesMap();
    }

    private void initValuesMap()
    {
        values.put(7, "семь");
        values.put(37, "тридцать семь");
        values.put(437, "четыреста тридцать семь");
        values.put(5821, "пять тысячь восемьсот двадцать один");
        values.put(104327, "сто четыре тысячи триста двадцать семь");
    }
}
