<template>
    <div>
        <div class="movement">{{ title }}</div>
    </div>
</template>

<script setup>
        import { defineProps, toRefs } from 'vue';

        const props = defineProps({ title: {type: String, } })

        const { title } = toRefs(props)
</script>

<style lang="scss" scoped>

</style>