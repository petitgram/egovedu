package com.spring;

import java.util.*;
public class SawonConfig {
	private List<Sawon> list =	new ArrayList<Sawon>();

	public void setList(List<Sawon> list) {
		this.list = list;
	}
	
	public void print(){
		for(Sawon sa:list){
			System.out.println(sa.getSabun()+"-"+sa.getName()+"-"+sa.getDept());
		}
	}
}
