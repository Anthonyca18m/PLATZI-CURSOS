<template>
  <img alt="Vue logo" src="./assets/logo.png" />
  <button @click="show = !show">Menu</button>
  <transition name="fade">
    <Menu v-show="show"></Menu>
  </transition>
</template>

<script>
import Menu from "./components/Menu.vue";
// import { defineAsyncComponent } from "vue";

// const HelloWorld = defineAsyncComponent(() => import("./components/HelloWorld.vue"));

export default {
  name: "App",
  components: {
    Menu,
  },
  data() {
    return {
      show: false,
      componentId: "HelloWorld",
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
