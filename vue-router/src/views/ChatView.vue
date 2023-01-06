<template>
    <div>
        <div v-for="m in messagesFilter" :key="m.id">
            {{  m.message  }}
        </div>
    </div>
</template>
<script>
export default {
    data: () => ({
        messages: [
            { id: 1, message: 'message 1', author: 1 },
            { id: 2, message: 'message 2', author: 2 },
            { id: 3, message: 'message 3', author: 1 },
            { id: 4, message: 'message 4', author: 2 },
            { id: 5, message: 'message 5', author: 1 },
        ]
    }),
    computed: {
        messagesFilter () {
            return this.messages.filter(m => `${m.author}` === this.$route.params.id)
        }
    }
}
</script>

<style scoped>

</style>