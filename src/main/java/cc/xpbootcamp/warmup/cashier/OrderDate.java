package cc.xpbootcamp.warmup.cashier;

import java.util.Calendar;

public class OrderDate {
  private Calendar orderDate;

  public OrderDate(Calendar orderDate){
    this.orderDate = orderDate;
  }

  String getDateDetail() {
    String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    return String.format("%d年%d月%d日, %s\n", orderDate.get(Calendar.YEAR),
            orderDate.get(Calendar.MONTH) + 1, orderDate.get(Calendar.DATE),
            weeks[orderDate.get(Calendar.DAY_OF_WEEK) - 1]);
  }
}
