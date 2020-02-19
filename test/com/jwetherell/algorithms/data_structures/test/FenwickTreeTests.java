package com.jwetherell.algorithms.data_structures.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jwetherell.algorithms.data_structures.FenwickTree;
import com.jwetherell.algorithms.data_structures.FenwickTree.Data;

public class FenwickTreeTests {

    @Test
    public void testRangeSumFenwickTree() {
        List<FenwickTree.Data.RangeSumData<Integer>> segments = new ArrayList<FenwickTree.Data.RangeSumData<Integer>>();
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(0,  (Integer) 4));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(1,  (Integer) 2));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(2,  (Integer) 6));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(3,  (Integer) 3));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(4,  (Integer) 1));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(5,  (Integer) 5));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(6,  (Integer) 0));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(17, (Integer) 7));   

        // No matter which order the data is given, all tests should pass

        // Initial order.
        testRangeSumFenwickTree(segments);

        // Randomize it
        Collections.shuffle(segments);
        testRangeSumFenwickTree(segments);

        // Try in order
        Collections.sort(segments);
        testRangeSumFenwickTree(segments);

        // Try reverse order
        Collections.sort(segments,REVERSE);
        testRangeSumFenwickTree(segments);
    }

    private void testRangeSumFenwickTree(List<FenwickTree.Data.RangeSumData<Integer>> segments) {   // Range Sum Segment tree
        FenwickTree<FenwickTree.Data.RangeSumData<Integer>> tree = new FenwickTree<FenwickTree.Data.RangeSumData<Integer>>(segments);

        FenwickTree.Data.RangeSumData<Integer> query = tree.query(0, 8);
        assertTrue("Segment tree query error. query=0->8 result="+query, tree, query.sum==21);

        query = tree.query(0, 17);
        assertTrue("Segment tree query error. query=0->17 result="+query, tree, query.sum==28);

        query = tree.query(2, 5);
        assertTrue("Segment tree query error. query=2->5 result="+query, tree, query.sum==15);

        query = tree.query(10, 17);
        assertTrue("Segment tree query error. query=10->17 result="+query, tree, query.sum==7);

        query = tree.query(16); // stabbing
        assertTrue("Segment tree query error. query=16 result="+query, tree, query.sum==0);

        query = tree.query(17); // stabbing
        assertTrue("Segment tree query error. query=17 result="+query, tree, query.sum==7);
    }

    @Test
    public void testRangeSumFenwickTree2() {
        List<FenwickTree.Data.RangeSumData<Integer>> segments = new ArrayList<FenwickTree.Data.RangeSumData<Integer>>();
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(0,  (Integer) 2));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(1,  (Integer) 1));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(2,  (Integer) 1));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(3,  (Integer) 3));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(4,  (Integer) 2));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(5,  (Integer) 3));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(6,  (Integer) 4));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(7,  (Integer) 5));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(8,  (Integer) 6));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(9,  (Integer) 7));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(10, (Integer) 8));
        segments.add(new FenwickTree.Data.RangeSumData<Integer>(11, (Integer) 9));

        // No matter which order the data is given, all tests should pass

        // Initial order.
        testRangeSumFenwickTree2(segments);

        // Randomize it
        Collections.shuffle(segments);
        testRangeSumFenwickTree2(segments);

        // Try in order
        Collections.sort(segments);
        testRangeSumFenwickTree2(segments);

        // Try reverse order
        Collections.sort(segments,REVERSE);
        testRangeSumFenwickTree2(segments);
    }

    private void testRangeSumFenwickTree2(List<FenwickTree.Data.RangeSumData<Integer>> segments) {   // Range Sum Segment tree
        FenwickTree<FenwickTree.Data.RangeSumData<Integer>> tree = new FenwickTree<FenwickTree.Data.RangeSumData<Integer>>(segments);

        FenwickTree.Data.RangeSumData<Integer> query = tree.query(0, 8);
        assertTrue("Segment tree query error. query=0->8 result="+query, tree, query.sum==27);

        query = tree.query(0, 11);
        assertTrue("Segment tree query error. query=0->11 result="+query, tree, query.sum==51);

        query = tree.query(2, 5);
        assertTrue("Segment tree query error. query=2->5 result="+query, tree, query.sum==9);

        query = tree.query(10, 17);
        assertTrue("Segment tree query error. query=10->17 result="+query, tree, query.sum==17);

        query = tree.query(2); // stabbing
        assertTrue("Segment tree query error. query=2 result="+query, tree, query.sum==1);

        query = tree.query(10); // stabbing
        assertTrue("Segment tree query error. query=10 result="+query, tree, query.sum==8);
    }

    /**
     * Test a Fenwick Tree with values of type BigInteger
     */
    @Test
    public void testRangeSumFenwickTreeBigInteger() {
        List<FenwickTree.Data.RangeSumData<BigInteger>> segments = new ArrayList<>();
        segments.add(new FenwickTree.Data.RangeSumData<>(0,  BigInteger.valueOf(4)));
        segments.add(new FenwickTree.Data.RangeSumData<>(1,  BigInteger.valueOf(2)));
        segments.add(new FenwickTree.Data.RangeSumData<>(2,  BigInteger.valueOf(6)));
        segments.add(new FenwickTree.Data.RangeSumData<>(3,  BigInteger.valueOf(3)));
        segments.add(new FenwickTree.Data.RangeSumData<>(4,  BigInteger.valueOf(1)));
        segments.add(new FenwickTree.Data.RangeSumData<>(5,  BigInteger.valueOf(5)));
        segments.add(new FenwickTree.Data.RangeSumData<>(6,  BigInteger.valueOf(0)));
        segments.add(new FenwickTree.Data.RangeSumData<>(17, BigInteger.valueOf(7)));

        FenwickTree<FenwickTree.Data.RangeSumData<BigInteger>> tree = new FenwickTree<>(segments);

        FenwickTree.Data.RangeSumData<BigInteger> query = tree.query(0, 8);
        assertTrue("Segment tree query error. query=0->8 result="+query, tree, query.sum.equals(BigInteger.valueOf(21)));

        query = tree.query(0, 17);
        assertTrue("Segment tree query error. query=0->17 result="+query, tree, query.sum.equals(BigInteger.valueOf(28)));

        query = tree.query(2, 5);
        assertTrue("Segment tree query error. query=2->5 result="+query, tree, query.sum.equals(BigInteger.valueOf(15)));

        query = tree.query(10, 17);
        assertTrue("Segment tree query error. query=10->17 result="+query, tree, query.sum.equals(BigInteger.valueOf(7)));

        query = tree.query(16); // stabbing
        assertTrue("Segment tree query error. query=16 result="+query, tree, query.sum.equals(BigInteger.ZERO));

        query = tree.query(17); // stabbing
        assertTrue("Segment tree query error. query=17 result="+query, tree, query.sum.equals(BigInteger.valueOf(7)));
    }

    /**
     * Test a Fenwick Tree with large values of type BigInteger
     */
    @Test
    public void testRangeSumFenwickTreeBigInteger2() {
        List<FenwickTree.Data.RangeSumData<BigInteger>> segments = new ArrayList<>();
        segments.add(new FenwickTree.Data.RangeSumData<>(0,  new BigInteger("123456789101213141516")));
        segments.add(new FenwickTree.Data.RangeSumData<>(1,  new BigInteger("65498491981951841894")));
        segments.add(new FenwickTree.Data.RangeSumData<>(2,  new BigInteger("321384941515915615984")));
        segments.add(new FenwickTree.Data.RangeSumData<>(3,  new BigInteger("9849815615126156165156")));
        segments.add(new FenwickTree.Data.RangeSumData<>(4,  new BigInteger("8451213516519849845616")));
        segments.add(new FenwickTree.Data.RangeSumData<>(5,  new BigInteger("6516549848112")));
        segments.add(new FenwickTree.Data.RangeSumData<>(6,  new BigInteger("51984")));
        segments.add(new FenwickTree.Data.RangeSumData<>(17, new BigInteger("99784981")));

        FenwickTree<FenwickTree.Data.RangeSumData<BigInteger>> tree = new FenwickTree<>(segments);

        FenwickTree.Data.RangeSumData<BigInteger> query = tree.query(0, 8);
        assertTrue("Segment tree query error. query=0->8 result="+query, tree, query.sum.equals(new BigInteger("18811369360761636510262")));

        query = tree.query(0, 17);
        assertTrue("Segment tree query error. query=0->17 result="+query, tree, query.sum.equals(new BigInteger("18811369360761736295243")));

        query = tree.query(2, 5);
        assertTrue("Segment tree query error. query=2->5 result="+query, tree, query.sum.equals(new BigInteger("18622414079678471474868")));

        query = tree.query(10, 17);
        assertTrue("Segment tree query error. query=10->17 result="+query, tree, query.sum.equals(new BigInteger("99784981")));

        query = tree.query(16); // stabbing
        assertTrue("Segment tree query error. query=16 result="+query, tree, query.sum.equals(BigInteger.ZERO));

        query = tree.query(17); // stabbing
        assertTrue("Segment tree query error. query=17 result="+query, tree, query.sum.equals(BigInteger.valueOf(99784981)));
    }

    /**
     * Test a Fenwick Tree with Long values
     */
    @Test
    public void testRangeSumFenwickTreeLong() {
        List<FenwickTree.Data.RangeSumData<Long>> segments = new ArrayList<>();
        segments.add(new FenwickTree.Data.RangeSumData<>(0,  12345678912345678L));
        segments.add(new FenwickTree.Data.RangeSumData<>(1,  -8949151981894515L));
        segments.add(new FenwickTree.Data.RangeSumData<>(2,  9849812132103202L));
        segments.add(new FenwickTree.Data.RangeSumData<>(3,  -9812168L));
        segments.add(new FenwickTree.Data.RangeSumData<>(4,  989845121321654L));
        segments.add(new FenwickTree.Data.RangeSumData<>(5,  365412198451625L));
        segments.add(new FenwickTree.Data.RangeSumData<>(6,  6498984531321L));
        segments.add(new FenwickTree.Data.RangeSumData<>(17, 219819812315L));

        FenwickTree<FenwickTree.Data.RangeSumData<Long>> tree = new FenwickTree<>(segments);

        FenwickTree.Data.RangeSumData<Long> query = tree.query(0, 8);
        assertTrue("Segment tree query error. query=0->8 result="+query, tree, query.sum == 14608095357046797L);

        query = tree.query(0, 17);
        assertTrue("Segment tree query error. query=0->17 result="+query, tree, query.sum == 14608315176859112L);

        query = tree.query(2, 5);
        assertTrue("Segment tree query error. query=2->5 result="+query, tree, query.sum == 11205069442064313L);

        query = tree.query(10, 17);
        assertTrue("Segment tree query error. query=10->17 result="+query, tree, query.sum == 219819812315L);

        query = tree.query(16); // stabbing
        assertTrue("Segment tree query error. query=16 result="+query, tree, query.sum == 0L);

        query = tree.query(17); // stabbing
        assertTrue("Segment tree query error. query=17 result="+query, tree, query.sum == 219819812315L);
    }

    private static final Comparator<FenwickTree.Data> REVERSE = new Comparator<FenwickTree.Data>() {
        @Override
        public int compare(Data arg0, Data arg1) {
            int r = arg0.compareTo(arg1);
            return r*-1;
        }
    };

    // Assertion which won't call toString on the tree unless the assertion fails
    private static final <D extends FenwickTree.Data> void assertTrue(String msg, FenwickTree<D> obj, boolean isTrue) {
        String toString = "";
        if (isTrue==false)
            toString = "\n"+obj.toString();
        Assert.assertTrue(msg+toString, isTrue);
    }

    /**
     * Combining RangeSumData instances with eventually null values
     */
    @Test
    public void combinedTrivialCases() {
        Data.RangeSumData<Integer> r1 = new Data.RangeSumData<>(0, null);
        Data.RangeSumData<Integer> r2 = new Data.RangeSumData<>(0, null);
        Assert.assertNull(r1.sum);

        r1.combined(r2);
        Assert.assertNull(r1.sum);
        Assert.assertNull(r2.sum);

        r1 = new Data.RangeSumData<>(0, 15);

        r1.combined(r2);
        Assert.assertEquals(r1.sum, 15);

        r2.combined(r1);
        Assert.assertEquals(r2.sum, 15);

        r1.combined(r2);
        Assert.assertEquals(r1.sum, 15 + 15);
    }

    /**
     * Separating RangeSumData instances with eventually null values
     */
    @Test
    public void separateTrivialCases() {
        Data.RangeSumData<Integer> r1 = new Data.RangeSumData<>(0, null);
        Data.RangeSumData<Integer> r2 = new Data.RangeSumData<>(0, null);

        r1.separate(r2);
        Assert.assertNull(r1.sum);
        Assert.assertNull(r2.sum);

        r1 = new Data.RangeSumData<>(0, 15);

        r1.separate(r2);
        Assert.assertEquals(r1.sum, 15);

        r2.separate(r1);
        Assert.assertEquals(r2.sum, 15);

        r1.separate(r2);
        Assert.assertEquals(r1.sum, 0);

        r2.separate(r1);
        Assert.assertEquals(r2.sum, 15);
    }
}
