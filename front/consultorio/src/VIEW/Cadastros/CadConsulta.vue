<script setup>
import axios from 'axios';
import { ref, onMounted } from 'vue';
import router from '../../main';

const agendamentos = ref([]);
const formasPagamento = ref([]);
const preco = ref('');
const obs = ref('');

const selectedAgendamento = ref(null);
const selectedFormaPagamento = ref(null);

onMounted(() => {
    getAgendamentos();
    getFormaPagamento();
});

function getAgendamentos() {
    axios.get('http://localhost:8080/scheduling')
        .then(response => {
            agendamentos.value = response.data;
            console.log(agendamentos);
        });
}

function getFormaPagamento() {
    axios.get('http://localhost:8080/paymentType')
        .then(response => {
            formasPagamento.value = response.data;
        });
}

const submitForm = () => {
    debugger;
    const consultaData = {
        price: preco.value,
        paymentTypeID: selectedFormaPagamento.value.id,
        schedulingID: selectedAgendamento.value.id,
        obs: obs.value,
    };
    axios.post('http://localhost:8080/service', consultaData)
        .then(response => {
            console.log('Paciente criado com sucesso:', response.data);
            // Limpe os campos após a criação bem-sucedida, se necessário
            preco.value = '';
            selectedFormaPagamento.value = null;
            selectedAgendamento.value = null;
            obs.value = '';

            router.push('/Consultas', () => { });
        })
        .catch(error => {
            console.error('Erro ao criar paciente:', error);
        });
};
</script>

<template>
    <div class="row d-flex justify-content-center">

        <div class="titulo"> <!-- Centralizando e adicionando margem acima do botão -->
            <h1>Cadastro consulta</h1>
        </div>

        <form class="col-md-6">
            <div class="mb-3">
                <label for="inputText" class="form-label">Agendamento</label>
                <select class="form-select" aria-label="Default select example" v-model="selectedAgendamento">
                    <option selected value="">Selecione o agendamento</option>
                    <option v-for="p in agendamentos" :key="p.id" :value="p">
                        {{ p.id }} - Paciente: {{ p.patient.name }} - Teste: {{ p.test.name }} - Status: {{
                            p.status.description }} - Data: {{ new Date(p.date).toLocaleString('pt-BR', { timeZone: 'UTC' }) }}
                    </option>
                </select>
            </div>

            <div class="mb-3">
                <label for="inputText" class="form-label">Valor da consulta</label>
                <input type="text" class="form-control" v-model="preco" required>
            </div>

            <div class="mb-3">
                <label for="inputText" class="form-label">Forma de pagamento</label>
                <select class="form-select" aria-label="Default select example" v-model="selectedFormaPagamento">
                    <option selected value="">Selecione a forma de pagamento</option>
                    <option v-for="p in formasPagamento" :key="p.id" :value="p">
                        {{ p.id }} {{ p.type }}
                    </option>
                </select>
            </div>

            <div class="mb-3">
                <label for="exampleFormControlTextarea1">Observações</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" v-model="obs"></textarea>
            </div>
            <div class="mb-3">
                <button @click="submitForm()" type="button" class="btn btn-success">Cadastrar</button>
            </div>
        </form>
    </div>
</template>

<style scoped>
.col-md-6 {
    margin-top: 1vw;
}

.form-label {
    margin-top: 1vw;
}

.titulo {
    margin-left: 970px;
}
</style>
