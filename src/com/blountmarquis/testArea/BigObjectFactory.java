package com.blountmarquis.testArea;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mlblount on 6/3/2015.
 */
public class BigObjectFactory {

  public static List<BigObject> getfBigObjects(int n) {
    List<BigObject> list = new ArrayList<BigObject>(n);
    for (int i = 0; i < n; i++) {
      list.add(new BigObject());
    }
    return list;
  }
}
