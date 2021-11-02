const apiUrlPublicacion = "http://localhost:5000/adoptar/publicacion/crear_publicacion";
const apiUrlCaracteristicas = "http://localhost:5000/caracteristicas";
const apiUrlComodidades = "http://localhost:5000/comodidades";

var app1 = new Vue({
	el: '#app',
    data: {
     	form : {
	        emailDelInteresado: '',
            preferencias: {
            	tipoMascota: '',
            	sexo: '',
            	edadMin: '',
            	edadMax: '',
            	caracteristicas: [],
            	comodidades: []
            }
        },
        caracteristicas2: [],
        comodidades2: []
    },
    methods: {
    	enviar() {
       		axios.post(apiUrlPublicacion, this.form).then((result) => {console.log(result);})
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
