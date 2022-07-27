import { useState, useEffect } from "react";
import OrderService from "../../services/order.service";
import "./Catalog.css";

import { OrderdView } from "./OrderView";

export function Catalog() {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    OrderService.getAllOrders().then((orders) => setOrders(orders.data));
  }, []);

  console.log(orders);

  return (
    <div className="container mt-100">
      <div className="row">
        {orders.map((order) => (
          <OrderdView order={order} />
        ))}
      </div>
    </div>
  );
}
