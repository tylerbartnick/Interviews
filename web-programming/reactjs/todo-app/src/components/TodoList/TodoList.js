/* TodoList.js */

import React from 'react';
import './TodoList.css';

const TodoList = ({ todos, toggleTodoComplete, deleteTodo }) => {
  if (todos.length === 0) {
    return (
      <div className="row">
        <div className="col s12 m6 offset-m3">
          <p className="center-align">No Todos saved.</p>
          <p className="center-align">Start adding some above and be sure to save your work using the "Save" button!</p>
        </div>
      </div>
    );
  }

  const todoList = todos.sort((a, b) => {
      // primary sort by todo.completed
      if (a.completed === false && b.completed === true) return -1; // put a first
      if (a.completed === true && b.completed === false) return 1; // put b first
      // secondary sort by todo.id
      if (a.id < b.id) return -1; // put a first
      if (a.id > b.id) return 1; // put b first
      // both todos are equal, leave both in place
      return 0; // same weight
    }).map((todo) => {
      if (todo.completed) {
        return (
          <li className="collection-item" key={todo.id}>
            <div className="left"><span className="completed-todo">{todo.content} | ID: {todo.id}</span></div>
            <div className="right">
              <i className="material-icons icon-green" onClick={() => toggleTodoComplete(todo.id)}>check</i>
              <i className="material-icons icon-red" onClick={() => deleteTodo(todo.id)}>close</i>
            </div>
            <div className="clearfix"></div>
          </li>
        );
      }

      return (
        <li className="collection-item" key={todo.id}>
          <div className="left">{todo.content}  | ID: {todo.id}</div>
          <div className="right">
            <i className="material-icons icon-green" onClick={() => toggleTodoComplete(todo.id)}>check</i>
            <i className="material-icons icon-red" onClick={() => deleteTodo(todo.id)}>close</i>
          </div>
          <div className="clearfix"></div>
        </li>
      );
    });

  return (
    <div className="row">
      <div className="col s12 m6 offset-m3">
        <div className="section">
          <ul className="collection">
            {todoList}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default TodoList;
