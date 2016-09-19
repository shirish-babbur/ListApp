package org.webonise.listapp;
public class CollectionFactory {
    private DataCollection collectionObject = null;
    public DataCollection getCollection(String collectionType){
        if (collectionType.equalsIgnoreCase(ListApp.Arraylist)) {
            collectionObject = new ListView();
        } else if (collectionType.equalsIgnoreCase(ListApp.HashMap)) {
            collectionObject = new MapView();
        }
        else if (collectionType.equalsIgnoreCase(ListApp.HashSet)) {
            collectionObject = new SetView();
        }
        return collectionObject;
    }
}
