<template>
  <div>
    <h1>Criar Tarefa</h1>
    <form @submit.prevent="createTask">
      <input v-model="taskName" placeholder="Nome da Tarefa" />
      <button type="submit">Salvar</button>
    </form>
  </div>
</template>
<script setup>
import { ref } from 'vue';
const taskName = ref('');
async function createTask() {
  await fetch('http://localhost:8080/tasks/', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ name: taskName.value.trim() })
  });
}
</script>
