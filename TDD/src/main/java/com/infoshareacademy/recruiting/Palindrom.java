package com.infoshareacademy.recruiting;

public class Palindrom {

    public static void main(String[] args) {
        palindromChecker("palindrom");
    }

    public static void palindromChecker(String text) {

         char[] originalText = text.toCharArray();
         char[] newText = new char[originalText.length];
         for (int i = 0; i < originalText.length ; i++) {
             newText[i] = originalText[originalText.length - i -1];
         }
         System.out.println(originalText);
         System.out.println(newText);
         StringBuilder stringBuilder = new StringBuilder();
         for (int i = 0; i < originalText.length ; i++) {
             stringBuilder.append(newText[i]);
         }
          if(text.equals(stringBuilder.toString())) {
              System.out.println("It is palindrom");
          } else {
              System.out.println("It is not palindrom");
          }
    }
}
