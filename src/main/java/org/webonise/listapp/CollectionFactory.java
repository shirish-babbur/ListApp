package org.webonise.listapp;
public class CollectionFactory {
    public DataCollection getCollection(String collectionType){
        if (collectionType.equalsIgnoreCase("ArrayList")) {
            return new ListView();
        } else if (collectionType.equalsIgnoreCase("HashMap")) {
            return new MapView();
        }
        else if (collectionType.equalsIgnoreCase("HashSet")) {
            return new SetView();
        } else {
            return null;
        }
    }
}
