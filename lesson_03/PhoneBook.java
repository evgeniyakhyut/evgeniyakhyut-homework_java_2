package ru.gb.jtwo.clesson.online;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    HashMap<String, ArrayList<HashMap<String, String>>> paper = new HashMap<>();

    public void add(Person person) {
        if (paper.containsKey(person.name)) {
            ArrayList<HashMap<String, String>> people = paper.get(person.name);
            people.add(person.getContactInfo());
        } else {
            ArrayList<HashMap<String, String>> people = new ArrayList<>();
            people.add(person.getContactInfo());
            paper.put(person.name, people);
        }
    }

    public ArrayList<String> findPhonesByName(String name) {
        ArrayList<String> phones = new ArrayList<>();

        if (paper.containsKey(name)) {
            for (HashMap<String, String> person : paper.get(name)) {
                phones.add(person.get("Phone"));
            }
        }

        return phones;
    }

    public ArrayList<String> findEmailsByName(String name) {
        ArrayList<String> emails = new ArrayList<>();

        if (paper.containsKey(name)) {
            for (HashMap<String, String> person : paper.get(name)) {
                emails.add(person.get("Email"));
            }
        }

        return emails;
    }
}
