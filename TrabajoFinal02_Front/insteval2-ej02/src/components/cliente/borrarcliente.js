import { Link, useLocation } from "react-router-dom";
import { useState } from "react";


function BorrarCliente(){
  const location = useLocation() ?? {};
  const {cliente} = location?.state;
  const [idCliente, setIdCliente] = useState(cliente.idCliente);

  const url = "http://localhost:8081/cliente/borrar/" + cliente.idCliente;
  
  const borrarCli = async () => {
    
    setIdCliente(cliente.idCliente);
    
    try {
      await fetch(url, {
        crossDomain: true,
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
            idCliente,
        }),
      });
    } catch (error) {
      console.error("Error:", error);
    }
  };

  const handleBorrado = (event) => {
    event.preventDefault();
    borrarCli();
    alert("El registro ha sido eliminado");
    window.location = "./listados";
  };

    return(
        <>
       <div className="container-fluid py-5 mt-5">
        <div className="row justify-content-md-center text-center">
          <h1 className="titulo text-center">Confirmar borrado:</h1>
          <p className="alerta text-center">
            Estás a punto de borrar al siguiente cliente:
          </p>
          <table className="table">
            <thead>
              <tr className="table-primary">
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Fecha Ingreso </th>
                <th>Domicilio</th>
                <th>Teléfono</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{cliente.idCliente}</td>
                <td>{cliente.nombre}</td>
                <td>{cliente.apellido}</td>
                <td>{cliente.fechaIngreso}</td>
                <td>{cliente.domicilio}</td>
                <td>{cliente.telefono}</td>
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
              to="/listados"
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

export default BorrarCliente;