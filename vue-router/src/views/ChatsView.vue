<script setup>

</script>

<template>
  <div>
    Chat view <br>
    <RouterLink v-for="(c,i) in chats" :key="i" :to="{ name: 'chat', params: { id : c.id ?? '' } }">{{ c.name }}</RouterLink>
    <!-- <RouterLink :to="{ name: 'chat', params: {id: 2} }">chat 2</RouterLink> -->
    

    <RouterView />
  </div>
  
</template>

<script>
export default {
    data: () => ({
      chats: [],
    }),
    // watch: {
    //   '$route.params': (val) => {
    //     console.log('updated params', val)
    //   }
    // },
    created() {
      this.$watch(
        '$route.params',
        (val) => {
          console.log('updated params', val)
          this.chats = [
            { id: 1, name: 'chat 1' },
            { id: 2, name: 'chat 2' },
            { id: 3, name: 'chat 3' },
          ]
        },
        { immediate: true }
      )
    },
}
</script>