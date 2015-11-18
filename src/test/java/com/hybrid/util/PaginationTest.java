package com.hybrid.util;

import java.util.Scanner;

public class PaginationTest {

	public static void main(String[] args) {
		
		Pagination paging = new Pagination();
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("pageNo=");
			int pageNo = scan.nextInt();
			
			paging.setPageNo(pageNo);
			paging.setTotalItem(4076);
			
			for(int i=paging.getFirstItem(); i<=paging.getLastItem(); i++)
				System.out.println("item index = " + i);
			
			if (!paging.isFirstGroup())
				System.out.print("[이전] ");
			else
				System.out.print("      ");
			
			for (int i=paging.getFirstPage(); i<=paging.getLastPage(); i++) {
				System.out.printf("[%03d] ", i);
			}
			
			if (!paging.isLastGroup())
				System.out.print("[다음] ");
			else
				System.out.print("      ");

			
			System.out.println();
		}
		
		
		
	}
	static void test1() {
		
		Pagination paging = new Pagination();

		for (int i=-2; i<20; i++) {
			paging.setPageNo(i);
			paging.setTotalItem(175);
			
			String line = "totalPage=" + paging.getTotalPage()
						+ ", firstGroup=" + paging.isFirstGroup()
						+ ", firstItem=" + paging.getFirstItem()
						+ ", lastItem=" + paging.getLastItem()
						+ ", pageNo=" + paging.getPageNo()
						+ ", fistPage=" + paging.getFirstPage()
						+ ", lastPage=" + paging.getLastPage()
						+ ", lastGroup=" + paging.isLastGroup();
			System.out.println(line);
		}

	}

}
