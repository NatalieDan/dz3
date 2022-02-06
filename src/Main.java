import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        uniqWords();
        telephoneDirectory();
    }

    private static void uniqWords() {
        HashMap<String, Integer> hm = new HashMap<>();
        String[] words = {
                "cat", "dog", "giraffe", "fish", "cat",
                "raccoon", "hamster", "lizard", "raccoon", "giraffe",
                "dog", "giraffe", "elephant", "snake", "crocodile",
                "raccoon", "crocodile", "ostrich", "lizard", "raccoon"
        };
        for (int i = 0; i < words.length; i++) {
            if (hm.containsKey(words[i])) {
                hm.put(words[i], hm.get(words[i]) + 1);
            } else {
                hm.put(words[i], 1);
            }
        }
        System.out.println(hm);
    }

    private static void telephoneDirectory() {
        Directory directory = new Directory();

        directory.add("Ivanov", "89546435488");
        directory.add("Kuznetsov", "89437651232");
        directory.add("Smirnov", "89875217490");
        directory.add("Sokolov", "89652417693");
        directory.add("Kuznetsov", "89774257050");
        directory.add("Sergeev", "89615297415");

        directory.get("Kuznetsov");
    }
}

class Directory{
    private Map<String, List<String>> directory = new HashMap<>();
    private List<String> numbers;

    public void add(String surname, String phone){
        if (directory.containsKey(surname)){
            numbers = directory.get(surname);
            numbers.add(phone);
            directory.put(surname,numbers);
        }
        else{
            numbers = new ArrayList<>();
            numbers.add(phone);
            directory.put(surname,numbers);
        }
    }

    public void get(String surname){
        System.out.println(directory.get(surname));
    }
}

