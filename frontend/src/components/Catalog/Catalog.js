import { useState, useEffect } from "react";
import OrderService from "../../services/order.service";
import { OrderActions } from "./OrderListConstants";
import { OrderDelete } from "./OrderDelete";
import { OrderEdit } from "./OrderEdit";
import "./Catalog.css";

import { OrderdView } from "./OrderView";

export function Catalog() {
  const [orders, setOrders] = useState([]);
  const [userAction, setUserAction] = useState({ order: null, action: null });

  useEffect(() => {
    OrderService.getAllOrders().then((orders) => setOrders(orders.data));
  }, []);

  console.log(orders);

  const userActionClickHandler = (orderId, actionType) => {
    console.log(orderId);
    OrderService.getOrderById(orderId).then((order) => {
      setUserAction({
        order,
        action: actionType,
      });
    });
  };

  const onChangeHandler = () => {
    OrderService.getAllOrders().then((orders) => setOrders(orders.data));
  };

  const deleteHandler = (orderId) => {
    setOrders((state) => state.filter((order) => order.id !== orderId));
  };

  const closeHandler = () => {
    setUserAction({ user: null, action: null });
  };

  return (
    <>
      {userAction.action === OrderActions.Delete && (
        <OrderDelete
          order={userAction.order}
          onClose={closeHandler}
          deleteHandler={deleteHandler}
        />
      )}

      {userAction.action === OrderActions.Edit && (
        <OrderEdit
          order={userAction.order}
          onClose={closeHandler}
          onChange={onChangeHandler}
        />
      )}

      <div className="container mt-100">
        <div className="row">
          {orders.map((order) => (
            <OrderdView order={order} onActionClick={userActionClickHandler} />
          ))}
        </div>
      </div>
    </>
  );
}
