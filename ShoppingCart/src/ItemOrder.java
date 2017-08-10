/*
 * Shopping Cart
 */

/**
 * ItemOrder provides the state and behavior of each items order.
 * @author Jasmine Scott
 * @version 1/17/2014
 */
public class ItemOrder {
  
  /**
   * The item.
   */
  private final Item my_item;
  
  /**
   * The quantity of the item.
   */
  private final int my_quantity;

  /**
   * Constructs an item order for the given quantity of the given item.
   * @param the_item is the item object.
   * @param the_quantity is how many of the item.
   */
  
  public ItemOrder(final Item the_item, final int the_quantity) {
    my_item = the_item;
    my_quantity = the_quantity;
  }
  
  /**
   * Calculates the price for the quantity of the an item.
   * @return the price for the item order.
   */
  public double calculatePrice() {
    return my_item.calculatePriceFor(my_quantity);

  }
  
  /**
   * This method returns a reference to the item in this item order.
   * @return my_item is the item object.
   */
  public Item getItem() {
    return my_item;
  }
  
  /**
   * This method returns a string representation of the itemOrder.
   * @return sb.toString(); is the string of an item and it's quantity.
   */
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append(my_item);
    sb.append(", ");
    sb.append(my_quantity);
    return sb.toString();
  }
}
