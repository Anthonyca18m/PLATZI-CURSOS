<template>
    
    <button @click="showModal = true">Agregar movimiento</button>
    
    <teleport to="#app">
        <Modal v-show="showModal" @close="showModal = !showModal">
            <form @submit.prevent="submit">
                <div class="field">
                    <label>titulo</label>
                    <input v-model="title" type="text" />
                </div>
                <div class="field">
                    <label>Monto</label>
                    <input v-model="amount" type="number" />
                </div>
                <div class="field">
                    <label>descripción</label>
                    <textarea rows="4" v-model="description"></textarea>
                </div>
                <div class="field">
                    <label class="radio-label">
                        <input type="radio" v-model="movementType" value="Ingreso"/>
                        <span>Ingreso</span>
                    </label>
                </div>
                <div class="field">
                    <label class="radio-label">
                        <input type="radio" v-model="movementType" value="Gasto"/>
                        <span>Gasto</span>
                    </label>
                </div>
                <div class="action">
                    <button>Agregar movimiento</button>
                </div>                
            </form>
        </Modal>
    </teleport>    
</template>

<script setup>
import Modal from './Modal.vue'

import { ref } from 'vue';

const showModal = ref(false)
const {title, description} = ref('')
const amount = ref(0)
const movementType = ref('Ingreso')

const submit = () => { showModal.value = !showModal.value }

</script>

<style scoped>

button {
  color: white;
  font-size: 1.25rem;
  background-color: #000;
  border: none;
  width: 100%;
  padding: 24px 60px;
  border-radius: 60px;
  box-sizing: border-box;
}
form {
  font-size: 1.24rem;
  width: 100%;
}
form .action {
  padding: 0 24px;
}
.field {
  display: flex;
  justify-content: space-between;
  flex-direction: column;
  padding: 16px 24px;
}
label {
  margin-bottom: 8px;
}
input,
textarea {
  font-size: 1.24rem;
  border: 2px solid #000;
  border-radius: 8px;
  padding: 8px;
}
input[type="number"] {
  text-align: right;
}
.radio-label {
  display: flex;
  align-items: center;
  margin-top: 8px;
}
.radio-label span {
  margin-top: 4px;
  margin-left: 8px;
}
input[type="radio"] {
  appearance: none;
  width: 1.24rem;
  height: 1.24rem;
  color: #000;
  border: 2px solid #000;
  border-radius: 50%;
}
input[type="radio"]:checked {
  background-color: #000;
}
</style>