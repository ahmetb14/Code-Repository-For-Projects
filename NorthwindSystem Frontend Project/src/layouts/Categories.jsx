import React from "react";
import { Menu } from "semantic-ui-react";

export default function Categories() {
  return (
    <div>
      <Menu pointing vertical>
        <Menu.Item name="Products" />
        <Menu.Item name="Categories" />
        <Menu.Item name="Prices" />
      </Menu>
    </div>
  );
}
