import React from "react";
import { Button, Menu } from "semantic-ui-react";

export default function SignedOut({ signIn }) {
  return (
    <div>
      <Menu.Item>
        <Button inverted onClick={signIn}>
          Giriş Yap
        </Button>
        <Button inverted style={{ marginLeft: "0.5em" }}>
          Üye Ol
        </Button>
      </Menu.Item>
    </div>
  );
}
