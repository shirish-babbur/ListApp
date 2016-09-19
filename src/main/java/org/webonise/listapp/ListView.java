package org.webonise.listapp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListView implements DataCollection {
    public void fetchAndViewData() throws Exception {
        ResultSet resultset = null;
        FetchData fetchData = new FetchData();
        List<Users> userList = new ArrayList<Users>();
        DisplayCollection displayCollection = new DisplayCollection();
        resultset = fetchData.getResultSet();
        while ( resultset.next() ) {
            userList.add(fetchData.getData(resultset));
        }
        System.out.println("Size of List:"+userList.size());
        System.out.println("Before Sorting");
        displayCollection.Display(userList);
        Collections.sort(userList,new UserComparator());
        System.out.println("After Sorting");
        displayCollection.Display(userList);
        resultset.close();
        fetchData.closeConnection();
    }
}
