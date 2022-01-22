import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";

import TotalCases from "./TotalCases"
import CountryCases from "./CountryCases";

const Routes = () => {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/totalCases">
          <TotalCases />
        </Route>
        <Route path="/countryCases">
          <CountryCases />
        </Route>
      </Switch>
    </BrowserRouter>
  );
};

export default Routes;
