const apiUrlMascota = "http://localhost:5000/api/mascota/obtener/"
const apiUrlPreguntasGlobales = "http://localhost:5000/api/preguntas/obtener"

var app1 = new Vue({
	el: '#app',
    data: {
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
    			preguntasAdicionales: [],
    			caracPropias: []
    		}
    	},
    	preguntas: []
    },
    methods: {
    	agregarPreguntasDeLaOrganizacion() {
    		for(pregunta in this.mascota.organizacion.preguntasAdicionales) {
    			this.preguntas.push(pregunta)
    		}
    	}

    },
    created() {

		const urlParams = new URLSearchParams(window.location.search);

        fetch(apiUrlMascota + urlParams.get("id"))
        	.then(response => response.json())
        	.then(mascotaObtenida => {this.mascota = mascotaObtenida})
			.then(fetch(apiUrlPreguntasGlobales)
				.then(response => response.json())
                .then(preguntasGlobales => {this.preguntas = preguntasGlobales})
            )
            this.agregarPreguntasDeLaOrganizacion()
    }
})