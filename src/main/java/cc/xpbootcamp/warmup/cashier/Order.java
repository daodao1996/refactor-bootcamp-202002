package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private String cName;
    private String addr;
    private List<LineItem> lineItemList;

    public Order(String cName, String addr, List<LineItem> lineItemList) {
        this.cName = cName;
        this.addr = addr;
        this.lineItemList = lineItemList;
    }

    public String toString() {
        double totalCost = 0d;
        double SALES_TAX = .10;
        StringBuilder output = new StringBuilder();
        output.append(cName);
        output.append(addr);

        for (LineItem lineItem : lineItemList) {
            output.append(lineItem.toString());
            totalCost += lineItem.totalAmount();
        }

        output.append("Sales Tax").append('\t').append(totalCost * SALES_TAX);
        output.append("Total Amount").append('\t').append(totalCost * (1 + SALES_TAX));

        return output.toString();
    }
}
