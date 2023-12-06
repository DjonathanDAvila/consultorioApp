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
    <form class="column">
        <div class="col-md-6">
            <label for="inputText" class="form-label">Nome</label>
            <input type="text" class="form-control" v-model="nome" required>
        </div>
        <div class="col-md-6">
            <label for="text" class="form-label">Descrição</label>
            <input type="text" class="form-control" v-model="descricao">
        </div>
        <div class="col-md-6">
            <label for="text" class="form-label">Preço</label>
            <input type="text" class="form-control" v-model="preco">
        </div>
        <div class="col-md-6">
            <label for="text" class="form-label">Duração</label>
            <input type="text" class="form-control" v-model="duracao">
        </div>
        <div class="col-md-6">
            <!-- <router-link to="/pacientes"> -->
            <button @click="submitForm" type="button" class="btn btn-warning">Alterar</button>
            <!-- </router-link> -->
        </div>
    </form>
</template>

<style scoped>
.col-md-6 {
    margin-top: 1vw;
}
</style>