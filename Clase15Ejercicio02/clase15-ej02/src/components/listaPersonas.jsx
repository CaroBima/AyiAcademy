function ListaPersonas(){
    return(
        <>
        <table>
        <thead>
          <tr>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Tipo Documento</th>
            <th>DNI</th>
            <th>Estado Civil</th>
            <th>Domicilio</th>
            <th>Teléfono</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Juan</td>
            <td>Pérez</td>
            <td>DNI</td>
            <td>35123456</td>
            <td>Soltero/a</td>
            <td>Calle 123, Ciudad</td>
            <td>351-1234567</td>
          </tr>
          <tr>
            <td>Maria</td>
            <td>Gómez</td>
            <td>Pasaporte</td>
            <td>AR1234567</td>
            <td>Casado/a</td>
            <td>Avenida 456, Ciudad</td>
            <td>351-7654321</td>
          </tr>
          <tr>
            <td>Luis</td>
            <td>Rodríguez</td>
            <td>DNI</td>
            <td>35187654</td>
            <td>Viudo/a</td>
            <td>Plaza 789, Ciudad</td>
            <td>351-8901234</td>
          </tr>
          <tr>
            <td>Ana</td>
            <td>Fernández</td>
            <td>Cédula</td>
            <td>AR9876543</td>
            <td>Divorciado/a</td>
            <td>Calle 456, Ciudad</td>
            <td>351-2345678</td>
          </tr>
          <tr>
            <td>Pablo</td>
            <td>López</td>
            <td>Pasaporte</td>
            <td>AR8765432</td>
            <td>Soltero/a</td>
            <td>Avenida 789, Ciudad</td>
            <td>351-6789012</td>
          </tr>
        </tbody>
      </table>
      </>
    );
}
export default ListaPersonas;