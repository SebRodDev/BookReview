import React from 'react';
import { animate, motion } from 'framer-motion';
import './App.css';
import NavigationBar from './components/NavigationBar';

const box = {
  width: 450,
  height: 450,
  backgroundColor: "#7d5239",
  borderRadius: 5,
}

function App() {

  return (
    <div className="App">
      <NavigationBar></NavigationBar>
      <h1 className="Title">Welcome to</h1>
      <h1 className="secondTitle">The Reading Room</h1>
      <h2 className="subtext">Create your own reviews and share your bookshelf with ease!</h2>

      <img src={require("./components/pngtree-book-clipart-vector-png-image_6653535.png")} className="bookImage"></img>
      <motion.div
        style={box}
        animate={{ rotate: 360 }}
        transition={{ duration: 2, repeat: Infinity, repeatType: "loop" }}
        className="bookBackground"
      />

      <h1 className="trendingTitle">Trending Books of 2025</h1>
    </div>
  );
}


export default App;
