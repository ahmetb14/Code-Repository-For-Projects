import React from "react";
import { Link } from "react-router-dom";
import { Icon, Menu } from "semantic-ui-react";

export default function SideMenu() {
  return (
    <div>
      <Menu inverted icon="labeled" vertical>
        <Menu.Item name="address book" as={Link} to={"/JobPositionDirectory"}>
          <Icon name="address book" />
          Pozisyonlar
        </Menu.Item>
        <Menu.Item name="address card" as={Link} to={"/EmployerDirectory"}>
          <Icon name="address card" />
          İş Verenler
        </Menu.Item>
        <Menu.Item
          name="envelope open"
          as={Link}
          to={"/JobAdvertisementDirectory"}
        >
          <Icon name="envelope open" />
          İş İlanları
        </Menu.Item>
      </Menu>
    </div>
  );
}
