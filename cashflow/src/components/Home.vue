<template>
  <Layout>
      <template #header>
        <Header></Header>
      </template>
  </Layout>
</template>

<script>
  import Layout from "./Layout.vue"
  import Header from "./Header.vue"

export default {
  components: {
    Layout,
    Header,
  }
};
</script>

<style scoped>

  .header, .resume, .movements {
    display: flex;
    justify-content: space-around;
    justify-items: center;
    padding: 14px 0px;
    box-sizing: border-box;
  }
  .header {
    position: fixed;
    width: 100vw;
  }

</style>
