import React from 'react';
import '../Styles/NavigationBarStyles.css'

function NavigationBar() {
    return (
        <div className="mainNavigationBar">
            <button className="bookNavigator">Trending Books</button>
            <button>Sign Up</button>
            <button>Log In</button>
        </div>
    )
}

export default NavigationBar;