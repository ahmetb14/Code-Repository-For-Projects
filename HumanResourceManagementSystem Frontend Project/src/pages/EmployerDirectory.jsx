import React, { useState, useEffect } from "react";
import { Table, Header, Icon, Button } from "semantic-ui-react";
import EmployerService from "../services/employerService";

export default function EmployerDirectory() {
  const [employers, setEmployers] = useState([]);

  useEffect(() => {
    let employerService = new EmployerService();
    employerService
      .getEmployers()
      .then((result) => setEmployers(result.data.data));
  }, []);

  return (
    <div>
      <Header as="h2">
        <Icon name="list alternate outline" />
        <Header.Content>İş Veren Listesi</Header.Content>
      </Header>
      <Table color="orange" key="orange">
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell>Şirket İsmi</Table.HeaderCell>
            <Table.HeaderCell>Web Site Adresi</Table.HeaderCell>
            <Table.HeaderCell>Email Adresi</Table.HeaderCell>
            <Table.HeaderCell>Hızlı İletişim</Table.HeaderCell>
          </Table.Row>
        </Table.Header>
        <Table.Body>
          {employers.map((employer) => (
            <Table.Row key={employer.id}>
              <Table.Cell>{employer.companyName}</Table.Cell>
              <Table.Cell>{employer.webAdress}</Table.Cell>
              <Table.Cell>{employer.email}</Table.Cell>
              <Table.Cell>
                <Button>İletişim</Button>
              </Table.Cell>
            </Table.Row>
          ))}
        </Table.Body>
      </Table>
    </div>
  );
}
