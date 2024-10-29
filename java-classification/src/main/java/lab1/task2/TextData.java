package lab1.task2;

public class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    public TextData(String text) {
        this.text = text;
        analyze();
    }

    // analyze text and calculate all metrics
    private void analyze() {
        this.numberOfVowels = countVowels();
        this.numberOfConsonants = countConsonants();
        this.numberOfLetters = text.replaceAll("[^a-zA-Z]", "").length();
        this.numberOfSentences = text.split("[.!?]+").length;
        this.longestWord = findLongestWord();
    }

    private int countVowels() {
        return text.toLowerCase().replaceAll("[^aeiou]", "").length();
    }

    private int countConsonants() {
        return text.toLowerCase().replaceAll("[^a-z]", "").replaceAll("[aeiou]", "").length();
    }

    private String findLongestWord() {
        String[] words = text.split("\\s+");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public String getFileName() { return fileName; }
    public String getText() { return text; }
    public int getNumberOfVowels() { return numberOfVowels; }
    public int getNumberOfConsonants() { return numberOfConsonants; }
    public int getNumberOfLetters() { return numberOfLetters; }
    public int getNumberOfSentences() { return numberOfSentences; }
    public String getLongestWord() { return longestWord; }
}
