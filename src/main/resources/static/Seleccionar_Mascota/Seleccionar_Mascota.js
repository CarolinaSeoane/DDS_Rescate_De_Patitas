const apiUrlUsuario = "http://localhost:5000/usuarios/datos-estandar"

var app1 = new Vue({
	el: '#app',
    data: {
    	usuarioEstandar: {
    		id: null,
    		password: null,
    		usuario: null,
    		duenioAsociado: {
    			id: null,
    			tipoDocumento: null,
    			nroDocumento: null,
    			fechaDeNacimiento: null,
    			otrosContactos: null,
    			domicilio: null,
    			nombre: null,
    			apellido: null,
    			telefono: null,
    			email: null,
    			formasDeNotificacion: null,
    			formasNotificacion: null,
    			mascotas: [{
    			}]
    		}
    	},
    	i: 0,
    	indices: [{
    		id: null,
    		index: 0
    	}]
    },
    methods: {
    	anteriorFoto(idMascota) {


    		if(this.indices[i].index <= '0'){
    			console.log("No modifica porque esta en el limite inferior")
    		}else{
	    		this.indices[i].index = this.indices[i].index - 1
    		}
    	},
    	siguienteFoto(i) {
    		console.log(this.indices[i].index)
    		console.log(this.usuarioEstandar.duenioAsociado.mascotas[i].fotos.length)
    		if(this.indices[i].index == (this.usuarioEstandar.duenioAsociado.mascotas[i].fotos.length-1)){
    			console.log("No modifica porque ya esta en el limite")
            }else{
    			this.indices[i].index = this.indices[i].index + 1
    		}
    	}
    },
    created() {
		var idSesion = localStorage.getItem("IDSESION");

    	fetch(apiUrlUsuario, {
        	headers: {
        		"Authorization": idSesion //se envia el IDSESION para identificar al usuario en backend
        	}})
        .then(response =>{ return response.json()})
        .then(estandar => { this.usuarioEstandar = estandar;
        })
    }

})
