package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void shouldPrintCustomerInformationOnOrder() {
        Order order = new Order(new ArrayList<LineItem>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();


        assertThat(output, containsString("===== 老王超市，值得信赖 ====="));
        assertThat(output, containsString("2020年2月17日，星期一"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("巧克力,\t21.50\tx\t2,\t43.00\n"));
        assertThat(output, containsString("小白菜,\t10.00\tx\t1\t10.0\n"));
        assertThat(output, containsString("-----------------------------------\n"));
        assertThat(output, containsString("税额:\t5.3\n"));
        assertThat(output, containsString("总价:\t58.3"));
    }

}
