import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>
          <Encabezado/>
        </h1>
      </header>
      <body>
        <Contenido/>
      </body>
    </div>
  );
}

function Encabezado(){
  return( 
    <h1>Ejercicio 01 de la clase 14</h1>
  );
}

function Contenido(){
  return( 
    <div  className="content">
      <p className="texto">Lorem ipsum dolor sit amet consectetur adipiscing elit potenti, arcu mattis magnis sem hac erat velit, vitae neque rutrum cursus conubia ornare augue. Praesent sociosqu elementum feugiat lacus torquent etiam vel aptent, nullam felis sodales sagittis convallis lectus. Dapibus nunc facilisis et sodales interdum ad aliquam lobortis habitant eleifend, turpis tempus nibh nostra diam donec proin enim vehicula, justo platea tortor etiam posuere class purus pretium taciti.</p>
      <p className="texto">Rhoncus molestie ligula luctus fringilla cursus suspendisse tempor, laoreet odio vitae nibh cubilia potenti elementum, sodales lobortis lectus magnis nunc fames. Natoque mus class est porta sollicitudin, eros suspendisse consequat cursus posuere penatibus, dictumst aptent ante porttitor. Platea at sagittis proin molestie nunc netus faucibus potenti dui, nec magna litora blandit commodo eleifend scelerisque pretium purus, venenatis torquent lacus vivamus ante pharetra class aenean.</p>
    </div>
  );
}
export default App;
