package com.blountmarquis.stackoverflow;

import java.util.TreeMap;

/**
 * Created by mlblount on 10/12/2015.
 */
public class TreeMapPair<K extends Comparable<K>,V> {

    private TreeMap<Pair, MapValue> map = new TreeMap<Pair, MapValue>();

    private static class Pair<K extends Comparable<K>> implements Comparable<Pair<K>> {
        K x;
        K y;

        Pair(K x, K y){this.x = x; this.y = y;}

        @Override
        public int compareTo(Pair<K> o) {
            int result1 = this.x.compareTo(o.x);
            int result2 = this.y.compareTo(o.y);
            return result1 + result2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (! (o instanceof Pair)) return false;

            Pair<?> pair = (Pair<?>) o;

            if (! x.equals(pair.x)) return false;
            return y.equals(pair.y);

        }

        @Override
        public int hashCode() {
            int result = x.hashCode();
            result = 31 * result + y.hashCode();
            return result;
        }

        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static class MapValue<V> {
        V value;
        MapValue(V v){this.value = v;}
        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        TreeMapPair<Integer, String> map = new TreeMapPair<Integer, String>();
        Pair<Integer> p1 = new Pair<Integer>(1,2);
        MapValue<String> value1 =new MapValue<String>("Hello World1");
        System.out.println(p1.hashCode());

        Pair<Integer> p2 = new Pair<Integer>(5,2);
        MapValue<String> value2 =new MapValue<String>("Hello World2");
        System.out.println(p2.hashCode());

        Pair<Integer> p3 = new Pair<Integer>(4,3);
        MapValue<String> value3 =new MapValue<String>("Hello World3");
        System.out.println(p3.hashCode());

        map.map.put(p1, value1);
        MapValue<String> temp1 = map.map.put(p1, value1);
        if(temp1 != null)System.out.println(temp1.getValue());
        map.map.put(p2, value2);
        MapValue<String> temp = map.map.put(p3, value3);
        System.out.println(temp.getValue());

        for(Pair p : map.map.keySet())   {
            System.out.println(p);
        }
    }
}
