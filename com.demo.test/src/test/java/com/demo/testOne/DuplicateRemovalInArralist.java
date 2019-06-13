package com.demo.testOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateRemovalInArralist {
	
	public void alDups() {
		
		/* ArrayList<Integer> al = new ArrayList<Integer>();
	    al.add(2);
	    al.add(3);
	    al.add(4);
	    al.add(3);
	   Set<Integer> s = al.stream().filter(i->i!=i+1).collect(Collectors.toSet());
	   System.out.println(s);*/
	    
	   ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(2,3,4)); 
	   ArrayList<Integer> an = new ArrayList<Integer>(Arrays.asList(2,3,4,7));
	   al.addAll(an);
	   Set<Integer> ax = al.stream().filter(i->i!=i+1).collect(Collectors.toSet());
	   System.out.println(ax);
	}

}
