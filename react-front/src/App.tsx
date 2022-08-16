import React from 'react';
import './App.css';

import Button from '@mui/material/Button';

import GetBookListApiFetch from './components/GetBookListApiFetch';
import {NavLink, Route, Switch} from "react-router-dom";
import Home from "./pages/Home";
import {Stack} from "@mui/material";
import SideBar from "./pages/SideBar";

function App() {
    return (
        <>
            <Stack direction={'row'}>
                <SideBar />
                {/*<Menu />*/}
                <div className="App">
                    <NavLink to="/" style={{textDecoration:'none'}}>
                        <Button variant="contained">Home</Button>
                    </NavLink>
                    <NavLink to="/bookList" style={{textDecoration:'none'}}>
                        <Button variant="contained">蔵書一覧</Button>
                    </NavLink>
                    <br />

                    <Switch>
                        <Route exact path="/">
                            <Home />
                        </Route>
                        <Route path="/bookList">
                            <GetBookListApiFetch />
                        </Route>
                    </Switch>
                </div>
            </Stack>
        </>
    );
}

export default App;
