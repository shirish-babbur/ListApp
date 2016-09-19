package org.webonise.listapp;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapView implements DataCollection {

    public void fetchAndViewData() throws Exception {
        ResultSet resultset = null;
        FetchData fetchData = new FetchData();
        DisplayCollection displayCollection = new DisplayCollection();
        Map<Integer,Users> usersMap = new HashMap<Integer,Users>();
        Map<Integer,Users> sortedUserMap = new TreeMap<Integer, Users>();
        resultset = fetchData.getResultSet();
        while ( resultset.next() ) {
            usersMap.put(fetchData.getData(resultset).getId(),fetchData.getData(resultset));
        }
        System.out.println("Size of List:"+usersMap.size());
        System.out.println("Before Sorting:");
        displayCollection.Display(usersMap);
        sortedUserMap.putAll(usersMap);
        System.out.println("After Sorting:");
        displayCollection.Display(sortedUserMap);
        resultset.close();
        fetchData.closeConnection();
    }
}
