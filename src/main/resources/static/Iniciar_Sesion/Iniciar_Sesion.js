const api = "http://localhost:5000/usuarios/iniciar-sesion";

var app = new Vue({
    el: "#app",
    data: {
        usuario: "",
        password: "",
        rol: ""
    },

    computed: {
        passwordsFilled () {
    	    return (this.password !== '' && this.usuario !== '')
    	}
    },

    methods: {
        login: function () {
            if(this.passwordsFilled)
            fetch(api, {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    usuario: this.usuario,
                    password: this.password
                })
            })
            .then(response => response.json())
            .then(datos => {
                localStorage.setItem("IDSESION", datos.idSesion); //guarda ID
                this.rol = datos.rol;
                this.redirect();
            })
        },

        redirect: function() {
            var idSesion = localStorage.getItem("IDSESION") //recupera ID

            if(this.rol == "Administrador") {
                window.location.href = 'Admin_Pantalla_Principal.html';
            } else if (this.rol == "Voluntario") {
                window.location.href = 'Voluntario.html';
            } else {
                window.location.href = 'index.html';
            }
        },
        mostrarContraseña() {
        	let password = document.getElementById("password")
        	if(password.type == 'text') {
        	    password.type = 'password'
        	} else {
        	    password.type = 'text'
        	}
        }

    }
})