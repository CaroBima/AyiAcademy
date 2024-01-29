
const MostrarSaludoComponent = ({ nombre, onClose }) => {
    return (
      <div>
        <h1>Bienvenido {nombre}</h1>
        <button onClick={onClose}>Cerrar</button>
      </div>
    );
  };
  
  export default MostrarSaludoComponent;