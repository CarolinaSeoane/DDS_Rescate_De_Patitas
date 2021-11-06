class Menu extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
			<header>
        		<div class="contenedor-base">

        			<nav class="menu">
        				<a href="Iniciar_Sesion.html">Iniciar Sesión</a>
        				<a href="index.html">Página Principal</a>
        				<a href=".">Organizaciones</a>
        			</nav>

        			<div class="logo">
        					<img src="../static/Menu/img/logo_blanco.png" alt="Logo">
        			</div>

        		</div>
        	</header>
    `;
    }
}

class MenuSimple extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <nav class="menu">
            <a href="Iniciar_Sesion.html">Iniciar Sesión</a>
            <a href="index.html">Página Principal</a>
            <a href=".">Organizaciones</a>
        </nav>
    `;
    }
}

class MenuAdmin extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
			<header>
        		<div class="contenedor-base">

        			<nav class="menu">
        				<a href=".">Mi Usuario</a>
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

customElements.define('main-menu', Menu);
customElements.define('main-menu-simple', MenuSimple);
customElements.define('main-menu-admin', MenuAdmin);