import java.util.List;

import static java.util.stream.Collectors.toList;

public class Anagram {

    private final String orderedLetters;

    public Anagram(final String ofWord) {

        this.orderedLetters = transformToOrderedLetters(ofWord);
    }

    public List<String> match(final List<String> toPossibleWords) {
        return toPossibleWords
                .stream()
                .filter(word -> word.length() == orderedLetters.length())
                .filter(word -> transformToOrderedLetters(word).equals(orderedLetters))
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


}
