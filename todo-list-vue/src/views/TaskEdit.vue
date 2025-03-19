<template>
  <div>
    <h1>Editar Tarefa</h1>
    <form @submit.prevent="updateTask">
      <input v-model="task.name" />
      <button type="submit">Salvar</button>
    </form>
  </div>
</template>
<script setup>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
const route = useRoute();
const task = ref({});

onMounted(async () => {
  const response = await fetch(`http://localhost:8000/api/tasks/${route.params.id}`);
  task.value = await response.json();
});

async function updateTask() {
  await fetch(`http://localhost:8000/api/tasks/${route.params.id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(task.value)
  });
}
</script>
