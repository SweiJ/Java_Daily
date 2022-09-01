<template>
    <el-container>
        <el-aside width="200px">
            <!-- 左侧栏菜单列表 -->
            <SideMenu></SideMenu>
        </el-aside>
        <el-container>
            <!-- 右上标头 -->
            <el-header>
                <strong>Rent House</strong>
                <div class="header-avatar">
                    <!-- 用户头像 -->
                    <el-avatar size="medium" :src="userInfo.avatar"></el-avatar>
                    <!-- 下拉菜单 -->
                    <el-dropdown>
                        <!-- 用户名 -->
                        <span class="el-dropdown-link">
                            {{userInfo.username}}<i class="el-icon-arrow-down el-icon--right"></i>
                        </span>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>
                                <!-- userCenter组件 -->
                                <router-link to="/userCenter">个人中心</router-link>
                            </el-dropdown-item>
                            <!-- 退出登录 -->
                            <el-dropdown-item @click.native="logout">退出</el-dropdown-item>
                        </el-dropdown-menu>
                      </el-dropdown>
                      <!-- 自定义网址按钮链接 -->
                      <el-link href="">网址</el-link>
                </div>
            </el-header>
            <el-main>
                <!-- 标签页 -->
                <Tabs></Tabs>
                <!-- 功能显示区 -->
                <div class="margin: 0 15px">
                    <router-view/>
                </div>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    import SideMenu from "./inc/SideMenu"
    import Tabs from "./inc/Tabs.vue"

    export default {
        name: "Home",
        components: {
            SideMenu,
            Tabs
        },
        data() {
            return {
                // 用户信息
                userInfo: {
                    id: "",
                    username: "",
                    avatar: ""
                }
            }
        },
        // 加载当前页面时自动加载
        created() {
            this.getUserInfo()
        },
        methods: {
            getUserInfo() {
                this.$axios.get("/sys/userInfo").then(res => {
                        this.userInfo = res.data.data
                })
            },
            logout() {
                this.$axios.post("/logout").then(res => {
                    localStorage.clear()
                    sessionStorage.clear()

                    this.$store.commit("resetState")
                    this.$router.push("/login")
                })
            }
        }
    }

</script>

<style scoped>
    .el-container {
        padding: 0;
        margin: 0;
        height: 100%;
    }
    .el-header {
        background-color: #ffffff;
        color: #333;
        text-align: center;
        line-height: 60px;
    }
    
    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        line-height: 200px;
    }
    
    .el-main {
        color: #333;
        padding: 0;
    }

    .el-dropdown-link {
        cursor: pointer;
        color: #409EFF;
    }
    .el-icon-arrow-down {
        font-size: 12px;
    }

    .header-avatar {
        float: right;
        width: 210px;
        display: flex;
        justify-content: space-around;
        align-items: center;
    }
    
    a {
        text-decoration: none;
    }
</style>