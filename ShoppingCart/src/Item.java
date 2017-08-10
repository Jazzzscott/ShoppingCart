/*
 * Shopping Cart
 */

import java.text.NumberFormat;
import java.util.Objects;

/**
 * The item class is an object item of one individual item.
 * @author Jasmine Scott
 * @version 1/17/2014
 */
public class Item {
  
  /**
   * the name of the item.
   */
  
  private final String my_name;
  
  /**
   * the price of the item.
   */
  
  private final double my_price;
  
  /**
   * the amount needed to have a discount price of the item.
   */
  
  private int my_bulk_quantity;
  
  /**
   * the discounted bulk price of a certain quantity of the item.
   */
  
  private double my_bulk_price;

  /**
   * Constructor that simply takes in the name and price of an item.
   * @param the_name is the name of the item.
   * @param the_price is the price of the item. 
   */
  public Item(final String the_name, final double the_price) {
    my_name = the_name;
    my_price = the_price;
  }
  
  /**
   * Constructor that takes in the name, price, bulk quantity, and bulk price of a 
   * particular item.
   * @param the_name is the name of the item.
   * @param the_price is the price of the item.
   * @param the_bulk_quantity is the amount of an item needed to be considered bulk.
   * @param the_bulk_price is the value price for an item in bulk.
   */
  public Item(final String the_name, final double the_price, final int the_bulk_quantity,
              final double the_bulk_price) {
    my_name = the_name;
    my_price = the_price;
    my_bulk_quantity = the_bulk_quantity;
    my_bulk_price = the_bulk_price;
  }
  
  /**
   * This method returns the price of a certain quantity of one item, taking into account
   * the bulk price if applicable.
   * @param the_quantity is how many of a certain item
   * @return is the price for the given amount of items
   **/
  
  public double calculatePriceFor(final int the_quantity) {
    double calc_price = 0.0;
    int quantity = the_quantity;
    int my_bulk_bundles = 0;
    if (my_bulk_quantity == 0 || the_quantity < my_bulk_quantity) {
      calc_price = the_quantity * my_price;
    } 
    else if (the_quantity >= my_bulk_quantity) {
      int extra_items = the_quantity % my_bulk_quantity;
      while (quantity > 1) {
        quantity = quantity / my_bulk_quantity;
        my_bulk_bundles++;
      }
      calc_price = (extra_items*my_price) + (my_bulk_bundles*my_bulk_price);
    }
    return calc_price;
  }

  // methods overridden from java.lang.Object
  @Override
  /**
   * Method returns a string representation of the objects state: name followed by a comma,
   * followed by a space, followed by a price. When there is a bulk price it will include
   * the bulk amount and it's price (10 for $39.99)
   * @return sb.toString() is a String of the item name and price 
   *  with (bulk amount and bulk price)
   */
  public String toString() {
    final NumberFormat nf = NumberFormat.getCurrencyInstance();
    final StringBuilder sb = new StringBuilder();
    if (my_bulk_quantity == 0) {
      sb.append(my_name);
      sb.append(", ");
      sb.append(nf.format(my_price));     
    } else {
      sb.append(my_name);
      sb.append(", ");
      sb.append(nf.format(my_price));
      sb.append(" (");
      sb.append(my_bulk_quantity);
      sb.append(" for ");
      sb.append(nf.format(my_bulk_price));
      sb.append(")");
    }
    return sb.toString();
  }

  @Override
  /**
   * This method tests if two objects are equal. They are only considered equal if names, 
   * price, bulk quantity, and bulk prices before rounding are all equivalent. If equal
   * it will return true, otherwise it will return false. 
   * @param the_other is the other item to compare to the item currently on
   * @return 
   */
  public boolean equals(final Object the_other) {
    boolean result = false;
    if (the_other == null || the_other.getClass() != this.getClass()) {
      result = false;
    } else { //(the_other != null){
      final Item other = (Item) the_other;
      if (the_other != null && my_name.equals(other.my_name) 
              && my_price == other.my_price 
              && my_bulk_quantity == other.my_bulk_quantity 
              && my_bulk_price == other.my_bulk_price) {
        result = true;
      }
    }
    return result;
  }

  @Override
  /**
   * This method is overridden to match the equals() method.
   * @ return Objects.hash(...) is a int.
   */
  public int hashCode() {
    return Objects.hash(my_name, my_price, my_bulk_quantity, my_bulk_price);
  }
}
