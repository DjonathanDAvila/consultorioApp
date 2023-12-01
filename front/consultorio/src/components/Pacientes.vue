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
  debugger
  getPatients();
})


function getPatients() {
  axios.get('http://localhost:8080/patient')
    .then(response => {
      patients.value = response.data
    })
}

function editPatient(id) {
  router.push(`/CadPatient/${id}`);
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
  <div class="header">
    <h2 class="title">Pacientes</h2>
    <!-- <button @click="addPatient" class="btn btn-success">Adicionar</button>         -->
    <router-link to="/CadPatient" class="nav-link"><button class="btn btn-success">Adicionar</button>  </router-link>

  </div>
  <div>
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
      <tbody>
        <tr v-for="p in patients" :key="p.id">
          <td>{{ p.id }}</td>
          <td>{{ p.name }}</td>
          <td>{{ p.sex }}</td>
          <td>{{ p.cpf }}</td>
          <td>{{ new Date(p.bornDate).toLocaleString('pt-BR', {timeZone: 'UTC'}) }}</td>
          <td>
            <button @click="editPatient(p.id)" class="btn btn-warning me-2">Alterar</button>
            <!-- <button @click="validaCarro">Adicionar</button><br> -->
            <button @click="removePatient(p.id)" class="btn btn-danger">Remover</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style>
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 16px;
}

.title {
  margin: 0;
}

.round-button {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: #007bff;
  /* ou qualquer cor desejada */
  color: #fff;
  font-size: 20px;
  border: none;
  cursor: pointer;
}
</style>