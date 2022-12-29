<template>
    <div>
        <svg
            viewBox="0 0 300 200"
        >
            <line
                stroke="#c4c4c4"
                stroke-width="2"
                x1="0"
                y1="100"
                x2="300"
                y2="100"
            />
            <polyline
                fill="none"
                stroke="#0689B0"
                stroke-width="2"
                :points="points"
            />
            <line
                stroke="#04b500"
                stroke-width="2"
                x1="200"
                y1="0"
                x2="200"
                y2="200"
            />
        </svg>
        <p>Últimos 30 días</p>
    </div>
</template>
<script setup>

    import { defineProps, toRefs, computed } from 'vue';

    const props = defineProps({
        amounts: {
            type: Array,
            default: () => []
        }
    })

    const { amounts } = toRefs(props)

    const amountToPixels = () => {
        const min = Math.min(...amounts.value)
        const max = Math.max(...amounts.value)

        return `${min}, ${max}`
    }

    const points = computed(() => {
        const total = amounts.value.length
        return Array(total).fill(100).reduce((points, amount, i) => {
            const x = (300 / total) * i
            const y = amountToPixels(amount)
            return `${points} ${x},${y}`
        }, "0, 100")
    })
</script>
<style>
    
</style>