package ru.gb.jtwo.clesson.online;

import java.util.HashMap;

public class Person {
    String name;
    String email;
    String phone;

    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public HashMap<String, String> getContactInfo() {
        HashMap<String, String> contactInfo = new HashMap<>();
        contactInfo.put("Phone", this.phone);
        contactInfo.put("Email", this.email);

        return contactInfo;
    }
}

