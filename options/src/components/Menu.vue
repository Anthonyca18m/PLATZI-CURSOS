<template>
    <ul>
        <li v-for="i in 10" :key="i">
            <li>{{ i }}</li>
        </li>
    </ul>
</template>

<script>
export default {
    name: 'Menu',
    data: () => ({

    })
}
</script>