<template>
  <img alt="Vue logo" src="./assets/logo.png" />
  <div>
    <Modal />
  </div>
</template>

<script>
import Modal from "./components/Modal.vue";

// const HelloWorld = defineAsyncComponent(() => import("./components/HelloWorld.vue"));

export default {
  name: "App",
  components: {
    Modal
  },
  data() {
    return {
      
    };
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.fade-leave-to,.fade-enter-from {
  opacity: 0;
}

.fade-leave-active,.fade-enter-active {
  transition: opacity 0.5s ease;

}

</style>
