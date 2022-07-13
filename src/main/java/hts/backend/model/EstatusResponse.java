package hts.backend.model;

/**
 * TODO [Agregar documentación de la clase]
 * @author
 * @version 1.0
 * @since
 */
public enum EstatusResponse {

    /**
     * TODO [Agregar documentación del atributo]
     */
    OK(1, 1, "Código de esatus correcto"),
    /**
     * TODO [Agregar documentación del atributo]
     */
    ERROR(1, 0, "Código de esatus error");

    /**
     * TODO [Agregar documentacion al método]
     * @author
     * @param id
     * @param estatus
     * @param descripcion
     */
    private EstatusResponse(int id, int estatus, String descripcion) {
        this.id = id;
        this.estatus = estatus;
        this.descripcion = descripcion;
    }

    /**
     * Regresa la representación EstatusResponse del argumento <code>int</code>
     * @param id un <code>int</code> que representa el id del {@link EstatusResponse}
     * @return {@link EstatusResponse}
     */
    public static EstatusResponse valueOf(int id) {
        for (EstatusResponse EstatusResponse : values()) {
            if (EstatusResponse.getId() == id) {
                return EstatusResponse;
            }
        }
        throw new IllegalArgumentException("Id '" + id + "' inválido para obtener enum EstatusResponse");
    }

    private int id;
    private int estatus;
    private String descripcion;

    /**
     * @return el atributo id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id parametro id a actualizar
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return el atributo estatus
     */
    public int getEstatus() {
        return estatus;
    }

    /**
     * @param estatus parametro estatus a actualizar
     */
    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    /**
     * @return el atributo descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion parametro descripcion a actualizar
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
