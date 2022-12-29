<template>
  <div>
    <div class="movement">
      <div class="content">
        <h4>{{ title }}</h4>
        <p>{{ description }}</p>
      </div>
      <div class="action">
        <img src="@/assets/trash.png" width="25" alt="Remove" @click="remove(id)" />
        <p :class="{ 'red': isNegative, 'green': !isNegative }">{{ amountVisual }}</p>
      </div>
    </div>
  </div>
</template>

<script setup>
import { defineProps, toRefs, computed, defineEmits } from "vue";

const formatx = Intl.NumberFormat("es-PE", { style: 'currency', currency: 'PEN' });

const props = defineProps({
  id: { type: Number },
  title: { type: String },
  description: { type: String },
  amount: { type: Number },
});

const { id, title, description, amount } = toRefs(props);

const emit = defineEmits(['remove'])

const amountVisual = computed(() => formatx.format(amount.value))
const isNegative = computed(() => amount.value < 0 )

const remove = (id) => {
    emit('remove', id)
};


</script>

<style scoped>
.movement {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  padding: 16px;
  background-color: #e6f9ff;
  border-radius: 8px;
  box-sizing: border-box;
}
.movement .content {
  /* width: 100%; */
}
.movement .action {
  display: flex;
  justify-content: space-between;
  align-items: flex-end;
  flex-direction: column;
}
h4,
p {
  margin: 0;
  padding: 0;
}
h4 {
  margin-bottom: 8px;
}
.movement .action img {
  margin-bottom: 16px;
}
.red {
  color: red;
  font-weight: 600;
}
.green {
  color: green;
  font-weight: 600;
}
</style>