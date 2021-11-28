

const urlParams = new URLSearchParams(window.location.search);

const apiUrl ="http://localhost:5000/api/adoptar/publicaciones/"+ urlParams.get('publicacion');

new Vue({
    el: '#publicacionAdopcion',
    data () {
        return{
            solicitudIniciada: false,
            estado_Solicitud: "",
            colorText:"red",
            fotos:[{
                id:{},
                contenidoBase64:{},
                normalizada:{}
            }],
            publicacion: {
                id: 0,
                mascota:{
                    id: 0,
                    id_QR:{},
                    tipo:"tipo",
                    sexo:"sexo",
                    nombre:"nombre",
                    apodo:"mascota",
                    edad: 0,
                    descripcion:{},
                    fotos:[{
                        id:{},
                        contenidoBase64:{},
                        normalizada:{}
                    }],

                    caracteristicas:[],
                },
                preguntas:[],
            }
        }
    },
    created(){
        fetch(apiUrl)
            .then(response =>{return response.json()})
            .then(publicacion =>{
                this.publicacion = publicacion;
                this.fotos = publicacion.mascota.fotos;
            }).then(startCarrusel);

    },
    methods:{
        adoptar: function (){
            this.solicitudIniciada = true;
            var idSesion = localStorage.getItem("IDSESION");
            this.colorText = "#4ba0dd";
            this.estado_Solicitud = "Procesando solicitud"
            fetch("http://localhost:5000/api/adoptar/publicaciones/"+ + this.publicacion.id +"/adoptar", {
                method: "GET",
                headers: {
                    "Authorization": idSesion
                }
            })
                .then(response => response.json())
                .then(estado =>{
                if (estado){
                    this.colorText = "green";
                    this.estado_Solicitud = "Se notifico al dueño de la mascota";
                }else{
                    this.colorText = "red";
                    this.estado_Solicitud = "Hubo un error";
                }

            });

        }
    }
});