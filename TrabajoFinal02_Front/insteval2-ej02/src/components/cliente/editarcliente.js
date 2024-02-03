import { Link, useLocation } from "react-router-dom";
import { useState } from "react";

function EditarCliente() {
  const location = useLocation() ?? {};
  const { cliente, titulo } = location?.state;

  const [idCliente, setIdCliente] = useState(cliente.idCliente);
  const [nombre, setNombre] = useState(cliente.nombre);
  const [apellido, setApellido] = useState(cliente.apellido);
  const [fechaIngreso, setFechaIngreso] = useState(cliente.fechaIngreso);
  const [domicilio, setDomicilio] = useState(cliente.domicilio);
  const [telefono, setTelefono] = useState(cliente.telefono);
  const [validarDatos, setValidarDatos] = useState(true);

  const editCliente = async () => {
    setIdCliente(cliente.idCliente);
    try {
      await fetch("http://localhost:8081/cliente/editar", {
        crossDomain: true,
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          idCliente,
          nombre,
          apellido,
          fechaIngreso,
          domicilio,
          telefono,
        }),
      });
    } catch (error) {
      console.error("Error:", error);
    }
  };

  const handleNombre = (event) => {
    setNombre(event.target.value);

  };

  const handleApellido = (event) => {
    setApellido(event.target.value);
  };

  const handleFechaIngreso = (event) => {
    setFechaIngreso(event.target.value);
  };

  const handleDomicilio = (event) => {
    setDomicilio(event.target.value);
  };

  const handleTelefono = (event) => {
    setTelefono(event.target.value);
  };

  const handleGuardado = (event) => {
    event.preventDefault();

    const datosValidos =
    nombre.length > 0 &&
    nombre.length <= 25 &&
    apellido.length > 0 &&
    apellido.length <= 25 &&
    domicilio.length > 0 &&
    domicilio.length <= 25 &&
    telefono.length <= 15 &&
    telefono.length >= 0;

 
    if (datosValidos) {
      editCliente();
      alert("El cliente ha sido editado");
      window.location = "./listados";
    } else {
      alert("Hay errores en los datos del formulario. Los campos deben estar completos y no tener más de 25 caracteres, salvo el telefono que soporta 15 como máximo");
    }
  };
  return (
    <>
      <div className="container-fluid py-5 mt-5 ">
        <div className="row justify-content-md-center">
          <div className="col-md-6">
            <h1 className="titulo mb-4 text-center">{titulo}</h1>

            <form name="formValid" method="put">
              <input
                type="hidden"
                name="legajo"
                defaultValue={cliente.idCliente}
              />
              <div className="mb-1">
                <label htmlFor="nombre" className="form-label">
                  Nombre:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="nombre"
                  id="nombre"
                  defaultValue={cliente.nombre}
                  onChange={handleNombre}
                  required
                />
              </div>
              <div className="mb-1">
                <label htmlFor="apellidoCliente" className="form-label">
                  Apellido:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="apellidoCliente"
                  id="apellidoCliente"
                  defaultValue={cliente.apellido}
                  onChange={handleApellido}
                  required
                />
              </div>
              <div className="mb-1">
                <label htmlFor="fecha" className="form-label">
                  Fecha de ingreso:
                </label>
                <input
                  type="date"
                  className="form-control"
                  name="fecha"
                  id="fecha"
                  defaultValue={cliente.fechaIngreso}
                  onChange={handleFechaIngreso}
                  required
                />
              </div>
              <div className="mb-1">
                <label htmlFor="domicilio" className="form-label">
                  Domicilio:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="domicilio"
                  id="domicilio"
                  defaultValue={cliente.domicilio}
                  onChange={handleDomicilio}
                  required
                />
              </div>
              <div className="mb-1">
                <label htmlFor="telefono" className="form-label">
                  Teléfono:
                </label>
                <input
                  type="number"
                  className="form-control"
                  name="telefono"
                  id="telefono"
                  defaultValue={cliente.telefono}
                  onChange={handleTelefono}
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
                <Link to="/listados" className="btn btn-outline-danger me-md-2">
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

export default EditarCliente;
