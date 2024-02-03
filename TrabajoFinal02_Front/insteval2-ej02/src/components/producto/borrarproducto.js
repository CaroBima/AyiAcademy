import { Link, useLocation } from "react-router-dom";
import { useState } from "react";


function BorrarProducto(){
    const location = useLocation() ?? {};
    const {producto, titulo} = location?.state;
    const [idProducto, setIdProducto] = useState(producto.idProducto);

    const url = "http://localhost:8081/producto/borrar/" + producto.idProducto;

    const borrarProd = async () => {
    
        setIdProducto(producto.idProducto);
        
        try {
          await fetch(url, {
            crossDomain: true,
            method: "DELETE",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify({
                idProducto,
            }),
          });
        } catch (error) {
          console.error("Error:", error);
        }
      };
    
      const handleBorrado = (event) => {
        event.preventDefault();
        borrarProd();
        alert("El producto ha sido eliminado");
        window.location = "./listados";
      };
    
        return(
            <>
           <div className="container-fluid py-5 mt-5">
            <div className="row justify-content-md-center text-center">
              <h1 className="titulo">{titulo}</h1>
              <p className="alerta">
                Estás a punto de borrar al siguiente producto:
              </p>
              <table className="table">
                <thead>
                  <tr className="table-primary">
                    <th>Id</th>
                    <th>Código EAN</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Tipo</th>
                    <th>Marca</th>
                    <th>Precio</th>
                    <th>Stock</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>{producto.idProducto}</td>
                    <td>{producto.codigoEan}</td>
                    <td>{producto.nombreProducto}</td>
                    <td>{producto.descripcionProducto}</td>
                    <td>{producto.tipo}</td>
                    <td>{producto.marca}</td>
                    <td>{producto.precio}</td>
                    <td>{producto.stock}</td>
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

export default BorrarProducto;