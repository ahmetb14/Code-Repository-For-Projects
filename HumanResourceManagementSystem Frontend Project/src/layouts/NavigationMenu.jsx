import React, { useState } from "react";
import { Link } from "react-router-dom";
import { Icon, Menu } from "semantic-ui-react";
import SignedOut from "../layouts/SignedOut";
import SignedIn from "../layouts/SignedIn";
import { Container } from "semantic-ui-react";
import { useHistory } from "react-router";

export default function NavigationMenu() {
  const [isAuthenticated, setIsAuthenticated] = useState(true);

  const history = useHistory();

  function handleSignOut() {
    setIsAuthenticated(false);
    history.push("/");
  }

  function handleSignIn() {
    setIsAuthenticated(true);
  }

  return (
    <div>
      <Menu className="navi" inverted fixed="top" size="big">
        <Container>
          <Menu.Item name="briefcase">
            <Icon name="briefcase" size="large" />
            HRMS App
          </Menu.Item>
          <Menu.Item name="Ana Sayfa" as={Link} to={"/"} />
          <Menu.Item name="Kurumsal" />
          <Menu.Item name="Destek Merkezi" />
          <Menu.Menu position="right">
            {isAuthenticated ? (
              <SignedIn signOut={handleSignOut} bisey="1" />
            ) : (
              <SignedOut signIn={handleSignIn} />
            )}
          </Menu.Menu>
        </Container>
      </Menu>
    </div>
  );
}
