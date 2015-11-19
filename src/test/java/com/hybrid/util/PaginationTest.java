package com.hybrid.util;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.parsing.ParsingException;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.CityMapper;
import com.hybrid.model.City;

public class PaginationTest {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = null;
		ctx = new GenericXmlApplicationContext("spring/beans_mysql.xml");
		
		CityMapper cityMapper = ctx.getBean(CityMapper.class);
		int totalItem = cityMapper.selectCount();
		System.out.println("totalItem=" + totalItem);
		
		Pagination paging = new Pagination();
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("pageNo=");
			int pageNo = scan.nextInt();
			
			paging.setPageNo(pageNo);
			paging.setTotalItem(totalItem);
			
			List<City> list = cityMapper.selectPage(paging);
			
//			for(int i=0; i<paging.getLength(); i++) {
//				City c = list.get(i);
			for(int i=paging.getFirstItem(); i<=paging.getLastItem(); i++) {
				City c = list.get(i-paging.getFirstItem());
				String line = c.getId() + " " + c.getName() + " " + c.getCountryCode();
				System.out.println(line);
			}
			
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
