const api = "http://localhost:5000/usuarios/iniciar-sesion";

var app = new Vue({
    el: "#app",
    data: {
        usuario: "",
        password: ""
        },

    methods: {
        login: function () {
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
                localStorage.setItem("IDSESION", datos.idSesion) //guarda ID
            })
        }

    }
})