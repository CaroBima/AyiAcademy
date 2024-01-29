import 'bootstrap/dist/css/bootstrap.min.css';
import "bootstrap/dist/js/bootstrap.min.js";
import {createRef, useState} from 'react';
import './App.css';
import MostrarSaludoComponent from './components/saludo'


/*
3) Crear un proyecto de React desde cero:
Editar la vista que viene por default
Crear un formulario que solicite nombre y un botón de enviar, al presionarlo se abrirá un nuevo 
componente con el mensaje de bienvenida
El nuevo componente debe tener un boton que al presionarlo, cambiara de color el mensaje de bienvenida.
*/


function App() {
  const [nombre, setNombre] = useState('');
  const [mostrarSaludo, setMostrarSaludo] = useState(false);
  const cambiarColor = createRef();
  
  
  const cambiarColorBienvenida=()=>{
    cambiarColor.current.style.color='red';
  }

  const abrirSaludo = () => {
    setMostrarSaludo(true);
   
  };


  const handleInputChange = (event) => {
    setNombre(event.target.value);
  };

  const handleEnviarClick = () => {
    abrirSaludo();
  };

  return (
    <div className="row justify-content-md-center mt-5">
      <div className="col-md-6 text-center mt-5">
        <div className="form-floating mb-3">
          <input
            type="text"
            className="form-control"
            id="nombreInput"
            onChange={handleInputChange}
          />
          <label htmlFor="nombreInput">Nombre</label>
        </div>
        <button
          className="btn btn-outline-success btn-lg col-md-6"
          type="submit"
          onClick={handleEnviarClick}
        >
          Enviar
        </button>
      </div>

      <div>
        <h1 ref={cambiarColor} >{mostrarSaludo && (<MostrarSaludoComponent nombre={nombre} />)}</h1>
        <BtnCambioColor mostrarSaludo = {mostrarSaludo} cambiarColor={cambiarColor} />
      </div>
    </div>
  );
}

function BtnCambioColor({mostrarSaludo, cambiarColor}) {

  const cambiarColorBienvenida=()=>{
    if(cambiarColor.current.style.color==='red')  cambiarColor.current.style.color='blue';
    else  cambiarColor.current.style.color='red'
  }

  if (mostrarSaludo) {
    return <button className="btn btn-outline-success btn-lg col-md-3" type="submit" onClick={cambiarColorBienvenida}>Cambiar Color</button>
  }
 
}



export default App;
