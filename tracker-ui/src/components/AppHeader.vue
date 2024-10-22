<template>
  <header>
    <nav>
      <h1>Project Manager</h1>
      <div class="buttons">
        <button @click="createProject">Create Project</button>
        <button @click="goHome">Home</button>
      </div>
    </nav>
  </header>
</template>

<script>
export default {
  name: "AppHeader",
  methods: {
    createProject() {
      this.$emit('create-project');
      this.$router.push({ name: 'CreateProject' });
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
  padding: 1rem;
}
nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
nav h1 {
  margin: 0;
}
.buttons {
  display: flex;
  gap: 1rem;
}
nav button {
  border: none;
  padding: 0.5rem 1rem;
  cursor: pointer;
  border-radius: 4px;
}
nav button:hover {
  background-color: #696a6e;
}
</style>
