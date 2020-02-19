package com.jwetherell.algorithms.data_structures.test;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import com.jwetherell.algorithms.data_structures.BinaryHeap;
import com.jwetherell.algorithms.data_structures.test.common.JavaCollectionTest;
import com.jwetherell.algorithms.data_structures.test.common.HeapTest;
import com.jwetherell.algorithms.data_structures.test.common.Utils;
import com.jwetherell.algorithms.data_structures.test.common.Utils.TestData;

public class BinaryHeapTests {
	
	/**
     * Test the validNode function by calling validate function in BinaryHeapArray
     * The function should return false if the value of child is smaller than its parent in a min-heap or larger than its parent in a max-heap
     */
    @Test
    public void minHeapArray() {

        BinaryHeap.BinaryHeapArray<Integer> minHeap = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MIN);
        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(4);
        minHeap.add(5);
        minHeap.add(6);
        assertTrue(minHeap.validate());
        minHeap.setValue(5, 0); // right child is invalid
        assertFalse(minHeap.validate());
        minHeap.setValue(2, 0); // right child is invalid
        assertFalse(minHeap.validate());
        minHeap.setValue(3, 0); // left child is invalid
        assertFalse(minHeap.validate());
    }
    
    /**
     * Test the validNode function by calling validate function in BinaryHeapTree
     * The function should return false if the value of child is larger than its parent in a max-heap
     */
    @Test
    public void maxHeapArray() {
        BinaryHeap.BinaryHeapArray<Integer> maxHeap = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MAX);
        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(3);
        maxHeap.add(4);
        maxHeap.add(5);
        maxHeap.add(6);
        assertTrue(maxHeap.validate());
        maxHeap.setValue(5, 10); // right child is invalid
        assertFalse(maxHeap.validate());
        maxHeap.setValue(2, 12); // right child is invalid
        assertFalse(maxHeap.validate());
        maxHeap.setValue(1, 15); // left child is invalid
        assertFalse(maxHeap.validate());
    }
    
    /**
     * Test the validNode function by calling validate function in BinaryHeapTree
     * The function should return false if the value of child is smaller than its parent in a min-heap 
     */
    @Test
    public void minHeapTree() {

        BinaryHeap.BinaryHeapTree<Integer> minHeap = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MIN);
        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(4);
        minHeap.add(5);
        minHeap.add(6);
        minHeap.add(7);
        assertTrue(minHeap.validate());
        minHeap.setValue(7, null);
        assertTrue(minHeap.validate());
        minHeap.setValue(6, 0); // right child is invalid
        assertFalse(minHeap.validate());
        minHeap.setValue(3, 0); // right child is invalid
        assertFalse(minHeap.validate());
        minHeap.setValue(4, 0); // left child is invalid
        assertFalse(minHeap.validate());
    }
    
    /**
     * Test the validNode function by calling validate function in BinaryHeapTree
     * The function should return false if the value of child is larger than its parent in a max-heap
     */
    @Test
    public void maxHeapTree() {
        BinaryHeap.BinaryHeapTree<Integer> maxHeap = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MAX);
        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(3);
        assertTrue(maxHeap.validate());
        maxHeap.setValue(2, 4); // right child is invalid
        assertFalse(maxHeap.validate());
        maxHeap.setValue(1, 5); // right child is invalid
        assertFalse(maxHeap.validate());
        maxHeap.setValue(3, 6); // left child is invalid
        maxHeap.setValue(5, null); // have a right node without a left in a heap
        assertFalse(maxHeap.validate());
    }

    @Test
    public void testMinHeap() {
        TestData data = Utils.generateTestData(2500);

        String aNameMin = "Min-Heap [array]";
        BinaryHeap.BinaryHeapArray<Integer> aHeapMin = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MIN);
        Collection<Integer> aCollectionMin = aHeapMin.toCollection();
        assertTrue(HeapTest.testHeap(BinaryHeap.Type.MIN, aHeapMin, Integer.class, aNameMin,  
                                     data.unsorted, data.sorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(aCollectionMin, Integer.class, aNameMin,
                                                     data.unsorted, data.sorted, data.invalid));

        BinaryHeap.BinaryHeapArray<Integer> aHeapNull = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MIN);
        aHeapNull.add(10);
        aHeapNull.add(11);
        aHeapNull.clear();
        assertNull(aHeapNull.getHeadValue()); // we expect null here

        String tNameMin = "Min-Heap [tree]";
        BinaryHeap.BinaryHeapTree<Integer> tHeapMin = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MIN);
        Collection<Integer> tCollectionMin = tHeapMin.toCollection();
        assertTrue(HeapTest.testHeap(BinaryHeap.Type.MIN, tHeapMin, Integer.class, tNameMin,
                                     data.unsorted, data.sorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(tCollectionMin, Integer.class, tNameMin,
                                                     data.unsorted, data.sorted, data.invalid));

        BinaryHeap.BinaryHeapTree<Integer> tHeapNull = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MIN);
        tHeapNull.add(10);
        tHeapNull.add(11);
        tHeapNull.clear();
        assertNull(tHeapNull.getHeadValue()); // we expect null here

    }

    @Test
    public void testMaxHeap() {
        TestData data = Utils.generateTestData(2500);

        String aNameMax = "Max-Heap [array]";
        BinaryHeap.BinaryHeapArray<Integer> aHeapMax = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MAX);
        Collection<Integer> aCollectionMax = aHeapMax.toCollection();
        assertTrue(HeapTest.testHeap(BinaryHeap.Type.MAX, aHeapMax, Integer.class, aNameMax, 
                                     data.unsorted, data.sorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(aCollectionMax, Integer.class, aNameMax,
                                                 data.unsorted, data.sorted, data.invalid));

        BinaryHeap.BinaryHeapArray<Integer> aHeapNull = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MAX);
        aHeapNull.add(10);
        aHeapNull.add(11);
        aHeapNull.clear();
        assertNull(aHeapNull.getHeadValue()); // we expect null here

        String lNameMax = "Max-Heap [tree]";
        BinaryHeap.BinaryHeapTree<Integer> tHeapMax = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MAX);
        Collection<Integer> tCollectionMax = tHeapMax.toCollection();
        assertTrue(HeapTest.testHeap(BinaryHeap.Type.MAX, tHeapMax, Integer.class, lNameMax, 
                                     data.unsorted, data.sorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(tCollectionMax, Integer.class, lNameMax,
                                                 data.unsorted, data.sorted, data.invalid));

        BinaryHeap.BinaryHeapTree<Integer> tHeapNull = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MAX);
        tHeapNull.add(10);
        tHeapNull.add(11);
        tHeapNull.clear();
        assertNull(tHeapNull.getHeadValue()); // we expect null here
    }
}
