import React from 'react';
import './App.css';

import ApiFetch from './components/ApiFetch';
import Clock from "./components/Clock";

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <h1>蔵書一覧</h1>
                <ApiFetch />
                {/* 追記 */}
                <Clock />
            </header>
        </div>
    );
}

export default App;
