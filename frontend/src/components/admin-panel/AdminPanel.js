import "./AdminPanel.css";

import { useState, useEffect } from "react";

import { UserItem } from "../../components/admin-panel/user-crud/UserItem";
import { UserActions } from "./user-crud/UserListConstants";
import { UserDetails } from "./user-crud/UserDetails";
import { UserDelete } from "./user-crud/UserDelte";
import { UserEdit } from "./user-crud/UserEdit";
import { UserCreate } from "./user-crud/UserCreate";

import UserService from "../../services/admin.service";

export const AdminPanel = () => {
  const [users, setUsers] = useState([]);
  const [userAction, setUserAction] = useState({ user: null, action: null });

  useEffect(() => {
    UserService.getAllUsers().then((users) => setUsers(users.data));
  }, []);

  const userActionClickHandler = (userId, actionType) => {
    UserService.getUserById(userId).then((user) => {
      setUserAction({
        user,
        action: actionType,
      });
    });
  };

  const userCreateHandler = (actionType) => {
    setUserAction({
      action: actionType,
    });
  };

  const onChangeHandler = () => {
    UserService.getAllUsers().then((users) => setUsers(users.data));
  };

  const deleteHandler = (userId) => {
    setUsers((state) => state.filter((user) => user.id !== userId));
  };

  const closeHandler = () => {
    setUserAction({ user: null, action: null });
  };

  return (
    <>
      <div className="table-wrapper">
        {userAction.action === UserActions.Details && (
          <UserDetails user={userAction.user} onClose={closeHandler} />
        )}

        {userAction.action === UserActions.Delete && (
          <UserDelete
            user={userAction.user}
            onClose={closeHandler}
            deleteHandler={deleteHandler}
          />
        )}

        {userAction.action === UserActions.Edit && (
          <UserEdit
            user={userAction.user}
            onClose={closeHandler}
            onChange={onChangeHandler}
          />
        )}

        {userAction.action === UserActions.Add && (
          <UserCreate onClose={closeHandler} onChange={onChangeHandler} />
        )}
        <table className="table">
          <thead>
            <tr>
              <th>Image</th>
              <th>
                Id
                <svg
                  aria-hidden="true"
                  focusable="false"
                  data-prefix="fas"
                  data-icon="arrow-down"
                  className="icon svg-inline--fa fa-arrow-down Table_icon__+HHgn"
                  role="img"
                  xmlns="http://www.w3.org/2000/svg"
                  viewBox="0 0 384 512"
                >
                  <path
                    fill="currentColor"
                    d="M374.6 310.6l-160 160C208.4 476.9 200.2 480 192 480s-16.38-3.125-22.62-9.375l-160-160c-12.5-12.5-12.5-32.75 0-45.25s32.75-12.5 45.25 0L160 370.8V64c0-17.69 14.33-31.1 31.1-31.1S224 46.31 224 64v306.8l105.4-105.4c12.5-12.5 32.75-12.5 45.25 0S387.1 298.1 374.6 310.6z"
                  ></path>
                </svg>
              </th>
              <th>
                Username
                <svg
                  aria-hidden="true"
                  focusable="false"
                  data-prefix="fas"
                  data-icon="arrow-down"
                  className="icon svg-inline--fa fa-arrow-down Table_icon__+HHgn"
                  role="img"
                  xmlns="http://www.w3.org/2000/svg"
                  viewBox="0 0 384 512"
                >
                  <path
                    fill="currentColor"
                    d="M374.6 310.6l-160 160C208.4 476.9 200.2 480 192 480s-16.38-3.125-22.62-9.375l-160-160c-12.5-12.5-12.5-32.75 0-45.25s32.75-12.5 45.25 0L160 370.8V64c0-17.69 14.33-31.1 31.1-31.1S224 46.31 224 64v306.8l105.4-105.4c12.5-12.5 32.75-12.5 45.25 0S387.1 298.1 374.6 310.6z"
                  ></path>
                </svg>
              </th>
              <th>
                First Name
                <svg
                  aria-hidden="true"
                  focusable="false"
                  data-prefix="fas"
                  data-icon="arrow-down"
                  className="icon svg-inline--fa fa-arrow-down Table_icon__+HHgn"
                  role="img"
                  xmlns="http://www.w3.org/2000/svg"
                  viewBox="0 0 384 512"
                >
                  <path
                    fill="currentColor"
                    d="M374.6 310.6l-160 160C208.4 476.9 200.2 480 192 480s-16.38-3.125-22.62-9.375l-160-160c-12.5-12.5-12.5-32.75 0-45.25s32.75-12.5 45.25 0L160 370.8V64c0-17.69 14.33-31.1 31.1-31.1S224 46.31 224 64v306.8l105.4-105.4c12.5-12.5 32.75-12.5 45.25 0S387.1 298.1 374.6 310.6z"
                  ></path>
                </svg>
              </th>
              <th>
                Last Name
                <svg
                  aria-hidden="true"
                  focusable="false"
                  data-prefix="fas"
                  data-icon="arrow-down"
                  className="icon svg-inline--fa fa-arrow-down Table_icon__+HHgn"
                  role="img"
                  xmlns="http://www.w3.org/2000/svg"
                  viewBox="0 0 384 512"
                >
                  <path
                    fill="currentColor"
                    d="M374.6 310.6l-160 160C208.4 476.9 200.2 480 192 480s-16.38-3.125-22.62-9.375l-160-160c-12.5-12.5-12.5-32.75 0-45.25s32.75-12.5 45.25 0L160 370.8V64c0-17.69 14.33-31.1 31.1-31.1S224 46.31 224 64v306.8l105.4-105.4c12.5-12.5 32.75-12.5 45.25 0S387.1 298.1 374.6 310.6z"
                  ></path>
                </svg>
              </th>
              <th>
                Email
                <svg
                  aria-hidden="true"
                  focusable="false"
                  data-prefix="fas"
                  data-icon="arrow-down"
                  className="icon active-icon svg-inline--fa fa-arrow-down Table_icon__+HHgn"
                  role="img"
                  xmlns="http://www.w3.org/2000/svg"
                  viewBox="0 0 384 512"
                >
                  <path
                    fill="currentColor"
                    d="M374.6 310.6l-160 160C208.4 476.9 200.2 480 192 480s-16.38-3.125-22.62-9.375l-160-160c-12.5-12.5-12.5-32.75 0-45.25s32.75-12.5 45.25 0L160 370.8V64c0-17.69 14.33-31.1 31.1-31.1S224 46.31 224 64v306.8l105.4-105.4c12.5-12.5 32.75-12.5 45.25 0S387.1 298.1 374.6 310.6z"
                  ></path>
                </svg>
              </th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {users.length !== 0 ? (
              users.map((user) => (
                <tr key={user.id}>
                  <UserItem
                    user={user}
                    onActionClick={userActionClickHandler}
                  />
                </tr>
              ))
            ) : (
              <div className="searchResult">
                <p>No Users</p>
              </div>
            )}
          </tbody>
        </table>
        <div className="btn-wrapper">
          <div
            className="btn-add"
            onClick={() => userCreateHandler(UserActions.Add)}
          >
            +
          </div>
        </div>
      </div>
    </>
  );
};
