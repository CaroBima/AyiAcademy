import { Routes, Route } from "react-router-dom"

import Login from "./components/login";
import Listados from './components/listados'
import NuevoCliente from './components/cliente/nuevocliente'
import EditarCliente from './components/cliente/editarcliente'
import BorrarCliente from './components/cliente/borrarcliente'
import BorrarProducto from './components/producto/borrarproducto'
import EditarProducto from './components/producto/editarproducto'
import NuevoProducto from  './components/producto/nuevoproducto'

import './App.css';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" exact element={<Login/>}/>
        <Route path="/listados" element={<Listados/>}/>
        <Route path="/nuevocliente" element={<NuevoCliente/>}/>
        <Route path="/editarcliente" element={<EditarCliente/>}/>
        <Route path="/borrarcliente" element={<BorrarCliente/>}/>
        <Route path="/nuevoproducto" element={<NuevoProducto/>}/>
        <Route path="/editarproducto" element={<EditarProducto/>}/>
        <Route path="/borrarproducto" element={<BorrarProducto/>}/>
      </Routes>
    </div>
  );
}

export default App;
