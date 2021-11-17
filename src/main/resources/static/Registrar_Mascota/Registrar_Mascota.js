const apiSesion = "http://localhost:5000/sesion/validar";

new Vue({
    el: "#app",
    data: {
        unlocked: false
    },

    methods: {
        redirect: function() {
            var idSesion = localStorage.getItem("IDSESION");
            if(idSesion == null) {
                this.unlocked = true
            } else {
                fetch(apiSesion, {
                    method: "GET",
                        headers: {
                        "Authorization": idSesion
                    }
                })
                .then(response => response.json())
                .then(data => {
                    if(data) {
                        window.location.href = 'Formulario_Registrar_Mascota.html';
                    } else {
                        this.unlocked = true;
                    }
                })

                //window.location.href = 'Formulario_Registrar_Mascota.html';
            }
        },

        goToRegistrarse: function() {
            window.location.href = 'Registrarse.html';
        },

        goToRegistrarMascota: function() {
            window.location.href = 'Formulario_Registrar_Mascota.html';
        }
    }
})