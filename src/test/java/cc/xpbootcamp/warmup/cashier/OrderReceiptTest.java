package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void shouldPrintCustomerInformationOnOrder() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 1, 17);
        Order order = new Order(calendar, new ArrayList<LineItem>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();


        assertThat(output, containsString("===== 老王超市，值得信赖 ====="));
        assertThat(output, containsString("2020年2月17日, 星期一"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.50, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("巧克力, 21.50 x 2, 43.00\n"));
        assertThat(output, containsString("小白菜, 10.00 x 1, 10.00\n"));
        assertThat(output, containsString("-----------------------------------\n"));
        assertThat(output, containsString("税额:\t5.30\n"));
        assertThat(output, containsString("总价:\t58.30"));
    }

}
