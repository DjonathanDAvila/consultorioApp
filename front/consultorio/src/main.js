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
import CadPaciente from './components/CadPaciente.vue'
import PutPaciente from './view/PutPaciente.vue'
import CadTestes from './view/CadTestes.vue' 
import Testes from './view/Testes.vue'
import PutTeste from './view/PutTeste.vue'
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  { path: '/', component: Inicio },
  { path: '/pacientes', component: Pacientes },
  { path: '/agendamentos', component: Agendamentos },
  { path: '/consultas', component: Consultas },
  { path: '/CadPaciente', component: CadPaciente },
  { path: '/PutPaciente/:id', component: PutPaciente },
  { path: '/CadTestes', component: CadTestes },
  { path: '/Testes', component: Testes },
  { path: '/PutTeste/:id', component: PutTeste }
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

const app = createApp(App)
app.use(router)
app.mount('#app')

export default router;