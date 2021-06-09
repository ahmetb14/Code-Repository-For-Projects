import React from "react";
import { Icon, Menu } from "semantic-ui-react";

export default function SideMenu() {
  return (
    <div>
      <Menu inverted icon="labeled" vertical>
        <Menu.Item name="address book">
          <Icon name="address book" />
          Pozisyonlar
        </Menu.Item>
        <Menu.Item name="address card">
          <Icon name="address card" />
          İş Verenler
        </Menu.Item>
        <Menu.Item name="envelope open">
          <Icon name="envelope open" />
          İş İlanları
        </Menu.Item>
      </Menu>
    </div>
  );
}
