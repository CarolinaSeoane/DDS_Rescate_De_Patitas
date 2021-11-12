
var app = new Vue({
    el: "#app",
    data: {

    },

    methods: {
        redirect: function() {
            if() {
                window.location.href = 'Datos_Dueño_Y_Contactos.html';
            } else {

            }
        }

    }

    /*

    Redireccion:
                                                   SI --> Organizaciones.html
                                                  /
    REGISTRAR CON USUARIO----> ¿Hay id de sesion?
                                                  \
                                                   NO --> Registrarse.html o Iniciar_Sesion.html


    REGSTRAR SIN USUARIO----> Datos_Dueño_Y_Contactos.html

    */


})