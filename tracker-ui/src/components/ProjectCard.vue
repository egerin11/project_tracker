<template>
  <div class="project-card">
    <router-link
        :to="{ name: 'ProjectDetails', params: { projectId: project.id } }"
        class="project-link"
    >
      <div class="project-card-body">
        <h3 class="project-name">{{ project.name }}</h3>
        <p class="project-description">{{ project.description }}</p>
      </div>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "ProjectCard",
  props: {
    project: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style scoped>
.project-card {
  background-color: rgba(112, 112, 112, 0.53);
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  width: 100%;
  max-width: none;
  height: 200px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.project-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.15);
}

.project-name {
  font-size: 1.25rem;
  font-weight: bold;
  margin-bottom: 10px;
}

.project-description {
  font-size: 1rem;
  color: #555;
}

.project-link {
  text-decoration: none;
  color: inherit;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 100%;
  background-color: transparent;
}


</style>

