
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
    </div>
  );
}

export default App;
