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
        StringBuilder receipt = new StringBuilder();

        receipt.append(generateHeader());
        receipt.append(order.toString());
        receipt.append(generateFooter());
        return receipt.toString();
    }

    private String generateFooter(){
        StringBuilder output = new StringBuilder();

        output.append("-----------------------------------\n");
        output.append(String.format("税额:\t%.2f\n", order.getTax()));
        if(isDiscount()){
            output.append(String.format("折扣:\t%.2f\n", order.getDiscount()));
            output.append(String.format("总价:\t%.2f\n", order.calculateTotalCost() + order.getTax() - order.getDiscount()));
        }else{
            output.append(String.format("总价:\t%.2f\n", order.calculateTotalCost() + order.getTax()));

        }

        return output.toString();
    }

    private String generateHeader(){
        StringBuilder footer = new StringBuilder();

        footer.append("===== 老王超市，值得信赖 =====\n");
        footer.append(order.getDateDetail());

        return footer.toString();
    }

    private boolean isDiscount(){
        return order.getDate().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY;
    }
}
