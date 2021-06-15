import React from "react";
import { Dropdown, Menu, Image } from "semantic-ui-react";

export default function SignedIn({ signOut }) {
  return (
    <div>
      <Menu.Item>
        <Image
          avatar
          spaced="right"
          src="https://media-exp3.licdn.com/dms/image/C4D03AQEDAfFvlfhhbA/profile-displayphoto-shrink_200_200/0/1616499733013?e=1628726400&v=beta&t=rQnuld-UNdd-wQuWmZ_vDlZLkxYervxRtfF8N1xjHMA"
        />
        <Dropdown pointing="top left" text="Ahmet Berkay Yılmaz">
          <Dropdown.Menu>
            <Dropdown.Item text="Bilgilerim" icon="info" />
            <Dropdown.Item onClick={signOut} text="Çıkış Yap" icon="sign-out" />
          </Dropdown.Menu>
        </Dropdown>
      </Menu.Item>
    </div>
  );
}
