<template>
  <div id="login">
    <form class="form-register" @submit.prevent="register" v-if="showRegistration">
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <input
        type="text"
        id="username"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      &nbsp;
      <input
        type="password"
        id="password"
        placeholder="Password"
        v-model="user.password"
        required
      />
      &nbsp;
      <input
        type="password"
        id="confirmPassword"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      &nbsp;
      <button type="submit">
        Create Account
      </button>
      &nbsp;
      |
      &nbsp;
      <a href="javascript:void(null)" @click.prevent="showLogin">Have an account?</a>
    </form>

    <form class="form-signin" @submit.prevent="login" v-else>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <input
        type="text"
        id="username"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      &nbsp;
      <input
        type="password"
        id="password"
        placeholder="Password"
        v-model="user.password"
        required
      />
      &nbsp;
      <button type="submit">Sign in</button>
      &nbsp;
      |
      &nbsp;
      <a href="javascript:void(null)" @click.prevent="showReg">Register</a>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: '',
        role: 'user',
      },
      invalidCredentials: false,
      showRegistration: false,

      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    showReg() {
      this.user = { role: 'user' };
      this.invalidCredentials = false;
      this.showRegistration = true;
    },
    showLogin() {
      this.user = {};
      this.registrationErrors = false;
      this.showRegistration = false;
    },

    login() {
      this.invalidCredentials = false;

      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.user = {};
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },

    register() {
      this.registrationErrors = false;

      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then(() => {
            this.user = {};
            this.showRegistration = false;
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
  }
};
</script>

<style>
  #login {
    text-align: right;
  }
</style>