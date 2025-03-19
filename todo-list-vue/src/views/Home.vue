<template>
  <div class="min-h-screen flex flex-col justify-center items-center bg-gradient-to-r from-indigo-300 via-blue-300 to-teal-300 p-6">
    <h1 class="text-4xl font-semibold text-center text-gray-800 mb-6">🎉 Bem-vindo ao To-Do List</h1>
    <p class="text-lg text-center text-gray-600 mb-8">Organize suas tarefas de maneira fácil e rápida!</p>

    <router-link
        to="/tasks"
        class="bg-gradient-to-r from-green-500 to-teal-500 text-white py-3 px-6 rounded-xl text-lg font-semibold hover:from-green-600 hover:to-teal-600 transition-all duration-300 transform hover:scale-105"
    >
      Ver Tarefas
    </router-link>
  </div>
</template>

<script setup>
// Nenhum script necessário para esta página, já que é apenas uma tela inicial com link
</script>

<style scoped>
/* Adicionando um efeito suave de sombra no título para destacar */
h1 {
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.1);
}
</style>
