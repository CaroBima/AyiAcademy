import { Link, useLocation } from "react-router-dom";
import { useState } from "react";

function EditarEmpleado() {
  //toma los valores  del objeto que le pasamos por props (empleado)
  const location = useLocation();
  const { empleado } = location.state;

  //para tomar los valores del form y pasarlos al back
  const [legajo, setLegajo] = useState("");
  const [nombreEmpleado, setNombreEmpleado] = useState("");
  const [apellidoEmpleado, setApellidoEmpleado] = useState("");
  const [cargo, setCargo] = useState("");
  const [sucursal, setSucursal] = useState("");
  const [antiguedadAnios, setAntiguedadAnios] = useState("");

  const editEmple = async () => {
    try {
      const response = await fetch("http://localhost:8081/editarempleado", {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
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
    } catch (error) {
      console.error("Error:", error);
    }
  };

  const handleNombre = (event) => {
    setNombreEmpleado(event.target.value);
  };

  const handleApellido = (event) => {
    setApellidoEmpleado(event.target.value);
  };

  const handleCargo = (event) => {
    setCargo(event.target.value);
  };

  const handleSucursal = (event) => {
    setSucursal(event.target.value);
  };

  const handleAntiguedad = (event) => {
    setAntiguedadAnios(event.target.value);
  };

  //ver aca, para guardar los valores que estan en el default en caso de que no se hayan editado
  const handleGuardado = (event) =>{
    console.log(empleado.legajo)
    if(legajo===""){
        console.log("entra al if")
        setLegajo(empleado.legajo);
    }
   

    if(nombreEmpleado===''){
        setNombreEmpleado(event.target.defaultValue);
    }

   
    editEmple();
    <Link to="/listarempleados" className="btn btn-outline-danger me-md-2"/>
            
  }

  return (
    <>
      <div className="container-fluid py-5 mt-5">
        <div className="row justify-content-md-center">
          <div className="col-md-6">
            <h1>Editar empleado:</h1>

            <form name="formValid" method="post">
              <input type="hidden" name="idProveedor" />
              <div className="mb-1">
                <label for="nombre" className="form-label">
                  Nombre:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="nombre"
                  id="nombre"
                  defaultValue={empleado.nombreEmpleado}
                  onChange={handleNombre}
                  required
                />
              </div>
              <div class="mb-1">
                <label for="apellidoEmpleado" className="form-label">
                  Apellido:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="apellidoEmpleado"
                  id="apellidoEmpleado"
                  defaultValue={empleado.apellidoEmpleado}
                  onChange={handleApellido}
                  required
                />
              </div>
              <div className="mb-1">
                <label for="cargo" className="form-label">
                  Cargo:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="cargo"
                  id="cargo"
                  defaultValue={empleado.cargo}
                  onChange={handleCargo}
                  required
                />
              </div>
              <div class="mb-1">
                <label for="sucursal" className="form-label">
                  Sucursal:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="sucursal"
                  id="sucursal"
                  defaultValue={empleado.sucursal}
                  onChange={handleSucursal}
                  required
                />
              </div>
              <div className="mb-1">
                <label for="antiguedadAnios" className="form-label">
                  Antigüedad:
                </label>
                <input
                  type="number"
                  className="form-control"
                  name="antiguedadAnios"
                  id="antiguedadAnios"
                  defaultValue={empleado.antiguedadAnios}
                  onChange={handleAntiguedad}
                />
              </div>
              <div className="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
                <input
                  type="submit"
                  name="guardar"
                  value="Actualizar"
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
export default EditarEmpleado;
