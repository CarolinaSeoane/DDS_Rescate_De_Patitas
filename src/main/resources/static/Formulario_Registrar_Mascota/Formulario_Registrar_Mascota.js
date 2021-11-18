const apiRegistrar = "http://localhost:5000/api/dueño/registrar";
const apiOrganizaciones = "http://localhost:5000/api/organizaciones";

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
                fotos: [{
                    contenidoBase64: ''
                }],
                organizacion: {}
            }]
        },
        organizaciones: []
    },

    created() {
        fetch(apiOrganizaciones)
            .then(response => response.json())
            .then(organizacionesObtenidas => {
                this.organizaciones = organizacionesObtenidas;
        })
    },

    methods: {
        enviar() {
            this.duenio.formasNotificacion = (this.duenio.formasNotificacion1).join(', ');

            for (let i = 0; i < this.duenio.otrosContactos.length; i++) {
                this.duenio.otrosContactos[i].formasNotificacion = (this.duenio.otrosContactos[i].formasNotificacion1).join(', ');
            }

            console.log(this.duenio);

            axios.post(apiRegistrar, this.duenio).then((result) => {console.log(result);})
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

        subirFoto: function (event, i) {
            var file = event.target.files[0]
            this.getBase64(file)
                .then(img => {
                    this.duenio.mascotas[i].fotos[0].contenidoBase64 = img;
                    // console.dir(request)
                })
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
        }
    }
})