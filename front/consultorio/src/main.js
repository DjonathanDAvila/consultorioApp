// import { createApp } from 'vue'
// import './style.css'
// import App from './App.vue'

// createApp(App).mount('#app')
import { createApp } from 'vue'
import App from './App.vue'
import Inicio from './components/Inicio.vue'
import Pacientes from './components/Pacientes.vue'
import Agendamentos from './VIEW/Agendamentos.vue'
import CadAgendamentos from './VIEW/CadAgendamentos.vue'
import Consultas from './VIEW/Consultas.vue'
import CadPaciente from './components/CadPaciente.vue'
import PutPaciente from './view/PutPaciente.vue'
import CadTestes from './view/CadTestes.vue' 
import Testes from './view/Testes.vue'
import PutTeste from './view/PutTeste.vue'
import CadConsulta from './view/Cadastros/CadConsulta.vue'
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  { path: '/', component: Inicio },
  { path: '/pacientes', component: Pacientes },
  { path: '/agendamentos', component: Agendamentos },
  { path: '/CadAgendamentos', component: CadAgendamentos },
  { path: '/Consultas', component: Consultas },
  { path: '/CadPaciente', component: CadPaciente },
  { path: '/PutPaciente/:id', component: PutPaciente },
  { path: '/CadTestes', component: CadTestes },
  { path: '/Testes', component: Testes },
  { path: '/PutTeste/:id', component: PutTeste },
  { path: '/CadConsulta', component: CadConsulta }

]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

const app = createApp(App)
app.use(router)
app.mount('#app')

export default router;