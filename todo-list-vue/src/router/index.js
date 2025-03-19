import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import TaskList from '../views/TaskList.vue';
import TaskCreate from '../views/TaskCreate.vue';
import TaskEdit from '../views/TaskEdit.vue';

const routes = [
    { path: '/', component: Home },
    { path: '/tasks', component: TaskList },
    { path: '/tasks/create', component: TaskCreate },
    { path: '/tasks/edit/:id', component: TaskEdit, props: true }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
