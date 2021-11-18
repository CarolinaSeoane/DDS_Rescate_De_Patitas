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
                fotos: [],
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
                                    fotos: [{
                                        contenidoBase64: '',
                                    }],
                                    organizacion: {},
                                    caracteristicas: [{}]
            })
        },

        deleteContacto(counter) {
              this.duenio.otrosContactos.splice(counter,1);
        },

        deleteMascota(i) {
              this.duenio.mascotas.splice(i,1);
        }
    }
})