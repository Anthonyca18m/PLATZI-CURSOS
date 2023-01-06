<script setup>

</script>

<template>
  <div>
    Chat view
    <div>
      {{  this.$route ?? 'undefined'  }}

      <hr>
      {{  this.$route.params.id ?? ''  }}
    </div>
  </div>
  
</template>
