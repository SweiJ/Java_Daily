import { TabPane } from 'element-ui'
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default {
  state: {
    menuList: [],
    permList: [],
    // authorities: []
    hasRoute: false,

    editableTabsValue: 'Index',
    editableTabs: [{
      title: '首页',
      name: 'Index',
    }]
  },
  mutations: {
    setMenuList(state, menus) {
        this.menuList = menus
    },
    setPermList(state, perms) {
        this.permList = perms
    },
    changeRouteStatus(state, hasRoute) {
      state.hasRoute = hasRoute

      sessionStorage.setItem("hasRoute", hasRoute)
    },
    addTab(state, item) {
      // 查询标签页里列表中是否包含当前点击的导航
      let index = state.editableTabs.findIndex(e => e.name === item.name)
      // 不包含则新增一个
      if(index === -1) {
        state.editableTabs.push({
          title: item.title,
          name: item.name
        })
      }
      // 包含则跳转到该标签页
      state.editableTabsValue = item.name
    },
    resetState: (state) => {
      state.token = ''
      state.menuList = []
      state.permList = []
      state.hasRoute = false
      state.editableTabs = [{
        title: '首页',
        name: 'Index',
      }]
      state.editableTabsValue = 'Index'
    }
  },
  actions: {
  },
}