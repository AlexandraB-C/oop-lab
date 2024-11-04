package lab1.task4;

public class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    public TextData(String fileName, String text) {
        this.fileName = fileName;
        this.text = text;
        analyze();
    }

    private void analyze() {
        this.numberOfVowels = countVowels();
        this.numberOfConsonants = countConsonants();
        this.numberOfLetters = text.replaceAll("[^a-zA-Z]", "").length();
        this.numberOfSentences = text.split("[.!?]+").length;
        this.longestWord = findLongestWord();
    }

    private int countVowels() {
        return text.toLowerCase()
                  .replaceAll("[^a-z]", "")
                  .replaceAll("[^aeiou]", "")
                  .length();
    }

    private int countConsonants() {
        return text.toLowerCase()
                  .replaceAll("[^a-z]", "")
                  .replaceAll("[aeiou]", "")
                  .length();
    }

    private String findLongestWord() {
        String cleanText = text.replaceAll("[^a-zA-Z\\s]", "");
        String[] words = cleanText.split("\\s+"); // split into words
        String longest = "";
        
        for (String word : words) {
            // skip empty strings that might result from multiple spaces
            if (!word.trim().isEmpty() && word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }
                  
    @Override
    public String toString() {
        return "File: " + fileName + "\n" +
               "Vowels: " + numberOfVowels + "\n" +
               "Consonants: " + numberOfConsonants + "\n" +
               "Letters: " + numberOfLetters + "\n" +
               "Sentences: " + numberOfSentences + "\n" +
               "Longest word: " + longestWord + "\n";
    }
}