const apiRegistrar = "http://localhost:5000/api/dueño/registrar";
const apiOrganizaciones = "http://localhost:5000/api/organizaciones";
const apiSesion = "http://localhost:5000/sesion/validar";

new Vue({
    el: '#app',
    data: {
        duenio : {
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
            mascotas: [{
                nombre: '',
                apodo: '',
                edad: '',
                sexo: '',
                descripcion: '',
                caracteristicas: [],
                fotos: [],
                organizacion: {}
            }]
        },
        organizaciones: [],
        sesionInvalida: true
    },

    created() {
        fetch(apiOrganizaciones)
            .then(response => response.json())
            .then(organizacionesObtenidas => {
                this.organizaciones = organizacionesObtenidas;
        })

        /* Valido la sesion, si hay */
        var idSesion = localStorage.getItem("IDSESION");
        console.log(idSesion);

        if(idSesion == null) {
            this.sesionInvalida = true
        } else {
            fetch(apiSesion, {
                method: "GET",
                headers: {
                    "Authorization": idSesion
                }
            })
            .then(response => response.json())
            .then(esValida => {
                this.sesionInvalida = !esValida;
            })
        }
    },

    methods: {

    /* FUNCIONES PARA ENVIAR DATOS AL SERVIDOR Y FUNCIONES DE COMPORTAMIENTO DE BOTONES */

        enviar() {
            this.duenio.formasNotificacion = (this.duenio.formasNotificacion1).join(', ');

            for (let i = 0; i < this.duenio.otrosContactos.length; i++) {
                this.duenio.otrosContactos[i].formasNotificacion = (this.duenio.otrosContactos[i].formasNotificacion1).join(', ');
            }

            console.log(this.duenio);

            axios.post(apiRegistrar, this.duenio)
                .then((result) => {
                    alert("¡Se ha registrado a su mascota correctamente! Pulse aceptar para volver a la pantalla principal");
                    window.location.href = 'index.html';
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

        addMascota() {
            this.duenio.mascotas.push({
                                    nombre: '',
                                    apodo: '',
                                    edad: '',
                                    descripcion: '',
                                    fotos: [],
                                    organizacion: {},
                                    caracteristicas: []
            })
        },

        deleteContacto(counter) {
              this.duenio.otrosContactos.splice(counter,1);
        },

        deleteMascota(i) {
              this.duenio.mascotas.splice(i,1);
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

        subirFotos: function (event, i) {
            for (let j = 0; j < event.target.files.length; j++) {
                this.getBase64(event.target.files[j])
                    .then(img => {
                    var request = {
                        contenidoBase64: img
                    }
                    this.duenio.mascotas[i].fotos.push(request);
                    })
            }
        },

        /* FUNCIONES PARA AUTOCOMPLETADO DE DATOS */

        disable: function() {
        	let duenioNombre = document.getElementById("duenioNombre")
        	let duenioApellido = document.getElementById("duenioApellido")
        	duenioNombre.disabled = true
            duenioApellido.disabled = true
        }

        /* FUNCIONES PARA VALIDACION DE DATOS */


    }
})