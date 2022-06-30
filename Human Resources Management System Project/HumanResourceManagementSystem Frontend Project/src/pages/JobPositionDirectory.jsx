import React from "react";
import { useState, useEffect } from "react";
import { Table, Header, Icon } from "semantic-ui-react";
import JobPositionService from "../services/jobPositionService";

export default function JobPositionDirectory() {
  const [positions, setPositions] = useState([]);

  useEffect(() => {
    let jobPositionService = new JobPositionService();
    jobPositionService
      .getJobPositions()
      .then((result) => setPositions(result.data.data));
  }, []);

  return (
    <div>
      <Header as="h2">
        <Icon name="clone outline" />
        <Header.Content>İş Pozisyonu Listesi</Header.Content>
      </Header>
      <Table color="brown" key="brown">
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell>İş Pozisyonları</Table.HeaderCell>
          </Table.Row>
        </Table.Header>
        <Table.Body>
          {positions.map((position) => (
            <Table.Row key={position.id}>
              <Table.Cell>{position.title}</Table.Cell>
            </Table.Row>
          ))}
        </Table.Body>
      </Table>
    </div>
  );
}
