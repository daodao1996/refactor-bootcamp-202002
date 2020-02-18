package cc.xpbootcamp.warmup.cashier;

import java.util.Date;
import java.util.List;

public class Order {
    private Date orderTime;
    private List<LineItem> lineItemList;

    public Order(Date orderTime, List<LineItem> lineItemList) {
        this.orderTime = orderTime;
        this.lineItemList = lineItemList;
    }

    public Order(List<LineItem> lineItemList){
        this(new Date(), lineItemList);
    }

    public Date getDate(){
        return orderTime;
    }

    public Double calculateTotalCost(){
        return lineItemList.stream().mapToDouble(LineItem::totalAmount).sum();
    }

    public String toString() {
        StringBuilder output = new StringBuilder();

        for (LineItem lineItem : lineItemList) {
            output.append(lineItem.toString());
        }

        return output.toString();
    }
}
