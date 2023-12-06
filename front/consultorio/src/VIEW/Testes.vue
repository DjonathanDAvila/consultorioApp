<script setup>
// defineProps(['title'])
import axios from 'axios';
import { ref, onMounted } from 'vue';
import router from '../main';

const testes = ref([]);

onMounted(() => {
    debugger
    // axios.get('http://localhost:8080/patient')
    //   .then(response => {
    //     patients.value = response.data
    //   })
    debugger
    getPatients();
})


function getPatients() {
    axios.get('http://localhost:8080/test')
        .then(response => {
            testes.value = response.data
        })
}

function editTeste(id) {
    router.push(`/PutTeste/${id}`);
}

function removeTeste(testeID) {
    axios.delete(`http://localhost:8080/test/${testeID}`)
        .then(response => {
            console.log('Paciente excluído com sucesso:', response);
            getPatients();
        })
}

</script>

<template>
    <div class="container mt-4">
        <div class="text-center mt-3"> <!-- Centralizando e adicionando margem acima do botão -->
            <router-link to="/CadTestes">
                <button class="btn btn-success">Adicionar</button>
            </router-link>
        </div>
        <div class="header">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Descrição</th>
                        <th scope="col">Preço</th>
                        <th scope="col">Duração</th>
                        <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody class="table-group-divider">
                    <tr v-for="p in testes" :key="p.id">
                        <td>{{ p.id }}</td>
                        <td>{{ p.name }}</td>
                        <td>{{ p.description }}</td>
                        <td>{{ p.price }}</td>
                        <td>{{ p.duration }}</td>
                        <td>
                            <button @click="editTeste(p.id)" class="btn btn-warning me-2">Alterar</button>
                            <!-- <button @click="validaCarro">Adicionar</button><br> -->
                            <button @click="removeTeste(p.id)" class="btn btn-danger">Remover</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<style scoped></style>