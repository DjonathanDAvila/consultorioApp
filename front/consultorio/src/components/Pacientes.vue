<script setup>
// defineProps(['title'])
import axios from 'axios';
import { ref, onMounted } from 'vue';
import router from '../main';

const patients = ref([]);

onMounted(() => {
  // axios.get('http://localhost:8080/patient')
  //   .then(response => {
  //     patients.value = response.data
  //   })
  getPatients();
})


function getPatients() {
  axios.get('http://localhost:8080/patient')
    .then(response => {
      patients.value = response.data
    })
}

function editPatient(id) {
  router.push(`/PutPaciente/${id}`);
}

function removePatient(patientId) {
  axios.delete(`http://localhost:8080/patient/${patientId}`)
    .then(response => {
      console.log('Paciente excluído com sucesso:', response);
      getPatients();
    })
}

</script>

<template>
  <div class="container mt-4">
    <div class="titulo"> <!-- Centralizando e adicionando margem acima do botão -->
      <h1>Pacientes</h1>
      <router-link to="/CadPaciente"><button class="btn btn-success">Adicionar</button> </router-link>
    </div>
    <div class="header">
      <table class="table">
        <thead>
          <tr>
            <th scope="col">id</th>
            <th scope="col">Nome</th>
            <th scope="col">Sexo</th>
            <th scope="col">CPF</th>
            <th scope="col">Data Nascimento</th>
            <th scope="col">Ações</th>
          </tr>
        </thead>
        <tbody class="table-group-divider">
          <tr v-for="p in patients" :key="p.id">
            <td>{{ p.id }}</td>
            <td>{{ p.name }}</td>
            <td>{{ p.sex }}</td>
            <td>{{ p.cpf }}</td>
            <td>{{ new Date(p.bornDate).toLocaleString('pt-BR', { timeZone: 'UTC' }) }}</td>
            <td>
              <button @click="editPatient(p.id)" class="btn btn-warning me-2">Alterar</button>
              <!-- <button @click="validaCarro">Adicionar</button><br> -->
              <button @click="removePatient(p.id)" class="btn btn-danger">Remover</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<style>
.header {
  display: flex;
  padding: 2vw;
  margin: 0 auto;
}
</style>