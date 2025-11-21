// dashboard.js

document.addEventListener('DOMContentLoaded', function() {
    
    // Obtenemos los elementos
    const sidebarToggle = document.getElementById('sidebarToggle');
    const sidebar = document.getElementById('sidebar');
    const contentWrapper = document.querySelector('.content-wrapper');

    if (sidebarToggle) {
        sidebarToggle.addEventListener('click', function() {
            // Alternar clase para móviles
            sidebar.classList.toggle('active');
            
            // Lógica para pantallas de escritorio (efecto empujar contenido)
            if (window.innerWidth > 768) {
                if (sidebar.style.marginLeft === '-260px') {
                    sidebar.style.marginLeft = '0';
                    contentWrapper.style.marginLeft = '260px';
                } else {
                    sidebar.style.marginLeft = '-260px';
                    contentWrapper.style.marginLeft = '0';
                }
            }
        });
    }
});