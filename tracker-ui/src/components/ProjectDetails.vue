<template>
  <div>
    <AppHeader/>
    <div class="project-details">
      <h2>Project: {{ project.name }}</h2>
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

      <div class="buttons">
        <button @click="showUserModal = true" class="add-user-btn">Add User to Project</button>
        <button @click="showTaskModal = true" class="add-task-btn">Assign Task to User</button>
      </div>
    </div>

    <InputComponent :show="showUserModal" @close="closeUserModal">
      <h2>{{ editingUser ? 'Update User' : 'Add User' }}</h2>
      <form @submit.prevent="addUserToProject">
        <div class="dropdown-container">
          <label for="userId">User</label>
          <select v-model="userId" id="userId" required>
            <option disabled value="">Select a user</option>
            <option v-for="user in users" :key="user.id" :value="user.id">{{ user.username }}</option>
          </select>
        </div>
        <button class="add-user-btn" type="submit">{{ editingUser ? 'Update' : 'Confirm' }}</button>
      </form>
    </InputComponent>



    <InputComponent :show="showTaskModal" @close="closeTaskModal">
      <h2>Create New Task</h2>
      <form @submit.prevent="createTask">
        <div class="form-group">
          <label for="taskTitle">Task Title</label>
          <input v-model="taskTitle" type="text" id="taskTitle" required/>
        </div>
        <div class="form-group">
          <label for="taskDescription">Task Description</label>
          <textarea v-model="taskDescription" id="taskDescription" required></textarea>
        </div>
        <div class="form-group">
          <label for="taskStatus">Task Status</label>
          <select v-model="taskStatus" id="taskStatus" required>
            <option value="TODO">TODO</option>
            <option value="IN_PROGRESS">In Progress</option>
            <option value="DONE">Completed</option>
            <option value="BLOCKED">Blocked</option>
          </select>
        </div>
        <div class="form-group">
          <label for="userId">Assign to User</label>
          <select v-model="userIdForTask" id="userId" required>
            <option disabled value="">Select a user</option>
            <option v-for="user in users" :key="user.id" :value="user.id">
              {{ user.username }}
            </option>
          </select>
        </div>
        <button type="submit" class="add-task-btn">Create Task</button>
      </form>
    </InputComponent>
  </div>
</template>

<script>
import axios from "axios";
import AppHeader from "@/components/AppHeader.vue";
import InputComponent from "@/components/InputComponent.vue";

export default {
  name: "ProjectDetails",
  components: {
    AppHeader,
    InputComponent,
  },
  data() {
    return {
      userIdForTask: "",
      taskTitle: "",
      taskDescription: "",
      taskStatus: "TODO",
      project: {},
      tasks: [],
      users: [],
      tasksAvailable: [],
      showUserModal: false,
      showTaskModal: false,
      userId: "",
      taskId: "",
      editingUser: false,
      editingTask: false,
    };
  },
  created() {
    const projectId = this.$route.params.projectId;
    this.fetchProject(projectId);
    this.fetchUsers();
    // this.fetchTasksAvailable();
  },
  methods: {
    async createTask() {
      const projectId = this.project.id;
      const requestPayload = {
        title: this.taskTitle,
        description: this.taskDescription,
        status: this.taskStatus,
        projectId: projectId,
        assignedUserId: this.userIdForTask,
      };

      try {
        const response = await axios.post("/api/tasks", requestPayload, {
          withCredentials: true,
        });
        this.tasks.push(response.data);
        this.showTaskModal = false;
      } catch (error) {
        console.error("Error creating task:", error);
      }
    },

    closeTaskModal() {
      this.showTaskModal = false;
      this.resetTaskForm();
    },

    resetTaskForm() {
      this.taskTitle = "";
      this.taskDescription = "";
      this.taskStatus = "TODO";
    },
    async fetchProject(projectId) {
      try {
        const response = await axios.get(`/api/projects/${projectId}`, {
          withCredentials: true,
        });
        this.project = response.data;
      } catch (error) {
        console.error("Error fetching project:", error);
      }
    },

    async fetchUsers() {
      try {
        const response = await axios.get('/api/users', {
          withCredentials: true,
        });
        this.users = response.data;
      } catch (error) {
        console.error("Error fetching users:", error);
      }
    },

    // async fetchTasksAvailable() {
    //   try {
    //     const response = await axios.get(`http://localhost:8080/api/tasks`, {
    //       withCredentials: true,
    //     });
    //     this.tasksAvailable = response.data;
    //   } catch (error) {
    //     console.error("Error fetching tasks:", error);
    //   }
    // },

    addUserToProject() {
      const projectId = this.project.id;
      const requestPayload = {userId: this.userId, projectId: projectId};

      axios.post('0/api/projects/add-user', requestPayload)
          .then(response => {
            console.log('User added to project:', response.data);
            this.showUserModal = false;
          })
          .catch(error => {
            console.error('Error adding user to project:', error);
          });
    },

    assignTaskToUser() {
      const requestPayload = {
        userId: this.userIdForTask,
        taskId: this.taskId,
      };

      axios.post(`/api/tasks/user/${this.userIdForTask}/task/${this.taskId}`, requestPayload)
          .then(response => {
            console.log('Task assigned to user:', response.data);
            this.showTaskModal = false;
          })
          .catch(error => {
            console.error('Error assigning task to user:', error);
          });
    },

    closeUserModal() {
      this.showUserModal = false;
      this.resetUserForm();
    },


    resetUserForm() {
      this.userId = "";
      this.editingUser = false;
    },


  },
};
</script>


<style scoped>
.project-details {
  padding: 20px;
  max-width: 800px;
  margin: 0 auto;
}

h2 {
  text-align: center;
}

.buttons {
  display: flex;
  justify-content: center;
  gap: 20px;
  margin-top: 20px;
}

.add-user-btn, .add-task-btn {
  margin-top: 20px;
  background-color: #636363;
  border: none;
  color: white;
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

.add-user-btn:hover, .add-task-btn:hover {
  background-color: #417c42;
}

.dropdown-container {
  margin-bottom: 20px;
}

select {
  width: 100%;
  padding: 10px;
  font-size: 16px;
  color: #333;
  background-color: #f4f4f4;
  border: 1px solid #ccc;
  border-radius: 5px;
  transition: border-color 0.3s ease, background-color 0.3s ease;
}

select:focus {
  border-color: #417c42;
  background-color: #e6f5e6;
  outline: none;
}

option {
  padding: 10px;
  font-size: 16px;
  background-color: #ffffff;
}

select:disabled {
  background-color: #f1f1f1;
  color: #aaa;
}

label {
  display: block;
  margin-bottom: 8px;
  font-size: 16px;
  color: #333;
}
</style>
