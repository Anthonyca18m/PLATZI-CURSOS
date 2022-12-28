<template>
  <Layout>
      <template #header>
        <Header></Header>
      </template>
      <template #resume>     
        <Resume
          :total-label="label"
          :label="'Ahorro total'"  
          :total-amount="100000"
          :amount="amount"
        >
        <template #graphic>graphic
        </template>
        <template #action>action
        </template>
      </Resume>      
      </template>
      <template #movements>
        <Movements :movements="movements"></Movements>
      </template>
  </Layout>
</template>

<script>
  import Layout from "./Layout.vue"
  import Header from "./Header.vue"
  import Resume from "./Resume/Index.vue"
  import Movements from "./Movements/Index.vue"

export default {
  components: {
    Layout,
    Header,
    Resume,
    Movements,
  },
  data: () => ({
    total: null,
    label: null,
    movements: [
      {
        id: 1,
        title: 'loren akosmd lasdjiw',
        description: 'lorem jknasdmejh nmehasn kjadisd',
        amount: 1000,
      },
      {
        id: 2,
        title: 'loren akosmd lasdjiw 2',
        description: 'lorem jknasdmejh nmehasn kjadisd',
        amount: 1000,
      },
      {
        id: 3,
        title: 'loren akosmd lasdjiw 3',
        description: 'lorem jknasdmejh nmehasn kjadisd',
        amount: 1000,
      },
      {
        id: 4,
        title: 'loren akosmd lasdjiw 4',
        description: 'lorem jknasdmejh nmehasn kjadisd',
        amount: 1000,
      },
      {
        id: 5,
        title: 'loren akosmd lasdjiw 5',
        description: 'lorem jknasdmejh nmehasn kjadisd',
        amount: 1000,
      },
    ]
  })
  
};
</script>

<style scoped>



</style>
