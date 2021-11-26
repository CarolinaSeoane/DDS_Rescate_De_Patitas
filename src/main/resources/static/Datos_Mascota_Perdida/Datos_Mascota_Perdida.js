const apiRescatista = "http://localhost:5000/api/rescatista/registrar";

new Vue({
	el: '#app',
    data: {
        rescatista : {
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
            }],
            mascotaPerdida: {
                fotos: [],
                estado: '',
                ubicacion: {
                    direccion: '',
                    lat: '',
                    long: ''
                },
                tipo: ''
            }
        },
        id_qr: ''
    },

    created() {
		const id = new URLSearchParams(window.location.search).get("id");
        if(id != null) {
            // console.log(id);
            this.id_qr = id;
            console.log(this.id_qr);
        }
    },

    methods: {
        enviar() {
            this.rescatista.formasNotificacion = (this.rescatista.formasNotificacion1).join(', ');

            for (let i = 0; i < this.rescatista.otrosContactos.length; i++) {
                this.rescatista.otrosContactos[i].formasNotificacion = (this.rescatista.otrosContactos[i].formasNotificacion1).join(', ');
            }

            fetch(apiRescatista, {
                 method: "POST",
                 headers: {
                    'Content-Type': 'application/json',
                    "Authorization": this.id_qr
                 },
                 body: JSON.stringify(this.rescatista)
            })
            .then(data => {
                console.log('status: ', data.status);

                switch (data.status) {
                    case 201:
                        alert("¡Se han guardado sus datos correctamente! Pulse aceptar para volver a la pantalla principal");
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
        },

        getBase64: function (file) {
            return new Promise((resolve, reject) => {
                var reader = new FileReader();
                reader.readAsDataURL(file);
                reader.onload = function () {
                    resolve(reader.result)
                };
                reader.onerror = function (error) {
                    reject('Error: ', error);
                }
            })
        },

        subirFotos: function (event) {
            for (let j = 0; j < event.target.files.length; j++) {
                this.getBase64(event.target.files[j])
                    .then(img => {
                    var request = {
                        contenidoBase64: img
                    }
                    this.rescatista.mascotaPerdida.fotos.push(request);
                    })
            }
        }

    }
})