package lab1.task2;

public class Main {
    public static void main(String[] args) {
        String filePath = "java-classification/src/main/resources/text/test.txt";  // AAAAAAAAAAAAAAAAAA

        FileReader reader = new FileReader();
        String text = reader.readFileIntoString(filePath);
        
        TextData data = new TextData(text);
        
        // print analysis
        System.out.println("Text Analysis Results:");
        System.out.println("Number of vowels: " + data.getNumberOfVowels());
        System.out.println("Number of consonants: " + data.getNumberOfConsonants());
        System.out.println("Number of letters: " + data.getNumberOfLetters());
        System.out.println("Number of sentences: " + data.getNumberOfSentences());
        System.out.println("Longest word: " + data.getLongestWord());
    }
}