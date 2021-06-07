import React from "react";
import CartSummary from "./CartSummary";
import { Button, Container, Menu } from "semantic-ui-react";

export default function Navi() {
  return (
    <div>
      <Menu inverted fixed="top">
        <Container>
          <Menu.Item name="Northwind System App" />
          <Menu.Item name="Ana Sayfa" />

          <Menu.Menu position="right">
            <CartSummary />
            <Menu.Item>
              <Button primary>Üye Ol</Button>
            </Menu.Item>
          </Menu.Menu>
        </Container>
      </Menu>
    </div>
  );
}
