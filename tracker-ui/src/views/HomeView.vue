<template>
  <div>
    <AppHeader/>
    <h2>Projects</h2>
    <div v-if="projects.length">
      <ul>
        <li v-for="project in projects" :key="project.id">
          <router-link :to="{ name: 'ProjectDetails', params: { projectId: project.id }}">
            View Details
          </router-link>
        </li>
      </ul>
    </div>
    <div v-else>
      <p>No projects available.</p>
    </div>
    <AppFooter/>
  </div>
</template>

<script>
import AppHeader from "@/components/AppHeader.vue";
import AppFooter from "@/components/AppFooter.vue";
import axios from "axios";

export default {
  name: "HomeView",
  components: {
    AppFooter,
    AppHeader
  },
  data() {
    return {
      projects: [],
    };
  },
  mounted() {
    this.fetchProjects();
  },
  methods: {
    async fetchProjects() {
      try {
        const response = await axios.get('http://localhost:8080/api/projects');
        this.projects = response.data;
      } catch (error) {
        console.error('Error fetching projects:', error);
      }
    },
  },
};
</script>

<style scoped>
h2 {
  text-align: center;
}
</style>
