<template>
  <div class="projects-grid">
    <ProjectCard
        v-for="project in projects"
        :key="project.id"
        :project="project"
    />
  </div>
</template>

<script>
import ProjectCard from "@/components/ProjectCard.vue";

export default {
  name: "ProjectGrid",
  components: {
    ProjectCard,
  },
  props: {
    projects: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style scoped>
.projects-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
  width: 100%;
  max-width: none;
  margin: 0 auto;
  box-sizing: border-box;
}

.projects-grid > * {
  flex: 1 1 300px;
  max-width: 300px;
  text-align: center;
  box-sizing: border-box;
}
</style>
