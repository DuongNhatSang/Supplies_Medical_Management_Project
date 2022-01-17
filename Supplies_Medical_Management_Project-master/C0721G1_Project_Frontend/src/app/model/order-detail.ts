import {Customer} from "./customer";
import {Supplies} from "./supplies";

export class OrderDetail {
  id : number;
  order_date: string;
  total_money: number;
  quantity: number;
  customer: Customer;
  supplies: Supplies;
}
