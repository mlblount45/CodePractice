package test;

import com.blountmarquis.datastructures.MinSegmentTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by MLBlount on 12/18/2015.
 */
public class MinSegmentTreeTest {

    MinSegmentTree minSegTree;
    @Before
    public void setUp() throws Exception {
        minSegTree = new MinSegmentTree(new int[]{2, 5, -4, 6, 0});
        minSegTree.update(4,-5);
    }

    @Test
    public void whenMinOnEndOfRangeMinReturned() throws Exception {
        Assert.assertSame(-4, minSegTree.minRange(0, 2));
    }

    @Test
    public void whenMinAtStartOfRangeMinReturned() throws Exception {
        Assert.assertSame(-5, minSegTree.minRange(2, 4));
    }

    @Test
    public void whenRangeLengthOneReturnSingleElement() throws Exception {
        Assert.assertSame(2, minSegTree.minRange(0, 0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRangeOutOfBoundsThrowIndexOutOfBoundsExceptionReturnSingleElement() throws Exception {
        Assert.assertSame(2, minSegTree.minRange(-1, 0));
    }

    @Test
    public void whenEntireRangeQueiedReturnMinElementOfArray() throws Exception {
        Assert.assertSame(-5, minSegTree.minRange(0, 4));
    }

    @Test
    public void whenMidOfArrayQueiredReturnMin() throws Exception {
        Assert.assertSame(-4, minSegTree.minRange(1, 3));
    }

    @Test
    public void whenEndOfArrayQueiredReturnMin() throws Exception {
        minSegTree.update(4, -100);
        Assert.assertSame(-100, minSegTree.minRange(3, 4));
    }

    @Test
    public void whenStartOfArrayQueiredReturnMin() throws Exception {
        Assert.assertSame(2, minSegTree.minRange(0, 1));
    }

}