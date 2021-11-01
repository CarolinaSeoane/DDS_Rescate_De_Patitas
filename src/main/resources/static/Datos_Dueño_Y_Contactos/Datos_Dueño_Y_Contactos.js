const apiUrl = "http://localhost:5000/registrar/datos-personales";

new Vue({
    el: '#app',
    data: {
        form : {
        nombre: '',
        apellido: '',
        telefono: '',
        email: '',
        formasnNotificacion: [],
        fechaDeNacimiento: '',
        tipoDocumento: '',
        nroDocumento: '',
        domicilio: ''
        }
    },

    methods: {
        enviar() {
            axios.post(apiUrl, this.form).then((result) => {console.log(result);})
        }
    }
})