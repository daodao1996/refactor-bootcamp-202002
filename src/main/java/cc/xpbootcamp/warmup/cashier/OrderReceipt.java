package cc.xpbootcamp.warmup.cashier;

import java.util.Calendar;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(generateHeader());
        output.append(order.toString());
        output.append(generateFooter());
        return output.toString();
    }

    private String generateFooter(){
        StringBuilder output = new StringBuilder();

        double SALES_TAX = .10;
        double DISCOUNT = .02;
        double feeIncludeTax = order.calculateTotalCost() * (1 + SALES_TAX);
        output.append("-----------------------------------\n");
        output.append("税额:").append('\t').append(String.format("%.2f", order.calculateTotalCost() * SALES_TAX)).append("\n");
        if(order.getDate().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY){
            output.append("折扣:").append('\t').append(String.format("%.2f", feeIncludeTax * DISCOUNT)).append("\n");
            output.append("总价:").append('\t').append(String.format("%.2f", feeIncludeTax * (1 - DISCOUNT))).append("\n");
        }
        else{
            output.append("总价:").append('\t').append(String.format("%.2f", feeIncludeTax)).append("\n");
        }

        return output.toString();
    }

    private String generateHeader(){
        StringBuilder output = new StringBuilder();

        output.append("===== 老王超市，值得信赖 =====\n");
        output.append(order.getDateDetail());

        return output.toString();
    }
}
