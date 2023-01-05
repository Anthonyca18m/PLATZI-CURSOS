<template>
    <div class="movements">
      <h2 class="title">Historial</h2>
      <div class="content">
        <Movement 
          v-for="(m, i) in movements" :key="i" 
          :id="m.id"
          :title="m.title"
          :description="m.description"
          :amount="m.amount"
          @remove="remove"
         /> 
      </div>
    </div>
</template>

<script setup>
  import { toRefs, defineProps, defineEmits } from 'vue';
  import Movement from './Movement.vue'

  const props = defineProps({
    movements: {
      type: Array,
      default: () => [],
    }
  }) 

  const emit = defineEmits(['remove'])

  const remove = (id) => { 
    emit('remove', id)
  }

  const { movements } = toRefs(props)

</script>

<style scoped>
.movements {
  max-height: 100%;
  padding: 0 8px;
  margin-bottom: 14px;
}

.title {
  margin: 8px 16px 24px 16px;
  color: var(--brand-blue);
}

.content {
  max-height: 68vh;
  display: flex;
  flex-direction: column;
  gap: 8px;
  overflow-y: scroll;
}
</style>