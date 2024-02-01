import { useState, useEffect } from "react";
import { Link} from 'react-router-dom';


function ListarEmpleados(props) {
  const [data, setData] = useState([]);

  useEffect(() => {
    const listarEmpleados = async () => {
      try {
        const response = await fetch("http://localhost:8081/listaempleados");
        const data = await response.json();

        setData(data);
      } catch (error) {
        console.error("Error:", error);
      }
    };
    listarEmpleados().catch(null);
  }, []);

 
  return (
    <div className="container-fluid py-5 mt-5">
      <div className="row justify-content-md-center text-center">
        <h1 className="mb-5">{props.titulo}</h1>
      
        {!data.length && <p className="alerta">No se encontraron empleados</p>}
        <table className="table">
          <thead>
            <tr className="table-primary">
              <th>Legajo</th>
              <th>Nombre</th>
              <th>Apellido</th>
              <th>Cargo </th>
              <th>Sucursal</th>
              <th>Antigüedad</th>
              <th></th>
              <th></th>
            </tr>
          </thead>
          <tbody>
          {data.map((value, index) => (
              <tr key={index} className={index % 2 === 0 ? 'even-row' : 'odd-row'}>
                <td>{value.legajo}</td>
                <td>{value.nombreEmpleado}</td>
                <td>{value.apellidoEmpleado}</td>
                <td>{value.cargo}</td>
                <td>{value.sucursal}</td>
                <td>{value.antiguedadAnios}</td>
                <td><Link to="/editarempleado"  state={{empleado: value}}  >Editar</Link></td>
                <td><Link to="/borrarempleado">Eliminar</Link></td>
              </tr>
            ))}
          </tbody>
        </table>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
          <Link to="/nuevoempleado" class="btn btn-outline-danger me-md-2">Nuevo Empleado</Link>
        </div>
      </div>
    </div>
   
  );

  
}




export default ListarEmpleados;

