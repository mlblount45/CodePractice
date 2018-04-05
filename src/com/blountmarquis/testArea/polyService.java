package com.blountmarquis.testArea;

import java.util.Date;

/**
 * Created by MLBlount on 8/3/2015.
 */
public class polyService {

  public static polyInterface getPoly() {
    return new polyClass(0, 1);
  }

  public static void main(String[] args) {
    System.out.println(getPoly());
    System.out.println(new Date());
  }


}


