<template>
  <div>
    <h1>Lista de Tarefas</h1>
    <router-link to="/tasks/create">Criar Nova Tarefa</router-link>
    <ul>
      <li v-for="task in tasks" :key="task.id">
        {{ task.name }}
        <router-link :to="`/tasks/edit/${task.id}`">Editar</router-link>
      </li>
    </ul>
  </div>
</template>
<script setup>
import { ref, onMounted } from 'vue';

const tasks = ref([]);

onMounted(async () => {
  const response = await fetch('http://localhost:8000/api/tasks');
  tasks.value = await response.json();
});
</script>