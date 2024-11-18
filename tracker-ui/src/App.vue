<script setup>
import { RouterView } from 'vue-router'
</script>

<template>
  <div class="app-wrapper">
    <router-view />
  </div>
</template>

<style scoped>
.app-wrapper {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  align-items: center;
  justify-content: center;
  width: 100%;
}
</style>