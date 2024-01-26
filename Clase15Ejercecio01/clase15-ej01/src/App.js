import 'bootstrap/dist/css/bootstrap.min.css';
import "bootstrap/dist/js/bootstrap.min.js";
import {createRef} from "react";
import {useState} from 'react';
import './App.css';


function App() {
  return (
    <div className="App">
      <Login/>
    </div>
  );
}


function Login(){
  const [Username, setUsuario] = useState('');
  const [contrasenia, setContrasenia] = useState('');
  const [inicioSesionExitoso, setInicioSesionExitoso] = useState(false);

  const handleIngresar = () => {
    const usuarioEncontrado = datosUsuarioJson.find(
      (usuJson) =>
      usuJson.nomUsuario === Username && usuJson.contrasenia === contrasenia
    );

    if (usuarioEncontrado) {
      setInicioSesionExitoso(true);
    } else {

      console.log(Username)
      console.log(contrasenia)
      alert('Usuario o contraseña incorrectos');
    }
  };

 return (
    <div className="container-fluid py-5 mt-5">
      {inicioSesionExitoso ? (
        <LogueoExitoso/>
      ) : (
        <div className="row justify-content-md-center">
          <div className="col-md-6 text-center">
            <div className="input-group mb-3">
              <span className="input-group-text" id="basic-addon1">
                Usuario
              </span>
              <input
                type="text"
                className="form-control"
                aria-label="Username"
                aria-describedby="basic-addon1"
                value={Username}
                onChange={(e) => setUsuario(e.target.value)}
              />
            </div>

            <div className="input-group mb-3">
              <span className="input-group-text" id="basic-addon1">
                Contraseña
              </span>
              <input
                type="password"
                className="form-control"
                aria-label="contrasenia"
                aria-describedby="basic-addon1"
                value={contrasenia}
                onChange={(e) => setContrasenia(e.target.value)}
              />
            </div>
            <div className="d-grid gap-2 col-6 mx-auto">
              <button type="submit"  className="btn btn-success" name="guardar" value="Guardar" onClick={handleIngresar}>
                Ingresar
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

function LogueoExitoso(){
  return(
    <div>
      <p>Bienvenido, has iniciado sesión con éxito.</p>
    </div>
  );
}

const datosUsuarioJson=[
  {
  nomUsuario: "usuario",
  contrasenia: "1234"
  }
];




export default App;
/*
 Crear un proyecto de React desde cero:
Editar la vista que viene por default
Crear un proyecto con formulario de login, si esta correcto el usuario y 
contraseña que se renderize el componente con el mensaje de Bienvenido 
y el nombre ingresado en el login.
*/