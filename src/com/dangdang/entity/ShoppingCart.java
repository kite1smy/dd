package com.dangdang.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ShoppingCart implements Serializable{
	//���ﳵ
	private Map<Integer,Product> productsMap=new HashMap<>();
	//����վ
	private Set<Books> recycleSet=new HashSet<>();
	
	//���ﳵ����bookId  ɾ����Ʒ
	public void delete(Books books){
		//��ȡbookID,���ﳵɾ��������վ���
		int id = books.getBookId();
		productsMap.remove(id);
		recycleSet.add(books);
	}
	//�����Ʒ
	public void add(Books books){
		int id = books.getBookId();
		if(productsMap.containsKey(id)){
			//���ǵ�һ�ι���ȡ��pro,pro��count+1
			Product product = productsMap.get(id);
			product.setCount(product.getCount()+1);
		}else{
			//��һ�ι���
			Product pro = new Product(books,1);
			productsMap.put(id, pro);
		}
	}	
	
	//�������
	public void quantity(int id,int count){
		//����id��ȡproduct,����count
		productsMap.get(id).setCount(count);
	}
	
	//��ʡ���
	public double saveMoney(){
		//������ ��ȥ ʵ�ʼ�
		double sum=0;
		for(Product pro:productsMap.values()){
			sum+=pro.subSaveMoney();
		}
		return sum;
	}
	
	//�ܼ�
	public double totalMoney(){
		double sum=0;
		//ѭ������map����ȡ����dangPrice�ĺ�
		for(Product pro:productsMap.values()){
			sum+=pro.subCurrentMoney();
		}
		return sum;
	}
	
	//�ָ�
	public void recover(Books books){
		//�жϹ��ﳵ���Ƿ���ڸ�ͼ��
		if(!productsMap.containsKey(books.getBookId())){
			//�����������
			add(books);
		}
		recycleSet.remove(books);
	}
	@Override
	public String toString() {
		return "ShoppingCart [productsMap=" + productsMap + ", recycleSet="
				+ recycleSet + "]";
	}
	public Map<Integer, Product> getProductsMap() {
		return productsMap;
	}
	
	public Set<Books> getRecycleSet() {
		return recycleSet;
	}
	
	
}
