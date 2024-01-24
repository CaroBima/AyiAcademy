
import './App.css';

function App() {
  return (
    <div className="App">
      <h1>Login</h1>
      <form>
        <label for="nombreUsuario">Usuario: </label>
        <input type="text" id="nombreUsuario" name="nombreUsuario"/>
        <br/>
        <label for="passUsuario">Contraseña: </label>
        <input type="password" id="passUsuario" name="passUsuario"/>
        <br/>
        <input type="submit" value="Ingresar"/>
      </form>
      <RegistrarUsuario/>
    </div>
  );
}

function RegistrarUsuario(){

return (
    <div className="registrarUsuario">
      <h1>Registro de usuario</h1>
      <form>
        <label for="nombre">Nombre: </label>
        <input type="text" id="nombre" name="nombre"/>
        <br/>
        <label for="apellido">Apellido: </label>
        <input type="text" id="apellido" name="apellido"/>
        <br/>
        <label for="tipoDni">Tipo de documento: </label>
        <select name="tipoDni" id="tipoDni">
          <option value="value1">Dni</option>
          <option value="value1">Pasaporte</option>
        </select>
        <br/>
        <label for="nroDni">Nro de documento: </label>
        <input type="text" id="nroDni" name="nroDni"/>
        <br/>
        <label for="domicilio">Domicilio: </label>
        <input type="text" id="domicilio" name="domicilio"/>
        <br/>
        <label for="telefono">Teléfono: </label>
        <input type="text" id="telefono" name="telefono"/>
        <br/>
        <input type="submit" value="Ingresar"/>
      </form>
    </div>
  );
}

export default App;
