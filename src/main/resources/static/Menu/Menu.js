class MenuAdmin extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
			<header>
        		<div class="contenedor-base">

        			<nav class="menu">
        				<a href="Admin_Pantalla_Principal.html">Página Principal</a>
        				<a href=".">Cerrar Sesión</a>
        			</nav>

        			<div class="logo">
        					<img src="../static/Menu/img/logo_blanco.png" alt="Logo">
        			</div>

        		</div>
        	</header>
    `;
    }
}

class MenuUsuario extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
            <div class="menu-bar">
                <div class="contenedor-base" id="app-sesion">

                    <nav class="menu">
                        <a v-if="sesionInvalida" href="Iniciar_Sesion.html">Iniciar Sesión</a>
                        <a v-if="!sesionInvalida" href="index.html">Mi Usuario</a>
                        <a href="index.html">Página Principal</a>
                        <a href="Organizaciones.html">Organizaciones</a>
                    </nav>

                    <div class="logo-menu">
                        <img src="../static/Menu/img/logo_blanco.png" alt="Logo">
                    </div>

                </div>
            </div>
    `;
    }
}

customElements.define('main-menu-admin', MenuAdmin);
customElements.define('main-menu-usuario', MenuUsuario);