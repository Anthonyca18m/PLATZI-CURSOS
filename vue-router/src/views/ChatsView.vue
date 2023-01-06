<script setup>

</script>

<template>
  <div>
    Chat view <br>
    <RouterLink :to="{ name: 'chat', params: {id: 1} }">chat 1</RouterLink>
    <RouterLink :to="{ name: 'chat', params: {id: 2} }">chat 2</RouterLink>
    

    <RouterView />
  </div>
  
</template>
