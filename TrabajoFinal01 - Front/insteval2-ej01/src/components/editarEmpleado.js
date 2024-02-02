import { Link, useLocation } from "react-router-dom";
import { useState } from "react";

function EditarEmpleado() {

  
  //toma los valores  del objeto que le pasamos por props (empleado)
  const location = useLocation() ?? {};
  const { empleado } = location?.state;

  //para tomar los valores del form y pasarlos al back
  const [legajo, setLegajo] = useState(empleado.legajo);
  const [nombreEmpleado, setNombreEmpleado] = useState(empleado.nombreEmpleado);
  const [apellidoEmpleado, setApellidoEmpleado] = useState(empleado.apellidoEmpleado);
  const [cargo, setCargo] = useState(empleado.cargo);
  const [sucursal, setSucursal] = useState(empleado.sucursal);
  const [antiguedadAnios, setAntiguedadAnios] = useState(empleado.antiguedadAnios);
 

    
  const editEmple = async () => {
    setLegajo(empleado.legajo);
    try {
      await fetch("http://localhost:8081/editarempleado", {
        crossDomain: true,
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
          antiguedadAnios
        }),
      });
      alert("Se ha actualizado el registro");
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

  
  const handleGuardado = (event) =>{
    event.preventDefault();
    editEmple();
    window.location='./listarempleados';
            
  }

  return (
    <>
      <div className="container-fluid py-5 mt-5">
        <div className="row justify-content-md-center">
          <div className="col-md-6">
            <h1>Editar empleado:</h1>

            <form name="formValid" method="put">
              <input type="hidden" name="legajo" defaultValue={empleado.legajo} />
              <div className="mb-1">
                <label forHtml="nombre" className="form-label">
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
                  name="actualizar"
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
