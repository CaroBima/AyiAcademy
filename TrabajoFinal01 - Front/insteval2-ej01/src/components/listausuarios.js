import { useState, useEffect } from "react";

function ListarEmpleados(props) {
  const [data, setData] = useState([]);

  useEffect(() => {
    const listarEmpleados = async () => {
      try {
        const response = await fetch("http://localhost:8081/listaempleados");
        const data = await response.json();

        setData(data);
        console.log(response);
        console.log(data);
      } catch (error) {
        console.error("Error:", error);
      }
    };
    listarEmpleados().catch(null);
  }, []);
  return (
    <div>
      <h1>{props.titulo}</h1>
      <br />
      <br />
      <br />

      {!data.length && <p>No existen resultados</p>}
      <table class="table">
        <thead>
          <tr class="table-primary">
            <th>Legajo</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Cargo </th>
            <th>Sucursal</th>
            <th>Antigüedad</th>
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
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
export default ListarEmpleados;
