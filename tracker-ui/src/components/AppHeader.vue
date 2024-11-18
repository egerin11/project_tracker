<template>
  <header>
    <nav>
      <h1 @click="goHome" class="logo">Project Manager</h1>
      <div class="buttons">
        <button @click="openModal" class="create-project-btn">Create Project</button>
      </div>
    </nav>
    <CreateProjectModal v-if="showModal" @close="closeModal" is-visible/>
  </header>
</template>

<script>

import CreateProjectModal from "@/components/CreateProjectModal.vue";

export default {
  name: "AppHeader",
  components: {
    CreateProjectModal,
  },
  data() {
    return {
      showModal: false,
    };
  },
  methods: {
    openModal() {
      this.showModal = true;
    },
    closeModal() {
      this.showModal = false;
    },
    goHome() {
      this.$router.push({ name: 'home' });
    },
  },
};
</script>



<style scoped>
header {
  background-color: #333;
  color: white;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  padding: 1rem 2rem;
  z-index: 1000;
  box-shadow: 0 4px 2px -2px gray;
}

nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  max-width: 1200px;
  margin: 0 auto;
  position: relative;
}

.logo {
  margin: 0;
  font-size: 1.5rem;
  cursor: pointer;
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
}

.buttons {
  display: flex;
  gap: 1rem;
  margin-left: auto;
}

.create-project-btn {
  background-color: #636363;
  border: none;
  color: white;
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

.create-project-btn:hover {
  background-color: #417c42;
}

@media (max-width: 768px) {
  nav {
    flex-direction: row;
    padding: 0 1rem;
  }

  .logo {
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
  }

  .buttons {
    margin-left: auto;
  }
}
</style>