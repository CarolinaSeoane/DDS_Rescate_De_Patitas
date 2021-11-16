const apiUrl = "http://localhost:5000/usuarios/datos-administrador";
const apiCaracteristicasGlobales = "http://localhost:5000/api/caracteristicas";

new Vue({
	el: '#app',
    data: {
      	administrador: {},
        caracteristicasGlobales: [],
    },
	methods: {
		mostrarCaracteristicasAgregadas() {
			for(let i = 0; i < this.caracteristicasGlobales.length; i++) {
				for(let j = 0; j < this.administrador.organizacion.caracPropias.length; j++){
					if(this.administrador.organizacion.caracPropias[j].id == this.caracteristicasGlobales[i].id) {
                    }
				}
			}
		}
	},
    created() {
        var idSesion = localStorage.getItem("IDSESION"); //recupera ID

        fetch(apiUrl, {
            headers: {
               "Authorization": idSesion //se envia el IDSESION para identificar al usuario en backend
                }})
                .then(response =>{
                    return response.json()})
                .then(adminObtenido => {
                    this.administrador = adminObtenido;
            })

            fetch(apiCaracteristicasGlobales)   //traigo todas las caracteristicas porque el admin puede agregar las que quiera
                .then(response => response.json())
                .then(caracObtenidas => {
        	        this.caracteristicasGlobales = caracObtenidas
        	        this.mostrarCaracteristicasAgregadas()
            	})

        }
})