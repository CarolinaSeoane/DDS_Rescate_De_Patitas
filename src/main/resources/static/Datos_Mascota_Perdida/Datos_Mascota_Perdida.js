const apiSinQR = "http://localhost:5000/api/perdidas/crear";
const apiConQR = "http://localhost:5000/api/mascota-perdida/crear";

new Vue({
	el: '#app',
    data: {
        publicacion: {
            organizacion: null,
            aceptada: false,
            mascota: {
                fotos: [],
                estado: '',
                ubicacion: {
                    lat: '',
                    _long: ''
                },
                tipo: '',
                mascotaAsociada: null,
                rescatista: {
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
            }
        },
        id_qr: ''
    },

    created() {
		const id = new URLSearchParams(window.location.search).get("id");
        if(id != null) {
            this.id_qr = id;
        }
    },

    methods: {
        enviar() {
            this.publicacion.mascota.rescatista.formasNotificacion = (this.publicacion.mascota.rescatista.formasNotificacion1).join(', ');

            for (let i = 0; i < this.publicacion.mascota.rescatista.otrosContactos.length; i++) {
                this.publicacion.mascota.rescatista.otrosContactos[i].formasNotificacion = (this.publicacion.mascota.rescatista.otrosContactos[i].formasNotificacion1).join(', ');
            }

            this.publicacion.mascota.ubicacion.lat = document.getElementById('lat').value;
            this.publicacion.mascota.ubicacion._long = document.getElementById('lng').value;

            var api;
            if(this.id_qr == '') {
                api = apiSinQR;
            } else {
                api = apiConQR;
            }

            fetch(api, {
                 method: "POST",
                 headers: {
                    'Content-Type': 'application/json',
                    "Authorization": this.id_qr
                 },
                 body: JSON.stringify(this.publicacion)
            })
            .then(data => {
                console.log('status: ', data.status);

                switch (data.status) {
                    case 200:
                        if(this.id_qr == '') {
                            alert("¡Se han guardado sus datos correctamente! Pulse aceptar para volver a la pantalla principal");
                        } else {
                            alert("¡Se han guardado sus datos correctamente y se ha notificado el dueño! Pulse aceptar para volver a la pantalla principal");
                        }
                        window.location.href = 'index.html';
                    break;
                    default:
                        console.log('error');
                    break;
                }
            })
        },

        addContacto() {
            this.publicacion.mascota.rescatista.otrosContactos.push({
                                    nombre: '',
                                    apellido: '',
                                    telefono: '',
                                    email: '',
                                    formasNotificacion1: [],
                                    formasNotificacion: ''
            })
        },

        deleteContacto(counter) {
              this.publicacion.mascota.rescatista.otrosContactos.splice(counter,1);
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
                    this.publicacion.mascota.fotos.push(request);
                    })
            }
        }

    }
})