/*
 * Shopping Cart
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ShoppingCart provides the details of the total items, prices, and membership status to process the cart order.
 * @author Jasmine Scott
 * @version 1/17/2014
 */
public class ShoppingCart {

  /**
   * The member discount is 15%.
   */
  private static final double MY_MEMBERSHIP_DISCOUNT_PERCENT = 0.15;

  /**
   * The minimum amount allowed in shopping cart to get membership discount.
   */
  private static final double MY_MIN_PRICE_FOR_DISCOUNT = 25.0;

  /**
   * True if customer has membership and false if they don't.
   */
  private boolean my_membership; 

  /**
   * A list of item orders in the shopping cart.
   */
  private final List<ItemOrder> my_cart;

  /**
   * Constructs an empty shopping cart.
   */
  public ShoppingCart() {
    my_cart = new ArrayList<>();
  }

  /**
   * Adds a order to the shopping cart replacing a previous order for an equivalent item
   * with a new order. 
   * if order has never been seen, put in the new order
   * if order has been seen before, replace order with the new amount
   * @param the_order is a item order.
   */
  public void add(final ItemOrder the_order) {

    final Iterator<ItemOrder> itr = my_cart.iterator();
    while (itr.hasNext()) {
      if (itr.next().getItem().equals(the_order.getItem())) {
        itr.remove();
      }
    }
    my_cart.add(the_order);
  }

  /**
   * This method sets whether or not the customer has a membership with the store.
   * If the customer does it will be set to true and if they don't it will be set to false,
   * @param the_membership is either true or false depending if customer has membership or not.
   */
  public void setMembership(final boolean the_membership) {
    if (the_membership) {
      my_membership = true;
    } else {
      my_membership = false;     
    }
  }

  /**
   * Will calculate the total cost of the shopping cart. 
   * @return total is the total price in the shopping cart.
   */
  public double calculateTotal() {
    double totalprice = 0.0;
    double itemprice = 0.0;

    for (int i = 0; i < my_cart.size(); i++) {
      final ItemOrder temp = my_cart.get(i);
      itemprice = temp.calculatePrice();
      totalprice += itemprice;
    }
    if (my_membership  && (totalprice > MY_MIN_PRICE_FOR_DISCOUNT)) {
      totalprice -= totalprice * MY_MEMBERSHIP_DISCOUNT_PERCENT;
    }     
    return totalprice;
  }

  /**
   * A string representation of the shopping cart.
   * @return sb.toString() is the string showing the shopping carts state.
   */
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append(my_cart);
    return sb.toString();
  }
}
