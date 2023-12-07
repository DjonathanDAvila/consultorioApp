<script setup>
import axios from 'axios';
import { ref, onMounted } from 'vue';
import { format } from 'date-fns'; // Importa a função format
import router from '../main';

const pacientes = ref([]);
const selectPaciente = ref(null);
const testes = ref([]);
const selectTeste = ref(null);
const status = ref([]);
const selectStatus = ref(null);

const dataAgendamento = ref('');

onMounted(() => {
    getPacientes();
    getTestes();
    getStatus();
})


function getPacientes() {
    axios.get('http://localhost:8080/patient')
        .then(response => {
            pacientes.value = response.data
        })
}

function getTestes() {
    axios.get('http://localhost:8080/test')
        .then(response => {
            testes.value = response.data
        })
}

function getStatus() {
    axios.get('http://localhost:8080/status')
        .then(response => {
            status.value = response.data
        })
}

const submitForm = () => {
    const [ano, mes, dia] = dataAgendamento.value.split('T')[0].split('-');
    const [hora, minuto] = dataAgendamento.value.split('T')[1].split(':');
    const dataObj = new Date(ano, mes - 1, dia, hora, minuto);


    const formattedDate = format(dataObj, 'yyyy-MM-dd HH:mm:ss');

    const agendamentoData = {
        patientID: selectPaciente.value.id,
        testID: selectTeste.value.id,
        statusID: selectStatus.value.id,
        date: formattedDate
    };
    debugger
    axios.post('http://localhost:8080/scheduling', agendamentoData)
        .then(response => {
            console.log('Paciente criado com sucesso:', response.data);
            // Limpe os campos após a criação bem-sucedida, se necessário
            selectPaciente.value = null;
            selectTeste.value = null;
            selectStatus.value = null;
            dataAgendamento.value = '';

            router.push('/agendamentos', () => { });
        })
        .catch(error => {
            console.error('Erro ao criar paciente:', error);
        });
};

</script>

<template>
    <div class="row d-flex justify-content-center">

        <div class="titulo"> <!-- Centralizando e adicionando margem acima do botão -->
            <h1>Cadastro agendamento</h1>
        </div>

        <form class="col-md-6">
            <div class="mb-3">
                <label for="inputText" class="form-label">Paciente</label>
                <select class="form-select" aria-label="Default select example" v-model="selectPaciente">
                    <option selected value="">Selecione o paciente</option>
                    <option v-for="p in pacientes" :key="p.id" :value="p">
                        {{ p.id }} - Paciente: {{ p.name }} - CPF: {{ p.cpf }}
                    </option>
                </select>
            </div>

            <div class="mb-3">
                <label for="inputText" class="form-label">Teste</label>
                <select class="form-select" aria-label="Default select example" v-model="selectTeste">
                    <option selected value="">Selecione o teste</option>
                    <option v-for="p in testes" :key="p.id" :value="p">
                        {{ p.id }} - {{ p.name }}
                    </option>
                </select>
            </div>

            <div class="mb-3">
                <label for="inputText" class="form-label">Status</label>
                <select class="form-select" aria-label="Default select example" v-model="selectStatus">
                    <option selected value="">Selecione o status</option>
                    <option v-for="p in status" :key="p.id" :value="p">
                        {{ p.id }} - {{ p.description }}
                    </option>
                </select>
            </div>

            <!-- <div class="mb-3">
                <label for="validationCustom04">Data</label>
                <input type="date" class="form-control" id="validationCustom04" v-model="dataAgendamento" required>
            </div> -->

            <div class="mb-3">
                <label for="validationCustom04">Data e Hora</label>
                <input type="datetime-local" class="form-control" id="validationCustom04" v-model="dataAgendamento"
                    required>
            </div>

            <div class="mb-3">
                <!-- <router-link to="/pacientes"> -->
                <button @click="submitForm" type="button" class="btn btn-success">Agendar</button>
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