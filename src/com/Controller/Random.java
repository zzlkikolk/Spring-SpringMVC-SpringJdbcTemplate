package com.Controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.ItemsDao;
import com.bean.*;

@Service
public class Random {
	
	@Autowired
	private ItemsDao dao;
	public List<Items> getItems(String ItemName){
		ArrayList<Items> array=new ArrayList<Items>();
		List<Items> list=dao.getItems(ItemName);
		boolean check=true;
		ArrayList<Integer> a=new ArrayList<Integer>();
		 int x=(int)(Math.random()*list.size());
		 a.add(x);
		for(int i=0;i<4;i++){
			check=true;
			 x=(int)(Math.random()*list.size());
			for(int j=0;j<a.size();j++){
				if(a.get(j)==x){
					--i;
					check=false;
					break;
				}
			}
			if(check)
				a.add(x);
		}
		//System.out.println(a);
		for(int i=0;i<a.size();i++){
			array.add(list.get(a.get(i)));
		}
		return array;
	}
}
