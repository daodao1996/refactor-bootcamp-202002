package cc.xpbootcamp.warmup.cashier;

public class LineItem {
  private String description;
  private double price;
  private int quantity;

  public LineItem(String desc, double price, int qty) {
    super();
    this.description = desc;
    this.price = price;
    this.quantity = qty;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  double totalAmount() {
    return price * quantity;
  }

  @Override
  public String toString() {
    return String.format("%s, %.2f x %s, %.2f\n", description, price, quantity, totalAmount());
  }
}
