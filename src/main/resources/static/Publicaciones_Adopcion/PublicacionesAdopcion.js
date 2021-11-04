const apiUrl ="http://localhost:5000/api/adoptar/publicaciones";
var cantidad =4;

new Vue({
    el: '#publicacionesAdopcion',
    data () {
        return{
            allPublicaciones: [],
            recientes: [],
            publicacionesMacotas: [],
            check: []
        }
    },
    created(){
        fetch(apiUrl)
            .then(response =>{return response.json()})
            .then(publicaciones =>{
                publicaciones.forEach(p =>{
                    var fotogato ={
                        "id":"1",
                        "path":"https://previews.123rf.com/images/yommy8008/yommy80081610/yommy8008161000081/67376534-square-photo-with-head-detail-of-few-weeks-old-tabby-cat-kitten-has-blue-eyes-and-dark-nose-baby-ani.jpg"
                    }
                    var fotoperro ={
                        "id":"1",
                        "path":"https://post.medicalnewstoday.com/wp-content/uploads/sites/3/2020/02/322868_1100-1100x628.jpg"
                    }
                    if(p.mascota.tipo=="PERRO"){
                        p.mascota.fotos.push(fotoperro);
                    }else{
                        p.mascota.fotos.push(fotogato);
                    }


                    p.mascota.fotos.sort((f1,f2) =>{
                        return f1.id -f2.id;
                    });
                });
                this.allPublicaciones = publicaciones;
                this.recientes = publicaciones.slice().sort((p1,p2) => {
                    return -(p1.id-p2.id);
                }).slice(0,4);
                this.publicacionesMacotas = publicaciones.slice(0,cantidad);
            })
    },
    methods:{
        filtrar: function(){
            if(this.check.length>0){
                this.publicacionesMacotas =  this.allPublicaciones.slice().filter(p =>{
                    return  this.check.includes(p.mascota.tipo);
                }).slice(0,cantidad);
            }else{
                this.publicacionesMacotas =  this.allPublicaciones.slice(0,cantidad);
            }
        },
        agregar: function(){
            cantidad +=4;
            this.filtrar();
        },
        orderByname: function(){
            this.allPublicaciones.sort((p1,p2) =>{
                if (p1.mascota.nombre>p2.mascota.nombre) return 1
                return -1;
            });

            this.filtrar();

        },
        reset: function(){
            document.getElementById("GATO").checked = false;
            document.getElementById("PERRO").checked = false;
            this.check = this.check.slice(0,0);
        },
        pedirInicio: function(){
            alert("Por favor inicie sesion");
        }
    }
});