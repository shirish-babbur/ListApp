package org.webonise.listapp;

import java.sql.SQLException;
import java.util.Scanner;

public class ListApp {
    static final String Arraylist = "ArrayList";
    static final String HashMap = "HashMap";
    static final String HashSet = "HashSet";
    static final String Exit = "exit";

    public static void main(String[] args) {
        String choice;
        CollectionFactory collectionFactory = new CollectionFactory();
        DataCollection dataCollection;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Select Collection to view Data:\n1.ArrayList\n2.HashMap\n3.HashSet\n4.exit");
            choice = input.nextLine();
            try {
                switch (choice) {
                    case Arraylist:
                        dataCollection = collectionFactory.getCollection(Arraylist);
                        dataCollection.fetchAndViewData();
                        break;
                    case HashMap:
                        dataCollection = collectionFactory.getCollection(HashMap);
                        dataCollection.fetchAndViewData();
                        break;
                    case HashSet:
                        dataCollection = collectionFactory.getCollection(HashSet);
                        dataCollection.fetchAndViewData();
                        break;
                    case Exit:
                        System.out.print("Exiting");
                        break;
                    default:
                        System.out.println("Invalid Choice!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } while (!choice.equalsIgnoreCase(Exit));
    }
}
