const apiUrl = "http://localhost:5000/registrar/datos-personales";

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
                email: ''
            }]
        }
    },

    methods: {
        enviar() {
            this.form.formasNotificacion = (this.form.formasNotificacion1).join(', ');
            axios.post(apiUrl, this.form).then((result) => {console.log(result);})
        }
    }
})