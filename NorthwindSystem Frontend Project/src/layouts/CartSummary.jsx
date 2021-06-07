import React from "react";
import { Dropdown } from "semantic-ui-react";
export default function CartSummary() {
  return (
    <div>
      <Dropdown item text="Diller">
        <Dropdown.Menu>
          <Dropdown.Item>Türkçe</Dropdown.Item>
          <Dropdown.Item>İngilizce</Dropdown.Item>
          <Dropdown.Item>Almanca</Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown>
    </div>
  );
}
