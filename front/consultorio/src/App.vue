<script setup>
import HelloWorld from './components/HelloWorld.vue'
import { ref } from 'vue'

</script>

<template>
  <!-- <div>
    <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <router-link to="/" class="nav-link">Principal</router-link>
              </li>
              <li class="nav-item">
                <router-link to="/pacientes" class="nav-link">Pacientes</router-link>
              </li>
              <li class="nav-item">
                <router-link to="/agendamentos" class="nav-link">Agendamentos</router-link>
              </li>
              <li class="nav-item">
                <router-link to="/consultas" class="nav-link">Consultas</router-link>
              </li>
              <li class="nav-item">
                <router-link to="/testes" class="nav-link">Testes</router-link>
              </li>
            </ul>
          </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
          <router-view />
        </main>
      </div>
    </div>
  </div> -->

  <header class="p-3 custom-bg">
    <div class="container text-center">
    
      <div>
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
            <use xlink:href="#bootstrap"></use>
          </svg>
        </a>
        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <router-link to="/" class="nav-link">Principal</router-link>
          <router-link to="/pacientes" class="nav-link">Pacientes</router-link>
          <router-link to="/agendamentos" class="nav-link">Agendamentos</router-link>
          <router-link to="/consultas" class="nav-link">Consultas</router-link>
          <router-link to="/Testes" class="nav-link">Testes</router-link>
        </ul>
      </div>
    </div>
  </header>
  <main role="main">
    <router-view />
  </main>
</template>

<style scoped>
</style>
