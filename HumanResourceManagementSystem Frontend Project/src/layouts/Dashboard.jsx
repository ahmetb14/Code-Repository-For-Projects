import React from "react";
import { Grid } from "semantic-ui-react";
import SideMenu from "../layouts/SideMenu";
import { Route } from "react-router";
import JobAdvertisementDirectory from "../pages/JobAdvertisementDirectory";
import JobPositionDirectory from "../pages/JobPositionDirectory";
import EmployerDirectory from "../pages/EmployerDirectory";

export default function Dashboard() {
  return (
    <div>
      <Grid>
        <Grid.Row>
          <Grid.Column width={2}>
            <SideMenu />
          </Grid.Column>
          <Grid.Column width={14}>
            <Route
              exact
              path="/JobAdvertisementDirectory"
              component={JobAdvertisementDirectory}
            />
            <Route
              exact
              path="/EmployerDirectory"
              component={EmployerDirectory}
            />
            <Route
              exact
              path="/JobPositionDirectory"
              component={JobPositionDirectory}
            />
          </Grid.Column>
        </Grid.Row>
      </Grid>
      <br />
    </div>
  );
}
