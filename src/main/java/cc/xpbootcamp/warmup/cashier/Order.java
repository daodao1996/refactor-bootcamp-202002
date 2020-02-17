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

    public Double calculateTotalCost(){
        return lineItemList.stream().mapToDouble(LineItem::totalAmount).sum();
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(cName);
        output.append(addr);

        for (LineItem lineItem : lineItemList) {
            output.append(lineItem.toString());
        }

        return output.toString();
    }
}
