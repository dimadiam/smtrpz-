import org.junit.jupiter.api.Test;


import static com.company.WordsCalculation.isHasSimilarCharInArray;
import static com.company.WordsCalculation.wordsWithDiffChars;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordsCalculationTest {

    @Test
    public void test_isHasSimilarCharInArray_returns_true_for_similar_letters_in_word() {
        boolean expected = true;
        String text = "Mann";
        char[] array = text.toCharArray();
        boolean actual = isHasSimilarCharInArray(array, 'n');
        assertEquals(expected, actual);
    }

    @Test
    public void test_wordsWithDiffChars_returns_words_with_unique_letters() {
        String[] expected = {"Quis", "autem", "some", "sunt"};
        String[] actual = wordsWithDiffChars("Quis autem unique nott uniqque lol some nnam sunt");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test_wordsWithDiffChars_returns_empty_array() {
        String[] expected = {""};
        String[] actual = wordsWithDiffChars("nott unique text fromm book лампа наушники");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test_wordsWithDiffChars_returns_empty_array_from_empty_string() {
        String[] expected = {};
        String[] actual = wordsWithDiffChars("");
        assertArrayEquals(expected, actual);
    }
}