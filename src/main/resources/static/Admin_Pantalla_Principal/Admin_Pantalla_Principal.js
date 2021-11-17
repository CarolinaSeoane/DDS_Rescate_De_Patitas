const apiUrlDatosAdmin = "http://localhost:5000/usuarios/datos-administrador";
const apiCaracteristicasGlobales = "http://localhost:5000/api/caracteristicas";
const apiGuardarCambios = "http://localhost:5000/api/organizaciones/guardarCambios"

new Vue({
	el: '#app',
    data: {
      	administrador: {
      		organizacion: {
      			caracPropias: null,
      			calidad: null,
      			resolucion: {
      				pixelesAlto: null,
      				pixelesAncho: null
      			}
      		}
      	},
        caracteristicasGlobales: [],
        jsonFinal: {
        	caracteristicasMarcadas: [],
        	calidad: '',
        	pixelesAlto: '',
        	pixelesAncho: ''
        }
    },
	methods: {
		laCaracteristicaEstaEnLaLista(unaCaracteristica, unaLista) {
			for (let i = 0; i < unaLista.length; i++) {
				if(unaCaracteristica.id == unaLista[i].id) {
					return true
				}
			}
			return false
		},
		sacarCaracteristicaDeLaLista(caracteristica, listaDeCaracteristicas) {
			this.jsonFinal.caracteristicasMarcadas = listaDeCaracteristicas.filter(function(unaCaracteristica) { return unaCaracteristica.id != caracteristica.id})
		},
		agregarOSacarDeLista(caracteristica) {
			if(this.laCaracteristicaEstaEnLaLista(caracteristica, this.jsonFinal.caracteristicasMarcadas)){
				this.sacarCaracteristicaDeLaLista(caracteristica, this.jsonFinal.caracteristicasMarcadas)
			}else{
				this.jsonFinal.caracteristicasMarcadas.push(caracteristica)
			}

		},
		laCaracteristicaEstaEnLaOrg(caracteristica) {
			return this.laCaracteristicaEstaEnLaLista(caracteristica, this.administrador.organizacion.caracPropias)
		},
		agregarLasMarcadasALaLista() {
			for(let j=0; j<this.caracteristicasGlobales.length; j++) {
            	if(this.laCaracteristicaEstaEnLaLista(this.caracteristicasGlobales[j], this.administrador.organizacion.caracPropias)) {
            		this.agregarOSacarDeLista(this.caracteristicasGlobales[j])
            	}
         	}
		},
		obtenerCalidadElegida() {
			let calidad = document.getElementById("calidad")
			this.jsonFinal.calidad = calidad.value
			console.log(calidad.value)
		},
		obtenerResolucionElegida() {
			let pixelesAlto = document.getElementById("pixelesAlto")
			this.jsonFinal.pixelesAlto = pixelesAlto.value
            console.log(pixelesAlto.value)

            let pixelesAncho = document.getElementById("pixelesAncho")
            this.jsonFinal.pixelesAncho = pixelesAncho.value
            console.log(pixelesAncho.value)
		},
		losDatosSonValidos() {
			return this.jsonFinal.pixelesAlto > 0 && this.jsonFinal.pixelesAncho > 0
		},
		guardarCambios() {

			this.obtenerCalidadElegida()
			this.obtenerResolucionElegida()
			console.log(this.jsonFinal.caracteristicasMarcadas)
			if(this.losDatosSonValidos()){
				//axios.post(apiUrlPublicacion, this.jsonFinal).then((result) => {console.log(result);})
			}else{
				alert("Los pixeles de alto y de ancho deben ser mayores que 0")
			}


		}
	},
    created() {
        var idSesion = localStorage.getItem("IDSESION"); //recupera ID

        fetch(apiUrlDatosAdmin, {
            headers: {
               "Authorization": idSesion //se envia el IDSESION para identificar al usuario en backend
                }})
                .then(response => response.json())
                .then(adminObtenido => { this.administrador = adminObtenido; })
            	.then(
            		fetch(apiCaracteristicasGlobales)   //traigo todas las caracteristicas porque el admin puede agregar las que quiera
                		.then(response => response.json())
                    	.then(caracObtenidas => {
                    		this.caracteristicasGlobales = caracObtenidas;
                  	   		this.agregarLasMarcadasALaLista();
                    	})
            	)


        }
})