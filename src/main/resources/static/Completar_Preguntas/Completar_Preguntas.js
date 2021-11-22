const apiUrlMascota = "http://localhost:5000/api/mascota/obtener/"
const apiPreguntasGlobales = "http://localhost:5000/api/preguntas/obtener"
const apiUrlGuardarPub = "http://localhost:5000/api/dar-en-adopcion/guardar"

var app1 = new Vue({
	el: '#app',
    data: {
    	publicacion: {
    		mascota: {
    			id: null,
    			id_QR: null,
    			tipo: null,
    			sexo: null,
    			nombre: null,
    			apodo: null,
    			edad: null,
    			descripcion: null,
    			fotos: [],
    			caracteristicas: [],
    			organizacion: {
					id: null,
					nombre: null,
					ubicacion: null,
					resolucion: null,
					calidad: null,
					preguntasAdicionales: [{
						id: null,
						preguntasPublicacion: [],
						pregunta: null
					}],
					caracPropias: []
    			}
    		},
    		preguntas: []
    	},
    	preguntasGlobales: [{
    		id: null,
    		preguntasPublicacion: [],
    		pregunta: null
    	}]
    },
    methods: {
    	pasarPreguntas() {
			this.publicacion.preguntas = this.publicacion.mascota.organizacion.preguntasAdicionales.slice();
			this.publicacion.preguntas = this.preguntasGlobales.slice();
    	},
    	enviarPreguntas() {
    		console.log(this.publicacion)
    		axios.post(apiUrlGuardarPub, this.publicacion).then((result) => {console.log(result);})
            //window.location.href = 'Todo_Listo.html';
    	}
    },
    created() {

		const urlParams = new URLSearchParams(window.location.search);

		fetch(apiUrlMascota + urlParams.get("id"))
			.then(response => response.json())
			.then(mascotaObtenida => {this.publicacion.mascota = mascotaObtenida})
			.then(fetch(apiPreguntasGlobales)
        		.then(response => response.json())
            	.then(preguntasGlobales => {
            		this.preguntasGlobales = preguntasGlobales
            		this.pasarPreguntas()
            })
		)
    }
})