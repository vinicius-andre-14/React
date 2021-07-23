
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import BarraNavegacao from './Componentes/BarraNavegacao';
import Footer from './Componentes/Footer';
import Home from './Componentes/Home';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListaLendas from './Componentes/ListaLendas';

import CreateUpdateLenda from './Componentes/CreateUpdateLenda';

function App() {
  return (    
    <div className="App">
      <Router>
          <BarraNavegacao/>
          <Switch>
            <Route exact path="/" component={Home}></Route>
            <Route exact path="/lenda" component={ListaLendas}></Route>
            <Route path="/lendas/:id" component={CreateUpdateLenda}></Route>

          </Switch>
          <Footer/>
      </Router>    
    </div>
  );
}

export default App;
