<template>
    
    <button @click="showModal = true">Agregar movimiento</button>
    
    <teleport to="#app">
        <Modal v-show="showModal" @close="showModal = !showModal">
            Aqui Formulario
        </Modal>
    </teleport>    
</template>

<script setup>
import Modal from './Modal.vue'

import { ref } from 'vue';

const showModal = ref(false)

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