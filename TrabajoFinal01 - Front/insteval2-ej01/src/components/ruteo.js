import React from 'react';
import { Routes, Route} from 'react-router-dom';
import ListarEmpleados from './listarEmpleados.js';
import EditarEmpleado from './editarEmpleado.js';
import BorrarEmpleado from './borrarEmpleado.js';
import Login from './login.js';


const Ruteo = () => {
  return (
    <Routes>
        <Route path="/" exact component={Login}></Route>
        <Route path="/listarempleados" component={<ListarEmpleados/>} />
        <Route path="/editarempleado/:id" element={<EditarEmpleado/>} />
        <Route path="/borrarempleado/:id" component={<BorrarEmpleado/>} />
    </Routes>
   
  );
  
};

export default Ruteo;