<script setup>
import axios from 'axios';
import { ref, onMounted } from 'vue';
import router from '../main';
import { useRoute } from 'vue-router';

const route = useRoute();

const teste = ref([]);

const testeID = ref(null)
const nome = ref('');
const descricao = ref('');
const preco = ref('');
const duracao = ref('');


onMounted(() => {
    const routerTesteID = route.params.id;
    testeID.value = routerTesteID;
    axios.get('http://localhost:8080/test/' + routerTesteID)
        .then(response => {
            // paciente.value = response.data;
            console.info(teste.value);
            nome.value = response.data.name;
            descricao.value = response.data.description;
            preco.value = response.data.price;
            duracao.value = response.data.duration;
        })
})


const submitForm = () => {
    const testeData = {
        name: nome.value,
        description: descricao.value,
        price: preco.value,
        duration: duracao.value
    }
    axios.put('http://localhost:8080/test/' + testeID.value, testeData)
        .then(response => {
            console.log('Teste ALTERADO com sucesso:', response.data);
            // Limpe os campos após a criação bem-sucedida, se necessário
            testeID.value = null;
            nome.value = '';
            descricao.value = '';
            preco.value = '';
            duracao.value = '';

            router.push('/Testes', () => { });
        })
        .catch(error => {
            console.error('Erro ao alterar teste:', error);
        });
};

</script>

<template>
    <div class="row d-flex justify-content-center">

        <div class="titulo"> <!-- Centralizando e adicionando margem acima do botão -->
            <h1>Alterar teste</h1>
        </div>

        <form class="col-md-6">
            <div class="mb-3">
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
                <button @click="submitForm" type="button" class="btn btn-warning">Alterar</button>
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