package org.webonise.listapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListView implements DataCollection {
    @Override
    public void fetchAndViewData() throws SQLException {
        ResultSet resultset = null;
        DataFetcher dataFetcher = new DataFetcher();
        List<Users> userList = new ArrayList<Users>();
        DisplayCollection displayCollection = new DisplayCollection();
        resultset = dataFetcher.getResultSet();
        while (resultset.next()) {
            userList.add(dataFetcher.getData(resultset));
        }
        System.out.println("Size of List:" + userList.size());
        System.out.println("Before Sorting");
        displayCollection.Display(userList);
        Collections.sort(userList, new UserComparator());
        System.out.println("After Sorting");
        displayCollection.Display(userList);
        resultset.close();
        dataFetcher.closeConnection();
    }
}
