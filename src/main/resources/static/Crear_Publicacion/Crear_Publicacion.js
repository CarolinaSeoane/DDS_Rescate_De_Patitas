const apiUrlPublicacion = "http://localhost:5000/api/publicacion-interesado/crear";
const apiUrlCaracteristicas = "http://localhost:5000/api/caracteristicas";
const apiUrlComodidades = "http://localhost:5000/api/comodidades";

var app1 = new Vue({
	el: '#app',
    data: {
     	form : {
	        emailDelInteresado: null,
            preferencias: {
            	tipoMascota: null,
            	sexo: null,
            	edadMin: null,
            	edadMax: null,
            	caracteristicas: [],
            	comodidades: []
            }
        },
        caracteristicas2: [],
        comodidades2: [],
        errors: []
    },
    methods: {
    	enviar() {
			axios.post(apiUrlPublicacion, this.form).then((result) => {console.log(result);})
        },
        habilitar: function() {
        	let edadMin = document.getElementById("edadMin")
        	let edadMax = document.getElementById("edadMax")
        	edadMin.disabled = false
            edadMax.disabled = false
        },
        deshabilitar: function() {
            let edadMin = document.getElementById("edadMin")
            let edadMax = document.getElementById("edadMax")
            edadMin.disabled = true
            edadMax.disabled = true
        },
        validEmail: function (email) {
            var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            return re.test(email);
        }
    },
	created () {
		fetch(apiUrlCaracteristicas)
        	.then(response => response.json())
        	.then(data => {
        		this.caracteristicas2 = data
           	})
        fetch(apiUrlComodidades)
            .then(response => response.json())
            .then(data => {
        	    this.comodidades2 = data
            })
    }
})
