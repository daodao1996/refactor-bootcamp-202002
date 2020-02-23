package cc.xpbootcamp.warmup.cashier;

import java.util.Calendar;
import java.util.List;

public class Order {
  private Calendar orderTime;
  private static final double SALES_TAX = .10;
  private static final double DISCOUNT = .02;
  private List<LineItem> lineItemList;

  public Order(Calendar orderTime, List<LineItem> lineItemList) {
    this.orderTime = orderTime;
    this.lineItemList = lineItemList;
  }

  public Order(List<LineItem> lineItemList) {
    this(Calendar.getInstance(), lineItemList);
  }

  public Calendar getDate() {
    return orderTime;
  }

  Double calculateTotalCost() {
    return lineItemList.stream().mapToDouble(LineItem::totalAmount).sum();
  }

  public String toString() {
    StringBuilder output = new StringBuilder();

    for (LineItem lineItem : lineItemList) {
      output.append(lineItem.toString());
    }

    return output.toString();
  }

  public double getTax() {
    return calculateTotalCost() * SALES_TAX;
  }

  public double getDiscount() {
    return (calculateTotalCost() + getTax()) * DISCOUNT;
  }
}
