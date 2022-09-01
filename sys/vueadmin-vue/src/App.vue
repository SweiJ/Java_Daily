<template>
  <div id="app">
    <!-- <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </nav> -->
    <router-view/>
  </div>
</template>

<script>
  export default {
    name: "App",
    watch: {
      $route(to, from) {
        if(to.path != '/login') {
          let obj = {
            name: to.name,
            title: to.meta.title
          }
          this.$store.commit("addTab", obj)
        }
      }
    }
  }
</script>

<style>
  	html, body, #app {
		font-family: 'Helvetica Neue', 'Hiragino Sans GB', 'WenQuanYi Micro Hei', 'Microsoft Yahei', sans-serif;
		height: 100%;
		padding: 0;
		margin: 0;
		font-size: 15px;
	}
</style>
