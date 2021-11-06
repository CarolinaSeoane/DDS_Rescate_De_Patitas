const apiUrl = "http://localhost:5000/api/mascota/registrar";

new Vue({
    el: '#app',
    data: {
        form : {
            nombre: '',
            apodo: '',
            tipo: '',
            edad: '',
            sexo: '',
            descripcion: '',
            fotos: [],
            caracteristicas: []
        }
    },

    methods: {

    }
})

