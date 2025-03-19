<template>
  <div>
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/tasks">Tarefas</router-link>
    </nav>
    <router-view />
  </div>
</template>

<script setup>
</script>

<style>
nav {
  margin-bottom: 20px;
}
nav a {
  margin-right: 10px;
}
</style>
