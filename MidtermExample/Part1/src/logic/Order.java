package logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;

	public Order() {
		// TODO
		orderItemList = new ArrayList<OrderItem>();
		orderNumber = totalOrderCount;
		totalOrderCount += 1;

	}

	public OrderItem addItem(Item item, int amount) {
		// TODO
		for (OrderItem x : orderItemList) {
			if (x.getItem().getName() == item.getName()) {
				x.increaseItemAmount(amount);
				return x;
			}
		}
		OrderItem order = new OrderItem(item, amount);
		orderItemList.add(order);
		return order;
		// Loop the orderItemList to find if item of any orderItem equals to the given
		// item
		// if there is orderItem with given item, increase that orderItem itemAmount
		// with amount
		// and return that orderItem

		// else create new orderItem with given item and amount, then return the new
		// orderItem
	}

	public int calculateOrderTotalPrice() {
		// TODO
		int sum=0;
		for(OrderItem x:orderItemList) {
			sum += x.getItem().getPricePerPiece() * x.getItemAmount();
		}
		// Calculate total price of the order by summing total price of each orderItem in orderItemList
		return sum;
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}

	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}


}
