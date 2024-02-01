import { Link } from "react-router-dom";

function NuevoEmpleado() {
  return (
    <>
      <div class="container-fluid py-5 mt-5">
        <div class="row justify-content-md-center">
          <div class="col-md-6">
            <h1>Editar empleado:</h1>
            <form name="formValid" method="post">
              <input type="hidden" name="idProveedor" />
              <div class="mb-1">
                <label for="nombre" class="form-label">
                  Nombre:
                </label>
                <input
                  type="text"
                  class="form-control"
                  name="nombre"
                  id="nombre"
                  required
                />
              </div>
              <div class="mb-1">
                <label for="apellidoEmpleado" class="form-label">
                  Apellido:
                </label>
                <input
                  type="text"
                  class="form-control"
                  name="apellidoEmpleado"
                  id="apellidoEmpleado"
                  required
                />
              </div>
              <div class="mb-1">
                <label for="cargo" class="form-label">
                  Cargo:
                </label>
                <input
                  type="text"
                  class="form-control"
                  name="cargo"
                  id="cargo"
                  required
                />
              </div>
              <div class="mb-1">
                <label for="sucursal" class="form-label">
                  Sucursal:
                </label>
                <input
                  type="text"
                  class="form-control"
                  name="sucursal"
                  id="sucursal"
                  required
                />
              </div>
              <div class="mb-1">
                <label for="antiguedadAnios" class="form-label">
                  Antigüedad:
                </label>
                <input
                  type="number"
                  class="form-control"
                  name="antiguedadAnios"
                  id="antiguedadAnios"
                />
              </div>
              <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
                <input
                  type="submit"
                  name="guardar"
                  value="Guardar"
                  class="btn btn-outline-danger me-md-2"
                />
                <Link
                  to="/listarempleados"
                  class="btn btn-outline-danger me-md-2"
                >
                  Volver
                </Link>
              </div>
            </form>
          </div>
        </div>
      </div>
    </>
  );
}

export default NuevoEmpleado;
