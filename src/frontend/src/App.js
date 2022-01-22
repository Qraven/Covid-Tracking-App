import './App.css';
import React from 'react'
import {  Sidebar  } from './Sidebar.js';

import {Navigation} from 'react-minimal-side-navigation';
import 'react-minimal-side-navigation/lib/ReactMinimalSideNavigation.css';
import Routes from './routes.js';

const App = () => {
  
  return (
    <>
      <Routes></Routes>
      <Sidebar/>

    </>
  )
}

export default App