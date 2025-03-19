<template>
  <div class="min-h-screen flex items-center justify-center bg-gray-100">
    <div class="w-full max-w-2xl bg-white shadow-lg rounded-xl p-6">
      <h1 class="text-2xl font-semibold text-center text-gray-800 mb-6">📋 Lista de Tarefas</h1>

      <router-link
          to="/tasks/create"
          class="block w-full bg-green-600 text-white py-3 rounded-lg text-center hover:bg-green-700 transition-all duration-200 mb-4"
      >
        ➕ Criar Nova Tarefa
      </router-link>

      <ul v-if="tasks.length" class="space-y-3">
        <li
            v-for="task in tasks"
            :key="task.id"
            class="flex justify-between items-center bg-gray-50 p-4 rounded-lg shadow-sm border border-gray-300"
        >
          <div>
            <span :class="{ 'line-through text-gray-500': task.completed }" class="font-medium text-lg">
              {{ task.title }}
            </span>
            <p class="text-sm text-gray-600">{{ task.completed ? '✅ Concluída' : '⏳ Pendente' }}</p>
          </div>

          <div class="space-x-2">
            <router-link
                :to="`/tasks/edit/${task.id}`"
                class="bg-blue-600 text-white px-4 py-2 rounded-lg hover:bg-blue-700 transition-all"
            >
              ✏️ Editar
            </router-link>

            <button
                @click="deleteTask(task.id)"
                class="bg-red-600 text-white px-4 py-2 rounded-lg hover:bg-red-700 transition-all"
            >
              🗑️ Excluir
            </button>
          </div>
        </li>
      </ul>

      <p v-else class="text-center text-gray-500 mt-4">Nenhuma tarefa encontrada.</p>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';

const tasks = ref([]);

onMounted(async () => {
  try {
    const response = await fetch('http://localhost:8080/tasks');
    tasks.value = await response.json();
  } catch (error) {
    console.error('Erro ao buscar tarefas:', error);
  }
});

const deleteTask = async (id) => {
  if (!confirm('Tem certeza que deseja excluir esta tarefa?')) return;

  try {
    await fetch(`http://localhost:8080/tasks/${id}`, { method: 'DELETE' });
    tasks.value = tasks.value.filter(task => task.id !== id);
  } catch (error) {
    console.error('Erro ao excluir tarefa:', error);
  }
};
</script>
