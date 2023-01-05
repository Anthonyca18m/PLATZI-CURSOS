<template>
  <Layout>
      <template #header>
        <Header></Header>
      </template>
      <template #resume>     
        <Resume
          :total-label="label"
          :label="'Ahorro total'"  
          :total-amount="totalAmount"
          :amount="amount"
        >
        <template #graphic>
          <Graphic :amounts="amounts"/>
        </template>
        <template #action>
          <Action @create="create"/>
        </template>
      </Resume>      
      </template>
      <template #movements>
        <Movements :movements="movements" @remove="remove"></Movements>
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
    movements: [],
  }),
  methods: {
    create(movement) {
      this.movements.push(movement)
      this.save()
    },
    remove(id) {
      const index = this.movements.findIndex(m => m.id === id)
      this.movements.splice(index, 1)
      this.save()
    },
    save() {
      localStorage.setItem('movements', this.movements)
    },
  },
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
    totalAmount() {
      return this.movements.reduce((suma, m) => {
        return suma + m.amount
      }, 0)
    }
  },
  mounted() {
    const movements = localStorage.getItem('movements')

    if (Array.isArray(movements)) {
      this.movements = movements.map(m => {
        return {...m, time: new Date(m.time) }
      })  
    }
    
  }
  
};
</script>

<style scoped>



</style>
