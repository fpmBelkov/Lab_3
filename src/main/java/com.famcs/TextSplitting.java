package com.famcs;

import java.util.ArrayList;
import java.util.Scanner;

public class TextSplitting {

    public static void main(String[] argc) {

        TextIntPair pair = new TextIntPair();
        System.out.println("Enter the text, to cancel the text input enter the empty string, then enter k");
        pair = inputFromKeyboard(pair);
        pair.text = textSplit(pair.text, pair.k);
        System.out.println(pair.text);
    }


    public static String textSplit(String text, int k) {
        ArrayList strArray  = new ArrayList<String>(textToStrArray(text));
        strArray = stringSplit(strArray,k);
        text = "";
        for (int i = 0; i < strArray.size(); i++) {
            text += strArray.get(i);
        }

        return text;
    }


    public static ArrayList<String> textToStrArray(String text) {

        ArrayList strArray = new ArrayList<String>();
        ArrayList indexes = new ArrayList<Integer>();

        indexes.add(0);

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\n') {
                indexes.add(i);
            }
        }

        for (int i = 0; i < indexes.size() - 1; i++) {
            strArray.add(text.substring((int) ((int) indexes.get(i) + Math.ceil(Math.abs(Math.sin(i)))), (int) indexes.get(i + 1) + 1));
        }

        return strArray;

    }


    private static ArrayList<String> stringSplit(ArrayList<String> strArray, int k) {

        String tempStr = new String();

        for (int i = 0; i < strArray.size(); i++) {
            tempStr = strArray.get(i).substring(0, strArray.get(i).length() - 1);

            if (k + 1 - strArray.get(i).length() >= 0) {
                for (int j = 0; j <= k + 1 - strArray.get(i).length(); j++) {
                    tempStr += " ";
                }
            }

            int p = k;
            while (tempStr.charAt(p) != ' ' && p > 0) {
                p--;
            }

            StringBuilder tempStrBuilder = new StringBuilder(tempStr);

            for (int j = 0; j < k - p; j++) {
                tempStrBuilder.insert(p,' ');
            }

            tempStrBuilder.insert(k,'\n');

            tempStr = tempStrBuilder.toString();

            tempStr += strArray.get(i).substring(strArray.get(i).length() - 1);

                strArray.remove(i);
                strArray.add(i,tempStr);

        }

        return strArray;

    }


    public static TextIntPair inputFromKeyboard(TextIntPair pair) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter the text : ");

            StringBuilder textBuilder = new StringBuilder();

            while (!(pair.text = scanner.nextLine()).isEmpty()) {
                textBuilder.append(pair.text).append('\n');
            }

            pair.text = textBuilder.toString();

            System.out.println("Now enter k : ");
            pair.k = scanner.nextInt();

            if (pair.k < 0) {
                throw new Exception("k must be >= 0");
            }

        } catch (Exception ex) {
            System.out.println("Error with text input : " + ex);
        }

        return pair;
    }


}
