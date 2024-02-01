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
    <div>
      <h1 className="mb-5">{props.titulo}</h1>
    

      {!data.length && <p>No existen resultados</p>}
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
              <td><Link to="/editarempleado"  state={{datos: value}} >Editar</Link></td>
              <td><Link to="/borrarempleado">Eliminar</Link></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
   
  );

  
}




export default ListarEmpleados;

