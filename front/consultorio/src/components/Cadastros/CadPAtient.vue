<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRoute } from 'vue-router';

const route = useRoute();

// const patients = ref({});
// const patients = ref([]);
const patientId = ref(null)
const nome = ref('');
const cpf = ref('');
const sexo = ref('');
const dataNascimento = ref('');

onMounted(() => {
    // Obtém o ID do paciente da rota
    const routerpacienteId = route.params.id;

    debugger
    if (routerpacienteId) {
        axios.get(`http://localhost:8080/patient/${routerpacienteId}`)
            // axios.get('http://localhost:8080/patient')
            .then(response => {
                // patients.value = response.data
                console.log(response.data)
                nome.value = response.data.name;
                cpf.value = response.data.cpf;
                sexo.value = response.data.sex;
                dataNascimento.value = response.data.bornDate;
            })
        debugger;
        patientId.value = routerpacienteId;
    }
});

const submitForm = () => {
    debugger;
    const [dia, mes, ano] = dataNascimento.value.split('/');
    const dataObj = new Date(`${ano}-${mes}-${dia}`);
    const patientData = {
        name: nome.value,
        sex: sexo.value,
        cpf: cpf.value,
        bornDate: dataObj
    }

    if (patientId.value == null) {
        debugger
        axios.post('http://localhost:8080/patient', patientData)
            .then(response => {
                console.log('Paciente criado com sucesso:', response.data);
                // Limpe os campos após a criação bem-sucedida, se necessário
                patientId.value = null;
                nome.value = '';
                cpf.value = '';
                sexo.value = '';
                dataNascimento.value = '';
            })
            .catch(error => {
                console.error('Erro ao criar paciente:', error);
            });

    } else {
        debugger
        console.log("ENTROU");
        // axios.put(`http://localhost:8080/patient/${patientId}`, patientData)
        axios.put('http://localhost:8080/patient/' + patientId.value, patientData)
            .then(response => {
                console.log('Paciente ALTERADO com sucesso:', response.data);
                // Limpe os campos após a criação bem-sucedida, se necessário
                patientId.value = null;
                nome.value = '';
                cpf.value = '';
                sexo.value = '';
                dataNascimento.value = '';
            })
            .catch(error => {
                console.error('Erro ao alterar paciente:', error);
            });
        debugger
    }
};

(function () {
    'use strict';
    window.addEventListener('load', function () {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function (form) {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();



</script>

<template>
    <h2>Cadastro de paciente</h2>
    <form class="needs-validation" novalidate>
        <div class="form-row">
            <div class="col-md-4 mb-3">
                <label for="validationCustom01">Nome</label>
                <input type="text" class="form-control" id="validationCustom01" v-model="nome" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="validationCustom03">CPF</label>
                <input type="text" class="form-control" id="validationCustom03" v-model="cpf" required>
                <div class="invalid-feedback">
                    Please provide a valid city.
                </div>
            </div>
            <div class="form-group col-md-4">
                <label for="inputEstado">Sexo</label>
                <select id="inputEstado" class="form-control" v-model="sexo">
                    <option selected>Escolher...</option>
                    <option>M</option>
                    <option>F</option>
                </select>
            </div><br>
            <div class="col-md-3 mb-3">
                <label for="validationCustom04">Data Nascimento</label>
                <input type="date" class="form-control" id="validationCustom04" v-model="dataNascimento" required>
                <div class="invalid-feedback">
                    Please provide a valid state.
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="form-check">
                <div class="invalid-feedback">
                    You must agree before submitting.
                </div>
            </div>
        </div>
        <button @click="submitForm" class="btn btn-primary" type="submit">Cadastrar</button>
    </form>
</template>


<style></style>