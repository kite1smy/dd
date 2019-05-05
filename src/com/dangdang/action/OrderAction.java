package com.dangdang.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dangdang.entity.Address;
import com.dangdang.entity.Order;
import com.dangdang.entity.OrderItem;
import com.dangdang.entity.Product;
import com.dangdang.entity.ShoppingCart;
import com.dangdang.entity.User;
import com.dangdang.service.AddressService;
import com.dangdang.service.OrderService;
import com.dangdang.service.impl.AddressServiceImpl;
import com.dangdang.service.impl.OrderServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	private Order order;
	private List<Address> addressList;
	private AddressService as = new AddressServiceImpl();
	private Map<String, Object> session = ActionContext.getContext().getSession();
	private OrderService os = new OrderServiceImpl();
	private List<Order> orderList;
	private int out_trade_no;
	
	//��������
	public String pay(){
		os.update(out_trade_no);
		return "pay_ok.jsp";
	}
	
	//չʾ��������
	public String orderList(){
		if(session.get("user")==null){
			return "toLogin.jsp";
		}
		orderList=os.selectAll();
		System.err.println(orderList);
		return "toOrderList.jsp";
	}
	
	
	//��ѯ��ǰ�û������п��õ�ַ
	public String showAddressList(){
		addressList=as.selectAll((User)session.get("user"));
		return "toAddress_form.jsp";
	}

	//�յ���ַ��ţ����ɶ���
	public String createOrder(){
		//�����û���Ϣ
		System.err.println(session);
		order.setUser((User)session.get("user"));
		//��ַ��Ϣ���ύ
		
		//��session�Ĺ��ﳵ�л�ȡ�ܼ�
		ShoppingCart cart = (ShoppingCart)session.get("cart");
		order.setGoodPrice(cart.totalMoney());
		
		//��������
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for(Product pro:cart.getProductsMap().values()){
			OrderItem item = new OrderItem();
			item.setBooks(pro.getBooks());
			item.setCount(pro.getCount());
			item.setAmount(pro.subCurrentMoney());
			item.setSaveMoney(pro.subSaveMoney());
			orderItemList.add(item);
		}
		order.setOrderItemList(orderItemList);
		try {
			os.insert(order);
			cart.getProductsMap().clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//����ʧ�ܣ������û�
			String message = e.getMessage();
		}
		
		return "toOrderOk";
	}
	
	
	public List<Address> getAddressList() {
		return addressList;
	}


	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}


	public AddressService getAs() {
		return as;
	}


	public void setAs(AddressService as) {
		this.as = as;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public OrderService getOs() {
		return os;
	}


	public void setOs(OrderService os) {
		this.os = os;
	}


	public List<Order> getOrderList() {
		return orderList;
	}


	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public int getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(int out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
}
