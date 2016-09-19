package org.webonise.listapp;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapView implements DataCollection {
    @Override
    public void fetchAndViewData() throws Exception {
        ResultSet resultset = null;
        DataFetcher dataFetcher = new DataFetcher();
        DisplayCollection displayCollection = new DisplayCollection();
        Map<Integer,Users> usersMap = new HashMap<Integer,Users>();
        Map<Integer,Users> sortedUserMap = new TreeMap<Integer, Users>();
        resultset = dataFetcher.getResultSet();
        while ( resultset.next() ) {
            usersMap.put(dataFetcher.getData(resultset).getId(), dataFetcher.getData(resultset));
        }
        System.out.println("Size of List:"+usersMap.size());
        System.out.println("Before Sorting:");
        displayCollection.Display(usersMap);
        sortedUserMap.putAll(usersMap);
        System.out.println("After Sorting:");
        displayCollection.Display(sortedUserMap);
        resultset.close();
        dataFetcher.closeConnection();
    }
}
