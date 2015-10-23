package com.blountmarquis.google;

        import java.util.Comparator;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

/**
 * Created by MLBlount on 9/17/2015.
 *
 * I've made a modification to my proposed solution. During the interview I saved a List of FruitType this
 * created the need to traverse the list in compare to determine the indices of fruit1's FruitTYpe and fruit2's
 * FruitType. This caused our compare method to have O(n) complexity. Instead of storing a List of FruitType a better
 * solution would be to store a Map. The constructor would need to populate our Map, the Map would save the FruitType as
 * a key and the index as a value. although this is also an O(n) operation we will only need to do it once and compare
 * method is now contant. VS the intial solution which was an O(N) compare. which will be caused multiple times.
 *
 */
public class FruitComparator implements Comparator<Fruit> {

    Map<FruitType, Integer> orderMap = new HashMap<FruitType, Integer>();

    public FruitComparator(List<FruitType> typeOrder) {
        for (int i = 0; i < typeOrder.size(); i++) {
            orderMap.put(typeOrder.get(i), i);
        }
    }

    @Override
    public int compare(Fruit fruit1, Fruit fruit2) {
        if (!orderMap.containsKey(fruit1.getType())) orderMap.put(fruit1.getType(), orderMap.size() - 1);
        if (!orderMap.containsKey(fruit2.getType())) orderMap.put(fruit2.getType(), orderMap.size() - 1);
        int val1 = orderMap.get(fruit1.getType());
        int val2 = orderMap.get(fruit2.getType());
        return val1 - val2;
    }
}
