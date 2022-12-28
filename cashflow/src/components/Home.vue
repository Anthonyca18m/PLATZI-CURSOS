<template>
  <Layout>
      <template #header>
        <Header></Header>
      </template>
      <template #resume>     
        <Resume
          :total-label="'2022-02-02'"
          :label="'Ahorro total'"  
          :total-amount="100000"
          :amount="1000"
        >
        <template #graphic>graphic
        </template>
        <template #action>action
        </template>
      </Resume>      
      </template>
      <template #movements>
        <Movements></Movements>
      </template>
  </Layout>
</template>

<script>
  import Layout from "./Layout.vue"
  import Header from "./Header.vue"
  import Resume from "./Resume/Index.vue"
  import Movements from "./Movements.vue"

export default {
  components: {
    Layout,
    Header,
    Resume,
    Movements,
  },
  
};
</script>

<style scoped>



</style>
