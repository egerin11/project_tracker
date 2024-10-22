<template>
  <div>
<AppHeader/>
    <h2>Project: {{ project.title }}</h2>
    <p>{{ project.description }}</p>

    <h3>Tasks</h3>
    <ul v-if="tasks.length">
      <li v-for="task in tasks" :key="task.id">
        {{ task.title }} ({{ task.status }})
      </li>
    </ul>
    <div v-else>
      <p>No tasks assigned.</p>
    </div>

    <AppFooter/>
  </div>
</template>

<script>

import axios from "axios";
import AppFooter from "@/components/AppFooter.vue";
import AppHeader from "@/components/AppHeader.vue";

export default {
  name: 'ProjectDetails',
  components: {
    AppHeader,
    AppFooter,

  },
  data() {
    return {
      project: {},
      tasks: [],
    };
  },
  created() {
    const projectId = this.$route.params.projectId;
    this.fetchProject(projectId);

  },
  methods: {
    async fetchProject(projectId) {
      try {
        const response = await axios.get(`http://localhost:8080/api/projects/${projectId}`, {
          withCredentials: true,
        });
        this.project = response.data;
      } catch (error) {
        console.error('Error fetching project:', error);
      }
    },
    // async fetchTasks(projectId) {
    //   const response = await axios.get(`/api/tasks/${projectId}`, {
    //     withCredentials: true, // Include credentials in requests
    //   });
    //   this.tasks = response.data;
    // },
  }
};
</script>

<style scoped>
h2 {
  text-align: center;
}
</style>
