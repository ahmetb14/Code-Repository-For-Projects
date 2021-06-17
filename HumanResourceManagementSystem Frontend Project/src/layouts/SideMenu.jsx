import React from "react";
import { Link } from "react-router-dom";
import { Icon, Menu } from "semantic-ui-react";

export default function SideMenu() {
  return (
    <div>
      <Menu
        className="sidemenu"
        inverted
        icon="labeled"
        color="brown"
        vertical
        size="small"
      >
        <Menu.Item name="bookmark">
          <Icon name="bookmark" />
          Sayfa Kısımları
        </Menu.Item>
        <Menu.Item name="world" as={Link} to={"/JobPositionDirectory"}>
          <Icon name="world" />
          İş Pozisyonları
        </Menu.Item>
        <Menu.Item name="users" as={Link} to={"/EmployerDirectory"}>
          <Icon name="users" />
          İş Verenler
        </Menu.Item>
        <Menu.Item name="bell" as={Link} to={"/JobAdvertisementDirectory"}>
          <Icon name="bell" />
          İş İlanları
        </Menu.Item>
        <Menu.Item
          name="hourglass"
          as={Link}
          to={"/CreateJobAdvertisementDirectory"}
        >
          <Icon name="hourglass" />
          İş İlanı Ekle
        </Menu.Item>
      </Menu>
    </div>
  );
}
