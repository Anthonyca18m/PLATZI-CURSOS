<template>
  <div>
    <label for="">usuario</label>
    <input v-model="username" type="text" />
    <button @click="submit">submit</button>
  </div>
</template>

<script>
  export default {
    data: () => ({
      username: '',
    }),
    methods: {
      submit() {
        this.$router.push({name: 'chats'}) // ir
        // this.$router.replace({name: 'chats'}) // reemplazar página sin historial
        // this.$router.go(-1) // avanzar o retroceder páginas
      }
    }
  }
</script>