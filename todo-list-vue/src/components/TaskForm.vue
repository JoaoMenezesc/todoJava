<template>
  <form @submit.prevent="submitTask">
    <input v-model="task.name" placeholder="Nome da tarefa" required />
    <button type="submit">Salvar</button>
  </form>
</template>

<script setup>
const props = defineProps({ taskData: Object });
const emit = defineEmits(['submitTask']);

const task = ref({ name: '' });

watch(
    () => props.taskData,
    (newVal) => {
      if (newVal) task.value = { ...newVal };
    },
    { immediate: true }
);

const submitTask = () => {
  if (!task.value.name.trim()) {
    alert('O nome da tarefa não pode estar vazio!');
    return;
  }
  emit('submitTask', task.value);
};
</script>
