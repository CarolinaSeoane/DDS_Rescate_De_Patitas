const apiUrl ="http://localhost:5000/api/hogares";

new Vue({
        el: '#app',
        data() {
            return{
                hogares: []
            }
        },
        created() {
            fetch(apiUrl)
                .then(response => response.json())
                .then(hogaresObtenidos => {
                    this.hogares = hogaresObtenidos
                })
        }
    })

