<template>
  <div class="dashboard-container">
    <div class="dashboard-text">
      <h1 style="color: rgb(81,193,142);">SW博客管理系统</h1>
    </div>
    <div>
      <h2>博客地址: <a href="www.swxpz.cn">www.swxpz.cn</a></h2>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name'
    ])
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 100px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
