<!-- src/components/SidebarMenu.vue -->
<template>
    <sidebar-menu :menu="menu" :visible="isVisible">
      <!-- Conteúdo do seu componente vai aqui -->
      <div>
        <h2>Conteúdo Principal</h2>
        <!-- Adicione seu conteúdo principal aqui -->
      </div>
    </sidebar-menu>
  </template>
  
  <script>
  import 'vue-sidebar-menu/dist/vue-sidebar-menu.css';
  import SidebarMenu from 'vue-sidebar-menu';
  
  export default {
    components: {
      SidebarMenu,
    },
    data() {
      return {
        isVisible: true,
        menu: [
          {
            heading: 'Menu Principal',
            items: [
              { title: 'Home', path: '/' },
              { title: 'Pacientes', path: '/pacientes' },
              { title: 'Agendamentos', path: '/agendamentos' },
              { title: 'Consultas', path: '/consultas' },
              { title: 'Testes', path: '/testes' },
            ],
          },
        ],
      };
    },
    methods: {
      toggleVisibility() {
        this.isVisible = !this.isVisible;
      },
    },
  };
  </script>
  
  <style scoped>
  /* Adicione estilos personalizados aqui se necessário */
  </style>
  