<template>
  <div class="min-h-screen flex items-center justify-center bg-gray-100">
    <div class="w-full max-w-md bg-white shadow-lg rounded-xl p-6">
      <h1 class="text-2xl font-semibold text-center text-gray-800 mb-6">✏️ Editar Tarefa</h1>

      <form @submit.prevent="updateTask" class="space-y-4">
        <div>
          <label class="block text-gray-700 font-medium mb-1">Título da Tarefa</label>
          <input
              v-model="task.title"
              required
              class="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 outline-none"
          />
        </div>

        <div class="flex items-center space-x-2">
          <input type="checkbox" v-model="task.completed" class="w-5 h-5 text-blue-500 accent-blue-600" />
          <span class="text-gray-700">Marcar como concluída</span>
        </div>

        <button
            type="submit"
            class="w-full bg-blue-600 text-white py-3 rounded-lg hover:bg-blue-700 transition-all duration-200"
        >
          💾 Atualizar Tarefa
        </button>
      </form>

      <router-link
          to="/tasks"
          class="block text-center mt-4 text-blue-600 hover:underline"
      >
        🔙 Voltar para Lista
      </router-link>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRouter, useRoute } from 'vue-router';

const router = useRouter();
const route = useRoute();
const task = ref({ title: '', completed: false });

onMounted(async () => {
  try {
    const response = await fetch(`http://localhost:8080/tasks/${route.params.id}`);
    task.value = await response.json();
  } catch (error) {
    console.error('Erro ao buscar tarefa:', error);
  }
});

const updateTask = async () => {
  try {
    const response = await fetch(`http://localhost:8080/tasks/${route.params.id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(task.value),
    });

    if (!response.ok) throw new Error('Erro ao atualizar tarefa');

    router.push('/tasks');
  } catch (error) {
    console.error('Erro ao atualizar tarefa:', error);
  }
};
</script>
