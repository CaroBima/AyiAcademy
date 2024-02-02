import { Link, useLocation } from "react-router-dom";
import { useState } from "react";

function BorrarEmpleado(props) {
  //toma los valores  del objeto que le pasamos por props (empleado)
  const location = useLocation() ?? {};
  const { empleado } = location?.state;

  const [legajo, setLegajo] = useState(empleado.legajo);

  const url = "http://localhost:8081/borrarempleado/" + empleado.legajo;

  const borrarEmple = async () => {
    setLegajo(empleado.legajo);
    console.log(url);

    try {
      await fetch(url, {
        crossDomain: true,
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          legajo,
        }),
      });
      alert("El registro ha sido eliminado");
    } catch (error) {
      console.error("Error:", error);
    }
  };

  const handleBorrado = (event) => {
    event.preventDefault();
    borrarEmple();
    window.location = "./listarempleados";
  };
  return (
    <>
      <div className="container-fluid py-5 mt-5">
        <div className="row justify-content-md-center text-center">
          <h1>Confirmar borrado:</h1>
          <p className="alerta">
            Estás a punto de borrar al siguiente empleado:
          </p>
          <table className="table">
            <thead>
              <tr className="table-primary">
                <th>Legajo</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Cargo </th>
                <th>Sucursal</th>
                <th>Antigüedad</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{empleado.legajo}</td>
                <td>{empleado.nombreEmpleado}</td>
                <td>{empleado.apellidoEmpleado}</td>
                <td>{empleado.cargo}</td>
                <td>{empleado.sucursal}</td>
                <td>{empleado.antiguedadAnios}</td>
              </tr>
            </tbody>
          </table>

          <div className="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
            <input
              type="submit"
              name="confirmar"
              value="Confirmar"
              className="btn btn-outline-danger me-md-2"
              onClick={handleBorrado}
            />
            <Link
              to="/listarempleados" titulo="Listado de empleados"
              className="btn btn-outline-danger me-md-2"
            >
              Volver
            </Link>
          </div>
        </div>
      </div>
    </>
  );
}
export default BorrarEmpleado;
