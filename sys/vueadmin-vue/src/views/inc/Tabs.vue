<template>
    <el-tabs v-model="editableTabsValue" type="card" editable @edit="handleTabsEdit">
        <el-tab-pane
          :key="item.name"
          v-for="(item, index) in editableTabs"
          :label="item.title"
          :name="item.name"
        >

        </el-tab-pane>
      </el-tabs>
</template>

<script>
    export default {
      data() {
        return {
          // editableTabsValue: this.$store.state.menus.editableTabsValue,
          // editableTabs: this.$store.state.menus.editableTabs,
        }
      },
      // 当导航页别点击时获取当前导航页的值并且显示在标签页中
      computed: {
        editableTabs: {
          get() {
            return this.$store.state.menus.editableTabs
          },
          set(val) {
            this.$store.state.menus.editableTabs = val
          }
        },
			  editableTabsValue: {
          get() {
            return this.$store.state.menus.editableTabsValue
          },
          set(val) {
            this.$store.state.menus.editableTabsValue = val
          }
        }
      },
      methods: {
        // removeTab(targetName) {
        //   let tabs = this.editableTabs;
        //   let activeName = this.editableTabsValue;
        //   if(activeName === targetName) {
        //     tabs.forEach((tab, index) => {
        //       if(tab.name === targetName) {
        //         let nextTab = tabs[index + 1] || tabs[index - 1];
        //         if(nextTab) {
        //           activeName = nextTab.name;
        //         }
        //       }
        //     })
        //   }
        // },

        // targetName 为当前操作的是哪个标签  action 为是增加还是删除
        handleTabsEdit(targetName, action) {
          if (action === 'add') {
            
          }
          if (action === 'remove') {
            let tabs = this.editableTabs;
            let activeName = this.editableTabsValue;

            console.log(activeName)
            // 如果为首页则直接返回
            if(targetName === 'Index') {
              return
            }


            if (activeName === targetName) {
              tabs.forEach((tab, index) => {
                if (tab.name === targetName) {
                  let nextTab = tabs[index + 1] || tabs[index - 1];
                  if (nextTab) {
                    activeName = nextTab.name;
                  }
                }
              });
            }
            
            this.editableTabsValue = activeName;
            this.editableTabs = tabs.filter(tab => tab.name !== targetName);

            this.$router.push({name: activeName})
          }
        },
        clickTab(target) {
          this.$router.push({name: target.name})
        }
      }
    }
</script>

<style scoped>

</style>