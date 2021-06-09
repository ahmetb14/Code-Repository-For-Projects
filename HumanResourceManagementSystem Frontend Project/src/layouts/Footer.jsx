import React from "react";
import { Menu } from "semantic-ui-react";

export default function NavigationMenu() {
  return (
    <div>
      <Menu inverted size="large" className="footer">
        <p className="footertext">
          Telif Hakkı © 2021 HRMS App Inc. Tüm Hakları Saklıdır.
        </p>
      </Menu>
    </div>
  );
}
