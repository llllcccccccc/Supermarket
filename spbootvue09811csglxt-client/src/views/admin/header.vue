<template>
    <div class="altair-header">
        <!--<div class="uk-float-left">
            <i class="icon" :class="{'el-icon-back':asideStatus,'el-icon-tickets':!asideStatus}" @click="switchAside"></i>
        </div>-->
        <div class="uk-float-left">{{ setting.title }}</div>
        <div class="uk-float-right">
            <ul class="uk-nav-list">
                <li><router-link to="/index">主页</router-link></li>
                <li>
                    <el-dropdown>
                        <span class="el-dropdown-link">
                            {{ $session.username }} {{ $session.cx }}
                            <i class="el-icon-arrow-down el-icon--right"></i>
                        </span>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item @click.native="$goto('/admin/mod')">修改密码</el-dropdown-item>
                            <el-dropdown-item @click.native="logout">退出登录</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </li>
            </ul>
        </div>
    </div>
</template>
<style type="text/scss" lang="scss">
    .altair-header {
        color: #ffffff;
        a {
            color: #ffffff;
        }
        .el-dropdown-link {
            cursor: pointer;
            color: #ffffff;
        }
        .uk-nav-list {
            height: 48px;
            overflow: hidden;
            li {
                display: inline-block;
                border-right: 1px solid #0057b1;
                border-left: 1px solid #4e87c6;
                > a,
                > .el-dropdown {
                    padding: 0 15px;
                    display: block;
                    text-decoration: none;
                }
                > .el-dropdown > span {
                    display: block;
                }
                transition: all 280ms linear;
            }
            li:hover {
                background: #0057b1;
            }
        }
        .uk-float-left {
            float: left;
            margin-right: 15px;
        }
        .uk-float-right {
            float: right;
            margin-right: 15px;
        }
        .icon {
            font-size: 32px;
            line-height: 48px;
            color: #ffffff;
            cursor: pointer;
        }
    }
</style>
<script>
    import setting from "@/setting";
    import api from "@/api";
    export default {
        name: "altair-header",
        data() {
            return {
                setting,
            };
        },
        props: {
            asideStatus: {
                type: Boolean,
                default: true,
            },
        },
        watch: {},
        computed: {},
        methods: {
            switchAside() {
                this.$emit("switch-aside");
            },
            logout() {
                this.$confirm("确定退出登录？", "确认信息").then(() => {
                    // 退出登录
                    this.$store
                        .dispatch("user/logout")
                        .then((res) => {
                            if (res.code == api.code.OK) {
                                this.$message.success("退出登录成功");
                                this.$router.replace("/index");
                            } else {
                                this.$message.error(res.msg);
                            }
                        })
                        .catch((err) => {
                            this.$message.error(err.message);
                        });
                });
            },
        },
        created() {},
        mounted() {},
        destroyed() {},
    };
</script>
