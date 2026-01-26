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


    $(document).ready(function() {
        $('#inventoryTable').DataTable({
            "language": {
                "lengthMenu": "Mostrar _MENU_ registros por página",
                "zeroRecords": "No se encontraron resultados - lo sentimos",
                "info": "Mostrando página _PAGE_ de _PAGES_",
                "infoEmpty": "No hay registros disponibles",
                "infoFiltered": "(filtrado de _MAX_ registros totales)",
                "search": "Buscar:",
                "paginate": {
                    "first": "Primero",
                    "last": "Último",
                    "next": "Siguiente",
                    "previous": "Anterior"
                }
            },
            // Botones de exportación
            dom: 'Bfrtip',
            buttons: [
                {
                    extend: 'excelHtml5',
                    text: '<i class="fas fa-file-excel"></i> Excel',
                    className: 'btn btn-success btn-sm'
                },
                {
                    extend: 'pdfHtml5',
                    text: '<i class="fas fa-file-pdf"></i> PDF',
                    className: 'btn btn-danger btn-sm'
                },
                {
                    extend: 'print',
                    text: '<i class="fas fa-print"></i> Imprimir',
                    className: 'btn btn-secondary btn-sm'
                }
            ]
        });
    });