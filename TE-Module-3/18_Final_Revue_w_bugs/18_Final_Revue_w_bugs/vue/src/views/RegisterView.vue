<template>
  <div id="register" class="text-center register-container">
    <form v-on:submit.prevent="register" class="register-form">
      <h1 class="register-title">Create Account</h1>
      <div role="alert" v-if="registrationErrors" class="error-message">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username" class="input-label">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus class="input-field" />
      </div>
      <div class="form-input-group">
        <label for="password" class="input-label">Password</label>
        <input type="password" id="password" v-model="user.password" required class="input-field" />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword" class="input-label">Confirm Password</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required class="input-field" />
      </div>
      <button type="submit" class="submit-button">Create Account</button>
      <p class="login-link">
        <router-link v-bind:to="{ name: 'login' }" class="login-link">Already have an account? Log in.</router-link>
      </p>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
.register-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.register-form {
  width: 300px;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.register-title {
  font-size: 1.5em;
  margin-bottom: 20px;
}

.error-message {
  color: red;
  margin-bottom: 10px;
}

.form-input-group {
  margin-bottom: 15px;
}

.input-label {
  display: block;
  font-weight: bold;
  margin-bottom: 5px;
}

.input-field {
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
  border: 1px solid #ccc;
  border-radius: 3px;
}

.submit-button {
  background-color: #3498db;
  color: white;
  padding: 10px;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}

.login-link {
  margin-top: 15px;
  text-align: center;
}

.login-link a {
  text-decoration: none;
  color: #3498db;
}
</style>
