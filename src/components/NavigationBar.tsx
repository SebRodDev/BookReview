import React from 'react';
import '../Styles/NavigationBarStyles.css'


function NavigationBar() {
    return (
        <div className="mainNavigationBar">
            <button className="bookNavigator">Trending Books</button>
            <button className="accountButtons">Login</button>
            <button className="accountButtons">Sign Up</button>
        </div>
    )
}

export default NavigationBar;