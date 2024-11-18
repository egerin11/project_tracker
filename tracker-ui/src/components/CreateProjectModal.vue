<template>
  <div v-if="isVisible" class="modal-overlay" @click.self="closeModal">
    <div class="modal-content">
      <h2>Create New Project</h2>
      <form @submit.prevent="submitForm">
        <div class="form-group">
          <label for="project-name">Project Name</label>
          <input
              v-model="project.name"
              id="project-name"
              type="text"
              required
              class="input-field"
              placeholder="Enter project name" />
        </div>
        <div class="form-group">
          <label for="project-description">Project Description</label>
          <textarea
              v-model="project.description"
              id="project-description"
              required
              class="input-field"
              placeholder="Enter project description"></textarea>
        </div>
        <button type="submit" class="submit-btn">Create Project</button>
      </form>
      <button class="close-btn" @click="closeModal">Close</button>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'CreateProjectModal',
  props: {
    isVisible: {
      type: Boolean,
      required: true,
    },
  },
  data() {
    return {
      project: {
        name: '',
        description: '',
      },
    };
  },
  methods: {
    closeModal() {
      this.$emit('close');
    },
    async submitForm() {
      try {
        const response = await axios.post("/api/projects", this.project);
        this.$emit('project-created', response.data);
        this.closeModal();
      } catch (error) {
        console.error('Ошибка при создании проекта:', error);
      }
    },
  },
};
</script>

<style scoped>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1001;
}

.modal-content {
  background-color: #6c6767;
  padding: 30px;
  border-radius: 10px;
  width: 400px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

h2 {
  margin-bottom: 20px;
  font-size: 24px;
  color: #fff;
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  font-size: 16px;
  color: #fff;
  margin-bottom: 5px;
}

.input-field {
  width: 100%;
  padding: 12px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f4f4f4;
  transition: border-color 0.3s ease;
}

.input-field:focus {
  border-color: #417c42;
  outline: none;
}

textarea.input-field {
  height: 150px;
  resize: vertical;
}

button {
  width: 100%;
  padding: 12px;
  font-size: 16px;
  border-radius: 5px;
  cursor: pointer;
}

.submit-btn {
  background-color: #417c42;
  color: white;
  border: none;
  transition: background-color 0.3s ease;
}

.submit-btn:hover {
  background-color: #365e36;
}

.close-btn {
  background-color: #e74c3c;
  color: white;
  border: none;
  padding: 8px 15px;
  border-radius: 5px;
  cursor: pointer;
  margin-top: 10px;
  width: 100%;
}

.close-btn:hover {
  background-color: #c0392b;
}
</style>
