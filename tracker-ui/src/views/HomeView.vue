<template>
  <div class="home-view">
    <AppHeader />
    <div class="container">
      <br>
      <div v-if="projects.length" class="projects-grid-container">
        <ProjectGrid :projects="projects" />
      </div>
      <div v-else>
        <p class="no-projects">No projects available.</p>
      </div>
    </div>
  </div>
</template>

<script>
import AppHeader from "@/components/AppHeader.vue";
import axios from "axios";
import ProjectGrid from "@/components/ProjectGrid.vue";

export default {
  name: "HomeView",
  components: {
    AppHeader,
    ProjectGrid,
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
        const response = await axios.get("/api/projects");
        this.projects = response.data;
      } catch (error) {
        console.error("Error fetching projects:", error);
      }
    },
  },
};
</script>

<style scoped>
.home-view {
  width: 100%;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.container {
  padding: 80px 20px 20px;
  width: 80%;
  max-width: 1200px;
  margin: 0 auto;
  box-sizing: border-box;
}

h2 {
  text-align: center;
  font-size: 2rem;
  margin-bottom: 40px;
  color: #fff;
}

.no-projects {
  text-align: center;
  font-size: 1.2rem;
  color: #777;
  margin-top: 20px;
}

.projects-grid-container {
  display: flex;
  justify-content: center;
}
</style>