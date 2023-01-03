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
        <template #graphic>
          <Graphic :amounts="amounts"/>
        </template>
        <template #action>
          <Action />
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
  import Graphic from "./Resume/Graphic.vue"
  import Movements from "./Movements/Index.vue"
  import Action from './Action.vue'

export default {
  components: {
    Layout,
    Header,
    Resume,
    Action,
    Graphic,
    Movements,
    
  },
  data: () => ({
    total: null,
    label: null,
    amount: null,
    movements: [
      {
        id: 1,
        title: 'loren akosmd lasdjiw',
        description: 'lorem jknasdmejh nmehasn kjadisd',
        amount: -1000,
        time: new Date("12-01-2022")
      },
      {
        id: 2,
        title: 'loren akosmd lasdjiw 2',
        description: 'lorem jknasdmejh nmehasn kjadisd',
        amount: 2000,
        time: new Date("12-14-2022")
      },
      {
        id: 3,
        title: 'loren akosmd lasdjiw 3',
        description: 'lorem jknasdmejh nmehasn kjadisd',
        amount: 3000,
        time: new Date("12-23-2022")
      },
      {
        id: 4,
        title: 'loren akosmd lasdjiw 4',
        description: 'lorem jknasdmejh nmehasn kjadisd',
        amount: 4000,
        time: new Date("12-20-2022")
      },
      {
        id: 5,
        title: 'loren akosmd lasdjiw 5',
        description: 'lorem jknasdmejh nmehasn kjadisd',
        amount: 1000,
        time: new Date("12-10-2022")
      },
    ],
  }),
  computed: {
    amounts(){
      const lastDays = this.movements
        .filter(m => {
          const today = new Date()
          const oldDate = today.setDate(today.getDate() - 30)
          
          return m.time >= oldDate
        })
        .map( m =>  m.amount)

        return lastDays.map((m, i) => {
          const lastMovements = lastDays.slice(0, i)

          return lastMovements.reduce((sum, movement) => {
            return sum + movement
          }, 0)
        })
    },
  },
  
};
</script>

<style scoped>



</style>
