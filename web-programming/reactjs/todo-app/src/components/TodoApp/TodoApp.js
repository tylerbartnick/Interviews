/* TodoApp.js */

import React, { Component } from 'react';
import './TodoApp.css';

import TodoList from '../TodoList/TodoList';
import TodoForm from '../TodoForm/TodoForm';

class TodoApp extends Component {
  constructor(props) {
    super(props);

    this.state = {
      todos: []
    }
  }

  componentDidMount() {
    const locallyStoredData = window.localStorage.getItem('todos-list');
    if (locallyStoredData) {
      this.setState({todos: JSON.parse(locallyStoredData)});
    }
  }

  saveState = () => {
    window.localStorage.setItem('todos-list', JSON.stringify(this.state.todos));
  }

  addTodo = (todo) => {
    const todos = this.state.todos;
    todos.push({
      id: this.state.todos.length + 1,
      content: todo,
      completed: false
    });
    this.setState({ todos: todos })
  }

  toggleTodoComplete = (id) => {
    const todos = this.state.todos;
    const changedTodo = todos.filter((todo) => todo.id === id)[0];
    const idx = todos.findIndex(item => item.id === changedTodo.id);

    changedTodo.completed = !changedTodo.completed;
    todos[idx] = changedTodo;

    this.setState({ todos: todos });
  }

  deleteTodo = (id) => {
    const todos = this.state.todos.filter(todo => todo.id !== id);
    this.setState({ todos: todos });
  }

  render() {
    return (
      <div className="todo-app container">
        <div className="section">
          <div className="row">
            <div className="col s12 m6 offset-m3">
              <h1 className="center-align teal-text text-lighten-1">Todos</h1>
              <div className="divider"></div>
            </div>
          </div>
        </div>
        <TodoForm addTodo={this.addTodo} saveState={this.saveState} />
        <TodoList todos={this.state.todos} toggleTodoComplete={this.toggleTodoComplete} deleteTodo={this.deleteTodo} />
      </div>
    );
  }
}

export default TodoApp;
