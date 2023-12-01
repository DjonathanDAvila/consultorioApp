// import { createApp } from 'vue'
// import './style.css'
// import App from './App.vue'

// createApp(App).mount('#app')
import { createApp } from 'vue'
import App from './App.vue'
import Inicio from './components/Inicio.vue'
import Pacientes from './components/Pacientes.vue'
import Agendamentos from './components/Agendamentos.vue'
import Consultas from './components/Consultas.vue'
import Testes from './components/Testes.vue'
import CadPatient from './components/Cadastros/CadPAtient.vue'
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  { path: '/', component: Inicio },
  { path: '/pacientes', component: Pacientes },
  { path: '/agendamentos', component: Agendamentos },
  { path: '/consultas', component: Consultas },
  { path: '/testes', component: Testes },
  { path: '/CadPatient', component: CadPatient },
  { path: '/CadPatient/:id', component: CadPatient },

]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

const app = createApp(App)
app.use(router)
app.mount('#app')

export default router;