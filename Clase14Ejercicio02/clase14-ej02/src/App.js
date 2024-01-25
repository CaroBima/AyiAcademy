import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.min.js";

import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Encabezado titulo= "Ejercicio 02 Clase 14" subtitulo="Resolución"/>
      </header>
      <Tabla titulo="Tabla de productos"/>
      <Botones />
    </div>
  );
}

function Encabezado(props){
  return( 
    <div>
      <p class="h1">{props.titulo}</p>
      <p class="h5">{props.subtitulo}</p>
    </div>
  );
}

function Tabla(propsTabla){
  return(
    <div>
      <h2>{propsTabla.titulo}</h2>
      <table class="table table-success table-striped">
        <thead>
          <tr>
            <th>ID de Producto</th>
            <th>Nombre</th>
            <th>Marca</th>
            <th>Contenido</th>
            <th>Descripción</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>001</td>
            <td>Producto A</td>
            <td>Marca X</td>
            <td>250 ml</td>
            <td>Descripción del Producto A.</td>
          </tr>
          <tr>
            <td>002</td>
            <td>Producto B</td>
            <td>Marca Y</td>
            <td>500 g</td>
            <td>Descripción del Producto B.</td>
          </tr>
          <tr>
            <td>003</td>
            <td>Producto C</td>
            <td>Marca Z</td>
            <td>1 kg</td>
            <td>Descripción del Producto C.</td>
          </tr>
          <tr>
            <td>004</td>
            <td>Producto D</td>
            <td>Marca W</td>
            <td>200 ml</td>
            <td>Descripción del Producto D.</td>
          </tr>
          <tr>
            <td>005</td>
            <td>Producto E</td>
            <td>Marca V</td>
            <td>300 g</td>
            <td>Descripción del Producto E.</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

function Botones(){
  return(
    <div>
      <input type="submit" class="btn btn-outline-success" value="Volver" />
      <input type="submit" class="btn btn-outline-success" value="Añadir" />
    </div>
  );
}

export default App;
