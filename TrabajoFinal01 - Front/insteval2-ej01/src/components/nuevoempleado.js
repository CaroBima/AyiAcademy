import { Link } from "react-router-dom";
import {useState} from 'react';


function NuevoEmpleado() {

  const [legajo, setLegajo] =  useState('');
  const [nombreEmpleado, setNombreEmpleado]  = useState('');
  const [apellidoEmpleado, setApellidoEmpleado] =  useState('');
  const [cargo, setCargo] =  useState('');
  const [sucursal, setSucursal] =  useState('');
  const [antiguedadAnios, setAntiguedadAnios] =  useState('');
  
  const guardarEmpleado= async () => {
    setLegajo('');
    try {
      await fetch("http://localhost:8081/nuevoempleado", {
        crossDomain: true,
        method: "POST",
        headers: {
          'Content-Type':'application/json',
        },
        body: JSON.stringify({
          legajo,
          nombreEmpleado,
          apellidoEmpleado,
          cargo,
          sucursal,
          antiguedadAnios,
        }), 
      });
      alert("Empleado registrado");
    } catch (error) {
      console.error("Error:", error);
    }
   };

  const handleNombreEmpleado = (event) => {
    setNombreEmpleado(event.target.value);
  };

  const handleApellidoEmpleado = (event) => {
    setApellidoEmpleado(event.target.value);
  };

  const handleCargo = (event) => {
    setCargo(event.target.value);
  };

  const handleSucursal= (event) => {
    setSucursal(event.target.value);
  };
  
  const handleAntiguedad = (event) => {
    setAntiguedadAnios(event.target.value);
  };
  
  const handleGuardado = (event) =>{
    event.preventDefault();
    guardarEmpleado();
    window.location='./listarempleados';
 }
  
  return (
    <>
      <div className="container-fluid py-5 mt-5">
        <div className="row justify-content-md-center">
          <div className="col-md-6">
            <h1>Editar empleado:</h1>
            <form name="formValid" method="post">
              <input type="hidden" name="legajo" defaultValue={legajo}  />
              <div className="mb-1">
                <label forhtml="nombre" className="form-label">
                  Nombre:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="nombre"
                  id="nombre"
                  value={nombreEmpleado}
                  onChange={handleNombreEmpleado}
                  required
                />
              </div>
              <div className="mb-1">
                <label forhtml="apellidoEmpleado" className="form-label">
                  Apellido:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="apellidoEmpleado"
                  id="apellidoEmpleado"
                  value={apellidoEmpleado}
                  onChange={handleApellidoEmpleado}
                  required
                />
              </div>
              <div className="mb-1">
                <label forhtml="cargo" className="form-label">
                  Cargo:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="cargo"
                  id="cargo"
                  value={cargo}
                  onChange={handleCargo}
                  required
                />
              </div>
              <div className="mb-1">
                <label forhtml="sucursal" className="form-label">
                  Sucursal:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="sucursal"
                  id="sucursal"
                  value={sucursal}
                  onChange={handleSucursal}
                  required
                />
              </div>
              <div className="mb-1">
                <label forhtml="antiguedadAnios" className="form-label">
                  Antigüedad:
                </label>
                <input
                  type="number"
                  className="form-control"
                  name="antiguedadAnios"
                  id="antiguedadAnios"
                  value={antiguedadAnios}
                  onChange={handleAntiguedad}
                />
              </div>
              <div className="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
                <input
                  type="submit"
                  name="guardar"
                  value="Guardar"
                  className="btn btn-outline-danger me-md-2"
                  onClick={handleGuardado}
                />
                <Link
                  to="/listarempleados"
                  className="btn btn-outline-danger me-md-2"
                >
                  Volver
                </Link>
              </div>
            </form>
          </div>
        </div>
      </div>
    </>
  );
}

export default NuevoEmpleado;
