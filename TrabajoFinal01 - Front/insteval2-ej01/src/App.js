import 'bootstrap/dist/css/bootstrap.min.css';
import "bootstrap/dist/js/bootstrap.min.js";
import {useEffect, useState} from 'react';
import './App.css';
import ListarEmpleados from './components/listausuarios';


function App() {
  return (
    <div className="App">
      <Login/>
    </div>
  );
}


function Login(){
  const [nombreUsuario, setUsuario] = useState('');
  const [passwordUsuario, setContrasenia] = useState('');
  const [inicioSesionExitoso, setInicioSesionExitoso] = useState(false);
  const [data, setData] = useState({});
   
    const logueo = async () => {
      try {
        const response = await fetch('http://localhost:8081/login', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({ nombreUsuario, passwordUsuario }),
        });

        if(response.status === 200){
          setData(response)
          setInicioSesionExitoso(true);
          
        } else if (response.status ===409) {
          setData(response)
          setInicioSesionExitoso(false);
          alert("Usuario o contraseña incorrectos");
         
        }

      } catch (error) {
        console.error('Error:', error);
      }
    };
 
  const handleUsuario = (event) => {
    setUsuario(event.target.value);
  };

  const handleContrasenia = (event) => {
    setContrasenia(event.target.value);
  };

  const handleLogin = () => {
    logueo(); 
  };

 return (
    <div className="container-fluid py-5 mt-5">
      {inicioSesionExitoso ? (
        <LogueoExitoso nombre={nombreUsuario}/>
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
                value={nombreUsuario}
                onChange={handleUsuario}
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
                value={passwordUsuario}
                onChange={handleContrasenia}
              />
            </div>
            <div className="d-grid gap-2 col-6 mx-auto">
              <button type="submit"  className="btn btn-success" name="guardar" value="Guardar" onClick={handleLogin}>
                Ingresar
              </button>
              
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

function LogueoExitoso(usuario){
  return(
    <div>
      <ListarEmpleados titulo="Listado de empleados"/>
    </div>
  );
}

export default App;