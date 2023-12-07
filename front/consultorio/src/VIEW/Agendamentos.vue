<script setup>
import axios from 'axios';
import { ref, onMounted } from 'vue';
import router from '../main';

const schedulings = ref([]);

onMounted(() => {
    getAgendamentos();
})

function getAgendamentos() {
    axios.get('http://localhost:8080/scheduling')
        .then(response => {
            schedulings.value = response.data
        })
}

function removeAgendamento(agendamentoID) {
    axios.delete(`http://localhost:8080/scheduling/${agendamentoID}`)
        .then(response => {
            console.log('Paciente excluído com sucesso:', response);
            getAgendamentos();
        })
}

</script>

<template>
    <div class="container mt-4">
        <div class="titulo">
            <h1>Agendamentos</h1>
            <router-link to="/CadAgendamentos">
                <button class="btn btn-success">Adicionar</button>
            </router-link>
        </div>

        <div class="header">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Paciente</th>
                        <th scope="col">CPF</th>
                        <th scope="col">Teste</th>
                        <th scope="col">Status</th>
                        <th scope="col">Data</th>
                        <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody class="table-group-divider">
                    <tr v-for="p in schedulings" :key="p.id">
                        <td>{{ p.id }}</td>
                        <td>{{ p.patient.name }}</td>
                        <td>{{ p.patient.cpf }}</td>
                        <td>{{ p.test.name }}</td>
                        <td>{{ p.status.description }}</td>
                        <!-- <td>{{ p.date }}</td> -->
                        <td>{{ new Date(p.date).toLocaleString('pt-BR', { timeZone: 'UTC' }) }}</td>

                        <td>
                            <button @click="editTeste(p.id)" class="btn btn-warning me-2">Alterar</button>
                            <!-- <button @click="validaCarro">Adicionar</button><br> -->
                            <button @click="removeAgendamento(p.id)" class="btn btn-danger">Remover</button>
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