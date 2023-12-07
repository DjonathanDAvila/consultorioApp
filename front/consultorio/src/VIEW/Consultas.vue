<script setup>
import axios from 'axios';
import { ref, onMounted } from 'vue';
import router from '../main';

const consultas = ref([]);

onMounted(() => {
    getConsulta()
})

function getConsulta() {
    axios.get('http://localhost:8080/service')
        .then(response => {
            consultas.value = response.data
        })
}


function editConsulta(id) {
    // router.push(`/PutTeste/${id}`);
}

function removeConsulta(ConsultaID) {
    axios.delete(`http://localhost:8080/service/${ConsultaID}`)
        .then(response => {
            console.log('Paciente excluído com sucesso:', response);
            getConsulta();
        })
}
</script>

<template>
    <div class="container-fluid mt-4">
        <div class="titulo"> <!-- Centralizando e adicionando margem acima do botão -->
            <h1>Consultas realizadas</h1>
            <router-link to="/CadConsulta"><button class="btn btn-success">Adicionar</button> </router-link>
        </div>
        <div class="header">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Agendamento</th>
                        <th scope="col">Paciente</th>
                        <th scope="col">Teste Aplicado</th>
                        <th scope="col">Valor da consulta</th>
                        <th scope="col">Forma pagamento</th>
                        <th scope="col">Data/hora</th>
                    </tr>
                </thead>
                <tbody class="table-group-divider">
                    <tr v-for="p in consultas" :key="p.id">
                        <td>{{ p.id }}</td>
                        <td>{{ p.scheduling.id }}</td>
                        <td>{{ p.scheduling.patient.name }}</td>
                        <td>{{ p.scheduling.test.name }}</td>
                        <td>{{ p.price }}</td>
                        <td>{{ p.paymentType.type }}</td>
                        <td>{{ new Date(p.scheduling.date).toLocaleString('pt-BR', { timeZone: 'UTC' }) }}</td>
                        <td>
                            <button @click="editConsulta(p.id)" class="btn btn-warning me-2">Alterar</button>
                            <!-- <button @click="validaCarro">Adicionar</button><br> -->
                            <button @click="removeConsulta(p.id)" class="btn btn-danger">Remover</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<style>
.titulo {
    margin-left: 30px;
}
</style>