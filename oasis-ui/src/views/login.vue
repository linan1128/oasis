<script setup lang="ts">
import { PersonOutline, LockClosedOutline } from '@vicons/ionicons5';

const formRef = ref();
const loading = ref(false);
const loginForm = ref({
  username: 'admin',
  password: 'admin123',
});
const rules = {
  username: { required: true, message: '请输入用户名', trigger: 'blur' },
  password: { required: true, message: '请输入密码', trigger: 'blur' }
};

const handleSubmit = (e) => {
  e.preventDefault();
  formRef.value.validate((errors) => {
    if (!errors) {
      loading.value = true;
    }
  })
}
</script>

<template>
  <div class="login">
    <div class="form-container">
      <n-el tag="div" style="display: flex;font-size: 30px;align-items: center;justify-content: center;color: var(--primary-color) ">OASIS</n-el>
      <n-form
          ref="formRef"
          label-placement="left"
          size="large"
          :model="loginForm"
          :rules="rules"
      >
        <n-form-item path="username">
          <n-input v-model:value="loginForm.username" placeholder="请输入用户名">
            <template #prefix>
              <n-icon size="18" color="#808695">
                <PersonOutline />
              </n-icon>
            </template>
          </n-input>
        </n-form-item>
        <n-form-item path="password">
          <n-input
              v-model:value="loginForm.password"
              type="password"
              show-password-toggle
              placeholder="请输入密码"
          >
            <template #prefix>
              <n-icon size="18" color="#808695">
                <LockClosedOutline />
              </n-icon>
            </template>
          </n-input>
        </n-form-item>
        <n-form-item>
          <n-button type="primary" @click="handleSubmit" :loading="loading" size="large" block>
            登录
          </n-button>
        </n-form-item>
      </n-form>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.login{
  display: flex;
  //flex-direction: column;
  height: 100vh;
  align-items: center;
  .form-container{
    width: 384px;
    margin: 0 auto;
  }
}
</style>