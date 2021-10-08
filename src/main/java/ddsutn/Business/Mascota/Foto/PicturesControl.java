package ddsutn.Business.Mascota.Foto;

import ddsutn.Business.Organizacion.Organizacion;

public class PicturesControl {

    /* No debe ser implementado aun.
       Elimino metodos de guardado de imagen porque la guarda el Converter */

    public void subirFoto(Foto foto, Organizacion org) {
        foto.convertirFoto(org);
    }

}
