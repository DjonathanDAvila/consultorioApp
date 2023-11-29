<script setup>
import HelloWorld from './components/HelloWorld.vue'
import Inicio from './components/Inicio.vue';
import {ref} from 'vue'

</script>

<template>
  <div>
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
  </div>

  <!-- <div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <router-link class="navbar-brand" to="/">Navbar</router-link>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Alterna navegação">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
          <router-link class="nav-item nav-link" to="/">Home</router-link>
          <router-link class="nav-item nav-link" to="/pacientes">Pacientes</router-link>
          <router-link class="nav-item nav-link" to="/agendamentos">Agendamentos</router-link>
          <router-link class="nav-item nav-link" to="/consultas">Consultas</router-link>
          <router-link class="nav-item nav-link" to="/testes">Testes</router-link>
        </div>
      </div>
    </nav>

    <router-view />
  </div>   -->
</template>

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
