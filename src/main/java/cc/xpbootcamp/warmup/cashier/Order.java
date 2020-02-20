package cc.xpbootcamp.warmup.cashier;

import java.util.Calendar;
import java.util.List;

public class Order {
    private Calendar orderTime;
    private List<LineItem> lineItemList;

    public Order(Calendar orderTime, List<LineItem> lineItemList) {
        this.orderTime = orderTime;
        this.lineItemList = lineItemList;
    }

    public Order(List<LineItem> lineItemList){
        this(Calendar.getInstance(), lineItemList);
    }

    public Calendar getDate(){
        return orderTime;
    }

    Double calculateTotalCost(){
        return lineItemList.stream().mapToDouble(LineItem::totalAmount).sum();
    }

    String getDateDetail(){
        String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};

        return String.format("%d年%d月%d日, %s\n", orderTime.get(Calendar.YEAR),
                orderTime.get(Calendar.MONTH) + 1, orderTime.get(Calendar.DATE),
                weeks[orderTime.get(Calendar.DAY_OF_WEEK) - 1]);
    }

    public String toString() {
        StringBuilder output = new StringBuilder();

        for (LineItem lineItem : lineItemList) {
            output.append(lineItem.toString());
        }

        return output.toString();
    }
}
