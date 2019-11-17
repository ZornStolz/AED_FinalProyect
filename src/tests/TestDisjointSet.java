package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import disjointSet.*;

class TestDisjointSet {

	private DisjointSet<Integer> set;
	
	void setUp1() {
		set = new DisjointSet<Integer>();				
	}
	
	void setUp2() {
		
		setUp1();
		
		set.makeSet(0);
		set.makeSet(1);
		set.makeSet(2);
		set.makeSet(3);
		set.makeSet(4);
		set.makeSet(5);
	}

	void setUp3() {
		
		setUp2();
		
		set.union(0, 1);
		set.union(0, 2);
		set.union(4, 5);
	}
	
	@Test
	void testMakeSet() {

		setUp1();
		
		assertEquals(true, set.makeSet(0));
		assertEquals(true, set.makeSet(1));
		assertEquals(true, set.makeSet(2));
		assertEquals(false, set.makeSet(2));
		
		assertEquals(3, set.size());
		
//		ArrayList<Integer> conjunto = new ArrayList<Integer>();
//		
//		for(int i = 0; i < set.size(); i ++) {
//			conjunto = set.getSet(i);
//			System.out.println(conjunto.get(0));
//		}
	}

	@Test
	void testFindSet() {
		
		setUp2();
		
		assertEquals(1, set.findSet(1));
		assertEquals(3, set.findSet(3));
		assertEquals(5, set.findSet(5));
		
		boolean test = false;
		
		setUp3();
		
		if(set.findSet(2) == 0)
			test = true;		
		assertTrue(test);
		
		test = false;
		
		if(set.findSet(1) == 0)
			test = true;		
		assertTrue(test);
		
		test = false;
		
		if(set.findSet(5) == 4)
			test = true;		
		assertTrue(test);
	}
	
	@Test
	void testUnion() {
		
		setUp2();
		
		set.union(0, 1);
		assertEquals(5, set.size());
		
		set.union(0, 2);
		assertEquals(4, set.size());
		
		set.union(4, 5);
		assertEquals(3, set.size());
		
		ArrayList<Integer> conjunto = new ArrayList<Integer>();
		
		conjunto = set.getSet(0);
		assertEquals(3, conjunto.size());

		conjunto = set.getSet(3);
		assertEquals(1, conjunto.size());
		
		conjunto = set.getSet(4);
		assertEquals(2, conjunto.size());		
		
//		conjunto = set.getSet(0);
//		for(int i = 0; i < conjunto.size(); i++)
//			System.out.print(" " + conjunto.get(i));
//		System.out.println();
//		
//		conjunto = set.getSet(3);
//		for(int i = 0; i < conjunto.size(); i++)
//			System.out.print(" " + conjunto.get(i));
//		System.out.println();
//		
//		conjunto = set.getSet(4);
//		for(int i = 0; i < conjunto.size(); i++)
//			System.out.print(" " + conjunto.get(i));
//		System.out.println();

	}	
}
