import "./App.css";
import { Container } from "semantic-ui-react";
import "semantic-ui-css/semantic.min.css";
import NavigationMenu from "./layouts/NavigationMenu";
import Dashboard from "./layouts/Dashboard";
import Footer from "./layouts/Footer";

function App() {
  return (
    <div className="App">
      <NavigationMenu />
      <Container className="main">
        <Dashboard />
      </Container>
      <Footer />
    </div>
  );
}

export default App;
