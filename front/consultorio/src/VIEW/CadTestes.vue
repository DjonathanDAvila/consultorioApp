<script setup>
import axios from 'axios';
import { ref, onMounted } from 'vue';
import router from '../main';

const testeID = ref(null)
const nome = ref('');
const descricao = ref('');
const preco = ref('');
const duracao = ref('');

const submitForm = () => {
    const testeData = {
        name: nome.value,
        description: descricao.value,
        price: preco.value,
        duration: duracao.value
    }
    axios.post('http://localhost:8080/test', testeData)
        .then(response => {
            console.log('Paciente criado com sucesso:', response.data);
            // Limpe os campos após a criação bem-sucedida, se necessário
            testeID.value = null;
            nome.value = '';
            descricao.value = '';
            preco.value = '';
            duracao.value = '';

            router.push('/Testes', () => { });
        })
        .catch(error => {
            console.error('Erro ao criar paciente:', error);
        });
};

</script>

<template>
    <div class="row d-flex justify-content-center">

        <div class="titulo"> <!-- Centralizando e adicionando margem acima do botão -->
            <h1>Cadastro teste</h1>
        </div>

        <form class="col-md-6">
            <div>
                <label for="inputText" class="form-label">Nome</label>
                <input type="text" class="form-control" v-model="nome" required>
            </div>
            <div class="mb-3">
                <label for="text" class="form-label">Descrição</label>
                <input type="text" class="form-control" v-model="descricao">
            </div>
            <div class="mb-3">
                <label for="text" class="form-label">Preço</label>
                <input type="text" class="form-control" v-model="preco">
            </div>
            <div class="mb-3">
                <label for="text" class="form-label">Duração</label>
                <input type="text" class="form-control" v-model="duracao">
            </div>
            <div class="mb-3">
                <!-- <router-link to="/pacientes"> -->
                <button @click="submitForm" type="button" class="btn btn-primary">Cadastrar</button>
                <!-- </router-link> -->
            </div>
        </form>
    </div>
</template>

<style scoped>
.mb-3 {
    margin-top: 1vw;
}

.form-label {
    margin-top: 1vw;
}

.titulo{
    margin-left: 970px;
}
</style>