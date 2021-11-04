const apiUrl = "http://localhost:5000/api/dueño/registrar";

new Vue({
    el: '#app',
    data: {
        form : {
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
            this.form.formasNotificacion = (this.form.formasNotificacion1).join(', ');

            for (let i = 0; i < this.form.otrosContactos.length; i++) {
                this.form.otrosContactos[i].formasNotificacion = (this.form.otrosContactos[i].formasNotificacion1).join(', ');
            }

            axios.post(apiUrl, this.form).then((result) => {console.log(result);})
        },

        addContacto() {
            this.form.otrosContactos.push({
                                    nombre: '',
                                    apellido: '',
                                    telefono: '',
                                    email: '',
                                    formasNotificacion1: [],
                                    formasNotificacion: ''
                                    })
        },

        deleteContacto(counter) {
              this.form.otrosContactos.splice(counter,1);
        }
    }
})