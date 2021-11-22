new Vue({
    el: "#app-sesion",
    data: {
        sesionInvalida: false
    },

    created() {
        var idSesion = localStorage.getItem("IDSESION");
        if(idSesion == null) {
           this.sesionInvalida = true
        } else {
            fetch("http://localhost:5000/sesion/validar", {
                method: "GET",
                    headers: {
                    "Authorization": idSesion
                }
            })
           .then(response => response.json())
           .then(data => {
            this.sesionInvalida = !data;
           })
        }
    }

})