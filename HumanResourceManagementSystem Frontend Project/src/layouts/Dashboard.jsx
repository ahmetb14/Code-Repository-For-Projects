import React from "react";
import { Grid } from "semantic-ui-react";
import SideMenu from "../layouts/SideMenu";
import Fragment from "../layouts/Fragment";

export default function Dashboard() {
  return (
    <div>
      <Grid>
        <Grid.Row>
          <Grid.Column width={2}>
            <SideMenu />
          </Grid.Column>
          <Grid.Column width={14}>
            <Fragment />
          </Grid.Column>
        </Grid.Row>
      </Grid>
      <br />
    </div>
  );
}
