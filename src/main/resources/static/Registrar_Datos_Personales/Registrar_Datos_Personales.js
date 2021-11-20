const apiAgregarDatosPersonales = "http://localhost:5000/usuarios/datos-estandar/actualizar";

new Vue({
    el: '#app',
    data: {
        duenio: {
            nombre: '',
            apellido: '',
            telefono: '',
            email: '',
            formasNotificacion1: [],
            formasNotificacion: '',
            fechaDeNacimiento: '',
            tipoDocumento: '',
            nroDocumento: '',
            domicilio: '',
            otrosContactos: [{
                nombre: '',
                apellido: '',
                telefono: '',
                email: '',
                formasNotificacion1: [],
                formasNotificacion: ''
            }]
        }
    },

    methods: {
        enviar() {
            this.duenio.formasNotificacion = (this.duenio.formasNotificacion1).join(', ');

            for (let i = 0; i < this.duenio.otrosContactos.length; i++) {
                this.duenio.otrosContactos[i].formasNotificacion = (this.duenio.otrosContactos[i].formasNotificacion1).join(', ');
            }

            console.log(this.duenio);

            var idSesion = localStorage.getItem("IDSESION");
            fetch(apiAgregarDatosPersonales, {
                 method: "POST",
                 headers: {
                    'Content-Type': 'application/json',
                    "Authorization": idSesion
                 },
                 body: JSON.stringify(this.duenio)
            })
            //.then(response => response.json())
            .then(data => {
                console.log('status: ', data.status);

                switch (data.status) {
                    case 201:
                        alert("¡Se han guardado sus datos personales correctamente! Pulse aceptar para volver a la pantalla principal");
                        window.location.href = 'index.html';
                    break;
                    default:
                        console.log('error');
                    break;
                }
            })
        },

        addContacto() {
            this.duenio.otrosContactos.push({
                                    nombre: '',
                                    apellido: '',
                                    telefono: '',
                                    email: '',
                                    formasNotificacion1: [],
                                    formasNotificacion: ''
            })
        },

        deleteContacto(counter) {
              this.duenio.otrosContactos.splice(counter,1);
        }
    }
})