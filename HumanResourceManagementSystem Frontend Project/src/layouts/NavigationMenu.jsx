import React from "react";
import { Button, Icon, Menu } from "semantic-ui-react";
import { Container } from "semantic-ui-react";

export default function NavigationMenu() {
  return (
    <div>
      <Menu inverted fixed="top" size="large">
        <Container>
          <Menu.Item name="briefcase">
            <Icon name="briefcase" size="large" />
            HRMS App
          </Menu.Item>
          <Menu.Item name="Ana Sayfa" />
          <Menu.Item name="Kurumsal" />
          <Menu.Item name="Destek Merkezi" />
          <Menu.Menu position="right">
            <Menu.Item>
              <Button.Group>
                <Button>Giriş Yap</Button>
                <Button positive>Üye Ol</Button>
              </Button.Group>
            </Menu.Item>
          </Menu.Menu>
        </Container>
      </Menu>
    </div>
  );
}
