import React from 'react';
import './App.css';

import {Route, Switch} from "react-router-dom";
import Home from "./pages/Home";
import {Stack} from "@mui/material";
import SideBar from "./pages/SideBar";
import BookList from "./pages/BookList";
import AddBook from "./pages/AddBook";

function App() {
    return (
        <>
            <Stack direction={'row'}>
                <SideBar />
                <div className="Contents">
                    {/*<Menu />*/}
                    <Switch>
                        <Route exact path="/">
                            <Home />
                        </Route>
                        <Route path="/bookList">
                            <BookList />
                        </Route>
                        <Route path="/addBook">
                            <AddBook />
                        </Route>
                    </Switch>
                </div>
            </Stack>
        </>
    );
}

export default App;
