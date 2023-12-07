<script setup>
import axios from 'axios';
import { ref, onMounted } from 'vue';
import router from '../main';

const patientId = ref(null)
const nome = ref('');
const cpf = ref('');
const sexo = ref('');
const dataNascimento = ref('');

const submitForm = () => {
    const [dia, mes, ano] = dataNascimento.value.split('/');
    const dataObj = new Date(`${ano}-${mes}-${dia}`);
    const patientData = {
        name: nome.value,
        sex: sexo.value,
        cpf: cpf.value,
        bornDate: dataObj
    }
    axios.post('http://localhost:8080/patient', patientData)
        .then(response => {
            console.log('Paciente criado com sucesso:', response.data);
            // Limpe os campos após a criação bem-sucedida, se necessário
            patientId.value = null;
            nome.value = '';
            cpf.value = '';
            sexo.value = '';
            dataNascimento.value = '';

            router.push('/Pacientes', () => { });
        })
        .catch(error => {
            console.error('Erro ao criar paciente:', error);
        });
};

</script>

<template>
    <div class="row d-flex justify-content-center">

        <div class="titulo"> <!-- Centralizando e adicionando margem acima do botão -->
            <h1>Cadastro paciente</h1>
        </div>

        <form class="col-md-6">
            <div class="mb-3">
                <label for="inputText" class="form-label">Nome</label>
                <input type="text" class="form-control" v-model="nome" required>
            </div>
            <div class="mb-3">
                <label for="text" class="form-label">CPF</label>
                <input type="text" class="form-control" v-model="cpf">
            </div>
            <div class="mb-3">
                <label for="inputEstado">Sexo</label>
                <select id="inputEstado" class="form-control" v-model="sexo" required>
                    <option selected value="">Escolher...</option>
                    <option>M</option>
                    <option>F</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="validationCustom04">Data Nascimento</label>
                <input type="date" class="form-control" id="validationCustom04" v-model="dataNascimento" required>
            </div>
            <div class="mb-3">
                <router-link to="/pacientes">
                    <button @click="submitForm" type="button" class="btn btn-success">Cadastrar</button>
                </router-link>
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