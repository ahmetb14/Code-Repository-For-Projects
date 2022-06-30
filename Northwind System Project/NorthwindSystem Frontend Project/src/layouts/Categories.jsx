import React from "react";
import { Link } from "react-router-dom";
import { Menu } from "semantic-ui-react";

export default function Categories() {
  return (
    <div>
      <Menu pointing vertical>
        <Menu.Item name="Detaylar" as={Link} to={"/product/list"} />
        <Menu.Item name="Kategori" />
        <Menu.Item name="Teslimat" />
      </Menu>
    </div>
  );
}
