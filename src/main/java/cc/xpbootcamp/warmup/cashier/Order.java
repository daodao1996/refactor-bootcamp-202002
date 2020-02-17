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

    public String getcName() {
        return cName;
    }

    public String getAddr() {
        return addr;
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
