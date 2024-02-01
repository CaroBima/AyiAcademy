import { Routes, Route } from "react-router-dom"

import 'bootstrap/dist/css/bootstrap.min.css';
import "bootstrap/dist/js/bootstrap.min.js";

import ListarEmpleados from './components/listarEmpleados.js'
import EditarEmpleado from './components/editarEmpleado.js';
import BorrarEmpleado from './components/borrarEmpleado.js';
import Login from './components/login.js';


import './App.css';

function App() {
  return (
    <div className="App">
        <Routes>
          <Route path="/" exact element={<Login/>}/>
          <Route path="/listarempleados" element={<ListarEmpleados/>} />
          <Route path="/editarempleado" element={<EditarEmpleado/>} />
          <Route path="/borrarempleado" element={<BorrarEmpleado/>} />
        </Routes>
      
    </div>
  );
}

export default App;