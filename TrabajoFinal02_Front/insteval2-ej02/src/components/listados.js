import { useState, useEffect } from "react";
import { Link} from 'react-router-dom';

function Listados(props){
    const [dataClientes, setDataClientes] = useState([]);
    const [dataProductos, setDataProductos] = useState([]);

    useEffect(() => {
      const listarClientes = async () => {
        try {
          const response = await fetch("http://localhost:8081/cliente/listado");
          const dataClientes = await response.json();
  
          setDataClientes(dataClientes);
        } catch (error) {
          console.error("Error:", error);
        }
      };
      listarClientes().catch(null);
    }, []);
  
    useEffect(() => {
        const listarProductos = async () => {
          try {
            const response = await fetch("http://localhost:8081/producto/listado");
            const dataProductos = await response.json();
    
            setDataProductos(dataProductos);
          } catch (error) {
            console.error("Error:", error);
          }
        };
        listarProductos().catch(null);
      }, []);
   
    return (
      <div className="container-fluid py-5 mt-5">
        <div className="row justify-content-md-center text-center">

          {/******************* Listado de Productos *********************/}
          <h1 className="mb-5 titulo">Listado de Productos</h1>
        
          {!dataProductos.length && <p className="alerta">No se encontraron productos</p>}
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
                <th></th>
                <th></th>
              </tr>
            </thead>
            <tbody>
            {dataProductos.map((value, index) => (
                <tr key={index} className={index % 2 === 0 ? 'even-row' : 'odd-row'}>
                  <td>{value.idProducto}</td>
                  <td>{value.codigoEan}</td>
                  <td>{value.nombreProducto}</td>
                  <td>{value.descripcionProducto}</td>
                  <td>{value.tipo}</td>
                  <td>{value.marca}</td>
                  <td>{value.precio}</td>
                  <td>{value.stock}</td>
                  <td><Link to="/editarproducto"  state={{producto: value, titulo: "Editar Producto"}}  >Editar</Link></td>
                  <td><Link to="/borrarproducto" state={{producto: value, titulo: "Confirmar borrado:"}} >Eliminar</Link></td>
                </tr>
              ))}
            </tbody>
          </table>
          <div className="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
            <Link to="/nuevoproducto" state={{titulo: "Nuevo Producto"}} className="btn btn-outline-danger me-md-2">Nuevo Producto</Link>
          </div>

          {/******************* Listado de Clientes *********************/}

          <h1 className="mb-5 mt-5 titulo">Listado de Clientes</h1>
        
          {!dataClientes.length && <p className="alerta">No se encontraron clientes</p>}
          <table className="table">
            <thead>
              <tr className="table-primary">
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Fecha de ingreso </th>
                <th>Domicilio</th>
                <th>Teléfono</th>
                <th></th>
                <th></th>
              </tr>
            </thead>
            <tbody>
            {dataClientes.map((value, index) => (
                <tr key={index} className={index % 2 === 0 ? 'even-row' : 'odd-row'}>
                  <td>{value.idCliente}</td>
                  <td>{value.nombre}</td>
                  <td>{value.apellido}</td>
                  <td>{value.fechaIngreso}</td>
                  <td>{value.domicilio}</td>
                  <td>{value.telefono}</td>
                  <td><Link to="/editarcliente"  state={{cliente: value, titulo: "Editar Cliente"}}  >Editar</Link></td>
                  <td><Link to="/borrarcliente" state={{cliente: value}} >Eliminar</Link></td>
                </tr>
              ))}
            </tbody>
          </table>
          <div className="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
            <Link to="/nuevocliente" state={{titulo: "Cargar nuevo Cliente:"}} className="btn btn-outline-danger me-md-2">Nuevo Cliente</Link>
          </div>
        </div>
      </div>
     
    );

    
}

export default Listados;