import java.util.List;

import static java.util.stream.Collectors.toList;

public class Anagram {

    private final String original;
    private final String orderedLetters;

    public Anagram(final String ofWord) {

        this.original = ofWord;
        this.orderedLetters = transformToOrderedLetters(ofWord);
    }

    public List<String> match(final List<String> toPossibleWords) {
        return toPossibleWords
                .stream()
                .filter(this::wordAndOriginalAreSameSize)
                .filter(this::wordIsNotTheSameIgnoringCase)
                .filter(this::orderingTheLettersOfTheWordsGivesTheSameStringThanTheOriginalWordOrdered)
                .collect(toList());
    }

    private String transformToOrderedLetters(final String ofWord) {
        return ofWord
                .toLowerCase()
                .chars()
                .sorted()
                .collect(
                        StringBuilder::new,
                        (sb, letter) -> sb.append((char) letter),
                        StringBuilder::append
                ).toString();
    }

    private boolean wordIsNotTheSameIgnoringCase(String word) {
        return !word.equalsIgnoreCase(original);
    }

    private boolean wordAndOriginalAreSameSize(String word) {
        return word.length() == orderedLetters.length();
    }

    private boolean orderingTheLettersOfTheWordsGivesTheSameStringThanTheOriginalWordOrdered(String word) {
        return transformToOrderedLetters(word).equals(orderedLetters);
    }
}
