import React, { Component } from 'react';
import './TodoForm.css';

class TodoForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      value: ''
    }
  }

  resetFormInput = () => {
    this.setState({ value: '' });
  }

  handleClick = () => {
    this.props.saveState();
  }

  handleChange = (evt) => {
    this.setState({ value: evt.target.value });
  }

  handleSubmit = (evt) => {
    evt.preventDefault();
    if (this.state.value !== '') {
      this.props.addTodo(this.state.value);
      this.resetFormInput();
    }
  }

  render() {
    return (
      <div className="section">
        <div className="row">

          <form className="col s12 m6 offset-m3" onSubmit={this.handleSubmit}>
            <div className="row">

              <div className="input-field col s12">
                <input placeholder="Todo" id="todo-add" type="text" value={this.state.value} onChange={this.handleChange} className="validate" />
                <label htmlFor="todo-add">Todo</label>
              </div>

            </div>
            <div className="row">
              <div className="col s12">

                <button className="btn waves-effect waves-light left" type="button" onClick={this.handleClick}>
                  Save
                  <i className="material-icons right">save</i>
                </button>

                <button className="btn waves-effect waves-light right" type="submit">
                  Submit
                  <i className="material-icons right">send</i>
                </button>

              </div>
            </div>
          </form>

        </div>
      </div>
    );
  }
}

export default TodoForm;
