<template>
  <div>
    <label for="">usuario</label>
    <input v-model="username" type="text" />
    <button @click="submit">submit</button>
  </div>
</template>



<script setup>
  import { ref } from 'vue'
  import { useRouter } from 'vue-router'

  const username = ref('')
  const router = useRouter()

  const submit = () => {
    
    router.push({name: 'chats'})
  }

</script>