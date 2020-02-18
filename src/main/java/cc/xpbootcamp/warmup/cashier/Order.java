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
        StringBuilder output = new StringBuilder();
        String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};

        output.append(orderTime.get(Calendar.YEAR)).append("年");
        output.append(orderTime.get(Calendar.MONTH) + 1).append("月");
        output.append(orderTime.get(Calendar.DATE)).append("日, ");
        output.append(weeks[orderTime.get(Calendar.DAY_OF_WEEK) - 1]).append("\n");

        return output.toString();
    }

    public String toString() {
        StringBuilder output = new StringBuilder();

        for (LineItem lineItem : lineItemList) {
            output.append(lineItem.toString());
        }

        return output.toString();
    }
}
