<template>
  <div v-if="show" class="modal-overlay">
    <div class="modal-content" :style="{ width }">
      <div class="modal-body">
        <button class="modal-close" @click="$emit('close')">
          <i class="fa fa-times-circle"></i>
        </button>
        <slot></slot>
      </div>
    </div>
  </div>
</template>

<script>
import 'font-awesome/css/font-awesome.min.css';

export default {
  name: 'InputComponent',
  props: {
    show: {
      type: Boolean,
      required: true
    },
    width: {
      type: String,
      default: '700px'
    }
  }
};
</script>

<style scoped>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background: rgba(0, 0, 0, 0.7);
  display: flex;
  justify-content: center;
  align-items: center;
  transition: all 0.3s ease-in-out;
  z-index: 1000;
}

.modal-content {
  background: #3e3d3d;
  padding: 2rem;
  border-radius: 8px;
  position: relative;
  max-width: 100%;
  max-height: 90vh;
  width: 700px;
  display: flex;
  flex-direction: column;
  transition: all 0.3s ease-in-out;
}

.modal-body {
  margin-top: -20px;
  overflow-y: auto;
  flex: 1 1 auto;
  font-family: 'Arial', sans-serif;
  color: #dddada;
  position: relative;
}

.modal-close {
  margin-top: 14px;
  margin-right: -14px;
  position: absolute;
  top: 10px;
  right: 10px;
  font-size: 1.5rem;
  background: transparent;
  border: none;
  cursor: pointer;
}

.modal-content i {
  color: #e62b2b;
  font-size: 30px;
}

.modal-body::-webkit-scrollbar {
  display: none;
}

.modal-body {
  -ms-overflow-style: none;
  scrollbar-width: none;
}

form {
  display: flex;
  flex-direction: column;
  width: 100%;
}

form div {
  margin-bottom: 1rem;
  width: 100%;
}

form label {
  font-size: 1rem;
  margin-bottom: 0.5rem;
  display: block;
  color: #dddada;
}

form input,
form select,
button[type="submit"] {
  width: 100%;
  padding: 0.5rem;
  font-size: 1rem;
  border: 1px solid #d51c1c;
  border-radius: 4px;
  box-sizing: border-box;
  margin: 0;
  background-color: #5c5c5c;
  color: #ac1313;
}

form input:focus,
form select:focus {
  border-color: #b81111;
  outline: none;
}

/*button[type="submit"] {
  background-color: #4CAF50;
  color: white;
  border: none;
  cursor: pointer;
  padding: 0.5rem 0;
  border-radius: 4px;
}*/

button[type="submit"]:hover {
  background-color: #45a049;
}

input[type="number"] {
  -webkit-appearance: none;
  -moz-appearance: textfield;
}

input[type="number"]::-webkit-inner-spin-button,
input[type="number"]::-webkit-outer-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
</style>