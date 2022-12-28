<template>
  <div id="app">
    <Suspense>
      <template #default>
        <Home />
      </template>
      <template #fallback>
        <SplashScreen/>
      </template>
    </Suspense>
  </div>
</template>

<script>
import SplashScreen from "@/components/SplashScreen.vue"
import {defineAsyncComponent} from 'vue'

export default {
  components: {
    SplashScreen,
    Home: defineAsyncComponent(() => 
      new Promise((resolve) => {
        setTimeout(() => {
          resolve(import("@/components/Home.vue"))
        }, 1000);
      })
    )
  },
};
</script>

<style>
html, body, .app {
  min-height: 100vh;
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

</style>
