<template>
    <div>
        <button @click="toggle">Modal</button>
        <teleport to='body'>
            <div v-show="show" class="modal">
                <h1>asdknkojasndioujskandoujikasnd</h1>
                <p>mikoajnsduias mdolkmasdas</p>
                <button @click="toggle">cerrar</button>
            </div>
        </teleport>
    </div>
</template>
<script>
export default {
    name: 'Modal',
    data: () => ({
        show: false,
    }),
    methods: {
        toggle() {
            this.show = !this.show
        },
    }
}
</script>