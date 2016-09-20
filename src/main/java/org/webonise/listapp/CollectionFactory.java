package org.webonise.listapp;

public class CollectionFactory {
    private DataCollection collectionObject = null;
    public DataCollection getCollection(String collectionType){
        switch (collectionType) {
            case ListApp.Arraylist:
                collectionObject=new ListView();
                break;
            case ListApp.HashMap:
                collectionObject=new MapView();
                break;
            case ListApp.HashSet:
                collectionObject=new SetView();
                break;
        }
        return collectionObject;
    }
}
