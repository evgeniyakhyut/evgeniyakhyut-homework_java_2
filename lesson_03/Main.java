package ru.gb.jtwo.clesson.online;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String[] text = {"cat", "dog", "pony", "horse", "apple", "cat", "lime", "money", "pony", "salt",
        "pepper", "lime", "dog", "beer", "owl", "cat", "cat", "money", "music", "pony"};

        ArrayList<String> wordsInText = new ArrayList<>();

        for (int i = 0; i < text.length; i++) {
            if (!wordsInText.contains(text[i])) {
                wordsInText.add(text[i]);
            }
        }
        System.out.println("Текст: " + Arrays.asList(text));
        System.out.println("Список слов, использованных в тексте: " + wordsInText.toString());

        HashMap<String, Integer> everyWordCount = new HashMap<>();

        for (String word : text) {
            int currentValue = 0;

//          word == 'cat'
            if (everyWordCount.containsKey(word)) {
//                everyWordCount == {
//                    "cat": 1,
//                    "dog": 2
//                }

                currentValue = everyWordCount.get(word);
            }

            everyWordCount.put(word, currentValue + 1);
//                everyWordCount == {
//                    "cat": 2,
//                    "dog": 2
//                }
        }

        System.out.println("\nКоличество повторений каждого слова в тексте:");

        for (String key : everyWordCount.keySet()) {
            if (everyWordCount.get(key) > 1) {
                System.out.printf("%s repeats %d times\n", key, everyWordCount.get(key));
            } else {
                System.out.printf("%s repeats %d time\n", key, everyWordCount.get(key));
            }
        }
//________________________________________________________________________________________________________________
//         2
//        {
//            "Khiut": [
//                Person {
//                    phone: '12345',
//                    email: 'mashka@mail.ru'
//                },
//                Person {
//                    phone: '233215',
//                    email: 'petka@mail.ru'
//                }
//            ]
//        }
        Person sarah = new Person("Connor", "sarahconnor@mail.ru", "8-922-137-84-57");
        Person john = new Person("Connor", "johnconnor@mail.ru", "8-987-884-64-64");
        Person petya = new Person("Pupkin", "petyapupkin666@mail.ru", "8-999-723-67-66");

        PhoneBook book = new PhoneBook();
        book.add(sarah);
        book.add(john);
        book.add(petya);

        System.out.println(book.paper.toString());
        System.out.println(book.findPhonesByName("Connor").toString());
        System.out.println(book.findPhonesByName("Pupkin").toString());

        System.out.println(book.findEmailsByName("Connor").toString());
        System.out.println(book.findEmailsByName("Pupkin").toString());

        System.out.println(book.findPhonesByName("Pipkin").toString());
        System.out.println(book.findEmailsByName("Pipkin").toString());
    }
}
