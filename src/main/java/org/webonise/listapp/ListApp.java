package org.webonise.listapp;
import java.util.Scanner;
public class ListApp {

    public static void main(String[] args) throws Exception{
        int choice;
        CollectionFactory collectionFactory=new CollectionFactory();
        DataCollection dataCollection;
        Scanner input =new Scanner(System.in);
        do {
            System.out.println("Select Collection to view Data:\n1.ArrayList\n2.HashMap\n3.HashSet\n4.exit");
            choice=input.nextInt();
            switch (choice) {
                case 1: dataCollection = collectionFactory.getCollection("ArrayList");
                        dataCollection.fetchAndViewData();
                        break;
                case 2: dataCollection = collectionFactory.getCollection("HashMap");
                        dataCollection.fetchAndViewData();
                        break;
                case 3: dataCollection = collectionFactory.getCollection("HashSet");
                        dataCollection.fetchAndViewData();
                        break;
                case 4: System.out.print("Exiting");
                        break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }while (choice!=4);
    }

}
