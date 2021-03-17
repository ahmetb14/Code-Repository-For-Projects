import { Injectable } from '@angular/core';
import { CarItem } from '../models/cartItem';
import { CartItems } from '../models/cartItems';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor() { }

  addToCart(product:Product){
    let item = CartItems.find(c=>c.product.productId===product.productId);
    if(item){
      item.quantity+=1;
    }else{
      let cartItem = new CarItem();
      cartItem.product = product;
      cartItem.quantity = 1;
      CartItems.push(cartItem)
    }
  }

  removeFromCart(product:Product){
    let item:CarItem = CartItems.find(c=>c.product.productId===product.productId);
    CartItems.splice(CartItems.indexOf(item),1);
  }

  list():CarItem[]{
    return CartItems;
  }
}
