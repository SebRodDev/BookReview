import React from 'react';
import { animate, motion } from "framer-motion"
import './App.css';
import NavigationBar from './components/NavigationBar';

function App() {
  return (
    <div className="App">
      <NavigationBar></NavigationBar>
      <h1 className="Title">Welcome to</h1>
      <h1 className="secondTitle">The Reading Room</h1>
      <h2 className="subtext">Create your own reviews and share your bookshelf with ease!</h2>
      <img src="./components/pngtree-book-clipart-vector-png-image_6653535.png"></img>
      <div className="trendingBooksSection">
        <h1 className="trendingTitle">Trending Books of 2025</h1>
      </div>
    </div>
  );
}

export default App;
