package com.demo.testOne;

import java.util.TreeMap;

public class PractJava {
	
	public static void minIntwoDArray() {
		int[][] a = {{2,3,4},{6,7,9},{1,5,8}};
		int least = a[0][0];
		int minThRow =0;
		for(int i=0;i<a[0].length;i++) {
			
			for(int j=0;j<a[i].length;j++) {
				
				if(a[i][j]<least) {
					
					least=a[i][j];
					minThRow=j;
				}
				
			}
			
		}
		int maxInMinRow = a[0][minThRow];
		for(int i=0;i<3;i++) {
			if(a[i][minThRow]>maxInMinRow) {
				
				maxInMinRow=a[i][minThRow];
			}
		}
		System.out.println(maxInMinRow);
		
	}
	
	public static void main(String[] args) {
		
		
		
		
		
		
	}
	

}
