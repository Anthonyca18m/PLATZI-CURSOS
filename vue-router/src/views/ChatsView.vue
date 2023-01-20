<script setup>

</script>

<template>
  <div>
    Chat view <br>
    <RouterLink v-for="(c,i) in chats" :key="i" :to="{ name: 'chat', params: { id : c.id ?? '' } }">{{ c.name ?? '' }}</RouterLink>
    <!-- <RouterLink :to="{ name: 'chat', params: {id: 2} }">chat 2</RouterLink> -->
    

    <RouterView />
  </div>
  
</template>

<script setup>
  import { ref, watch } from 'vue'
  import { useRoute } from 'vue-router'

  const route = useRoute()

  const chats = ref()


  watch(() => route.params , (val) => {
    console.log('updated params', val)
    chats.value = [
      { id: 1, name: 'chat 1' },
      { id: 2, name: 'chat 2' },
      { id: 3, name: 'chat 3' },
    ]
  }, { immediate: true })


</script>
