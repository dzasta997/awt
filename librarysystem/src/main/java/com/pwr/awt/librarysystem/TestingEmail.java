package com.pwr.awt.librarysystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestingEmail {

    public static void main(String[] args) {
        try {
            Process p = Runtime.getRuntime().exec(String.format("python3 scrips/returnemail.py filtracjaseparacja@gmail.com Andrew BOOK_RESERVATION Harry Potter and the chamber of secrets"));
        p.waitFor();
            System.out.println(new BufferedReader(new InputStreamReader(p.getInputStream())).readLine());
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }
}
