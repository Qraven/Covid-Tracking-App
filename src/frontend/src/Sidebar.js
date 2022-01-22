import './App.css';
import React from 'react'
import TotalCases from './TotalCases';
import CountryCases from './CountryCases';
import { useHistory } from "react-router-dom";
import { useLocation } from "react-router-dom";


import {Navigation} from 'react-minimal-side-navigation';
import 'react-minimal-side-navigation/lib/ReactMinimalSideNavigation.css';
import './Sidebar.css';

export const Sidebar = () => {

    

    return (
        <>
            <a href="/totalCases">Total Cases</a>
            <br></br>
            <a href="/countryCases">Country Cases</a>
        </>
  );
}