package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        output.append(orderTime.get(Calendar.YEAR));
        output.append("年");
        output.append(orderTime.get(Calendar.MONTH) + 1);
        output.append("月");
        output.append(orderTime.get(Calendar.DATE));
        output.append("日,\t");
        output.append(weeks[orderTime.get(Calendar.DAY_OF_WEEK) - 1]);
        output.append("\n");

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
