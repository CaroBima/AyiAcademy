import { Link, useLocation } from "react-router-dom";
import { useState } from "react";

function NuevoProducto() {
  const location = useLocation() ?? {};
  const { titulo } = location.state;

  const [idProducto, setIdProducto] = useState("");
  const [codigoEan, setCodigoEan] = useState("");
  const [nombreProducto, setNombreProducto] = useState("");
  const [descripcionProducto, setDescripcionProducto] = useState("");
  const [tipo, setTipo] = useState("");
  const [marca, setMarca] = useState("");
  const [precio, setPrecio] = useState("");
  const [stock, setStock] = useState("");
  const [mostrarDatosValidos, setMostrarDatosValidos] = useState(false);

  const guardarProducto = async () => {
    setIdProducto("");
    try {
      await fetch("http://localhost:8081/producto/guardar", {
        crossDomain: true,
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          idProducto,
          codigoEan,
          nombreProducto,
          descripcionProducto,
          tipo,
          marca,
          precio,
          stock,
        }),
      });
    } catch (error) {
      console.error("Error:", error);
    }
  };

  const handleCodigoEan = (event) => {
    setCodigoEan(event.target.value);
  };

  const handleNombreProducto = (event) => {
    setNombreProducto(event.target.value);
  };

  const handleDescripcionProducto = (event) => {
    setDescripcionProducto(event.target.value);
  };

  const handleTipo = (event) => {
    setTipo(event.target.value);
  };

  const handleMarca = (event) => {
    setMarca(event.target.value);
  };

  const handlePrecio = (event) => {
    setPrecio(event.target.value);
  };

  const handleStock = (event) => {
    setStock(event.target.value);
  };

  const handleGuardado = (event) => {
    event.preventDefault();

    const datosValidos =
      codigoEan.length > 0 &&
      codigoEan.length <= 25 &&
      nombreProducto.length > 0 &&
      nombreProducto.length <= 25 &&
      descripcionProducto.length > 0 &&
      descripcionProducto.length <= 100 &&
      tipo.length > 0 &&
      tipo.length <= 15 &&
      marca.length > 0 &&
      marca.length <= 20 &&
      precio > 0 &&
      precio <= 999.99 &&
      stock >= 0;

    if (datosValidos) {
    guardarProducto();
    alert("Producto guardado correctamente");
    window.location = "./listados";
  } else {
    alert(
      "Todos los campos deben estar completos. Verificar además la longitud máxima especificada para cada campo."
    );
    setMostrarDatosValidos(true)
  }
  };

  return (
    <>
      <div className="container-fluid py-5 mt-5">
        <div className="row justify-content-md-center">
          <div className="col-md-6">
            <h1 className="mb-5 titulo">{titulo}</h1>
            <form name="formValid" method="post">
              <input type="hidden" name="legajo" value={idProducto} />
              {mostrarDatosValidos && (<div>
                                    <p>Caracteres máximos de cada campo:
                                    <br></br>
                                    Cod. Ean: 25, Nombre: 25, Descripción: 100, Tipo: 15, Marca: 20. El precio debe ser menor a 999.99</p>
                                    </div>)}
              <div className="mb-1">
                <label forhtml="codigoEan" className="form-label">
                  Codigo EAN:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="codigoEan"
                  id="codigoEan"
                  value={codigoEan}
                  onChange={handleCodigoEan}
                  required
                />
              </div>
              <div className="mb-1">
                <label forhtml="nombreProducto" className="form-label">
                  Nombre:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="nombreProducto"
                  id="nombreProducto"
                  value={nombreProducto}
                  onChange={handleNombreProducto}
                  required
                />
              </div>
              <div className="mb-1">
                <label htmlFor="descripcionProducto" className="form-label">
                  Descripción:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="descripcionProducto"
                  id="descripcionProducto"
                  value={descripcionProducto}
                  onChange={handleDescripcionProducto}
                  required
                />
              </div>
              <div className="mb-1">
                <label htmlFor="tipo" className="form-label">
                  Tipo:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="tipo"
                  id="tipo"
                  value={tipo}
                  onChange={handleTipo}
                  required
                />
              </div>
              <div className="mb-1">
                <label htmlFor="marca" className="form-label">
                  Marca:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="marca"
                  id="marca"
                  value={marca}
                  onChange={handleMarca}
                />
              </div>
              <div className="mb-1">
                <label htmlFor="precio" className="form-label">
                  Precio:
                </label>
                <input
                  type="number"
                  className="form-control"
                  name="precio"
                  id="precio"
                  value={precio}
                  onChange={handlePrecio}
                />
              </div>
              <div className="mb-1">
                <label htmlFor="stock" className="form-label">
                  Stock:
                </label>
                <input
                  type="number"
                  className="form-control"
                  name="stock"
                  id="stock"
                  value={stock}
                  onChange={handleStock}
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

export default NuevoProducto;
