package org.webonise.listapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetView implements DataCollection {
    @Override
    public void fetchAndViewData() throws SQLException {
        ResultSet resultset = null;
        DataFetcher dataFetcher = new DataFetcher();
        Set<Users> usersHashSet = new HashSet<Users>();
        Set<Users> userTreeSet = new TreeSet<Users>(new UserComparator());
        DisplayCollection displayCollection = new DisplayCollection();
        resultset = dataFetcher.getResultSet();
        while (resultset.next()) {
            usersHashSet.add(dataFetcher.getData(resultset));
        }
        System.out.println("Size of List:" + usersHashSet.size());
        System.out.println("Before Sorting:");
        displayCollection.Display(usersHashSet);
        userTreeSet.addAll(usersHashSet);
        System.out.println("After Sorting:");
        displayCollection.Display(userTreeSet);
        resultset.close();
        dataFetcher.closeConnection();
    }
}
