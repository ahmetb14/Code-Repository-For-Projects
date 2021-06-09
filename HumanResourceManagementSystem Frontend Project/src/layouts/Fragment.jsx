import React from "react";
import { Grid, GridColumn } from "semantic-ui-react";
import JobPositionDirectory from "../pages/JobPositionDirectory";
import EmployerDirectory from "../pages/EmployerDirectory";
import JobAdvertisementDirectory from "../pages/JobAdvertisementDirectory";

export default function Fragment() {
  return (
    <div>
      <Grid>
        <Grid.Row>
          <GridColumn size={14}>
            <JobPositionDirectory />
          </GridColumn>
        </Grid.Row>
        <Grid.Row>
          <GridColumn size={14}>
            <EmployerDirectory />
          </GridColumn>
        </Grid.Row>
        <Grid.Row>
          <GridColumn size={14}>
            <JobAdvertisementDirectory />
          </GridColumn>
        </Grid.Row>
      </Grid>
    </div>
  );
}
