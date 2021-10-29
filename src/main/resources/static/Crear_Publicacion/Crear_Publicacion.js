var app = new Vue({
        el: "#caracteristicas",
        data: {
            caracteristicas: []
        },
        created () {
          	fetch('http://localhost:5000/caracteristicas')
                .then(response => response.json())
                .then(data => {
                    this.caracteristicas = data
                })
        }
    })

var app2 = new Vue({
        el: "#comodidades",
        data: {
            comodidades: []
        },
        created () {
          	fetch('http://localhost:5000/comodidades')
                .then(response => response.json())
                .then(data => {
                    this.comodidades = data
                })
        }
    })