import { Link} from 'react-router-dom';

function BorrarEmpleado(props){

    return(
        <>
        <p>Borrado de empleados</p>
        <p><Link to="/listarempleados"  >Volver</Link></p>
        </>
    );
}
export default BorrarEmpleado;