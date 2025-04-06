import React from 'react';
import logo from './logo.svg';
import './App.css';
import NavigationBar from './components/NavigationBar';

function App() {
  return (
    <div className="App">
      <NavigationBar></NavigationBar>
      <h1 className="Title">Welcome to</h1>
      <h1 className="secondTitle">The Reading Room</h1>
    </div>
  );
}

export default App;
