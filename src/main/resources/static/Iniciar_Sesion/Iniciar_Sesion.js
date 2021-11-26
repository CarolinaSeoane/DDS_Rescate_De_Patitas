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
            .then(function (response){
                if(!response.ok){
                    alert("Usuario o constraseña incorrectos");
                    throw new Error("Status: " + response.status);
                }
                return response.json();
            })
            .then(data => {
                console.log('logged in');
                localStorage.setItem("IDSESION", data.idSesion); //guarda ID
                this.rol = data.rol;
                this.redirect();
            })
        },
        redirect: function() {
            var idSesion = localStorage.getItem("IDSESION") //recupera ID

            if(this.rol == "Administrador") {
                window.location.href = 'Admin_Pantalla_Principal.html';
            } else { // pongo else porque no vamos a hacer las pantallas de los voluntarios
                window.location.href = 'index.html';
            }
        }

    }
})