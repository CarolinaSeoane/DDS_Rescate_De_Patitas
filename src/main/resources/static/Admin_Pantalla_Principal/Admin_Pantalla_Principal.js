const apiUrl = "http://localhost:5000/usuarios/datos-administrador";
const apiCaracteristicasGlobales = "http://localhost:5000/api/caracteristicas";

new Vue({
	el: '#app',
    data: {
      	administrador: {},
        caracteristicasGlobales: [],
    },
	methods: {
		laCaracteristicaEstaEnLaOrg(caracteristica) {
			for(let i=0; i<this.administrador.organizacion.caracPropias.length; i++) {
				if(this.administrador.organizacion.caracPropias[i].id == caracteristica.id) {
					return true
				}
			}
			return false
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
            })
        }
})